package com.ztt.websocket;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.http.websocketx.*;
import io.netty.util.CharsetUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @Auther: zhangtietuo
 * @Description: 接收/处理/相应客户端websocket请求的核心业务处理类
 * @Date: 2019/7/2 16:25
 */
public class MyWebSocketHandler extends SimpleChannelInboundHandler<Object> {


    private WebSocketServerHandshaker handshaker;

    private static final String WEB_SOCKET_URL = "ws://localhost:8888/websocket";

    /**
     * 客户端与服务端创建连接时候调用
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        NettyConstant.channelGroup.add(ctx.channel());
        System.out.println("==========客户端与服务端连接开启================");
    }

    /**
     * 客户端与服务端断开连接时调用
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        NettyConstant.channelGroup.remove(ctx.channel());
        if(NettyConstant.userMap.containsKey(ctx.channel().id().toString())) {
            TextWebSocketFrame tws = new TextWebSocketFrame("3|用户:"+NettyConstant.userMap.get(ctx.channel().id().toString()).getNickName()+"("+ctx.channel().id().toString()+"}"+" 已退出聊天");
            NettyConstant.channelGroup.writeAndFlush(tws);
        }
        NettyConstant.userMap.remove(ctx.channel().id().toString());
        List<String> nickNameArr = new ArrayList<>();
        NettyConstant.userMap.values().forEach(userEntity -> nickNameArr.add(userEntity.getNickName()+ctx.channel().id()));
        TextWebSocketFrame userMapInfo = new TextWebSocketFrame(4+"|"+JSONObject.toJSONString(nickNameArr));
        NettyConstant.channelGroup.writeAndFlush(userMapInfo);
        System.out.println("===============客户端与服务端连接断开===================");
    }

    /**
     * 工程出现异常时调用
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    /**
     * 服务端接收客户端发送过来数据结束之后调用
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    /**
     * 处理的核心方法
     * @param channelHandlerContext
     * @param msg
     * @throws Exception
     */
    @Override
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, Object msg) throws Exception {
        //处理客户端向服务端发起http握手请求的业务msg = {TextWebSocketFrame@2374} "TextWebSocketFrame(data: PooledUnsafeDirectByteBuf(ridx: 0, widx: 9, cap: 9))"
        if(msg instanceof FullHttpRequest) {
            handHttpRequest(channelHandlerContext, (FullHttpRequest) msg);
        } else if(msg instanceof WebSocketFrame) {//处理websocket连接业务
            handWesocketFrame(channelHandlerContext, (WebSocketFrame) msg);
        }
    }

    /**
     * 处理客户端向服务端发起http握手请求得业务
     * @param ctx
     * @param req
     * @param req
     */
    private void handHttpRequest(ChannelHandlerContext ctx, FullHttpRequest req) {
        if(!req.decoderResult().isSuccess() || !("websocket".equals(req.headers().get("Upgrade")))) {
            sendHttpResponse(ctx, req, new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.BAD_REQUEST));
            return;
        } else {
            System.out.println("客户端连接服务端握手");
        }
        WebSocketServerHandshakerFactory wsFactory = new WebSocketServerHandshakerFactory(WEB_SOCKET_URL, null, false);
        handshaker = wsFactory.newHandshaker(req);
        if(null == handshaker) {
            WebSocketServerHandshakerFactory.sendUnsupportedVersionResponse(ctx.channel());

        } else {
            handshaker.handshake(ctx.channel(), req);
        }
    }

    /**
     * 服务端向客户端相应消息
     * @param ctx
     * @param req
     * @param res
     */
    private void sendHttpResponse(ChannelHandlerContext ctx, FullHttpRequest req, DefaultFullHttpResponse res) {
        if(res.status().code() != 200) {
            ByteBuf buf = Unpooled.copiedBuffer(res.status().toString(), CharsetUtil.UTF_8);
            res.content().writeBytes(buf);
            buf.release();
        }
        //服务端像客户端发送数据
        ChannelFuture f = ctx.channel().writeAndFlush(res);
        if(res.status().code() != 200) {
            f.addListener(ChannelFutureListener.CLOSE);
        }
    }

    /**
     * 处理服务端与客户端的websocket业务
     * @param ctx
     * @param frame  type 1:用户登录 2：发送消息 3：欢迎/退出  4：用户列表
     */
    private void handWesocketFrame(ChannelHandlerContext ctx, WebSocketFrame frame) {
        //判断是否 是关闭websocket的指令
        if(frame instanceof CloseWebSocketFrame) {
            handshaker.close(ctx.channel(), ((CloseWebSocketFrame) frame).retain());
        }
        //判断是否是ping消息
        if( frame instanceof PingWebSocketFrame) {
            ctx.channel().write(new PongWebSocketFrame(frame.content().retain()));
            return;
        }
        //是否是二进制消息 如果是二进制消息 抛出异常
        if(!(frame instanceof TextWebSocketFrame)) {

            System.out.println("=============目前不支持二进制消息===============:"+frame.toString());
            //throw new RuntimeException("【"+this.getClass().getName()+"】不支持消息");
            return;
        }
        //返回应答消息
        //获取客户端向服务端发送的消息
        String request = ((TextWebSocketFrame) frame).text();
        System.out.println("服务端收到客户端的消息=====》》"+ request);
        String[] requestArr = request.split("\\|");
        if(1 == Integer.parseInt(requestArr[0])) {
            UserEntity user = new UserEntity();
            user.setNickName(requestArr[1]);
            user.setChannel(ctx.channel());
            NettyConstant.userMap.put(ctx.channel().id().toString(), user);
            TextWebSocketFrame tws = new TextWebSocketFrame("3|"+"欢迎用户:"+NettyConstant.userMap.get(ctx.channel().id().toString()).getNickName()+"("+ctx.channel().id()+")"+" 加入ztt的聊天室");
            NettyConstant.channelGroup.writeAndFlush(tws);
            List<String> nickNameArr = new ArrayList<>();
            NettyConstant.userMap.values().forEach(userEntity -> nickNameArr.add(userEntity.getNickName()+"("+ctx.channel().id()+")"));
            TextWebSocketFrame userMapInfo = new TextWebSocketFrame(4+"|"+JSONObject.toJSONString(nickNameArr));
            NettyConstant.channelGroup.writeAndFlush(userMapInfo);
        } else if(2 == Integer.parseInt(requestArr[0])) {
            TextWebSocketFrame tws = new TextWebSocketFrame(2+"|"+LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) +"  "+NettyConstant.userMap.get(ctx.channel().id().toString()).getNickName()+"("+ctx.channel().id()+")"+":  "+ requestArr[1]);
            //群发，服务端向每个连接上来的客户端群发消息
            NettyConstant.channelGroup.writeAndFlush(tws);
        }


    }
}

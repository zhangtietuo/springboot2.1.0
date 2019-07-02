package com.ztt.chat_room;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class NioServer {

    public void start() throws IOException {
        //1. 创建Selector
        Selector selector = Selector.open();
        //2. 通过ServerSocketChannel创建Channel通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //3. 绑定监听端口
        serverSocketChannel.bind(new InetSocketAddress(8000));
        //4. 设置为非阻塞i/o
        serverSocketChannel.configureBlocking(false);
        //5. 注册到Seletor,监听连接事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT, "服务器注册");
        System.out.println("=======================================服务器端监听注册事件的通道启动成功==========================================");
        //6. 循环等待新接入通道(连接)
        while (true) {
            int readyChannels = selector.select();
            if(0 == readyChannels) {
                continue;
            }
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator iterator =  keys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = (SelectionKey) iterator.next();
                iterator.remove();
                if(selectionKey.isAcceptable()) {
                    acceptHandler(serverSocketChannel, selector);
                }
                if(selectionKey.isReadable()) {
                    readHandler(selectionKey, selector);
                }
            }

        }

    }

    /**
     * 接入事件处理器
     */
    private void acceptHandler(ServerSocketChannel serverSocketChannel, Selector selector) throws IOException {
        //1. 创建socketChannel
        SocketChannel socketChannel = serverSocketChannel.accept();
        //2. 设置为非阻塞模式
        socketChannel.configureBlocking(false);
        //3. 注册到Selector,监听可读事件
        socketChannel.register(selector, SelectionKey.OP_READ, "服务器accept");
        //4. 回复客户端提示信息
        socketChannel.write(Charset.forName("UTF-8").encode("您与群聊中其它人都不是好友"));
    }

    private void readHandler(SelectionKey selectionKey, Selector selector) throws IOException {
        //从selectionkey中获取到已经就绪的channel
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        //创建buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        //循环读取客户端请求信息
        String request = "";
        while (socketChannel.read(byteBuffer)> 0) {
            byteBuffer.flip();
            request = Charset.forName("UTF-8").decode(byteBuffer).toString();
        }
        //将channel再次注册到selector上，监听她的可读事件
        socketChannel.register(selector, SelectionKey.OP_READ, "服务器read");
        //将客户端发送的请i去信息 广播给其它客户端
        if(request.length()>0) {
            System.out.println(request);
            boardCast(selector, socketChannel, request);
        }
    }

    /**
     * 广播给其它客户端
     */
    private void boardCast(Selector selector, SocketChannel sourceChannel, String request) {
        //获取到所有已接入得客户端channel
        Set<SelectionKey> keys = selector.keys();
        keys.forEach(selectionKey -> {
            Channel targetChannel = selectionKey.channel();
            if(targetChannel instanceof SocketChannel && targetChannel != sourceChannel) {
                try {
                    ((SocketChannel) targetChannel).write(Charset.forName("UTF-8").encode(request));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        //循环向所有channel广播信息
    }

    public static void main( String[] args ) throws IOException {
        new NioServer().start();
    }
}

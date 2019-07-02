package com.ztt.chat_room;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * @Auther: zhangtietuo
 * @Description: 客户端线程类 专门接收服务器端相应信息
 * @Date: 2019/7/1 16:31
 */
public class NioClientHandler implements Runnable {

    private Selector selector;

    public NioClientHandler(Selector selector) {
        this.selector = selector;
    }

    @Override
    public void run() {
        try {
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
                    if(selectionKey.isReadable()) {
                        readHandler(selectionKey, selector);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readHandler(SelectionKey selectionKey, Selector selector) throws IOException {
        //从selectionkey中获取到已经就绪的channel
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        //创建buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        //循环读取服务器端请求信息
        String response = "";
        while (socketChannel.read(byteBuffer)> 0) {
            byteBuffer.flip();
            response = Charset.forName("UTF-8").decode(byteBuffer).toString();
        }
        //将channel再次注册到selector上，监听她的可读事件
        socketChannel.register(selector, SelectionKey.OP_READ);
        //将服务器端发送的请i去信息 广播给其它客户端
        if(response.length()>0) {
            System.out.println(response);
        }
    }
}

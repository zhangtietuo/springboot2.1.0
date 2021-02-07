package com.ztt.NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2021/2/5 15:20
 */
public class NioServer {

    private static List<SocketChannel> channelList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        socketChannel.socket().bind(new InetSocketAddress(9001));
        socketChannel.configureBlocking(false);
        Selector selector = Selector.open();
        //selector 帮serverChannel关注客户端channel连接事件
        SelectionKey selectionKey = socketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            //阻塞等待需要处理的事件发生
            selector.select();
//            SocketChannel channel = socketChannel.accept();
//            if(null != channel) {
//                channel.configureBlocking(false);
//                channelList.add(channel);
//            }
//            Iterator<SocketChannel> iterators = channelList.iterator();
//            while(iterators.hasNext()) {
//                SocketChannel sc = iterators.next();
//                ByteBuffer bf = ByteBuffer.allocate(128);
//                sc.read(bf);
//                System.out.println(new String(bf.array()));
//            }
        }
    }
}

package com.ztt.chat_room;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class NioClient {

    public void start(String nickName) throws IOException {
        //连接服务器
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8000));
        System.out.println("===========客户端【"+nickName+"】，连接本机8000端口==========================");

        //接收服务器端数据 新启线程
        Selector selector = Selector.open();
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ, nickName);
        new Thread(new NioClientHandler(selector)).start();

        //像服务器发送数据
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()) {
            String request = scanner.next();
            socketChannel.write(Charset.forName("UTF-8").encode(nickName+"说:  " +request));
        }


    }

    /*public static void main( String[] args ) throws IOException {
        new NioClient().start();
    }*/
}

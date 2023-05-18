package com.ztt.BIO.single;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Description
 * @Author tietuo.zhang
 * @Date 2023/5/9 10:35
 */

public class Client2 {
    public static void main(String[] args) {
        Socket socket = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;

        //获取从键盘输入的内容
        Scanner scanner = new Scanner(System.in);
        try {
            //创建socket实例
            socket = new Socket();

            //连接服务端
            socket.connect(new InetSocketAddress("127.0.0.1",7777));
            System.out.println("客户端连接服务端成功2");

            //读写操作
            outputStream = socket.getOutputStream();
            inputStream = socket.getInputStream();
            byte[] bytes = new byte[100];

            while (scanner.hasNext()) {
                //获取键盘内容
                String msg = scanner.next();
                if (msg == null || "".equals(msg.trim())) continue;
                //发给服务端
                outputStream.write(msg.getBytes());
                outputStream.flush();

                //接收服务端返回的数据
                int num = inputStream.read(bytes);
                System.out.println("服务端返回2："+new String(bytes,0,num));

                if ("exit".equals(msg.trim())) {
                    //特定结束
                    System.out.println("客户端主动断开连接啦2");
                    break;
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            try {
                if (socket != null) socket.close();
                if (outputStream != null) outputStream.close();
                if (inputStream != null) inputStream.close();

            } catch (Exception e) {}
        }
    }
}


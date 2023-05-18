package com.ztt.BIO.single;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description
 * @Author tietuo.zhang
 * @Date 2023/5/9 10:33
 */
public class SingleServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            //创建ServerSocket实例并绑定端口
            serverSocket = new ServerSocket(7777);
            System.out.println("服务端绑定端口7777并启动啦");

            //等待并接受客户端连接
            socket = serverSocket.accept();
            //getRemoteSocketAddress() 获取连接的对方的IP和端口
            System.out.println("有新的客户端连接：" + socket.getRemoteSocketAddress());

            //进行读写操作
            inputStream = socket.getInputStream(); //读取客户端数据
            outputStream = socket.getOutputStream();//给客户端发送数据

            byte[] bytes = new byte[100];
            //可多次接受数据
            int len = 0;
            //判断当前的一个消息是否结束
            String recv = null;
            while ((len = inputStream.read(bytes)) != -1) {
                recv = new String(bytes, 0, len);
                System.out.println("客户端发送消息：" + recv);
                //封装返回给客户端
                outputStream.write(("[echo]" + recv + "\n").getBytes());
                outputStream.flush();

                //判断当前业务结束标识：客户端发送exit
                if (recv != null && "exit".equals(recv.trim())) {
                    System.out.println("客户端断开即将断开连接");
                    break;
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭资源
                if (serverSocket != null) serverSocket.close();
                if (socket != null) socket.close();
                if (inputStream != null) inputStream.close();
                if (outputStream != null) outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}

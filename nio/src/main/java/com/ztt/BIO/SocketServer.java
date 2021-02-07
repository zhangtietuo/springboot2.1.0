package com.ztt.BIO;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2021/2/5 14:41
 */
public class SocketServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9000);
        while(true) {
            Socket client = serverSocket.accept();
            byte[] bytes = new byte[1024];
            int i = client.getInputStream().read(bytes);
            if(-1 != i) {
                System.out.println(new String(bytes));
            }
        }
    }
}

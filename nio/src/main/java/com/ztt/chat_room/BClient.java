package com.ztt.chat_room;

import java.io.IOException;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2019/7/2 9:18
 */
public class BClient {

    public static void main(String[] args) throws IOException {
        new NioClient().start("BClient");
    }
}

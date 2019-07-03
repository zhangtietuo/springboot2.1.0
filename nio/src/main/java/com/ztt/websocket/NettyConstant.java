package com.ztt.websocket;

import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2019/7/2 16:21
 */
public class NettyConstant {

    /**
     * 存储每一个客户端接入进来时的channel
     */
    public static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    public static Map<String, String> userMap = new HashMap<String, String>();
}

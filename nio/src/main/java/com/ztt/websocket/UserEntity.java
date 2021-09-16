package com.ztt.websocket;

import io.netty.channel.Channel;
import lombok.Data;

/**
 * @author tietuo.zhang
 * @title:
 * @Description:
 * @date 2021/9/16 17:18
 */
@Data
public class UserEntity {

    private String nickName;

    private Channel channel;
}

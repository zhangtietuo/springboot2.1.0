package com.ztt.controller;

import com.ztt.utils.QrCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2019/7/11 16:17
 */
@RestController
public class QRController {

    @Autowired
    HttpServletRequest request;

    @Autowired
    HttpServletResponse response;

    @RequestMapping("/qrcode")
    public String qrcode() {

        StringBuffer url = request.getRequestURL();
        // 域名
        String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).append("/").toString();

        // 再加上请求链接
        String requestUrl = "欢迎关注铁托的二维码";
        try {
            OutputStream os = response.getOutputStream();
            String qrBase64String = QrCodeUtils.encode(requestUrl, "/static/images/logo.png", os, true);
            return qrBase64String;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

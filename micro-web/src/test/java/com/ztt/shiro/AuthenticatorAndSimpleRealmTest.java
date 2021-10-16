package com.ztt.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther: zhangtietuo
 * @Description: shiro认证器测试
 * @Date: 2019/3/29 11:10
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthenticatorAndSimpleRealmTest {

    SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();

    @Before
    public void addUser() {
        simpleAccountRealm.addAccount("ztt", "123456", "admin");
    }

    @Test
    public void testAuthenticator() {
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager(simpleAccountRealm);
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();//客户端认证请求
        UsernamePasswordToken token = new UsernamePasswordToken("ztt", "123456");
        subject.login(token);//登录时判断subject(客户端请求)中的账户信息与服务器中的账户信息是否一致
        System.out.println(subject.isAuthenticated());

        subject.checkRole("admin");//角色验证 authorizer

        subject.logout();//退出
        System.out.println(subject.isAuthenticated());
    }

}

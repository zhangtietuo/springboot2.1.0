package com.ztt.shiro;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther: zhangtietuo
 * @Description: Inirealm测试
 * @Date: 2019/3/29 11:10
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbcRealmTest {

    DruidDataSource dataSource = new DruidDataSource();

    {
        dataSource.setUrl("jdbc:mysql://localhost:3306/admin?serverTimezone=GMT");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
    }

    @Before
    public void addUser() {

    }

    @Test
    public void testJdbcRealm() {
        JdbcRealm jdbcRealm = new JdbcRealm();
        jdbcRealm.setDataSource(dataSource);
        jdbcRealm.setPermissionsLookupEnabled(true);//默认不会开启查询权限的语句
        jdbcRealm.setAuthenticationQuery("select password from t_user where user_name = ?");
        jdbcRealm.setUserRolesQuery("select role_sign from t_user_role where user_id = ?");
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager(jdbcRealm);
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();//客户端认证请求
        UsernamePasswordToken token = new UsernamePasswordToken("admin", "123456");
        subject.login(token);//登录时判断subject(客户端请求)中的账户信息与服务器中的账户信息是否一致
        System.out.println(subject.isAuthenticated());
    }

}

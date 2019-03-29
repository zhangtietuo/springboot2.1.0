package com.ztt.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.*;

/**
 * @Auther: zhangtietuo
 * @Description:
 * @Date: 2019/3/29 14:50
 */
public class CustomRealm extends AuthorizingRealm {

    Map<String, String> map = new HashMap();

    {

        map.put("ztt", "f51703256a38e6bab3d9410a070c32ea");
        super.setName("customRealm");
    }

    /**
     * @date:2019/3/29 14:51
     * @author:wwwtietuo.zhang
     * @description: 授权
     * @param principalCollection
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal();
        Set<String> roles = getRolesByUser(username);
        Set<String> permissions = getPermissionsByRoles(roles);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo(roles);
        simpleAuthorizationInfo.setStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }

    /**
     * @date:2019/3/29 14:51
     * @author:wwwtietuo.zhang
     * @description: 认证
     * @param authenticationToken
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //1. 从主体传过来的认证信息中，获得用户名
        String username = (String) authenticationToken.getPrincipal();//
        //2. 用户名来验证密码
        String password = getPassByUser(username);
        if(null != password) {
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username, password, "customRealm");
            authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes("salt"));
            return authenticationInfo;
        }
        return null;
    }

    private String getPassByUser(String username) {
        return (String) map.get(username);
    }

    private Set<String> getPermissionsByRoles(Set<String> roles) {
        Set<String> permissions = new HashSet<>();
        Iterator<String> iterator = roles.iterator();
        while (iterator.hasNext()) {
            String role = iterator.next();
            permissions.add("user");
            permissions.add("role");
        }
        return permissions;
    }

    private Set<String> getRolesByUser(String username) {
        Set<String> roles = new HashSet<>();
        roles.add("admin");
        roles.add("ztt");
        return roles;
    }

    public static void main(String[] args) {
        Md5Hash md5Hash = new Md5Hash("123456", "salt");
        System.out.println(md5Hash.toString());
    }
}

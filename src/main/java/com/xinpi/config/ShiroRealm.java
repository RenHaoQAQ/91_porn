package com.xinpi.config;

import com.xinpi.dao.UserDao;
import com.xinpi.entity.UserEntity;
import com.xinpi.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 类 名 称：ShiroRealm
 * 类 描 述：TODO
 * 创建时间：2019-08-02 17:05
 * 创 建 人：renhao
 */
public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    /**
     * 获取用户角色和权限
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }


    /**
     * 登录认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 获取用户输入的用户名和密码
        String iphone = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());

        // 通过用户名到数据库查询用户信息
        UserEntity user = userService.findByiphone(iphone);

        if (user == null) {
            throw new UnknownAccountException("用户不存在！");
        }
        if (user.getStatus().equals("0")) {
            throw new LockedAccountException("账号已被锁定,请联系管理员！");
        }


//        第一个参数数据查出的对象， 第二个参数，用户输入的密码
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user.getIphone(), user.getPassword(), getName());

        if (StringUtils.isNotBlank(user.getSalt())) {
            // 如果存在则添加盐值
            info.setCredentialsSalt(ByteSource.Util.bytes(user.getSalt()));
        }
        return info;


    }
}

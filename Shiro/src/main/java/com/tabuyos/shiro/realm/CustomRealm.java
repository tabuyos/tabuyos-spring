package com.tabuyos.shiro.realm;

import com.tabuyos.shiro.entity.UserInfo;
import com.tabuyos.shiro.service.RolePermService;
import com.tabuyos.shiro.service.UserInfoService;
import com.tabuyos.shiro.service.UserRoleService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author Tabuyos
 * @Time 2020/5/5 22:51
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
@Component
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private RolePermService rolePermService;

//    public CustomRealm(UserInfoService userInfoService, UserRoleService userRoleService, RolePermService rolePermService) {
//        this.userInfoService = userInfoService;
//        this.userRoleService = userRoleService;
//        this.rolePermService = rolePermService;
//    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("doGetAuthorizationInfo");
        if (principals == null) {
            throw new AuthorizationException("PrincipalCollection method argument cannot be null.");
        }
        UserInfo user = (UserInfo) getAvailablePrincipal(principals);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(user.getRoles());
        info.setStringPermissions(user.getPerms());
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("doGetAuthenticationInfo");
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String username = upToken.getUsername();
        if (username == null) {
            throw new AccountException("Null usernames are not allowed by this realm.");
        }
        UserInfo userDB = userInfoService.selectBy(username);
        if (userDB == null) {
            throw new UnknownAccountException("No account found for admin [" + username + "]");
        }
        List<String> roleList = userRoleService.getRolesByUserId(userDB.getId());
        List<String> permList = rolePermService.getPermsByUserId(userDB.getId());
        Set<String> roles = new HashSet<>(roleList);
        Set<String> perms = new HashSet<>(permList);
        System.out.println(roleList.toString());
        System.out.println(permList.toString());
        userDB.setRoles(roles);
        userDB.setPerms(perms);
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo();
        info.setCredentialsSalt(ByteSource.Util.bytes(userDB.getSalt()));
        return info;
    }
}

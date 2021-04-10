//package com.tabuyos.shiro.realm;
//
//import com.tabuyos.shiro.entity.UserInfo;
//import com.tabuyos.shiro.service.RolePermService;
//import com.tabuyos.shiro.service.UserInfoService;
//import com.tabuyos.shiro.service.UserRoleService;
//import org.apache.shiro.authc.*;
//import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
//import org.apache.shiro.authz.AuthorizationException;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.apache.shiro.util.ByteSource;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
///**
// * @Author Tabuyos
// * @Time 2020/5/5 20:25
// * @Site www.tabuyos.com
// * @Email tabuyos@outlook.com
// * @Description
// */
//public class MyShiroRealm extends AuthorizingRealm {
//
//    @Autowired
//    private UserInfoService userInfoService;
//    @Autowired
//    private UserRoleService userRoleService;
//    @Autowired
//    private RolePermService rolePermService;
//
//    /**
//     * 告诉shiro如何根据获取到的用户信息中的密码和盐值来校验密码
//     */ {
//        //设置用于匹配密码的CredentialsMatcher
//        HashedCredentialsMatcher hashMatcher = new HashedCredentialsMatcher();
//        hashMatcher.setHashAlgorithmName("md5");
//        hashMatcher.setStoredCredentialsHexEncoded(true);
//        //加密的次数
//        hashMatcher.setHashIterations(1024);
//        this.setCredentialsMatcher(hashMatcher);
//    }
//
//
//    /**
//     * 定义如何获取用户的角色和权限的逻辑，给shiro做权限判断
//     */
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        if (principals == null) {
//            throw new AuthorizationException("PrincipalCollection method argument cannot be null.");
//        }
//        UserInfo user = (UserInfo) getAvailablePrincipal(principals);
//        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        Set<String> roles = new HashSet<>();
//        roles.add("admin");
//        roles.add("user");
//        info.setRoles(roles);
//        Set<String> perms = new HashSet<>();
//        perms.add("create");
//        perms.add("delete");
//        info.setStringPermissions(perms);
//        return info;
//    }
//
//    /**
//     * 定义如何获取用户信息的业务逻辑，给shiro做登录
//     */
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
//        String username = upToken.getUsername();
//        if (username == null) {
//            throw new AccountException("Null usernames are not allowed by this realm.");
//        }
//        UserInfo userDB = userInfoService.selectBy(username);
//        if (userDB == null) {
//            throw new UnknownAccountException("No account found for admin [" + username + "]");
//        }
//        //查询用户的角色和权限存到SimpleAuthenticationInfo中，这样在其它地方
//        //SecurityUtils.getSubject().getPrincipal()就能拿出用户的所有信息，包括角色和权限
////        List<String> roleList = userRoleService.getRolesByUserId(userDB.getId());
////        List<String> permList = rolePermService.getPermsByUserId(userDB.getId());
////        Set<String> roles = new HashSet(roleList);
////        Set<String> perms = new HashSet(permList);
////        userDB.setRoles(roles);
////        userDB.setPerms(perms);
//
//        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userDB, userDB.getPassword(), getName());
//        info.setCredentialsSalt(ByteSource.Util.bytes(userDB.getSalt()));
//        return info;
//
//    }
//
//}

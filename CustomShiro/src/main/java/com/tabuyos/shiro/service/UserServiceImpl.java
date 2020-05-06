package com.tabuyos.shiro.service;

import com.tabuyos.shiro.entity.SysPermission;
import com.tabuyos.shiro.entity.SysRole;
import com.tabuyos.shiro.entity.UserInfo;
import com.tabuyos.shiro.entity.UserVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Tabuyos
 * @Time 2020/5/7 0:29
 * @Site www.tabuyos.com
 * @Email tabuyos@outlook.com
 * @Description
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserVO login(String username, String password) {
        return null;
    }

    @Override
    public UserInfo findByUsername(String userName) {
        SysRole admin = SysRole.builder().role("admin").build();
        List<SysPermission> list=new ArrayList<SysPermission>();
        SysPermission sysPermission=new SysPermission("read");
        SysPermission sysPermission1=new SysPermission("write");
        list.add(sysPermission);
        list.add(sysPermission1);
        admin.setPermissions(list);
        UserInfo root = UserInfo.builder().userName("root").password("b1ba853525d0f30afe59d2d005aad96c").credentialsSalt("cm9vdA==").state(0).build();
        List<SysRole> roleList=new ArrayList<>();
        roleList.add(admin);
        root.setRoleList(roleList);
        System.out.println(root);
        return root;
    }
}

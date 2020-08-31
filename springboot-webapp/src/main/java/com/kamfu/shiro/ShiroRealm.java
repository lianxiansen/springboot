package com.kamfu.shiro;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.kamfu.entity.Permission;
import com.kamfu.entity.Role;
import com.kamfu.entity.User;
import com.kamfu.mapper.PermissionMapper;
import com.kamfu.mapper.RoleMapper;
import com.kamfu.service.UserService;

public class ShiroRealm extends AuthorizingRealm
{
    @Autowired
    private UserService userService;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissionMapper permissionMapper;
    @Override
    /**
     * 权限配置
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals)
    {
        //创建Shiro授权对象
        SimpleAuthorizationInfo authorization = new SimpleAuthorizationInfo();
 
        //获取用户信息
        User user = (User) principals.getPrimaryPrincipal();
        //获取角色信息
        Role role=roleMapper.selectById(user.getRoleId());
        if(null!=role) {
        	Collection<String> roleList=new ArrayList<String>();
        	roleList.add(role.getName());
        	authorization.addRoles(roleList);
        	
        	
        	Collection<String> permissionList=new ArrayList<String>();
        	List<Permission> permissions=permissionMapper.selectListByRoleId(role.getId());
        	for(Permission permission :permissions) {
        		permissionList.add(permission.getName());
        	}
        	 authorization.addStringPermissions(permissionList);
        }
        
       
//        //遍历角色与权限
//        List<RoleInfo> roleInfoList = staffInfo.getRoleList();
//        if (roleInfoList != null && roleInfoList.size() > 0)
//        {
//            roleInfoList.forEach(role ->
//            {
//                //添加角色信息
//                authorization.addRole(role.getRoleCode());
// 
//                //添加权限信息
//                List<PermissionInfo> permissionInfoList = role.getPermissionInfoList();
//                if (permissionInfoList != null && permissionInfoList.size() > 0)
//                {
//                    List<String> permissions = permissionInfoList.stream().map(PermissionInfo::getPermissionCode).collect(Collectors.toList());
//                    authorization.addStringPermissions(permissions);
//                }
//            });
//        }
 
        return authorization;
    }
 
    /**
     * 进行身份认证,判断用户名密码是否匹配正确
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException
    {
        //获取用户的输入的账号
        String username = (String) token.getPrincipal();
 
        System.out.println("身份："+username);
        System.out.println("凭证："+token.getCredentials());
 
        if (username == null || username.length() == 0)
        {
            return null;
        }
 
        //获取用户信息
        User userInfo = userService.getByUsername(username);
        if (userInfo == null)
        {
            throw new UnknownAccountException(); //未知账号
        }
        //判断账号是否被锁定，状态（0：禁用；1：锁定；2：启用）
//        if(userInfo.getState() == 0)
//        {
//            throw new DisabledAccountException(); //帐号禁用
//        }
// 
//        if (userInfo.getState() == 1)
//        {
//            throw new LockedAccountException(); //帐号锁定
//        }
 
        //验证
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userInfo, //用户名
                userInfo.getPassword(), //密码
                ByteSource.Util.bytes(userInfo.getSalt()), //盐
                getName() //realm name
        );
        return authenticationInfo;
    }
 
    /*
        DisabledAccountException（禁用的帐号）、LockedAccountException（锁定的帐号）、
        UnknownAccountException（错误的帐号）、ExcessiveAttemptsException（登录失败次数过多）、
        IncorrectCredentialsException （错误的凭证）、ExpiredCredentialsException（过期的凭证）等
    */
}

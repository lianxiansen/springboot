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
import org.springframework.data.redis.core.RedisTemplate;

import com.kamfu.entity.Permission;
import com.kamfu.entity.Role;
import com.kamfu.entity.User;
import com.kamfu.mapper.PermissionMapper;
import com.kamfu.mapper.RoleMapper;
import com.kamfu.model.dto.UserInfo;
import com.kamfu.service.RoleService;
import com.kamfu.service.UserService;

public class ShiroRealm extends AuthorizingRealm
{
	@Autowired
	UserService userService;
	@Autowired
	RoleService roleService;
	@Autowired
	RoleMapper roleMapper;
	@Autowired
	PermissionMapper permissionMapper;
    @Autowired
    private  RedisTemplate<String,  String>  redisTemplate;
    @Override
    /**
     * 权限配置
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals)
    {
        //创建Shiro授权对象
        SimpleAuthorizationInfo authorization = new SimpleAuthorizationInfo();
 
        //获取用户信息
        UserInfo user = (UserInfo) principals.getPrimaryPrincipal();
        if(null!=user) {
        	if(null!=user.getRole()) {
            	Collection<String> roleList=new ArrayList<String>();
            	roleList.add(user.getRole().getCode());
            	authorization.addRoles(roleList);
        	}
        	
        	if( null!=user.getPermissionList()&&user.getPermissionList().size()>0) {
        		List<Permission> permissions=user.getPermissionList();
        		Collection<String> permissionList=new ArrayList<String>();
            	for(Permission permission :permissions) {
            		permissionList.add(permission.getCode());
            	}
            	 authorization.addStringPermissions(permissionList);
        	}
        }
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
        User user= userService.getByUsername(username);
        if (user != null)
        {
        	Role role=roleMapper.selectById(user.getRoleId());
            if(null!=role) {
            	List<Permission> permissions=permissionMapper.selectListByRoleId(role.getId());
            	 UserInfo userInfo=new UserInfo()
            			 .setUserId(user.getId())
            			 .setDeptId(user.getDeptId())
            			 .setName(user.getName())
            			 .setUsername(user.getUsername())
            			 .setPassword(user.getPassword())
            			 .setSalt(user.getSalt())
            			 .setRole(role)
            			 .setPermissionList(permissions);
                 //验证
                 SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                         userInfo, //用户名
                         userInfo.getPassword(), //密码
                         ByteSource.Util.bytes(userInfo.getSalt()), //盐
                         getName() //realm name
                 );
                 return authenticationInfo;
//            	 redisTemplate.opsForValue().set(userInfo.getUserId()+"",JSONObject.toJSONString(userInfo));
            }
        }
        throw new UnknownAccountException(); //未知账号
//        throw new DisabledAccountException(); //帐号禁用
//        throw new LockedAccountException(); //帐号锁定
        /*
        DisabledAccountException（禁用的帐号）、LockedAccountException（锁定的帐号）、
        UnknownAccountException（错误的帐号）、ExcessiveAttemptsException（登录失败次数过多）、
        IncorrectCredentialsException （错误的凭证）、ExpiredCredentialsException（过期的凭证）等
    */

    }
 

}

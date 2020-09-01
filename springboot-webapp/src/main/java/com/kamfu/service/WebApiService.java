package com.kamfu.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kamfu.entity.Permission;
import com.kamfu.entity.Role;
import com.kamfu.entity.User;
import com.kamfu.model.AjaxResponse;
import com.kamfu.model.LayuiTreeNode;

@FeignClient(name ="springboot-web", fallback = WebApiServiceHystrix.class)
public interface WebApiService {
    
    /**
     * @Title: layuiTree
     * @Description: 部门属性列表
     * @param @param deptId
     * @param @return 参数
     * @return List<LayuiTreeNode> 返回类型
     * @throws
     */
        
    @GetMapping("/dept/layuiTree")
    List<LayuiTreeNode> layuiTree(@RequestParam(value = "deptId") Long deptId);
    @GetMapping("/test/getUser")
    String getUser(@RequestParam(value = "username") String username);
    
    /**
     * @Title: getRoleById
     * @Description: 根据id获取角色
     * @param @param id
     * @param @return 参数
     * @return Role 返回类型
     * @throws
     */
        
    @GetMapping("/user/getRoleById")
    Role getRoleById(@RequestParam(value = "id") Long id);
    
    /**
     * @Title: getUserByUsername
     * @Description: 根据用户名获取用户
     * @param @param username
     * @param @return 参数
     * @return User 返回类型
     * @throws
     */
        
    @GetMapping("/user/getUserByUsername")
    User getUserByUsername(@RequestParam(value = "username") String username);
    
    /**
     * @Title: selectPagedList
     * @Description: 用户列表
     * @param @param deptId
     * @param @param page
     * @param @param pagesize
     * @param @return 参数
     * @return List<User> 返回类型
     * @throws
     */
        
    @GetMapping("/user/selectUserPagedList")
    List<User> selectUserPagedList(@RequestParam(value = "deptId")Long deptId,@RequestParam(value = "page")int page,@RequestParam(value = "pagesize")int pagesize);
    
    /**
     * @Title: selectPermissionList
     * @Description: 根据角色id获取权限列表
     * @param @param roleId
     * @param @return 参数
     * @return List<Permission> 返回类型
     * @throws
     */
        
    @GetMapping("/user/selectPermissionList")
    List<Permission> selectPermissionList(@RequestParam(value = "roleId")Long roleId);
}
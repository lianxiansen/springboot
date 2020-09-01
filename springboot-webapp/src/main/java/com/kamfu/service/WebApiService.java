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

@FeignClient(name ="springboot-web")
public interface WebApiService {
    @GetMapping("/dept/layuiTree")
    List<LayuiTreeNode> layuiTree(@RequestParam(value = "deptId") Long deptId);
    @GetMapping("/test/getUser")
    String getUser(@RequestParam(value = "username") String username);
    @GetMapping("/user/getRoleById")
    Role getRoleById(@RequestParam(value = "id") Long id);
    @GetMapping("/user/getUserByUsername")
    User getUserByUsername(@RequestParam(value = "username") String username);
    @GetMapping("/user/selectPagedList")
    List<User> selectPagedList(@RequestParam(value = "deptId")Long deptId,@RequestParam(value = "page")int page,@RequestParam(value = "pagesize")int pagesize);
    @GetMapping("/user/selectPermissionList")
    List<Permission> selectPermissionList(@RequestParam(value = "roleId")Long roleId);
}
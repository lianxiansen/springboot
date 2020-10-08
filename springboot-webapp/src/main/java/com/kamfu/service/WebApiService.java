//package com.kamfu.service;
//
//import java.util.List;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.kamfu.entity.Dept;
//import com.kamfu.entity.Permission;
//import com.kamfu.entity.Role;
//import com.kamfu.entity.User;
//import com.kamfu.model.BaseResponse;
//import com.kamfu.model.LayuiTreeNode;
//import com.kamfu.model.PagedList;
//import com.kamfu.model.dto.PermissionInfo;
//
//
///**
// * @ClassName: WebApiService
// * @Description: 接口服务
// * @author liandy
// * @date 2020年9月8日
// *
// */
//    
////@FeignClient(name ="api-gateway", fallback = WebApiServiceHystrix.class)
//public interface WebApiService {
//    
//    /**
//     * @Title: layuiTree
//     * @Description: 部门属性列表
//     * @param @param deptId
//     * @param @return 参数
//     * @return List<LayuiTreeNode> 返回类型
//     * @throws
//     */
//    @Deprecated
//    @GetMapping("/webapi/dept/layuiTree")
//    List<LayuiTreeNode> layuiTree(@RequestParam(value = "deptId") Long deptId);
//    
//    @GetMapping("/webapi/dept/selectList")
//    BaseResponse selectDeptList(@RequestParam(value = "deptId") Long deptId);
//    
//    @GetMapping("/webapi/test/getUser")
//    String getUser(@RequestParam(value = "username") String username);
//    
//    @PostMapping(value="/webapi/user/add")
//    BaseResponse addUser(@RequestBody User user);
//    /**
//     * @Title: getRoleById
//     * @Description: 根据id获取角色
//     * @param @param id
//     * @param @return 参数
//     * @return Role 返回类型
//     * @throws
//     */
//        
//    @GetMapping("/webapi/user/getRoleById")
//    Role getRoleById(@RequestParam(value = "id") Long id);
//    
//    /**
//     * @Title: getUserByUsername
//     * @Description: 根据用户名获取用户
//     * @param @param username
//     * @param @return 参数
//     * @return User 返回类型
//     * @throws
//     */
//        
//    @GetMapping("/webapi/user/getUserByUsername")
//    User getUserByUsername(@RequestParam(value = "username") String username);
//    
//    /**
//     * @Title: selectPagedList
//     * @Description: 用户列表
//     * @param @param deptId
//     * @param @param page
//     * @param @param pagesize
//     * @param @return 参数
//     * @return List<User> 返回类型
//     * @throws
//     */
//        
//    @GetMapping("/webapi/user/selectUserPagedList")
//    PagedList<User> selectUserPagedList(@RequestParam(value = "deptId")Long deptId,@RequestParam(value = "page")int page,@RequestParam(value = "pagesize")int pagesize);
//    
//    /**
//     * @Title: selectPermissionList
//     * @Description: 根据角色id获取权限列表
//     * @param @param roleId
//     * @param @return 参数
//     * @return List<Permission> 返回类型
//     * @throws
//     */
//        
//    @GetMapping("/webapi/permission/selectListByRoleId")
//    List<Permission> selectPermissionList(@RequestParam(value = "roleId")Long roleId);
//    
//    
//    @PostMapping(value="/webapi/permission/add")
//    BaseResponse addPermission(@RequestBody Permission permission);
//    
//    @PostMapping(value="/webapi/permission/edit")
//    BaseResponse editPermission(@RequestBody Permission permission);
//    /**
//     * @Title: selectAllPermissionListByRoleId
//     * @Description: 根据角色获取权限列表（包含所有权限）
//     * @param @param roleId
//     * @param @return 参数
//     * @return List<PermissionInfo> 返回类型
//     * @throws
//     */
//        
//    @GetMapping("/webapi/permission/selectTreeListByRoleId")
//    List<PermissionInfo> selectPermissionTreeListByRoleId(@RequestParam(value = "roleIdChoose")Long roleIdChoose,@RequestParam(value = "roleIdMe")Long roleIdMe);
//    /**
//     * @Title: selectRolePagedList
//     * @Description: 获取角色列表
//     * @param @param page
//     * @param @param pagesize
//     * @param @return 参数
//     * @return PagedList<Role> 返回类型
//     * @throws
//     */
//        
//    @GetMapping("/webapi/role/selectPagedList")
//    PagedList<Role> selectRolePagedList(@RequestParam(value = "page")int page,@RequestParam(value = "pagesize")int pagesize);
//    
//
//    
//    /**
//     * @Title: selectPermissionList
//     * @Description: 获取权限列表
//     * @param @return 参数
//     * @return List<Permission> 返回类型
//     * @throws
//     */
//        
//    @GetMapping("/webapi/permission/selectList")
//    List<Permission> selectPermissionList();
//    
//
//    
//    @PostMapping(value="/webapi/role/add")
//    BaseResponse addRole(@RequestBody Role role);
//    
//    @PostMapping(value="/webapi/role/addPermissions")
//    BaseResponse addPermissions(@RequestParam(value = "roleId") Long roleId,@RequestParam(value = "permissionIds") String permissionIds);
//    
//    
//    @PostMapping(value="/webapi/dept/add")
//    BaseResponse addDept(@RequestBody Dept dept);
//    
//    
//}
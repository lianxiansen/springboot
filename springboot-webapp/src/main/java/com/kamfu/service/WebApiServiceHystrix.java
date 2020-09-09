package com.kamfu.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.kamfu.entity.Permission;
import com.kamfu.entity.Role;
import com.kamfu.entity.User;
import com.kamfu.model.BaseResponse;
import com.kamfu.model.LayuiTreeNode;
import com.kamfu.model.PagedList;
import com.kamfu.model.dto.PermissionInfo;

/**
 * @ClassName: WebApiServiceHystrix
 * @Description: 服务降级
 * @author liandy
 * @date 2020年9月9日
 *
 */
    
@Component
public class WebApiServiceHystrix implements WebApiService {

	@Override
	public List<LayuiTreeNode> layuiTree(Long deptId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUser(String username) {
		// TODO Auto-generated method stub
		return "服务降级【user:】"+username;
	}

	@Override
	public Role getRoleById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PagedList<User> selectUserPagedList(Long deptId, int page, int pagesize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Permission> selectPermissionList(Long roleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PagedList<Role> selectRolePagedList(int page, int pagesize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Permission> selectPermissionList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PermissionInfo> selectAllPermissionListByRoleId(Long roleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseResponse addRole(Role role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseResponse addPermissions(Long roleId, String permissionIds) {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.kamfu.model.dto;

import java.util.List;

import com.kamfu.entity.Permission;
import com.kamfu.entity.Role;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain  = true)
public class UserInfo {
	private Long userId;
	private Long deptId;
	private String username;
	private String name;
	private Role role;
	private String password;
	private String salt;
	List<Permission> permissionList;
}

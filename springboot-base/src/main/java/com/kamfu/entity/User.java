package com.kamfu.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.management.relation.RoleInfo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

    
@NoArgsConstructor
@Data
@Accessors(chain=true)
public class User implements Serializable {
    
	private static final long serialVersionUID = 1L;
    private Long id;
    private Long roleId;
    private String username;
    private String password;
    private String salt;
	private String name;

	private Date birthday;
	private int sex;
	private String email;
	private String phone;
	private Long deptId;
	private int status;
	private Long createUser;
	private Long updateUser;
    /**
     * 创建时间
     */
	private Date createTime;
    /**
     * 更新时间
     */
	private Date updateTime;
	public Collection<String> getRoleList(){
		Collection<String> list =new ArrayList();
		 Role role=new Role();
		 role.setName("admin");
		 list.add(role.getName());
		 return list;
	}
	
	
}

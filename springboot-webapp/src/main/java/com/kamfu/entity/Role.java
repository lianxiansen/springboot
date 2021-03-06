package com.kamfu.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
@NoArgsConstructor
@Data
@Accessors(chain=true)
public class Role implements Serializable {
    
	/**
	 * @Fields:TODO(用一句话描述这个变量表示什么)
	 */    
	private static final long serialVersionUID = 1L;
	/**
     * 主键ID
     */
    private Long id;
	private Long pid;
	private String pids;
	private String code;
	private String name;
	private String description;
	private int sort;
	private long createUser;
	private long updateUser;
    /**
     * 创建时间
     */
	private Date createTime;
    /**
     * 更新时间
     */
	private Date updateTime;
	
	

	
	public Collection<String> getMenuList(){
		Collection<String> list=new ArrayList<String>();
		Permission menu=new Permission();
		menu.setName("user:add");
		list.add(menu.getName());
		return list;
	}
}

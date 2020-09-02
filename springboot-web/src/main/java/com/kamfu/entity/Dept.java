package com.kamfu.entity;

import java.io.Serializable;
import java.util.Date;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @ClassName: Dept
 * @Description: 部门
 * @author liandy
 * @date 2020年6月30日
 *
 */
    
@NoArgsConstructor
@Data
@Accessors(chain=true)
public class Dept implements Serializable {
    
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
	private String name;
	private String description;
	private int sort;
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
}

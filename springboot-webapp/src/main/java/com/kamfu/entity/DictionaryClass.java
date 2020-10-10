package com.kamfu.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


/**
 * @ClassName: Dictionary
 * @Description: 字典分类
 * @author liandy
 * @date 2020年10月9日
 *
 */
    
@NoArgsConstructor
@Data
@Accessors(chain=true)
public class DictionaryClass implements Serializable{
	private static final long serialVersionUID = 4109273339022580828L;
	private Long id;
	 private String name;
	 private String code;
	 private int sort;
	    /**
	     * 创建时间
	     */
		private Date createTime;
	    /**
	     * 更新时间
	     */
		private Date updateTime;
}

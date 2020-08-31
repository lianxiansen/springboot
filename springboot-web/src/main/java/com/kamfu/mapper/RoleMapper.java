package com.kamfu.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.kamfu.entity.Role;

/**
 * <p>
 * 部门表 Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2018-12-07
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

//	Role getRoleByUserId(Long userId);


	
}

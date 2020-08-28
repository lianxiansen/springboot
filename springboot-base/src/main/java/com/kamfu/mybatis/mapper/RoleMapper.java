package com.kamfu.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.kamfu.entity.Role;
import com.kamfu.entity.User;

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

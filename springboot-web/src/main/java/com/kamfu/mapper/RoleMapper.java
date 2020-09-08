package com.kamfu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.kamfu.entity.Role;
import com.kamfu.model.RoleParam;
import com.kamfu.model.UserParam;

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

	List<Role> selectPagedList(@Param("param") RoleParam param);
	Integer selectCount(@Param("param") RoleParam param);
}

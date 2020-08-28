package com.kamfu.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;
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
public interface UserMapper extends BaseMapper<User> {

	User getByUsername(String username);
	@Select("select * from user")
	List<User> selectPagedList(@Param("deptId") Long deptId,int pageIndex);
}

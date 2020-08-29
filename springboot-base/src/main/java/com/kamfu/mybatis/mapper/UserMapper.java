package com.kamfu.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.kamfu.entity.User;
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
public interface UserMapper extends BaseMapper<User> {

	User getByUsername(@Param("username") String username);
	List<User> selectPagedList(@Param("param") UserParam param);
}

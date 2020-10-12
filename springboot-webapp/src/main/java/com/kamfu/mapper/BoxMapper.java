package com.kamfu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.kamfu.entity.Box;
import com.kamfu.model.param.BoxParam;


/**
 * <p>
 * 部门表 Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2018-12-07
 */
@Mapper
public interface BoxMapper extends BaseMapper<Box> {
	Integer selectCount(@Param("param") BoxParam param);
	List<Box> selectPagedList(@Param("param") BoxParam param);
}

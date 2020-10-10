package com.kamfu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.kamfu.entity.DictionaryClass;
import com.kamfu.model.param.DictionaryClassParam;

/**
 * <p>
 * 部门表 Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2018-12-07
 */
@Mapper
public interface DictionaryClassMapper extends BaseMapper<DictionaryClass> {

	List<DictionaryClass> selectPagedList(@Param("param") DictionaryClassParam param);
	Integer selectCount(@Param("param") DictionaryClassParam param);
}

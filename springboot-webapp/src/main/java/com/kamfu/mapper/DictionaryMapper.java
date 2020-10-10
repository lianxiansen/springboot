package com.kamfu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.kamfu.entity.Dictionary;
import com.kamfu.model.param.DictionaryParam;

/**
 * <p>
 * 部门表 Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2018-12-07
 */
@Mapper
public interface DictionaryMapper extends BaseMapper<Dictionary> {

	List<Dictionary> selectPagedList(@Param("param") DictionaryParam param);
	Integer selectCount(@Param("param") DictionaryParam param);
}

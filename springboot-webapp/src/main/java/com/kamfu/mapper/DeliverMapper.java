package com.kamfu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.kamfu.entity.Deliver;
import com.kamfu.model.param.DeliverParam;


@Mapper
public interface DeliverMapper extends BaseMapper<Deliver> {
	Integer selectCount(@Param("param") DeliverParam param);
	List<Deliver> selectPagedList(@Param("param") DeliverParam param);
}

package com.kamfu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.kamfu.entity.Cabinet;
import com.kamfu.model.param.CabinetParam;


/**
 * <p>
 * 部门表 Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2018-12-07
 */
@Mapper
public interface CabinetMapper extends BaseMapper<Cabinet> {
	Integer selectCount(@Param("param") CabinetParam param);
	List<Cabinet> selectPagedList(@Param("param") CabinetParam param);
}

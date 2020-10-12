	package com.kamfu.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kamfu.entity.Cabinet;
import com.kamfu.mapper.CabinetMapper;
import com.kamfu.model.PagedList;
import com.kamfu.model.param.CabinetParam;


/**
 * 后台用户管理
 */

@Service
public class CabinetService {

    @Resource
    private CabinetMapper cabinetMapper;

    
    public PagedList<Cabinet> selectPagedList(Long deptId,int page,int pagesize) {
    	CabinetParam param=new CabinetParam().setDeptId(deptId)
    			.setStart((page-1)*pagesize)
    			.setLimit(pagesize);
    	List<Cabinet> list= cabinetMapper.selectPagedList(param);
    	int count=cabinetMapper.selectCount(param);
    	PagedList<Cabinet> pagedList=new PagedList<Cabinet>().setCount(count)
    			.setData(list)
    			.setPage(page)
    			.setPagesize(pagesize);
    	return pagedList;
    }
    
}

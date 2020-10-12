	package com.kamfu.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kamfu.entity.Box;
import com.kamfu.mapper.BoxMapper;
import com.kamfu.model.PagedList;
import com.kamfu.model.param.BoxParam;


/**
 * 后台用户管理
 */

@Service
public class BoxService {

    @Resource
    private BoxMapper BoxMapper;

    
    public PagedList<Box> selectPagedList(String cabinetName,int page,int pagesize) {
    	BoxParam param=new BoxParam().setCabinetName(cabinetName)
    			.setStart((page-1)*pagesize)
    			.setLimit(pagesize);
    	List<Box> list= BoxMapper.selectPagedList(param);
    	int count=BoxMapper.selectCount(param);
    	PagedList<Box> pagedList=new PagedList<Box>().setCount(count)
    			.setData(list)
    			.setPage(page)
    			.setPagesize(pagesize);
    	return pagedList;
    }
    
}

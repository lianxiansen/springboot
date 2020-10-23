	package com.kamfu.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kamfu.entity.Deliver;
import com.kamfu.mapper.DeliverMapper;
import com.kamfu.model.PagedList;
import com.kamfu.model.param.DeliverParam;


/**
 * 后台用户管理
 */

@Service
public class DeliverService {

    @Resource
    private DeliverMapper deliverMapper;

    
    public PagedList<Deliver> selectPagedList(DeliverParam param) {    	
    	List<Deliver> list= deliverMapper.selectPagedList(param);
    	int count=deliverMapper.selectCount(param);
    	PagedList<Deliver> pagedList=new PagedList<Deliver>().setCount(count)
    			.setData(list)
    			.setPage(param.getPage())
    			.setPagesize(param.getLimit());
    	return pagedList;
    }
    
}

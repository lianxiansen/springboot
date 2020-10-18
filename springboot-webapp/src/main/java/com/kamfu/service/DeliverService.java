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
    private DeliverMapper DeliverMapper;

    
    public PagedList<Deliver> selectPagedList(int page,int pagesize) {
    	DeliverParam param=new DeliverParam()
    			.setStart((page-1)*pagesize)
    			.setLimit(pagesize);
    	List<Deliver> list= DeliverMapper.selectPagedList(param);
    	int count=DeliverMapper.selectCount(param);
    	PagedList<Deliver> pagedList=new PagedList<Deliver>().setCount(count)
    			.setData(list)
    			.setPage(page)
    			.setPagesize(pagesize);
    	return pagedList;
    }
    
}

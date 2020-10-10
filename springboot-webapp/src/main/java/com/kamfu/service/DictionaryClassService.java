	package com.kamfu.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kamfu.entity.DictionaryClass;
import com.kamfu.mapper.DictionaryClassMapper;
import com.kamfu.model.PagedList;
import com.kamfu.model.param.DictionaryClassParam;
import com.kamfu.util.Md5Util;
import com.kamfu.util.StringUtil;


/**
 * 后台用户管理
 */

@Service
public class DictionaryClassService {

    @Resource
    private DictionaryClassMapper dictionaryClassMapper;

    
    public PagedList<DictionaryClass> selectPagedList(int page,int pagesize) {
    	DictionaryClassParam param=new DictionaryClassParam()
    			.setStart((page-1)*pagesize)
    			.setLimit(pagesize);
    	List<DictionaryClass> list= dictionaryClassMapper.selectPagedList(param);
    	int count=dictionaryClassMapper.selectCount(param);
    	PagedList<DictionaryClass> pagedList=new PagedList<DictionaryClass>().setCount(count)
    			.setData(list)
    			.setPage(page)
    			.setPagesize(pagesize);
    	return pagedList;
    }
    
}

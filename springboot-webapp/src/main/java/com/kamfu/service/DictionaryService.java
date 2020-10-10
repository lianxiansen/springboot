	package com.kamfu.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kamfu.entity.Dictionary;
import com.kamfu.mapper.DictionaryMapper;
import com.kamfu.model.PagedList;
import com.kamfu.model.param.DictionaryParam;


/**
 * 后台用户管理
 */

@Service
public class DictionaryService {

    @Resource
    private DictionaryMapper dictionaryMapper;

    
    public PagedList<Dictionary> selectPagedList(Long dictionaryClassId,int page,int pagesize) {
    	DictionaryParam param=new DictionaryParam().setDictionaryClassId(dictionaryClassId)
    			.setStart((page-1)*pagesize)
    			.setLimit(pagesize);
    	List<Dictionary> list= dictionaryMapper.selectPagedList(param);
    	int count=dictionaryMapper.selectCount(param);
    	PagedList<Dictionary> pagedList=new PagedList<Dictionary>().setCount(count)
    			.setData(list)
    			.setPage(page)
    			.setPagesize(pagesize);
    	return pagedList;
    }
    
}

package com.kamfu.model;

import java.util.List;

import lombok.Data;
import lombok.experimental.Accessors;
@Data
@Accessors(chain  = true)
public class PagedList<T> {
	private int count;
	private int page;
	private int pagesize;
	private List<T> data;
}

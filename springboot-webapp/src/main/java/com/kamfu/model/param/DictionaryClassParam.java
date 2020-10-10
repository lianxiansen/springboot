package com.kamfu.model.param;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain  = true)
public class DictionaryClassParam {
	private Integer start;
	private Integer limit;
	private Long deptId;
}

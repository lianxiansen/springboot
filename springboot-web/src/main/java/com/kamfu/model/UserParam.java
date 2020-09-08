package com.kamfu.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain  = true)
public class UserParam {
	private Integer start;
	private Integer limit;
	private Long deptId;
}

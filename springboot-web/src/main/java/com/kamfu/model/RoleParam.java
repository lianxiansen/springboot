package com.kamfu.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain  = true)
public class RoleParam {
	private Integer start;
	private Integer limit;
}

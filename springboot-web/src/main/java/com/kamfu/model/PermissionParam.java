package com.kamfu.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain  = true)
public class PermissionParam {
	private Integer start;
	private Integer end;
}

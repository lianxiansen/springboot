package com.kamfu.model.param;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain  = true)
public class PermissionParam {
	private Integer start;
	private Integer end;
}

package com.kamfu.model.param;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain  = true)
public class CabinetParam {
	private Integer start;
	private Integer limit;
	private Long deptId;
}

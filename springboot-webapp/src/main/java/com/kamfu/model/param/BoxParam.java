package com.kamfu.model.param;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain  = true)
public class BoxParam {
	private Integer start;
	private Integer limit;
	private String cabinetName;
}

package com.kamfu.model.param;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain  = true)
public class DeliverParam {
	private Integer start;
	private Integer limit;
}

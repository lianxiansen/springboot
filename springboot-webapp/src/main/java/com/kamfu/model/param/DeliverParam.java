package com.kamfu.model.param;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain  = true)
public class DeliverParam {
	private Integer start;
	private Integer limit;
	private Integer page;
	private String addr;
	private Integer packgeStatu;
	private String pickupPhone;
}

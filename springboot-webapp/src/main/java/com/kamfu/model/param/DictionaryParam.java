package com.kamfu.model.param;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain  = true)
public class DictionaryParam {
	private Integer start;
	private Integer limit;
	private Long dictionaryClassId;
}

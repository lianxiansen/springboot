package com.kamfu.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain  = true)
public class PermissionInfo {
	private String name;
	private boolean checked;
	private Long id;
	@JsonProperty("pId")
	private Long pId;
	private boolean open;
}

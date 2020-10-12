package com.kamfu.entity;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor
@Data
@Accessors(chain=true)
public class Box {
	private Integer id;
	private String cabinetName;
	private int boxNum;
	private int size;
	private int statu;
	private String deliverID;
	private Date lastUseTime;
}

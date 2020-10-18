package com.kamfu.entity;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor
@Data
@Accessors(chain=true)
public class Deliver {
	private Integer id;
	private String cabinetName;
	private String openID;
	private String addr;
	private String postNum;
	private int boxNum;
	private int boxSize;
	private Integer deliverPayMoney;
	private Date deliverDate;
	private String takeCode;
	private int smsCnt;
	private int packgeStatu;
	private Date takeDate;
	private Integer takePayMoney;
	private String beneficiary;
	private String pickupPhone;
	private String msgOutId;
}

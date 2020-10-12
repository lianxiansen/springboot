package com.kamfu.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @ClassName: Cabinet
 * @Description: 箱体
 * @author liandy
 * @date 2020年10月9日
 *
 */
    
@NoArgsConstructor
@Data
@Accessors(chain=true)
public class Cabinet implements Serializable{
	private Integer id;
	private String cabinetName;
	private String addr;
	private String beneficiary;
	private String qrCode;
	private Date onlineData;
	private Integer smallChargeID;
	private Integer largeChargeID;
	private Integer mediumChargeID;
	private Long deptId;
}

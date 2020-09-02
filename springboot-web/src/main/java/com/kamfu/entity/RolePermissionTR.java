package com.kamfu.entity;

import java.io.Serializable;

/**
 * @ClassName: RoleMenuTR
 * @Description: 角色菜单关联
 * @author liandy
 * @date 2020年6月30日
 *
 */
    
public class RolePermissionTR implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;
    /**
     * 角色id
     */
    private Long roleId;
    /**
     * 菜单id
     */
    private Long permissionId;




}

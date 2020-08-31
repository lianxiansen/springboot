package com.kamfu.model;

import java.util.ArrayList;
import java.util.List;

import com.kamfu.util.StringUtil;

import lombok.Data;

/**
 * layui属性组件节点
 *
 * @author stylefeng
 * @Date 2019-8-26 14:01
 */
@Data
public class LayuiTreeNode implements Tree {

    /**
     * 节点id
     */
    private Long id;

    /**
     * 父级节点id
     */
    private Long pid;

    /**
     * 节点名称
     */
    private String title;

    /**
     * 节点是否初始展开
     */
    private Boolean spread;

    /**
     * 节点是否初始为选中状态
     */
    private Boolean checked;

    /**
     * 节点是否为禁用状态
     */
    private Boolean disabled;

    private List<LayuiTreeNode> children = new ArrayList<>();

    @Override
    public String getNodeId() {
        if (StringUtil.isNotEmpty(id+"")) {
            return String.valueOf(id);
        } else {
            return null;
        }
    }

    @Override
    public String getNodeParentId() {
        if (StringUtil.isNotEmpty(pid+"")) {
            return String.valueOf(pid);
        } else {
            return null;
        }
    }

    @Override
    public void setChildrenNodes(List childrenNodes) {
        this.children = childrenNodes;
    }

}

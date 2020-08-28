package com.kamfu.webapp.factory;

import java.util.ArrayList;
import java.util.List;

import com.kamfu.model.Tree;

import lombok.Data;



/**
 * @ClassName: LayuiTreeBuildFactory
 * @Description: LayuiTree构建工厂
 * @author Administrator
 * @date 2020年1月16日
 *
 * @param <T>
 */
    
@Data
public class LayuiTreeBuildFactory<T extends Tree> extends AbstractTreeBuildFactory<T> {

    /**
     * 椤剁骇鑺傜偣鐨勭埗鑺傜偣id(榛樿-1)
     */
    private String rootParentId = "-1";

    /**
     * 鏌ヨ瀛愯妭鐐圭殑闆嗗悎
     *
     * @param totalNodes     鎵�鏈夎妭鐐圭殑闆嗗悎
     * @param node           琚煡璇㈣妭鐐圭殑id
     * @param childNodeLists 琚煡璇㈣妭鐐圭殑瀛愯妭鐐归泦鍚�
     */
    private void buildChildNodes(List<T> totalNodes, T node, List<T> childNodeLists) {
        if (totalNodes == null || node == null) {
            return;
        }

        List<T> nodeSubLists = getSubChildsLevelOne(totalNodes, node);

        if (nodeSubLists.size() == 0) {

        } else {
            for (T nodeSubList : nodeSubLists) {
                buildChildNodes(totalNodes, nodeSubList, new ArrayList<>());
            }
        }

        childNodeLists.addAll(nodeSubLists);
        node.setChildrenNodes(childNodeLists);
    }

    /**
     * 鑾峰彇瀛愪竴绾ц妭鐐圭殑闆嗗悎
     *
     * @param list 鎵�鏈夎妭鐐圭殑闆嗗悎
     * @param node 琚煡璇㈣妭鐐圭殑model
     * @author fengshuonan
     */
    private List<T> getSubChildsLevelOne(List<T> list, T node) {
        List<T> nodeList = new ArrayList<>();
        for (T nodeItem : list) {
            if (nodeItem.getNodeParentId().equals(node.getNodeId())) {
                nodeList.add(nodeItem);
            }
        }
        return nodeList;
    }

    public List<T> doTreeBuild(List<T> nodes) {

        //鏋勫缓涔嬪墠鐨勮妭鐐瑰鐞嗗伐浣�
        List<T> readyToBuild = beforeBuild(nodes);

        //鍏蜂綋鏋勫缓鐨勮繃绋�
        List<T> builded = executeBuilding(readyToBuild);

        //鏋勫缓涔嬪悗鐨勫鐞嗗伐浣�
        return afterBuild(builded);
    }
    
    @Override
    protected List<T> beforeBuild(List<T> nodes) {

        //榛樿涓嶈繘琛屽墠缃鐞�,鐩存帴杩斿洖

        return nodes;
    }

    @Override
    protected List<T> executeBuilding(List<T> nodes) {
        for (T treeNode : nodes) {
            this.buildChildNodes(nodes, treeNode, new ArrayList<>());
        }
        return nodes;
    }
    private String getRootParentId(List<T> nodes) {
    	Long rootParentId=Long.MAX_VALUE;

        for (T node : nodes) {
            if (Long.valueOf(node.getNodeParentId()) <rootParentId) {
            	rootParentId=Long.valueOf(node.getNodeParentId());
            }
        }
        return rootParentId+"";
    }
    @Override
    protected List<T> afterBuild(List<T> nodes) {
    	this.rootParentId=getRootParentId(nodes);
        //鍘绘帀鎵�鏈夌殑浜岀骇鑺傜偣
        ArrayList<T> results = new ArrayList<>();
        for (T node : nodes) {
            if (node.getNodeParentId().equals(rootParentId)) {
                results.add(node);
            }
        }
        return results;
    }
}
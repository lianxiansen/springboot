/**
 * Copyright 2018-2020 stylefeng & fengshuonan (sn93@qq.com)
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.kamfu.webapp.factory;

import java.util.List;

/**
 * 鏍戞瀯寤虹殑鎶借薄绫伙紝瀹氫箟鏋勫缓tree鐨勫熀鏈楠�
 *
 * @author fengshuonan
 * @Date 2018/7/25 涓嬪崍5:59
 */
public abstract class AbstractTreeBuildFactory<T> {

    /**
     * 鏍戣妭鐐规瀯寤烘暣浣撹繃绋�
     *
     * @author fengshuonan
     * @Date 2018/7/26 涓婂崍9:45
     */
    public List<T> doTreeBuild(List<T> nodes) {

        //鏋勫缓涔嬪墠鐨勮妭鐐瑰鐞嗗伐浣�
        List<T> readyToBuild = beforeBuild(nodes);

        //鍏蜂綋鏋勫缓鐨勮繃绋�
        List<T> builded = executeBuilding(readyToBuild);

        //鏋勫缓涔嬪悗鐨勫鐞嗗伐浣�
        return afterBuild(builded);
    }

    /**
     * 鏋勫缓涔嬪墠鐨勫鐞嗗伐浣�
     *
     * @author fengshuonan
     * @Date 2018/7/26 涓婂崍10:10
     */
    protected abstract List<T> beforeBuild(List<T> nodes);

    /**
     * 鍏蜂綋鐨勬瀯寤鸿繃绋�
     *
     * @author fengshuonan
     * @Date 2018/7/26 涓婂崍10:11
     */
    protected abstract List<T> executeBuilding(List<T> nodes);

    /**
     * 鏋勫缓涔嬪悗鐨勫鐞嗗伐浣�
     *
     * @author fengshuonan
     * @Date 2018/7/26 涓婂崍10:11
     */
    protected abstract List<T> afterBuild(List<T> nodes);
}
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
package com.kamfu.model;

import java.util.List;

/**
 * 鏋勯�犳爲鑺傜偣鐨勬帴鍙ｈ鑼�
 *
 * @author fengshuonan
 * @date 2018-07-25-涓嬪崍5:59
 */
public interface Tree {

    /**
     * 鑾峰彇鑺傜偣id
     */
    String getNodeId();

    /**
     * 鑾峰彇鑺傜偣鐖秈d
     */
    String getNodeParentId();

    /**
     * 璁剧疆children
     */
    void setChildrenNodes(List childrenNodes);
}

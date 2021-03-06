/**
 * Copyright © 2018 organization waynechu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.waynechu.bootstarter.dynamicdatasource.strategy;

import javax.sql.DataSource;
import java.util.List;

/**
 * 默认使用组数据源中的第一个作为主数据源
 *
 * @author zhuwei
 * @since 2019/1/18 9:57
 */
public abstract class AbstractDynamicDataSourceStrategy implements DynamicDataSourceStrategy {

    /**
     * 选择当前LinkedList中的第一个作为主数据源
     *
     * @param dataSources 数据源选择库
     * @return 主数据源
     */
    @Override
    public DataSource determineMaster(List<DataSource> dataSources) {
        return dataSources.get(0);
    }
}

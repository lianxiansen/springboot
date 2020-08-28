package com.kamfu.mybatis;

import java.sql.SQLException;
import java.util.HashMap;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.kamfu.mybatis.properties.DruidProperties;
import com.kamfu.mybatis.properties.MutiDataSourceProperties;

@Configuration
@EnableTransactionManagement(order = 2)
@MapperScan("com.kamfu.*.mapper")
public class MybatisPlusConfig {

    @Autowired
    DruidProperties druidProperties;

    @Autowired
    MutiDataSourceProperties mutiDataSourceProperties;

    /**
     * 核心数据源
     */
    private DruidDataSource coreDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        druidProperties.config(dataSource);
        return dataSource;
    }

    /**
     * 另一个数据源
     */
    private DruidDataSource bizDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        druidProperties.config(dataSource);
        mutiDataSourceProperties.config(dataSource);
        return dataSource;
    }

    /**
     * 单数据源连接池配置
     */
    @Bean
    @ConditionalOnProperty(prefix = "sys-config", name = "muti-datasource-open", havingValue = "false")
    public DruidDataSource singleDatasource() {
        return coreDataSource();
    }

    /**
     * 多数据源连接池配置
     */
    @Bean
    @ConditionalOnProperty(prefix = "sys-config", name = "muti-datasource-open", havingValue = "true")
    public DynamicDataSource mutiDataSource() {

        DruidDataSource coreDataSource = coreDataSource();
        DruidDataSource bizDataSource = bizDataSource();

        try {
            coreDataSource.init();
            bizDataSource.init();
        } catch (SQLException sql) {
            sql.printStackTrace();
        }

        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put(DSEnum.DATA_SOURCE_CORE, coreDataSource);
        hashMap.put(DSEnum.DATA_SOURCE_BIZ, bizDataSource);
        dynamicDataSource.setTargetDataSources(hashMap);
        dynamicDataSource.setDefaultTargetDataSource(coreDataSource);
        return dynamicDataSource;
    }
    
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}



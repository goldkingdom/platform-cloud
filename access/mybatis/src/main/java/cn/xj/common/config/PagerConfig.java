package cn.xj.common.config;

import cn.xj.common.model.DynamicDataSource;
import cn.xj.common.sql.service.PagerService;
import cn.xj.common.sql.service.impl.MysqlPagerServiceImpl;
import cn.xj.common.sql.service.impl.OrclPagerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Welink on 2017/4/26.
 */
@Configuration
@ComponentScan("cn.xj.common")
public class PagerConfig {

    @Autowired
    private DynamicDataSource dynamicDataSource;

    @Bean
    public PagerService pagerService() {
        if ("com.mysql.jdbc.Driver".equals(dynamicDataSource.getDriverClassName())) {
            return new MysqlPagerServiceImpl();
        } else if ("oracle.jdbc.driver.OracleDriver".equals(dynamicDataSource.getDriverClassName())) {
            return new OrclPagerServiceImpl();
        } else {
            return null;
        }
    }

}

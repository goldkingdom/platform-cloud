package cn.xj.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Welink on 2017/4/28.
 */
@Component
@ConfigurationProperties(prefix = "baseConfig")
public class BaseConfig {

    private String version;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

}

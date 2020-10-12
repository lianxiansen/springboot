package com.kamfu.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * yml文件工具类
 */
@Component
public class YmlUtils {

    private static final String BOOTSTRAP_FILE = "application.yml";
    private static String PROFILES_ACTIVE = "spring.profiles.active";
    private static final String ACTIVE_PRO = "pro";
    private static final String ACTIVE_PRE = "pre";
    private static final String ACTIVE_DEV = "dev";

    public static boolean isNotPro() {
        return !isPro();
    }

    public static boolean isNotDev() {
        return !isDev();
    }

    public static boolean isPro() {
        return ACTIVE_PRO.equals(getProfilesActive());
    }

    public static boolean isDev() {
        return ACTIVE_DEV.equals(getProfilesActive());
    }
    public static boolean isPre() {
        return ACTIVE_PRE.equals(getProfilesActive());
    }

    @Value("${spring.profiles.active}")
    public String setProfilesActive(String activeValue){
        PROFILES_ACTIVE = activeValue;
        return PROFILES_ACTIVE;
    }

    public static String getProfilesActive() {
        return PROFILES_ACTIVE;
    }

    public static String getYmlProperty(String propertyName){
        return getYmlProperty(BOOTSTRAP_FILE, propertyName);
    }

    public static String getYmlProperty(String fileName,String propertyName){
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        yaml.setResources(new ClassPathResource(fileName));
        Properties properties = yaml.getObject();
        String property = properties.getProperty(propertyName);
        return property;
    }



}

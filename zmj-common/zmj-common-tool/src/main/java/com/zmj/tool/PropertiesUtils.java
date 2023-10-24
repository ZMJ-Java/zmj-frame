package com.zmj.tool;


import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author ZMJ
 * @Package com.zmj.tool
 * @describe 动态配置读取工具类
 * @date 2023/10/24 14:49
 */
public class PropertiesUtils {

    private Map<String, Properties> propertiesMap = new HashMap<>();

    private Map<String, Long> modifyTimeMap = new HashMap<>();

    private String configPath = "";

    public void setConfigPath(String configPath) {
        this.configPath = configPath;
    }

    private PropertiesUtils() {
    }


    public static class SingleHolder {
        private static PropertiesUtils instance = new PropertiesUtils();
    }

    public static PropertiesUtils getInstance() {
        return SingleHolder.instance;
    }


    public String getPropertyValue(String propertyFileName, String key) throws Exception {

        String fileName = coverFileName(propertyFileName);

        if (propertiesMap.get(fileName) == null) {
            loadProperties(fileName);
        } else {
            checkPropertiesModified(fileName);
        }

        return propertiesMap.get(fileName).getProperty(key);
    }


    private String coverFileName(String fileName) {
        if (!fileName.endsWith(".properties0")) {
            return fileName;
        }

        int index = fileName.lastIndexOf(".");
        fileName = fileName.substring(0, index);
        return fileName;
    }

    private void loadProperties(String fileName) throws Exception {
        //拿到file文件
        File file = getProperties(fileName);

        Long newTime = file.lastModified();

        if (propertiesMap.get(fileName) != null) {
            propertiesMap.remove(fileName);
        }

        Properties properties = new Properties();
        properties.load(new FileInputStream(file));
        propertiesMap.put(fileName, properties);
        modifyTimeMap.put(fileName, newTime);

    }

    private void checkPropertiesModified(String fileName) throws Exception {
        //拿到file文件
        File file = getProperties(fileName);
        long newTime = file.lastModified();
        Long lastModifiedTime = modifyTimeMap.get(fileName);
        if (newTime > lastModifiedTime) {
            loadProperties(fileName);
        }

    }

    private File getProperties(String fileName) throws URISyntaxException {
        File propertiesFile = null;
        if (this.configPath != null && !StringUtils.isBlank(configPath)) {
            return new File(this.configPath + File.separator + fileName + ".properties");
        }

        String dir = System.getProperty("user.dir") + File.separator + fileName + ".properties";

        propertiesFile = new File(dir);

        if (!propertiesFile.exists()) {
            URL url = PropertiesUtils.class.getResource("/" + fileName + ".properties");
            if (url != null) {
                propertiesFile = new File(url.toURI());
            }
        }
        return propertiesFile;

    }


}

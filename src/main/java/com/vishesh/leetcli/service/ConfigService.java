package com.vishesh.leetcli.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigService {

    private final Properties properties;

    public ConfigService(Properties properties) {
        this.properties = properties;
        InputStream inputStream = ConfigService.class.getClassLoader().getResourceAsStream("config.properties");
        if (inputStream == null){
            throw new IllegalStateException("config.properties not found.");
        }
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration.", e);
        }
    }

    public String getRepositoryPath() {
        return properties.getProperty("repo.path");
    }
}

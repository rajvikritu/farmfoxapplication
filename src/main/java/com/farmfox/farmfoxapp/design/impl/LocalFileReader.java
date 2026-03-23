package com.farmfox.farmfoxapp.design.impl;

import com.farmfox.farmfoxapp.design.FileReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
public class LocalFileReader implements FileReader {

    private final ResourceLoader resourceLoader;

    public LocalFileReader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public boolean supports(String path) {
        return path.startsWith("file:") || path.startsWith("classpath:");
    }

    @Override
    public String read(String path) throws Exception {
        Resource resource = resourceLoader.getResource(path);
        return new String(resource.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
    }
}

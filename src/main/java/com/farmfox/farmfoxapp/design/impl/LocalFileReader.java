package com.farmfox.farmfoxapp.design.impl;

import com.farmfox.farmfoxapp.design.FileReader;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;

@Component
public class LocalFileReader implements FileReader {

    private final ResourceLoader resourceLoader;

    private final ObjectMapper objectMapper;

    public LocalFileReader(ResourceLoader resourceLoader, ObjectMapper objectMapper) {
        this.resourceLoader = resourceLoader;
        this.objectMapper = objectMapper;
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
    public <T> T readFromFile(String filePath,
                               TypeReference<T> typeReference) {

        try {
            return objectMapper.readValue(
                    Paths.get(filePath).toFile(),
                    typeReference
            );
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JSON file", e);
        }
    }
}

package com.farmfox.farmfoxapp.service;

import com.farmfox.farmfoxapp.design.FileReader;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileReaderFactory {
    private final List<FileReader> readers;

    public FileReaderFactory(List<FileReader> readers) {
        this.readers = readers;
    }

    public String read(String path) throws Exception {
        return readers.stream()
                .filter(r -> r.supports(path))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No reader found for: " + path))
                .read(path);
    }
}

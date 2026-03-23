package com.farmfox.farmfoxapp.design;

public interface FileReader {
    boolean supports(String path);
    String read(String path) throws Exception;
}

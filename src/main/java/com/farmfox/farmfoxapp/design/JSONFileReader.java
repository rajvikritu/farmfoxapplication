package com.farmfox.farmfoxapp.design;

import com.farmfox.farmfoxapp.design.impl.LocalFileReader;
import com.farmfox.farmfoxapp.design.impl.S3FileReader;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Component;

@Component
public class JSONFileReader {

    private final S3FileReader s3FileReader;
    private final LocalFileReader localFileReader;

    public JSONFileReader(S3FileReader s3FileReader, LocalFileReader localFileReader) {
        this.s3FileReader = s3FileReader;
        this.localFileReader = localFileReader;
    }

    public <T> T readJson(String bucket,
                          String protocol,
                          String location,
                          TypeReference<T> typeReference) {

        if ("S3".equalsIgnoreCase(protocol)) {
            return s3FileReader.readJsonFromS3(bucket,location, typeReference);
        }

        if ("file".equalsIgnoreCase(protocol)) {
            return localFileReader.readFromFile(location, typeReference);
        }

        throw new IllegalArgumentException("Unsupported protocol: " + protocol);
    }
}

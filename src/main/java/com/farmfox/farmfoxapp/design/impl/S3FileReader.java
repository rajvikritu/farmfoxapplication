package com.farmfox.farmfoxapp.design.impl;

import com.farmfox.farmfoxapp.configuration.FarmFoxDataConfig;
import com.farmfox.farmfoxapp.configuration.SupplierConfig;
import com.farmfox.farmfoxapp.design.FileReader;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.services.s3.model.ListBucketsRequest;
import software.amazon.awssdk.services.s3.model.ListBucketsResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;


@Component
public class S3FileReader implements FileReader {
    private final S3Client s3Client;
    private final ObjectMapper objectMapper;

    public S3FileReader(S3Client s3Client, ObjectMapper objectMapper) {
        this.s3Client = s3Client;
        this.objectMapper = objectMapper;
    }

    @Override
    public boolean supports(String path) {
        return path.startsWith("s3://");
    }

    @Override
    public String read(String path) throws Exception {
        String withoutPrefix = path.replace("s3://", "");

        String bucket = withoutPrefix.substring(0, withoutPrefix.indexOf("/"));
        String key = withoutPrefix.substring(withoutPrefix.indexOf("/") + 1);

        GetObjectRequest request = GetObjectRequest.builder()
                .bucket(bucket)
                .key(key)
                .build();

        return new String(
                s3Client.getObject(request).readAllBytes(),
                StandardCharsets.UTF_8
        );
    }
    public void listBuckets() {
        ListBucketsRequest request = ListBucketsRequest.builder().build();
        ListBucketsResponse response = s3Client.listBuckets(request);
        response.buckets().forEach(bucket -> System.out.println(bucket.name()));
    }


    public <T> T readJsonFromS3(String bucketName,
                                String key,
                                TypeReference<T> typeReference) {

        GetObjectRequest request = GetObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .build();

        try (ResponseInputStream<GetObjectResponse> inputStream =
                     s3Client.getObject(request)) {

            return objectMapper.readValue(inputStream, typeReference);

        } catch (IOException e) {
            throw new RuntimeException(
                    "Failed to read JSON from S3. Bucket=" + bucketName + ", Key=" + key,
                    e);
        }
    }
}

package com.farmfox.farmfoxapp.design.impl;

import com.farmfox.farmfoxapp.design.FileReader;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.ListBucketsRequest;
import software.amazon.awssdk.services.s3.model.ListBucketsResponse;

import java.nio.charset.StandardCharsets;


@Component
 class S3FileReader implements FileReader {
    private final S3Client s3Client;

    public S3FileReader(S3Client s3Client) {
        this.s3Client = s3Client;
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
}

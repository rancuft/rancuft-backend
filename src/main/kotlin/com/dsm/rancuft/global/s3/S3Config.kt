package com.dsm.rancuft.global.s3

import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class S3Config {
    @Value("\${cloud.aws.credentials.accessKey}")
    final lateinit var accessKey: String;
    @Value("\${cloud.aws.credentials.secretKey}")
    final lateinit var secretKey: String;
    @Value("\${cloud.aws.region.static}")
    lateinit var region: String

    @Bean
    fun amazonS3Client(): AmazonS3 {
        val credentials = BasicAWSCredentials(accessKey, secretKey)

        return AmazonS3ClientBuilder
            .standard()
            .withCredentials(AWSStaticCredentialsProvider(credentials))
            .withRegion(region)
            .build()
    }
}
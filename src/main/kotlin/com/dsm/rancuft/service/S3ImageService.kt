package com.dsm.rancuft.service

import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.model.CannedAccessControlList
import com.amazonaws.services.s3.model.ObjectMetadata
import com.amazonaws.services.s3.model.PutObjectRequest
import com.dsm.rancuft.entity.Image
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.InputStream
import java.util.*

@Service
class S3ImageService (
    private val amazonS3: AmazonS3)
{
    @Value("\${cloud.aws.s3.bucket}")
    final lateinit var bucket: String

    fun uploadFile(file:MultipartFile) : Image {
        val fileName :String = createFileName(file.originalFilename!!)

        val objectMetadata = ObjectMetadata()
        objectMetadata.contentType = file.contentType

        val inputStream = file.inputStream
        upload(fileName, inputStream, objectMetadata)

        return Image(fileName, getFileUrl(fileName))
    }

    private fun createFileName(fileName: String) :String{
        return UUID.randomUUID().toString()+getFileExtension(fileName)
    }

    private fun getFileExtension(fileName: String) : String {
        return fileName.substring(fileName.lastIndexOf("."))
    }

    fun upload( fileName: String,  inputStream:InputStream, objectMetadata: ObjectMetadata) {
        amazonS3.putObject(PutObjectRequest(bucket, fileName, inputStream, objectMetadata).withCannedAcl(
            CannedAccessControlList.PublicRead))

    }

    fun getFileUrl(fileName: String) : String{
        return amazonS3.getUrl(bucket, fileName).toString()
    }

}
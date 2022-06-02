package com.dsm.rancuft.repository

import com.dsm.rancuft.entity.Comment
import org.springframework.data.repository.CrudRepository

interface CommentRepository :CrudRepository<Comment, Int>{
}
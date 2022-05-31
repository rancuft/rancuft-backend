package com.dsm.rancuft.service

import com.dsm.rancuft.entity.Comment
import com.dsm.rancuft.repository.CommentRepository
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import javax.annotation.PostConstruct

@RequiredArgsConstructor
@Component
class InitDBService(private val initDB : InitDB) {

//    @PostConstruct
    fun init() {
        initDB.commentInsert()
    }


    @RequiredArgsConstructor
    @Transactional
    @Component
    class InitDB(private val commentRepository: CommentRepository ) {

        fun commentInsert(){
            val comments = ArrayList<Comment>()

            comments.add(Comment("모든 일이 시원시원하게 풀릴 거예요"))
            comments.add(Comment("당신의 행복을 응원해요"))
            comments.add(Comment("오늘 하늘을 한 번 바라봐요"))
            comments.add(Comment("쉰다고 뒤쳐지는 건 아니에요"))
            comments.add(Comment("항상 응원해용가리"))
            comments.add(Comment("💛"))
            comments.add(Comment("걱정을 잠시 내려놓는 하루 어때요?"))
            comments.add(Comment("하루종일 웃는 하루 보내길 바라요"))
            comments.add(Comment("당신이 좋아하는 일을 응원해"))
            comments.add(Comment("우리는 모두 애기야"))
            comments.add(Comment("행복티비 사랑티비 응원티비"))
            comments.add(Comment("사랑해줘서 고마워요"))

            commentRepository.saveAll(comments)
        }

    }
}
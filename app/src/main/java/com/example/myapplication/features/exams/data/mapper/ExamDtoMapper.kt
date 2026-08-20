package com.example.myapplication.features.exams.data.mapper

import android.R.attr.id
import com.example.myapplication.features.exams.data.remote.dto.exam.ExamDto
import com.example.myapplication.features.exams.domain.models.Exam

fun ExamDto.toDomain(): Exam {
    return Exam(
        examId = _id,
        active = active ,
        duration = duration,
        numberOfQuestions = numberOfQuestions ,
        subjectId= subject ,
        title = title
    )
}
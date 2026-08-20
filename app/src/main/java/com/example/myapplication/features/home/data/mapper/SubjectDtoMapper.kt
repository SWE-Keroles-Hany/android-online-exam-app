package com.example.myapplication.features.home.data.mapper

import android.R.attr.icon
import android.R.attr.id
import android.R.attr.name
import com.example.myapplication.features.home.data.remote.dto.SubjectDto
import com.example.myapplication.features.home.domain.models.Subject

fun SubjectDto.toDomain():Subject {
    return Subject(
        id = _id ,
        icon = icon ,
        name = name
    );
}
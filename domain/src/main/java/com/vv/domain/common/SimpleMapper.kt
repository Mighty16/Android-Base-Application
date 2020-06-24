package com.vv.domain.common

interface SimpleMapper<IN,OUT> {

    fun map(from:IN):OUT
    fun map(from:List<IN>):List<OUT>{
        return from.map { map(it) }
    }
}
package com.example.mytetris.helper

fun array2dOfByte(sizeOuter: Int, sizeInner: Int): Array<ByteArray>
        = Array(sizeOuter) { ByteArray(sizeInner) }
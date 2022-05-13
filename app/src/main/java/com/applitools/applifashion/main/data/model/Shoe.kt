package com.applitools.applifashion.main.data.model


import androidx.compose.ui.graphics.painter.Painter
import java.io.Serializable

data class Shoe(
    var name: String,
    var imageResource: Painter,
    var currentPrice: String,
    var oldPrice: String = ""
): Serializable
package com.example.videoteca.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import java.io.InputStream
import java.nio.charset.Charset
import java.security.AccessControlContext

fun Context.getJsonFromAssets(file: String) : String? {
    var json = ""
    val stream : InputStream = assets.open(file)
    val size : Int = stream.available()
    val buffer = ByteArray(size)
    stream.read(buffer)
    stream.close()

    json = String(buffer, Charset.defaultCharset())
    return json
}

fun ImageView.loadImage(image: String){

    Glide.with(this)
        .load(image)
        .into(this)

}
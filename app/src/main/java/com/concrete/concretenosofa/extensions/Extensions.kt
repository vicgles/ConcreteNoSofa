package com.concrete.concretenosofa.extensions

import android.view.View
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo

fun Double.toTempFormat() = this.toString().replace(".0","")

fun View.shake(duration: Long) {
    YoYo.with(Techniques.Shake).duration(duration).playOn(this)
}
fun View.slideIn(duration: Long) {
    this.visible()
    YoYo.with(Techniques.SlideInLeft).duration(duration).playOn(this)
}
fun View.slideInRight(duration: Long) {
    this.visible()
    YoYo.with(Techniques.SlideInRight).duration(duration).playOn(this)
}
fun View.startMoving(){
    YoYo.with(Techniques.Pulse).duration(3000).onEnd { startMoving() }.playOn(this)
}

fun View.showUp(){
    this.visible()
    YoYo.with(Techniques.Landing).duration(2000).onEnd { startMoving() }.playOn(this)
}

fun View.visible(){
    this.visibility = View.VISIBLE
}
fun View.hide(){
    this.visibility = View.VISIBLE
}

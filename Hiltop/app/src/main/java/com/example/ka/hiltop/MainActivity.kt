package com.example.ka.hiltop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.gsm.GsmCellLocation
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    //field injection
    @Inject
    lateinit var someClazz: SomeClazz

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println(someClazz.doSomething())
    }

}


@ActivityScoped //This will not crash
// @FragmentScoped this will crash
class SomeClazz
@Inject
constructor(
    private val someInterFaceImpl: SomeInterFace,
    private val gson: Gson
){

    fun doSomething(): String{
        return "Look I did a thing! ${someInterFaceImpl.getAThing()} "
    }
}


class SomeInterFaceImpl
@Inject
constructor() : SomeInterFace{

    override fun getAThing(): String {
        return "A Thing"
    }

}


interface SomeInterFace{
    fun  getAThing():String
}



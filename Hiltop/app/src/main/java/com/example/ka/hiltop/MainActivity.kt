package com.example.ka.hiltop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
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
        println(someClazz.doSomeOTTHERThings())
    }

}

class SomeClazz
@Inject
constructor(
        //Constructor Injection
        private val someOtherClazz: SomeOtherClazz
){

    fun doSomething(): String{
        return "Look I did a thing!"
    }

    fun doSomeOTTHERThings():String{
        return someOtherClazz.doSomeOtherThing()
    }
}

class SomeOtherClazz
@Inject
constructor(){
    fun doSomeOtherThing(): String{
        return "I do other things!"
    }
}
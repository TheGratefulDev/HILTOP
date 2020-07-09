package com.example.ka.hiltop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Inject
import javax.inject.Singleton

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


@AndroidEntryPoint
class MyFragment : Fragment(){
    @Inject
    lateinit var someClazz: SomeClazz

}

@ActivityScoped //This will not crash
// @FragmentScoped this will crash
class SomeClazz
@Inject
constructor(){

    fun doSomething(): String{
        return "Look I did a thing!"
    }
}


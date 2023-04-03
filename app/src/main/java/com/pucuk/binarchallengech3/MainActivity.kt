package com.pucuk.binarchallengech3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pucuk.binarchallengech3.fragment.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragmentManager = supportFragmentManager
        val homeFragment = HomeFragment()
        val fragment = fragmentManager.findFragmentByTag(HomeFragment::class.java.simpleName)

        if (fragment !is HomeFragment) {
            fragmentManager
                .beginTransaction()
                .add(R.id.frameContainer, homeFragment, HomeFragment::class.java.simpleName)
                .commit()
        }
    }
}
package com.pignasoft.dotasks.app.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pignasoft.dotasks.R
import kotlinx.coroutines.ObsoleteCoroutinesApi

class MainActivity : AppCompatActivity() {
    @ObsoleteCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

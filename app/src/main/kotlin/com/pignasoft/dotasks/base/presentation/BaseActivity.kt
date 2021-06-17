package com.pignasoft.dotasks.base.presentation

import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity(@LayoutRes layoutResourceId: Int) :
    AppCompatActivity(layoutResourceId)

package com.example.apple.mindsharpner.di.Qualifier


import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

import javax.inject.Qualifier

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
annotation class NormalOkHttpClient
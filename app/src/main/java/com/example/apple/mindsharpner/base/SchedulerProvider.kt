package com.example.apple.mindsharpner.base

import io.reactivex.Scheduler


interface SchedulerProvider {

    fun ui(): Scheduler

    fun computation(): Scheduler

    fun io(): Scheduler

}
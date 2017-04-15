package com.m2f.wallapop.domain.executor

import io.reactivex.Scheduler

/**
 * @author Marc Moreno
 * @version 1
 */
interface PostExecutionThread {

    val scheduler: Scheduler
}
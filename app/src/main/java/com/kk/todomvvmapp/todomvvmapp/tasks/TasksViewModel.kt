package com.kk.todomvvmapp.todomvvmapp.tasks

import android.content.Context
import android.databinding.BaseObservable
import com.kk.todomvvmapp.todomvvmapp.data.TasksRepository

class TasksViewModel(repository: TasksRepository,
                     context: Context): BaseObservable() {

    private var mContext: Context? = context
    private var mTasksRepository: TasksRepository? = repository

    init {
        // do nothing
    }
}
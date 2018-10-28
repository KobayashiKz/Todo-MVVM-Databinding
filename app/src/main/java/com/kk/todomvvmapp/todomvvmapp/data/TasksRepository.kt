package com.kk.todomvvmapp.todomvvmapp.data

class TasksRepository: TasksDataSource {

    var mTasksRemoteDataSource: TasksDataSource? = null
    var mTasksLocalDataSource: TasksDataSource? = null

    companion object {
        var sInstance: TasksRepository? = null

        fun getInstance(tasksRemoteDataSource: TasksDataSource,
                        tasksLocalDataSource: TasksDataSource): TasksRepository? {
            if (sInstance == null) {
                sInstance = TasksRepository(
                    tasksRemoteDataSource, tasksLocalDataSource)
            }
            return sInstance
        }

        fun destroyInstance() {
            sInstance = null
        }
    }

    constructor(tasksRemoteDataSource: TasksDataSource,
                tasksLocalDataSource: TasksDataSource) {
        mTasksRemoteDataSource = tasksRemoteDataSource
        mTasksLocalDataSource = tasksLocalDataSource
    }
}
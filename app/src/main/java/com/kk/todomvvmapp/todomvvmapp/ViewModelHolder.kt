package com.kk.todomvvmapp.todomvvmapp

import android.os.Bundle
import android.support.v4.app.Fragment

class ViewModelHolder<VM>: Fragment() {

    private var mViewModel: VM? = null

    companion object {
        fun <M> createContainer(viewModel: M): ViewModelHolder<M> {
           val viewModelContainer: ViewModelHolder<M> = ViewModelHolder()
            viewModelContainer.setViewModel(viewModel)
            return viewModelContainer
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    fun getViewModel(): VM? {
        return mViewModel
    }

    fun setViewModel(viewModel: VM) {
        mViewModel = viewModel
    }
}


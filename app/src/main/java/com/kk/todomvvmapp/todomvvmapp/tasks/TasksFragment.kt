package com.kk.todomvvmapp.todomvvmapp.tasks

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*
import com.kk.todomvvmapp.todomvvmapp.R

class TasksFragment : Fragment() {

    init {
        // do nothing
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        // オプションメニューの追加
        setHasOptionsMenu(true)

        return inflater.inflate(R.layout.fragment_tasks, container, false)
    }

    /**
     * インスタンスの生成処理
     */
    fun newInstance(): TasksFragment {
        return TasksFragment()
    }

    /**
     * {@inheritDoc}
     */
    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.tasks_fragment_menu, menu)
    }

    /**
     * {@inheritDoc}
     */
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId) {
            R.id.menu_filter -> {
                // TODO フィルタタップ時の処理
            }
            R.id.menu_clear -> {
                // TODO クリアタップ時の処理
            }
            R.id.menu_refresh -> {
                // TODO 更新タップ時の処理
            }
            else -> {
                // do nothing
            }
        }
        return true
    }
}

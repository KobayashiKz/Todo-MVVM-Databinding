package com.kk.todomvvmapp.todomvvmapp.tasks

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import com.kk.todomvvmapp.todomvvmapp.R
import com.kk.todomvvmapp.todomvvmapp.util.ActivityUtil

class MainActivity : AppCompatActivity() {

    private var mDrawerLayout: DrawerLayout? = null

    private var mTasksViewModel: TasksViewModel? = null

    companion object {
        const val TASKS_VIEWMODEL_TAG: String = "tasks_viewmodel_tag"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupToolbar()

        setupNavigationDrawer()

        // Fragmentの生成
        val tasksFragment: TasksFragment = findOrCreateViewFragment()

        // ViewModelの生成
//        mTasksViewModel = findOrCreateViewModel()
    }

    /**
     * タスクリストを管理するTasksFragmentを追加する処理
     */
    private fun findOrCreateViewFragment(): TasksFragment {
        val tasksFragment: TasksFragment = TasksFragment().newInstance()
        ActivityUtil.addFragmentToActivity(supportFragmentManager,
            tasksFragment, R.id.contentFrame
        )
        return tasksFragment
    }

    /**
     * ViewModelの生成
     * TODO: 処理の追加
     */
//    private fun findOrCreateViewModel(): TasksViewModel {
        // TODO: Injection
//        val retainedViewModel: ViewModelHolder<TasksViewModel> =
//            supportFragmentManager.findFragmentByTag(TASKS_VIEWMODEL_TAG)
//                    as ViewModelHolder<TasksViewModel>

//        if (retainedViewModel != null && retainedViewModel.getViewModel() != null) {
//            return retainedViewModel.getViewModel()!!
//        }
//        else {
//        }
//    }

    /**
     * ツールバーの初期設定
     */
    private fun setupToolbar() {
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        // ハンバーガー画像を設置
        val actionbar : ActionBar? = supportActionBar
        actionbar?.setHomeAsUpIndicator(R.drawable.ic_menu)
        // タップイベントの有効化
        actionbar?.setDisplayHomeAsUpEnabled(true)
    }

    /**
     * ハンバーガー画像がタップされた際の処理
     */
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> {
                // ドロワーメニューを開く
                mDrawerLayout?.openDrawer(GravityCompat.START)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    /**
     * ドロワーメニューの初期設定
     */
    private fun setupNavigationDrawer() {
        // ドロワーメニューのステータスバーに色を設定
        mDrawerLayout = findViewById(R.id.drawer_layout)
        mDrawerLayout?.setStatusBarBackground(R.color.colorPrimaryDark)
        // ドロワーのNavigationViewの処理を設定する
        val navigationView: NavigationView = findViewById(R.id.nav_view)
        setupDrawerContent(navigationView)
    }

    /**
     * ドロワーメニューのNavigationViewタップ時の処理
     */
    private fun setupDrawerContent(navigationView: NavigationView) {
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.list_navigation_menu_item -> {
                    // do nothing
                }
                R.id.statistics_navigation_menu_item -> {
                    // TODO: タップ時の処理
                }
                else -> {
                    // do nothing
                }
            }

            menuItem.isChecked = true
            // タップされたらドロワーメニューを必ず閉じる
            mDrawerLayout?.closeDrawers()
            true
        }
    }
}

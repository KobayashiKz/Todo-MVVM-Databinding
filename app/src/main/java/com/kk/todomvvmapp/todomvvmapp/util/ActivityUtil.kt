package com.kk.todomvvmapp.todomvvmapp.util

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction

class ActivityUtil {

    companion object {
        /**
         * 対象のレイアウトに対してFragmentを追加する処理
         *
         * @param fragmentManager フラグメントマネージャー
         * @param fragment 追加したいFragment
         * @param frameId 追加したいリソースID
         */
        fun addFragmentToActivity(fragmentManager: FragmentManager,
                                  fragment: Fragment, frameId: Int) {
            val transaction: FragmentTransaction = fragmentManager.beginTransaction()
            transaction.add(frameId, fragment)
            transaction.commit()
        }
    }
}
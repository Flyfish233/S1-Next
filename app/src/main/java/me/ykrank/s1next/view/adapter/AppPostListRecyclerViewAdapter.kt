package me.ykrank.s1next.view.adapter

import android.app.Activity
import androidx.lifecycle.LifecycleOwner

import com.github.ykrank.androidtools.ui.adapter.delegate.FooterProgressAdapterDelegate

import me.ykrank.s1next.data.api.app.model.AppThread
import me.ykrank.s1next.view.adapter.delegate.AppPostAdapterDelegate

/**
 * This [android.support.v7.widget.RecyclerView.Adapter]
 * has another item type [FooterProgressAdapterDelegate]
 * in order to implement pull up to refresh.
 */
class AppPostListRecyclerViewAdapter(
    activity: Activity,
    lifecycleOwner: LifecycleOwner,
    quotePid: String?
) : BaseRecyclerViewAdapter(activity, true) {

    private val postAdapterDelegate: AppPostAdapterDelegate = AppPostAdapterDelegate(activity, lifecycleOwner, quotePid)

    init {
        addAdapterDelegate(postAdapterDelegate)
    }

    fun setThreadInfo(threadInfo: AppThread) {
        postAdapterDelegate.setThreadInfo(threadInfo)
    }
}

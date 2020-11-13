package com.fmt.kotlin.eyepetizer.provider.router

import android.app.Activity
import android.view.View
import androidx.core.app.ActivityOptionsCompat
import com.alibaba.android.arouter.launcher.ARouter
import com.fmt.kotlin.eyepetizer.common.ext.toJson
import com.fmt.kotlin.eyepetizer.provider.constant.BaseConstant
import com.fmt.kotlin.eyepetizer.provider.model.Data

fun go2VideoPlayerActivity(
    activity: Activity,
    view: View?,
    data: Data,
    fromRelate: Boolean = false
) {
    ARouter.getInstance().build(RouterPath.Video.PATH_VIDEO_HOME)
        .also { postcard ->
            view?.let { shareView ->
                postcard.withOptionsCompat(
                    ActivityOptionsCompat.makeSceneTransitionAnimation(
                        activity,
                        shareView,
                        BaseConstant.SHARED_ELEMENT_NAME
                    )
                )
            }
        }
        .withString(BaseConstant.VIDEO_MODE_KEY, toJson(data))
        .withBoolean(BaseConstant.VIDEO_IS_FROM_RELATE_KEY, fromRelate)
        .navigation(activity)
}
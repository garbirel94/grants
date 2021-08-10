package com.garbirel.jetpack.ui.fragment.home

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.garbirel.jetpack.R
import com.garbirel.jetpack.model.bean.BannerResponse
import com.zhpan.bannerview.BaseBannerAdapter
import com.zhpan.bannerview.BaseViewHolder
import me.hgj.jetpackmvvm.base.appContext

class HomeBannerAdapter : BaseBannerAdapter<BannerResponse, HomeBannerAdapter.HomeBannerViewHolder>() {
    override fun getLayoutId(viewType: Int) = R.layout.item_banner

    override fun createViewHolder(itemView: View, viewType: Int): HomeBannerViewHolder {
        return HomeBannerViewHolder(itemView)
    }

    override fun onBind(
        holder: HomeBannerViewHolder?,
        data: BannerResponse?,
        position: Int,
        pageSize: Int
    ) {
        holder?.bindData(data,position,pageSize)
    }

    class HomeBannerViewHolder(view: View) : BaseViewHolder<BannerResponse>(view) {
        override fun bindData(data: BannerResponse?, position: Int, pageSize: Int) {
            val img = itemView.findViewById<ImageView>(R.id.banner_home_img)
            data?.let {
                Glide.with(appContext)
                    .load(it.imagePath)
                    .transition(DrawableTransitionOptions.withCrossFade(500))
                    .into(img)
            }
        }
    }
}


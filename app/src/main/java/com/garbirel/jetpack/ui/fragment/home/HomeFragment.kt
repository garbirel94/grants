package com.garbirel.jetpack.ui.fragment.home

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.blankj.utilcode.util.ConvertUtils
import com.garbirel.jetpack.R
import com.garbirel.jetpack.base.BaseFragment
import com.garbirel.jetpack.databinding.FragmentHomeBinding
import com.garbirel.jetpack.ext.*
import com.garbirel.jetpack.model.bean.BannerResponse
import com.garbirel.jetpack.weight.recyclerview.DefineLoadMoreView
import com.garbirel.jetpack.weight.recyclerview.SpaceItemDecoration
import com.kingja.loadsir.core.LoadService
import com.yanzhenjie.recyclerview.SwipeRecyclerView
import com.zhpan.bannerview.BannerViewPager
import kotlinx.android.synthetic.main.fragment_home.*
import me.hgj.jetpackmvvm.ext.nav
import me.hgj.jetpackmvvm.ext.navigateAction
import me.hgj.jetpackmvvm.ext.parseState

class HomeFragment : BaseFragment<RequestHomeViewModel,FragmentHomeBinding>(){
    override fun layoutId() = R.layout.fragment_home

    //适配器
    private val articleAdapter: HomeArticleAdapter by lazy { HomeArticleAdapter(arrayListOf(), true) }

    //请求数据ViewModel
    private val requestHomeViewModel: RequestHomeViewModel by viewModels()

    //请求数据ViewModel
    private val requestCollectViewModel: RequestCollectViewModel by viewModels()

    //recyclerview的底部加载view 因为在首页要动态改变他的颜色，所以加了他这个字段
    private lateinit var footView: DefineLoadMoreView

    //界面状态管理者
    private lateinit var loadsir: LoadService<Any>

    override fun initView(savedInstanceState: Bundle?) {
        loadsir = loadServiceInit(swipeRefresh) {
            loadsir.showLoading()
            requestHomeViewModel.getHomeData(true)
            requestHomeViewModel.getBannerData()
        }
        //初始化recyclerView
        home_rv.init(LinearLayoutManager(context), articleAdapter).let {
            //因为首页要添加轮播图，所以我设置了firstNeedTop字段为false,即第一条数据不需要设置间距
            it.addItemDecoration(SpaceItemDecoration(0, ConvertUtils.dp2px(8f), false))
            footView = it.initFooter(SwipeRecyclerView.LoadMoreListener {
                requestHomeViewModel.getHomeData(false)
            })
        }
        //初始化 SwipeRefreshLayout
        swipeRefresh.init {
            //触发刷新监听时请求数据
            requestHomeViewModel.getHomeData(true)
        }

        articleAdapter.run {
            setCollectClick { item, v, _ ->
                if (v.isChecked) {
                    requestCollectViewModel.unCollect(item.id)
                } else {
                    requestCollectViewModel.collect(item.id)
                }
            }
            setOnItemClickListener { adapter, view, position ->

            }
            addChildClickViewIds(R.id.item_home_author, R.id.item_project_author)
            setOnItemChildClickListener { adapter, view, position ->
                when (view.id) {
                    R.id.item_home_author, R.id.item_project_author -> {

                    }
                }
            }
        }
    }

    override fun lazyLoadData() {
        super.lazyLoadData()
        loadsir.showLoading()
        requestHomeViewModel.getHomeData(true)
        requestHomeViewModel.getBannerData()
    }

    override fun createObserver() {
        super.createObserver()
        requestHomeViewModel.run {
            //监听首页文章列表请求的数据变化
            homeData.observe(viewLifecycleOwner, Observer {
                //设值 新写了个拓展函数，搞死了这个恶心的重复代码
                loadListData(it, articleAdapter, loadsir, home_rv, swipeRefresh)
            })
            bannerData.observe(viewLifecycleOwner, Observer {
                parseState(it, { data ->
                    if (home_rv.headerCount == 0) {
                        val headView = LayoutInflater.from(context).inflate(R.layout.include_banner, null).apply {
                            findViewById<BannerViewPager<BannerResponse, HomeBannerAdapter.HomeBannerViewHolder>>(R.id.banner_view).apply {
                                adapter = HomeBannerAdapter()
                                setLifecycleRegistry(lifecycle)
                                setOnPageClickListener {

                                }
                                create(data)
                            }
                        }
                        home_rv.addHeaderView(headView)
                    }
                })
            })
        }
    }
}
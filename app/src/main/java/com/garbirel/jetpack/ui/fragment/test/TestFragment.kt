package com.garbirel.jetpack.ui.fragment.test

import PermissionHelper
import android.content.Context
import android.content.pm.ApplicationInfo
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Rect
import android.os.Bundle
import android.util.Log
//import androidx.lifecycle.rxLifeScope
import com.garbirel.jetpack.R
import com.garbirel.jetpack.base.BaseFragment
import com.garbirel.jetpack.databinding.FragmentTestBinding
import com.garbirel.jetpack.ext.showMessage
import com.google.gson.JsonObject
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream

class TestFragment : BaseFragment<TestViewModel, FragmentTestBinding>(){

    override fun layoutId() = R.layout.fragment_test

    override fun initView(savedInstanceState: Bundle?) {
        mDatabind.vm = mViewModel
        mDatabind.click = ProxyClick()
    }

    override fun lazyLoadData() {
        super.lazyLoadData()

    }

    override fun createObserver() {
        super.createObserver()
        mViewModel.name.set(getAppList(requireActivity().applicationContext).toString())
    }

    inner class ProxyClick {
        fun compress() {
            /*rxLifeScope.launch {
                val imgUri = FileUtils.getPicSaveUrl(requireContext(), "${System.currentTimeMillis()}.jpg")
                CameraUtils.openCamera(
                    requireActivity(),
                    1,
                    FileUtils.getFileUri(requireContext(), imgUri)
                )
            }*/
        }
    }

    fun compressBmpFileToTargetSize(file: File, targetSize: Long) {
        Log.d("garbirel", String.format("compressBmpFileToTargetSize start file.length():%d", file.length()))
        if (file.length() > targetSize) {
            // 每次宽高各缩小一半
            val ratio = 2
            // 获取图片原始宽高
            val options = BitmapFactory.Options()
            val bitmap = BitmapFactory.decodeFile(file.absolutePath, options)
            var targetWidth = options.outWidth / ratio
            var targetHeight = options.outHeight / ratio

            // 压缩图片到对应尺寸
            val baos = ByteArrayOutputStream()
            val quality = 100
            var result = generateScaledBmp(bitmap, targetWidth, targetHeight, baos, quality)

            // 计数保护，防止次数太多太耗时。
            var count = 0
            while (baos.size() > targetSize && count <= 10) {
                targetWidth /= ratio
                targetHeight /= ratio
                count++
                // 重置，不然会累加
                baos.reset()
                result = generateScaledBmp(result, targetWidth, targetHeight, baos, quality)
            }
            try {
                val fos = FileOutputStream(file)
                fos.write(baos.toByteArray())
                fos.flush()
                fos.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        Log.d("garbirel", String.format("compressBmpFileToTargetSize end file.length():%d", file.length()))
    }

    private fun generateScaledBmp(
        srcBmp: Bitmap,
        targetWidth: Int,
        targetHeight: Int,
        baos: ByteArrayOutputStream,
        quality: Int
    ) : Bitmap {

        val result = Bitmap.createBitmap(targetWidth, targetHeight, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(result)
        val rect = Rect(0, 0, result.width, result.height)
        canvas.drawBitmap(srcBmp, null, rect, null)
        if (!srcBmp.isRecycled) {
            srcBmp.recycle()
        }
        result.compress(Bitmap.CompressFormat.JPEG, quality, baos)
        return result
    }

    private fun getAppList(mContext: Context): List<JsonObject> {
        val pm = mContext.packageManager
        val packages = pm.getInstalledPackages(0)
        return packages.mapNotNull {
            // 判断系统/非系统应用
            val isSystemApp = (it.applicationInfo.flags and ApplicationInfo.FLAG_SYSTEM == 0).not()
            // 非系统应用
            JsonObject().apply {
                addProperty("appId", it.packageName)
                addProperty(
                    "appName",
                    it.applicationInfo.loadLabel(mContext.packageManager).toString()
                )
                addProperty("versionName", it.versionName)
                addProperty("versionCode", it.versionCode.toString())
                addProperty("firstInstallTime", it.firstInstallTime)
                addProperty("lastUpdateTime", it.lastUpdateTime)
                addProperty("systemApp", isSystemApp)
            }
        }
    }
}
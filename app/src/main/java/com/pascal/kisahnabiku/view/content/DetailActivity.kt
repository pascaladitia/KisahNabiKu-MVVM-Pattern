package com.pascal.kisahnabiku.view.content

import android.graphics.text.LineBreaker
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.pascal.kisahnabiku.R
import com.pascal.kisahnabiku.model.ResponseMain
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    private var item: ResponseMain? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.title = "Detail Activity"

        initView()
    }

    private fun initView() {
        item = intent?.getParcelableExtra("data")

        detail_nama.setText(item?.name)
        detail_tahun.setText(item?.thnKelahiran)
        detail_tempat.setText(item?.tmp)
        detail_usia.setText(item?.usia)
        detail_desk.setText(item?.description)

        Glide.with(this)
            .load(item?.imageUrl)
            .apply(
                RequestOptions()
                    .override(500, 500)
                    .placeholder(R.drawable.ic_image)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .priority(Priority.HIGH))
            .into(detail_image)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            detail_desk.justificationMode = LineBreaker.JUSTIFICATION_MODE_INTER_WORD
        }
    }
}
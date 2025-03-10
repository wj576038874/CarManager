package com.car.app.adapter;

import android.net.Uri;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.car.app.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/**
 * author: wenjie
 * date: 2022-06-09 17:13
 * descption:
 */
public class DetailImageAdapter extends BaseQuickAdapter<String, BaseViewHolder> {


    public DetailImageAdapter() {
        super(R.layout.detail_adapter_item);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, String item) {
        ImageView imageView = helper.getView(R.id.iv_cover);
        Glide.with(mContext)
                .load(item)
                .into(imageView);
    }
}
package com.car.app.adapter;

import android.net.Uri;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.car.app.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/**
 * author: wenjie
 * date: 2022-06-09 15:16
 * descption:
 */
public class CarImageAdapter extends BaseQuickAdapter<String, BaseViewHolder> {


    public CarImageAdapter() {
        super(R.layout.image_adapter_item);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, String item) {
        ImageView imageView = helper.getView(R.id.iv_cover);
        if (item.equals("add")) {
            Glide.with(mContext)
                    .load(R.drawable.ic_image_add)
                    .into(imageView);
        } else {
            Glide.with(mContext)
                    .applyDefaultRequestOptions(RequestOptions.bitmapTransform(new MultiTransformation<>(new CenterCrop(),new RoundedCorners(16))))
                    .load(Uri.parse(item))
                    .into(imageView);
        }
    }
}

package com.car.app.adapter;

import android.net.Uri;
import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.car.app.R;
import com.car.app.model.CarItem;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

/**
 * author: wenjie
 * date: 2022-06-08 17:51
 * descption:
 */
public class CarItemAdapter extends BaseQuickAdapter<CarItem, BaseViewHolder> {


    public CarItemAdapter() {
        super(R.layout.car_adapter_item);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, CarItem item) {
        helper.setText(R.id.tv_name, item.getName())
                .setText(R.id.tv_mileage, item.getMileage() + "公里")
                .setText(R.id.tv_price, item.getPrice() + "万");
        ImageView imageView = helper.getView(R.id.iv_cover);
        Uri uri = Uri.parse(item.getImages().get(0));
        Log.e("asd" , uri.toString());
        Glide.with(mContext)
                .load(Uri.parse(item.getImages().get(0)))
                .into(imageView);
    }
}

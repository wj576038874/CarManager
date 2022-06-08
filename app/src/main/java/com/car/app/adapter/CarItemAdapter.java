package com.car.app.adapter;

import androidx.annotation.NonNull;

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

    }
}

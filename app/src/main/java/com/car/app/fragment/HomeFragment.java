package com.car.app.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.car.app.R;
import com.car.app.activity.AddCarActivity;
import com.car.app.activity.CarDetailActivity;
import com.car.app.activity.LoginActivity;
import com.car.app.adapter.CarItemAdapter;
import com.car.app.model.CarItem;
import com.car.app.utils.SpUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * author: wenjie
 * date: 2022-06-08 16:51
 * descption:
 */
public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private CarItemAdapter carItemAdapter;
    private View emptyView;

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        CarItem carItem = new CarItem();
//        carItem.setName("奥迪Q5L 2021款 2.0T 自动 汽油 领先型M运动套装（国VI）");
//        carItem.setGearbox("AMT");
//        carItem.setLevel("S级");
//        carItem.setLocation("广州");
//        carItem.setPrice(45.2);
//        carItem.setFuelConsumption(8.0);
//        carItem.setEngine("2.0T");
//        carItem.setMileage(12346);
//        carItem.setStruct("四门五座");
//        List<String> imgs = new ArrayList<>();
//        imgs.add("content://media/external_primary/images/media/103966");
//        imgs.add("content://media/external_primary/images/media/103965");
//        imgs.add("content://media/external_primary/images/media/103964");
//        carItem.setImages(imgs);
//        carItem.setColor("白色");
//        carItem.setDrive("四驱");
//        carItem.setFuel("汽油");
//        carItem.setCarOwner("asd");
//        carItem.setPhoneNumber("12345678901");
//        carItem.save();
//    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        emptyView = LayoutInflater.from(getContext()).inflate(R.layout.empty_layout, recyclerView, false);
        emptyView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (SpUtils.getInstance().isLogin()){
                    startActivity(new Intent(getActivity(), AddCarActivity.class));
                }else {
                    startActivity(new Intent(getActivity(), LoginActivity.class));
                }
            }
        });
        carItemAdapter = new CarItemAdapter();
        recyclerView.setAdapter(carItemAdapter);
        carItemAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getActivity(), CarDetailActivity.class);
                intent.putExtra("id", carItemAdapter.getItem(position).getId());
                startActivity(intent);
            }
        });
    }


    @Override
    public void onResume() {
        super.onResume();
        refresh();
    }

    private void refresh() {
        List<CarItem> carItems = LitePal.findAll(CarItem.class);
        if (carItems.isEmpty()) {
            carItemAdapter.setNewData(null);
            carItemAdapter.setEmptyView(emptyView);
        } else {
            carItemAdapter.setNewData(carItems);
        }
    }
}

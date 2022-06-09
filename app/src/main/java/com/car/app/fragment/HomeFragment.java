package com.car.app.fragment;

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
import com.car.app.adapter.CarItemAdapter;
import com.car.app.model.CarItem;

import org.litepal.LitePal;

/**
 * author: wenjie
 * date: 2022-06-08 16:51
 * descption:
 */
public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private CarItemAdapter carItemAdapter;

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
        carItemAdapter = new CarItemAdapter();
        recyclerView.setAdapter(carItemAdapter);


        Log.e("asd" , LitePal.findAll(CarItem.class).size()+"");
        carItemAdapter.setNewData(LitePal.findAll(CarItem.class));

    }


}

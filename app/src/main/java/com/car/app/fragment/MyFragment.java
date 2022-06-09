package com.car.app.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.car.app.R;
import com.car.app.activity.AddCarActivity;
import com.car.app.activity.LoginActivity;
import com.car.app.utils.SpUtils;


/**
 * author: wenjie
 * date: 2022-06-08 16:53
 * descption:
 */
public class MyFragment extends Fragment {

    private TextView tvName;
    private TextView tvName_;
    private Button btnReport;
    private Button btnLogout;
    private ImageView imageView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvName = view.findViewById(R.id.tv_name);
        tvName_ = view.findViewById(R.id.tv_name_);
        btnReport = view.findViewById(R.id.btn_report);
        btnLogout = view.findViewById(R.id.btn_logout);
        imageView = view.findViewById(R.id.imageView);

        tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!SpUtils.getInstance().isLogin()) {
                    startActivity(new Intent(getActivity(), LoginActivity.class));
                }
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!SpUtils.getInstance().isLogin()) {
                    startActivity(new Intent(getActivity(), LoginActivity.class));
                }
            }
        });

        btnReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), AddCarActivity.class));
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SpUtils.getInstance().logout();
                refreshStatus();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        refreshStatus();
    }

    private void refreshStatus() {
        if (SpUtils.getInstance().isLogin()) {
            tvName.setText(SpUtils.getInstance().getLoginUser());
            tvName_.setVisibility(View.VISIBLE);
            btnLogout.setVisibility(View.VISIBLE);
            btnReport.setVisibility(View.VISIBLE);
        } else {
            tvName_.setVisibility(View.GONE);
            btnLogout.setVisibility(View.GONE);
            btnReport.setVisibility(View.GONE);
            tvName.setText("点击登录");
        }
    }
}

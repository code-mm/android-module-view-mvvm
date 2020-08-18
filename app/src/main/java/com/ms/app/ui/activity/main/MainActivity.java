package com.ms.app.ui.activity.main;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.ms.module.base.view.BaseAppCompatActivity;
import com.ms.module.supers.client.Modules;

import org.ms.jetpack.android_module_view_mvvm.R;

public class MainActivity extends BaseAppCompatActivity<MainActivityViewModel> {


    private static final String TAG = "MainActivity";


    private Observer<String> observer;

    @Override
    protected MainActivityViewModel initViewModel() {
        return new ViewModelProvider(this).get(MainActivityViewModel.class);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        showDialog();
        observer = new Observer<String>() {
            @Override
            public void onChanged(String s) {

                dismiss();
                Log.e(TAG, "onChanged: " + s);

                Modules.getUtilsModule().getToastUtils().show(s);

            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (!viewModel.getLiveDataHomeData().hasObservers()) {
            viewModel.getLiveDataHomeData().observeForever(observer);
        }

        viewModel.requestHomeData();
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (viewModel.getLiveDataHomeData().hasObservers()) {
            viewModel.getLiveDataHomeData().removeObserver(observer);
        }
    }
}

package com.ms.app.ui.activity.main;

import android.os.SystemClock;

import androidx.lifecycle.LiveData;

import com.ms.module.base.repository.BaseRepository;
import com.ms.module.supers.client.Modules;
import com.ms.module.supers.inter.module.Module;

public class MainRepository extends BaseRepository {


    LiveData<String> getHomeData() {
        return new LiveData<String>() {
            @Override
            protected void onActive() {
                super.onActive();
                Modules.getUtilsModule().getThreadPoolUtils().runSubThread(new Runnable() {
                    @Override
                    public void run() {
                        // 网络请求
                        SystemClock.sleep(5000);
                        // 数据回调
                        postValue("请求成功");
                    }
                });
            }
        };
    }

}

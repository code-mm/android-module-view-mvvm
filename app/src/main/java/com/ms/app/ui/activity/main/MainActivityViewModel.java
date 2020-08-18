package com.ms.app.ui.activity.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import com.ms.module.base.viewmodel.BaseViewModel;

public class MainActivityViewModel extends BaseViewModel<MainRepository> {
    @Override
    protected MainRepository initRepository() {
        return new MainRepository();
    }

    private LiveData<String> liveDataHomeData;

    public LiveData<String> getLiveDataHomeData() {
        return liveDataHomeData;
    }

    MutableLiveData<String> mutableLiveDataHomeData = new MutableLiveData<>();


    public MainActivityViewModel() {
        liveDataHomeData = Transformations.switchMap(mutableLiveDataHomeData, (input) -> repository.getHomeData());
    }

    public void requestHomeData() {
        mutableLiveDataHomeData.postValue("");
    }

}

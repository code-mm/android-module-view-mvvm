package com.ms.module.base.viewmodel;

import androidx.lifecycle.ViewModel;

import com.ms.module.base.inter.IRepository;
import com.ms.module.base.inter.IViewModel;

public abstract class BaseViewModel<R extends IRepository> extends ViewModel implements IViewModel {

    protected R repository = initRepository();

    protected abstract R initRepository();

}

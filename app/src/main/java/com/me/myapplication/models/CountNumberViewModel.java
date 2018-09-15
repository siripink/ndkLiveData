package com.me.myapplication.models;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import android.util.Log;

public class CountNumberViewModel extends ViewModel {

    private String TAG = CountNumberViewModel.class.getSimpleName();

    private MutableLiveData<Integer> count;

    public LiveData<Integer> getCount() {
        if (count == null) {
            count = new MutableLiveData<>();
            initCount();
        }
        return count;
    }

    public void update(String newCount){
        count.setValue(Integer.parseInt(newCount));
    }

    private void initCount() {
        count.setValue(0);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d(TAG, "on cleared called");
    }

}
package com.nguyendan.earthquake.viewmodel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.nguyendan.earthquake.data.model.Feature;
import com.nguyendan.earthquake.data.repository.QuakeRepository;

import java.util.List;

public class MainViewModel extends ViewModel {
    QuakeRepository quakeRepository = new QuakeRepository();

    public LiveData<List<Feature>> getFeature(Context context){
        return quakeRepository.getMutableLiveData(context);
    }


}

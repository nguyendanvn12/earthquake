package com.nguyendan.earthquake.data.repository;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.nguyendan.earthquake.data.model.Feature;
import com.nguyendan.earthquake.data.model.QuakeReport;
import com.nguyendan.earthquake.data.remote.QuakeReportService;
import com.nguyendan.earthquake.data.remote.RetrofitClient;
import com.nguyendan.earthquake.view.MainActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuakeRepository {
    private List<Feature> features;
    private MutableLiveData<List<Feature>> mutableLiveData = new MutableLiveData<List<Feature>>();

    public MutableLiveData<List<Feature>> getMutableLiveData(Context context) {

        final QuakeReportService quakeReportService = RetrofitClient.getClient();
        quakeReportService.getFeature().enqueue(new Callback<QuakeReport>() {
            @Override
            public void onResponse(Call<QuakeReport> call, Response<QuakeReport> response) {

                features = response.body().getFeatures();
                mutableLiveData.setValue(features);
            }

            @Override
            public void onFailure(Call<QuakeReport> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(context,"Connect error!",Toast.LENGTH_LONG).show();
            }
        });
        return mutableLiveData;
    }
}

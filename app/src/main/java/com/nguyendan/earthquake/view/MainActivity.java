package com.nguyendan.earthquake.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.nguyendan.earthquake.data.model.Feature;
import com.nguyendan.earthquake.view.adapter.MainAdapter;
import com.nguyendan.earthquake.viewmodel.MainViewModel;
import com.nguyendan.earthquake.R;
import com.nguyendan.earthquake.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        binding.setLifecycleOwner(this);
        RecyclerView recyclerView = binding.container;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MainAdapter adapter = new MainAdapter();
        recyclerView.setAdapter(adapter);
        viewModel.getFeature(getApplicationContext()).observe(this, new Observer<List<Feature>>() {
            @Override
            public void onChanged(List<Feature> features) {
                if(features.size()<=0){
                }else {
                    adapter.setFeatureList(features);
                }
            }
        });
    }

}

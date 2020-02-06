package com.nguyendan.earthquake.view.adapter;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.nguyendan.earthquake.R;
import com.nguyendan.earthquake.data.model.Feature;
import com.nguyendan.earthquake.databinding.ItemRowBinding;
import com.nguyendan.earthquake.viewmodel.MainViewModel;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {
    private List<Feature> featureList;
    private Context context;
    public void setFeatureList(List<Feature> featureList) {
        this.featureList = featureList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRowBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.item_row,parent,false);
        context = parent.getContext();
        return new MainViewHolder(binding);
    }

    private int getColor(Double text) {
        int i = (int)Math.floor(text);
        switch (i) {
            case 0:
            case 1:
                return  R.color.magnitude1;

            case 2:
                return  R.color.magnitude2;

            case 3:
                return  R.color.magnitude3;

            case 4:
                return  R.color.magnitude4;

            case 5:
                return  R.color.magnitude5;

            case 6:
                return  R.color.magnitude6;

            case 7:
                return  R.color.magnitude7;

            case 8:
                return R.color.magnitude8;

            case 9:
                return  R.color.magnitude9;

            default:
                return  R.color.magnitude10plus;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        Feature feature = featureList.get(position);
        GradientDrawable drawable = (GradientDrawable) holder.binding.magnitude.getBackground();
        drawable.setColor(ContextCompat.getColor(context,getColor(featureList.get(position).getProperties().getMag())));
        holder.binding.setData(feature.getProperties());
    }

    @Override
    public int getItemCount(){
        if(featureList!=null){
            return featureList.size();
        }else{
            return 0;
        }
    }

    class MainViewHolder extends RecyclerView.ViewHolder{
        ItemRowBinding binding;
        public MainViewHolder(@NonNull ItemRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}

package com.ellekay.lucie.fashionhouse;

import android.content.Context;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.etsy.android.grid.util.DynamicHeightImageView;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;
import java.util.Random;

/**
 * Created by lucie on 11/3/15.
 */
public class HomeAdapter extends ArrayAdapter<String> {
    private static final String TAG = "home";
    private LayoutInflater mInflater;
    private Random mRandom;
    private static SparseArray<Double> sPositionHeightRatios = new SparseArray<Double>();

    public HomeAdapter(Context context, int textViewRes, List<String> objects) {
        super(context, textViewRes, objects);
        this.mInflater = LayoutInflater.from(context);
        this.mRandom = new Random();
    }



    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        ViewHolder homeViewHolder;

        if (convertView == null){
            convertView = mInflater.inflate(R.layout.home_item, parent, false);
           homeViewHolder = new ViewHolder();
            homeViewHolder.imgView = (DynamicHeightImageView) convertView.findViewById(R.id.imgView);
            convertView.setTag(homeViewHolder);
        }else {
            homeViewHolder = (ViewHolder) convertView.getTag();
        }

        double positionHeight = getPositionRatio(position);
        homeViewHolder.imgView.setHeightRatio(positionHeight);

        ImageLoader.getInstance().displayImage(getItem(position), homeViewHolder.imgView);

        return convertView;
    }


    static class ViewHolder {
        DynamicHeightImageView imgView;
    }

    private double getPositionRatio(final int position) {
        double ratio = sPositionHeightRatios.get(position, 0.0);
        if (ratio == 0) {
            ratio = getRandomHeightRatio();
            sPositionHeightRatios.append(position, ratio);
            Log.d(TAG, "getPositionRatio:" + position + " ratio:" + ratio);
        }
        return ratio;
    }

    private double getRandomHeightRatio() {
        return (mRandom.nextDouble() / 2.0) + 1.0;
        // height will be 1.0 - 1.5
        // the width
    }
}
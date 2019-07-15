package com.grishko.weather.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.grishko.weather.R;

public class WeatherFragment extends Fragment {


    private TextView city_name;
    private TextView temperature;
    private TextView wet;
    private TextView wind;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.weather_fragment, container,false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews();
        Toast.makeText(getActivity(),"Created", Toast.LENGTH_SHORT).show();
    }

    private void initViews(){
        city_name=getView().findViewById(R.id.textView_city_name);
        temperature=getView().findViewById(R.id.textView_temperature);
        wet=getView().findViewById(R.id.textView_wet);
        wind=getView().findViewById(R.id.textView_wind);
    }


}

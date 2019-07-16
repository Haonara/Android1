package com.grishko.weather.fragments;

import android.content.Intent;
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
import com.grishko.weather.model.CityIndexParcel;

public class WeatherFragment extends Fragment {

    public static final String PARCEL = "parcel";
    private TextView city_name;
    private TextView temperature;
    private TextView wet;
    private TextView wind;

    public static WeatherFragment createInstance(CityIndexParcel parcel){
        WeatherFragment fragment=new WeatherFragment();
        Bundle args=new Bundle();
        args.putSerializable(PARCEL, parcel);
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.weather_fragment, container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
        CityIndexParcel parcel=getParcel();
        if (parcel != null) {
            city_name.setText(parcel.getCityName());
        } else {
            city_name.setText(getResources().getTextArray(R.array.cities_list)[0].toString());
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Toast.makeText(getActivity(),"Created", Toast.LENGTH_SHORT).show();
    }

    private void initViews(){
        city_name=getView().findViewById(R.id.textView_city_name);
        temperature=getView().findViewById(R.id.textView_temperature);
        wet=getView().findViewById(R.id.textView_wet);
        wind=getView().findViewById(R.id.textView_wind);
    }

    public @Nullable CityIndexParcel getParcel() {
        CityIndexParcel parcel = null;
        if (getArguments() != null) {
            parcel = (CityIndexParcel) getArguments().getSerializable(PARCEL);
        }
        return parcel;
    }


}

package com.grishko.weather.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.grishko.weather.R;


public class SettingsFragment extends Fragment {

    private EditText enter_city;
    private CheckBox wet;
    private CheckBox wind;
    private Button ok;
    FrameLayout container;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.settings_fragment, container,false);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //Button cities=getView().findViewById(R.id.button_back);
        Toast.makeText(getActivity(),"Created", Toast.LENGTH_SHORT).show();
        FragmentActivity activityContext=getActivity();

        if (activityContext==null){
            return;
        }

        /*cities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CitiesListFragment citiesListFragment=new CitiesListFragment();
                FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.my_container,citiesListFragment).addToBackStack(null).commit();
            }
        });*/

    }



}

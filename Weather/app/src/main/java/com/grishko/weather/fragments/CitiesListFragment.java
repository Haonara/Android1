package com.grishko.weather.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.grishko.weather.R;
import com.grishko.weather.activities.SecondActivity;
import com.grishko.weather.model.CityIndexParcel;


public class CitiesListFragment extends ListFragment {

    private final String CURRENT_CITY_INDEX = "CURRENT_CITY_INDEX";
    int currentPosition = 0;
    private CityIndexParcel cityIndexParcel;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FragmentActivity activityContext = getActivity();
        if (activityContext == null) {
            return;
        }
        createAndSetAdapter(activityContext);

        if (savedInstanceState != null) {
            cityIndexParcel = (CityIndexParcel) savedInstanceState.getSerializable(CURRENT_CITY_INDEX);
        } else {
            cityIndexParcel = new CityIndexParcel(currentPosition, getResources().getTextArray(R.array.cities_list)[currentPosition].toString());
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(CURRENT_CITY_INDEX, cityIndexParcel);
    }

    private void createAndSetAdapter(@NonNull Context context) {
        ArrayAdapter adapter = ArrayAdapter.createFromResource(
                context,
                R.array.cities_list,
                android.R.layout.simple_list_item_activated_1);
        setListAdapter(adapter);
    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        currentPosition = position;
        TextView cityNameView = (TextView) v;
        cityIndexParcel = new CityIndexParcel(position, cityNameView.getText().toString());
        okSettings(cityIndexParcel);
    }

    private void okSettings(@NonNull CityIndexParcel parcel){
        if (getActivity() == null) {
            return;
        }

        int clickedIndex = parcel.getIndex();
        getListView().setItemChecked(clickedIndex, true);
        WeatherFragment weatherFragment=(WeatherFragment)getActivity().getSupportFragmentManager().findFragmentById(R.id.fragment_weather);

        if (weatherFragment == null ||
                ( weatherFragment.getParcel() != null && weatherFragment.getParcel().getIndex() != clickedIndex)) {
            weatherFragment = weatherFragment.createInstance(parcel);

            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .commit();
        }else {
            if (getContext() != null) {
                SecondActivity.start(getContext(), parcel);
            }
        }



    }
}

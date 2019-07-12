package com.grishko.weather.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.grishko.weather.R;

public class CitiesListFragment extends ListFragment {

    int currentPosition = 0;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FragmentActivity activityContext = getActivity();
        if (activityContext == null) {
            return;
        }
        createAndSetAdapter(activityContext);
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
        Toast.makeText(getActivity(),"position="+currentPosition,Toast.LENGTH_SHORT).show();
    }
}

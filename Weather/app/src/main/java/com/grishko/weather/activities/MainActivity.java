package com.grishko.weather.activities;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.grishko.weather.R;
import com.grishko.weather.fragments.SettingsFragment;

public class MainActivity extends AppCompatActivity {

    SettingsFragment settingsFragment;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState==null){
            settingsFragment=new SettingsFragment();
            fragmentTransaction=getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.my_container,settingsFragment).addToBackStack(null).commit();
        }


    }

}

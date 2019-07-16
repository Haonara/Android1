package com.grishko.weather.activities;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.grishko.weather.R;
import com.grishko.weather.fragments.WeatherFragment;
import com.grishko.weather.model.CityIndexParcel;

import static com.grishko.weather.fragments.WeatherFragment.PARCEL;

public class SecondActivity extends AppCompatActivity  {

    /*public static final int REQUEST_CODE_SECOND_A = 100;
    private TextView fromSecondActivity_cityname;
    private TextView fromSecondActivity_humidity;
    private TextView fromSecondActivity_wind;
    private Button settingsButton;*/
    //private String[] citiesNameArray;
    //int currentIndex=0;


    public static void start(@NonNull Context context, @NonNull CityIndexParcel parcel) {
        Intent intent=new Intent(context,SecondActivity.class);
        intent.putExtra(PARCEL,parcel);
        context.startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        if (savedInstanceState == null) {
            WeatherFragment weatherFragment = new WeatherFragment();
            weatherFragment.setArguments(getIntent().getExtras());

            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .add(android.R.id.content, weatherFragment)
                    .commit();
        }

        //initViews();
        /*Intent data=getIntent();
        if (data != null && data.getExtras() != null) {
            Parceling receivedData = (Parceling) data.getExtras().get(FROM_SECOND_ACTIVITY);
            if (receivedData != null) {
                fromSecondActivity_cityname.setText(receivedData.getCity_name());
                try {
                    if(receivedData.isVisibilityWet()){
                        fromSecondActivity_humidity.setVisibility(View.VISIBLE);
                    }
                }catch (Exception e){
                    Toast.makeText(this,e.getMessage(),Toast.LENGTH_SHORT).show();
                }

                try {
                    if(receivedData.isVisibilityWind()){
                        fromSecondActivity_wind.setVisibility(View.VISIBLE);
                    }
                }catch (Exception e){
                    Toast.makeText(this,e.getMessage(),Toast.LENGTH_SHORT).show();
                }

            }
        }
        settingsButton.setOnClickListener(SecondActivity.this);*/
    }

    /*@Override
    public void onClick(View v) {
        Intent intent=new Intent(this, MainActivity.class);
        startActivityForResult(intent, REQUEST_CODE_SECOND_A);
    }*/

    /*private void initViews(){
        settingsButton =findViewById(R.id.button_settings);
        fromSecondActivity_cityname =findViewById(R.id.textView_city_name);
        fromSecondActivity_humidity =findViewById(R.id.textView_wet);
        fromSecondActivity_wind =findViewById(R.id.textView_wind);
        //citiesNameArray=getResources().getStringArray(R.array.cities_list);
    }*/

    /*@Override protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE_SECOND_A) {
            if (data != null && data.getExtras() != null) {
                Parceling receivedData = (Parceling) data.getExtras().get(FROM_SECOND_ACTIVITY);
                if (receivedData != null) {
                    fromSecondActivity_cityname.setText(receivedData.getCity_name());
                    try {
                        if(receivedData.isVisibilityWet()){
                            fromSecondActivity_humidity.setVisibility(View.VISIBLE);
                        }
                    }catch (Exception e){
                        Toast.makeText(this,e.getMessage(),Toast.LENGTH_SHORT).show();
                    }

                    try {
                        if(receivedData.isVisibilityWind()){
                            fromSecondActivity_wind.setVisibility(View.VISIBLE);
                        }
                    }catch (Exception e){
                        Toast.makeText(this,e.getMessage(),Toast.LENGTH_SHORT).show();
                    }

                }
            }
        }
    }*/

   /* public void setCityName(int cityIndex){
        String cityName=citiesNameArray[cityIndex];
        fromSecondActivity_cityname.setText(cityName);
    }*/

}

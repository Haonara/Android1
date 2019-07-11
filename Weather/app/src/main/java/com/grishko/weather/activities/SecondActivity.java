package com.grishko.weather.activities;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.grishko.weather.R;
import com.grishko.weather.model.Parceling;

import static com.grishko.weather.activities.MainActivity.FROM_SECOND_ACTIVITY;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int REQUEST_CODE_SECOND_A = 100;
    private TextView fromSecondActivity_cityname;
    private TextView fromSecondActivity_humidity;
    private TextView fromSecondActivity_wind;
    private Button settingsButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initViews();
        Intent data=getIntent();
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
        settingsButton.setOnClickListener(SecondActivity.this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(this, MainActivity.class);
        startActivityForResult(intent, REQUEST_CODE_SECOND_A);
    }

    private void initViews(){
        settingsButton =findViewById(R.id.button_settings);
        fromSecondActivity_cityname =findViewById(R.id.textView_city_name);
        fromSecondActivity_humidity =findViewById(R.id.textView_wet);
        fromSecondActivity_wind =findViewById(R.id.textView_wind);
    }

    @Override protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
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
    }

}

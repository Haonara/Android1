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
import com.grishko.weather.model.Parcel;

import static com.grishko.weather.activities.SecondActivity.FROM_SECOND_ACTIVITY;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static final int REQUEST_CODE_SECOND_A = 100;
    private TextView fromSecondActivity1;
    private TextView fromSecondActivity2;
    private TextView fromSecondActivity3;
    Button secondActivityButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        secondActivityButton.setOnClickListener(MainActivity.this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(this, SecondActivity.class);
        startActivityForResult(intent, REQUEST_CODE_SECOND_A);
    }

    private void initViews(){
        secondActivityButton=findViewById(R.id.button_settings);
        fromSecondActivity1=findViewById(R.id.textView_city_name);
        fromSecondActivity2=findViewById(R.id.textView_wet);
        fromSecondActivity3=findViewById(R.id.textView_wind);
    }

    @Override protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE_SECOND_A) {
            if (data != null && data.getExtras() != null) {
                Parcel receivedData = (Parcel) data.getExtras().get(FROM_SECOND_ACTIVITY);
                if (receivedData != null) {
                    fromSecondActivity1.setText(receivedData.getCity_name());
                    String temp = "visible";
                    try {
                        if(receivedData.getVisibilityWet().equalsIgnoreCase(temp)){
                            fromSecondActivity2.setVisibility(View.VISIBLE);
                        }
                    }catch (Exception e){
                        Toast.makeText(this,e.getMessage(),Toast.LENGTH_SHORT).show();
                    }

                    try {
                        if(receivedData.getVisibilityWind().equalsIgnoreCase(temp)){
                            fromSecondActivity3.setVisibility(View.VISIBLE);
                        }
                    }catch (Exception e){
                        Toast.makeText(this,e.getMessage(),Toast.LENGTH_SHORT).show();
                    }

                }
            }
        }
    }

}

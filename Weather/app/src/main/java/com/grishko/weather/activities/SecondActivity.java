package com.grishko.weather.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.grishko.weather.R;
import com.grishko.weather.model.Parcel;

import static com.grishko.weather.activities.MainActivity.REQUEST_CODE_SECOND_A;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    public static String FROM_SECOND_ACTIVITY = "FROM_SECOND_ACTIVITY";
    public static final int REQUEST_CODE_SECOND_A = 100;

    private EditText enterCityText;
    Button okButton;
    private CheckBox wet;
    private CheckBox wind;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initViews();
        /*okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSaveAndFinishClicked();
            }
        });*/
        okButton.setOnClickListener(SecondActivity.this);
    }

    private void initViews(){
        enterCityText=findViewById(R.id.editText_city_enter);
        okButton=findViewById(R.id.button_ok);
        wet=findViewById(R.id.checkBox_wet);
        wind=findViewById(R.id.checkBox_wind);
    }

    private void onSaveAndFinishClicked() {
        Parcel parcel = new Parcel();
        parcel.setCity_name(enterCityText.getText().toString());
        if (wet.isChecked()){
            parcel.setVisibilityWet("visible");
        }
        if (wind.isChecked()){
            parcel.setVisibilityWind("visible");
        }

        Intent dataToMainActivity = new Intent(this, MainActivity.class);
        dataToMainActivity.putExtra(FROM_SECOND_ACTIVITY, parcel);
        startActivity(dataToMainActivity);
        setResult(Activity.RESULT_OK, dataToMainActivity);
        finish();
    }

    @Override
    public void onClick(View v) {
        onSaveAndFinishClicked();
    }
}

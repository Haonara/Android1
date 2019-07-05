package com.grishko.weather.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.grishko.weather.R;
import com.grishko.weather.model.Parcel;

public class SecondActivity extends AppCompatActivity {

    public static String FROM_SECOND_ACTIVITY = "FROM_SECOND_ACTIVITY";

    private EditText enterCityText;
    private Button okButton;
    private CheckBox wet;
    private CheckBox wind;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toast.makeText(getApplicationContext(), "Second - onCreate()", Toast.LENGTH_SHORT).show();
        initViews();
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSaveAndFinishClicked();
            }
        });
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
        setResult(Activity.RESULT_OK, dataToMainActivity);
        finish();
    }
}

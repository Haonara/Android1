package com.grishko.weather.activities;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.grishko.weather.R;
import com.grishko.weather.model.CityIndexParcel;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static String FROM_SECOND_ACTIVITY = "FROM_SECOND_ACTIVITY";

    private EditText enterCityText;
    private Button okButton;
    private CheckBox wet;
    private CheckBox wind;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        okButton.setOnClickListener(this);
        FragmentManager manager=getFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();

    }

    private void initViews(){
        enterCityText=findViewById(R.id.editText_city_enter);
        okButton=findViewById(R.id.button_ok);
        wet=findViewById(R.id.checkBox_wet);
        wind=findViewById(R.id.checkBox_wind);
    }


    private void onSaveAndFinishClicked() {
        /*Parceling parceling = new Parceling();
        parceling.setCity_name(enterCityText.getText().toString());
        if (wet.isChecked()){
            parceling.setVisibilityWet(true);
        }
        if (wind.isChecked()){
            parceling.setVisibilityWind(true);
        }

        Intent dataToMainActivity = new Intent(this, SecondActivity.class);
        dataToMainActivity.putExtra(FROM_SECOND_ACTIVITY, parceling);
        startActivity(dataToMainActivity);
        setResult(Activity.RESULT_OK, dataToMainActivity);
        finish();*/

        Intent intent=new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        onSaveAndFinishClicked();
    }
}

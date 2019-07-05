package com.grishko.weather.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.grishko.weather.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "toast";
    public static final int REQUEST_CODE_SECOND_A = 100;
    private TextView fromSecondActivity1;
    private TextView fromSecondActivity2;
    Button secondActivityButton;

    /*@Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(MainActivity.this, "onStart()", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onStart");
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this, "onCreate()", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onCreate");
        secondActivityButton=findViewById(R.id.button_settings);
        secondActivityButton.setOnClickListener(MainActivity.this);



    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    /*@Override
    protected void onRestoreInstanceState(Bundle saveInstanceState){
        super.onRestoreInstanceState(saveInstanceState);
        Toast.makeText(MainActivity.this, "Повторный запуск!! - onRestoreInstanceState()", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onRestoreInstanceState");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(MainActivity.this, "onResume()", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(MainActivity.this, "onPause()", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onPause");
    }

    @Override
    protected void onSaveInstanceState(Bundle saveInstanceState){
        super.onSaveInstanceState(saveInstanceState);
        Toast.makeText(MainActivity.this, "onSaveInstanceState()", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onSaveInstanceState");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(MainActivity.this, "onStop()", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onStop");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(MainActivity.this, "onRestart()", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(MainActivity.this, "onDestroy()", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onDestroy");
    }*/



}

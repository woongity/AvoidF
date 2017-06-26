package com.example.tae_woong.avoidf;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Tae_woong on 2017-06-26.
 */

public class ResultActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
    }
    public void tryAgain(View view){
        startActivity(new Intent(getApplicationContext(),GameActivity.class));
    }
}

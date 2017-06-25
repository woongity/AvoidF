package com.example.tae_woong.avoidf;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ButtonSelActivity extends AppCompatActivity {
    private static MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button playButton =(Button)findViewById(R.id.play);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gameIntent = new Intent(ButtonSelActivity.this,GameActivity.class);
                ButtonSelActivity.this.startActivity(gameIntent);
            }
        });
        Button ruleButton=(Button)findViewById(R.id.rule);
        ruleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ruleIntent = new Intent(ButtonSelActivity.this, RuleActivity.class);
                ButtonSelActivity.this.startActivity(ruleIntent);
            }
        });
        Button creditButton=(Button)findViewById(R.id.credit);
        creditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent creditIntent = new Intent(ButtonSelActivity.this, CreditActivity.class);
                ButtonSelActivity.this.startActivity(creditIntent);
            }
        });
        mp=MediaPlayer.create(this,R.raw.beat);
        mp.setLooping(true);
        mp.start();
    }
}

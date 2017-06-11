package com.example.tae_woong.avoidf;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by Tae_woong on 2017-06-11.
 */
public class GameActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_play);

        final ImageView iv = (ImageView)findViewById(R.id.imageView1);
        LinearLayout ll = (LinearLayout)findViewById(R.id.linearLayout);
        ll.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN :
                    case MotionEvent.ACTION_MOVE :
                    case MotionEvent.ACTION_UP   :
                        // 이미지 뷰의 위치를 옮기기
                        iv.setX(event.getX());
                        iv.setY(event.getY());
                }
                return true;
            }
        });
    }
}

package com.example.tae_woong.avoidf;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by Tae_woong on 2017-06-11.
 */
public class GameActivity extends AppCompatActivity {
    Chronometer timer;
    float x;
    float y;
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_play);
        timer=(Chronometer)findViewById(R.id.chronometer);
        startGame();
    }//게임 화면 시작
    
    public void onDestroy(){
        super.onDestroy();
        timer.stop();
    }//항상 앱종료할때는 타이머를 끈다.
    public void startGame() {
        final ImageView iv = (ImageView) findViewById(R.id.imageView1);
        LinearLayout ll = (LinearLayout) findViewById(R.id.linearLayout);
        timer.start();
        ll.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                    case MotionEvent.ACTION_MOVE:
                    case MotionEvent.ACTION_UP:
                        // 이미지 뷰의 위치를 마우스 가는곳으로 옮기기
                        x = event.getX();
                        y=event.getY();
                        iv.setX(x);
                        iv.setY(y);
                }
                return true;
            }
        });
    }
}
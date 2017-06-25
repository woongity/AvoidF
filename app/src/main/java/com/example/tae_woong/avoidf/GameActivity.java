package com.example.tae_woong.avoidf;

import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Tae_woong on 2017-06-11.
 */
public class GameActivity extends AppCompatActivity {
    Chronometer passTime;
    float x;
    float y;
    private ImageView imageF;

    //Screen Size
    private int imageFSize;
    private int screenHeight;
    private int screenWidth;

    private float imageFx;
    private float imageFy;

    private Handler handler=new Handler();
    private Timer timer=new Timer();


    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_play);
        imageF=(ImageView)findViewById(R.id.imageF);
        passTime =(Chronometer)findViewById(R.id.chronometer);

        WindowManager wm=getWindowManager();
        Display disp=wm.getDefaultDisplay();
        Point size=new Point();
        disp.getSize(size);
        screenWidth=size.x;
        screenHeight=size.y;
        //스크린 사이즈를 받아온다.

        imageF.setX(-80.0f);
        imageF.setY(-80.0f);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        changePos();
                    }
                });
            }
        },0,20);
        startGame();
    }//게임 화면 시작

    public void onDestroy(){
        super.onDestroy();
        passTime.stop();
    }//항상 앱종료할때는 타이머를 끈다.
    public void changePos()
    {
        imageFy+=20;
        if(imageF.getY()>screenHeight){
            imageFx=(float)Math.floor(Math.random()*(screenWidth-imageF.getWidth()));
            imageFy=-100.0f;
        }
        imageF.setX(imageFx);
        imageF.setY(imageFy);
    }

    public void startGame() {
        final ImageView iv = (ImageView) findViewById(R.id.imageView1);
        LinearLayout ll = (LinearLayout) findViewById(R.id.linearLayout);
        passTime.start();
        //hitCheck();
        ll.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                    case MotionEvent.ACTION_MOVE:
                    case MotionEvent.ACTION_UP:
                        // 이미지 뷰의 위치를 마우스 가는곳으로 옮기기
                        x = event.getX();
                        y = event.getY();
                        iv.setX(x);
                        iv.setY(y);
                }
                return true;
            }
        });
    }

}
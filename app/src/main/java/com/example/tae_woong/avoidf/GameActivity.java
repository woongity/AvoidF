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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Tae_woong on 2017-06-11.
 */
public class GameActivity extends AppCompatActivity {
    private TextView startLabel;
    Chronometer passTime;
    private ImageView imageF;
    private int ivY;

    //Screen Size
    private int imageFSize;
    private int screenWidth;
    private int screenHeight;

    private int frameHeight;

    private float charSize;
    private float imageFx;
    private float imageFy;

    private Handler handler=new Handler();
    private Timer timer=new Timer();
    private ImageView iv;
    private boolean action_flg=false;//동작 여부 감지
    private boolean start_flg=false;//시작 여부 감지
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_play);

        startLabel=(TextView)findViewById(R.id.startLabel);
        iv=(ImageView)findViewById(R.id.imageView1);
        imageF=(ImageView)findViewById(R.id.imageF);
        passTime =(Chronometer)findViewById(R.id.chronometer);

        imageF.setX(-80.0f);
        imageF.setY(-80.0f);

        ivY=500;

        WindowManager wm=getWindowManager();
        Display disp=wm.getDefaultDisplay();
        Point size=new Point();
        disp.getSize(size);
        screenWidth=size.x;
        screenHeight=size.y;
        //스크린 사이즈를 받아온다.

    }//게임 화면 시작

    public void onDestroy(){
        super.onDestroy();
        passTime.stop();
    }//항상 앱종료할때는 초시계를 끈다.
    public void changePos()
    {
        if(action_flg==true){
            ivY-=20;
        }else{
            ivY+=20;
        }
        iv.setY(ivY);
    }
    public void hitCheck(){
        float imageFXcenter=imageF.getX()+imageF.getWidth()/2;
        float imageFYcenter=imageF.getY()+imageF.getHeight()/2;
        if(imageFYcenter>10 && imageFYcenter<100){
            passTime.getBase();
            passTime.stop();
            timer.cancel();
            timer=null;
        }
    }
    public boolean onTouchEvent(MotionEvent me){

        if(start_flg==false){
            start_flg=true;

            FrameLayout frame=(FrameLayout)findViewById(R.id.frame);
            screenHeight=frame.getHeight();
            passTime.start();
            startLabel.setVisibility(View.GONE);

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
        }
        else{
            if(me.getAction()==MotionEvent.ACTION_DOWN){
                action_flg=true;
            } else if(me.getAction()==MotionEvent.ACTION_UP){
                action_flg=false;
            }
        }
        return true;
     //이미지뷰 위아래로 옮기기기
    }
}
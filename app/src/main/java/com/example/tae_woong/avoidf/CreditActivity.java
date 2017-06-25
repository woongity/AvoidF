package com.example.tae_woong.avoidf;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

/**
 * Created by Tae_woong on 2017-06-11.
 */

public class CreditActivity extends AppCompatActivity {
    YouTubePlayerView youtubeview;
    YouTubePlayer.OnInitializedListener listener;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit);
        youtubeview=(YouTubePlayerView)findViewById(R.id.youtubeView);
        listener= new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("vewH-f3fAes");
            }
            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
            }
        };
        youtubeview.initialize("AIzaSyChoYIwWWrT1y42x0YhX2NhSNkelJpmop0",listener);
    }
}

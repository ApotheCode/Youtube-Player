package com.example.sit305youtubeplayerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class YouTubeActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    YouTubePlayerView youTubePlayerView;
    YouTubePlayer.OnInitializedListener onInitializedListener;
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_tube);

        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player_view);
        youTubePlayerView.initialize(YouTubeConfig.getAPI_Key(), this);

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

            youTubePlayer.loadVideo(url);
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this, "Failed to Initialize Youtube Player", Toast.LENGTH_LONG).show();
    }
}

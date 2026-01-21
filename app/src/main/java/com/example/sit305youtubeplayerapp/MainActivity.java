package com.example.sit305youtubeplayerapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.youtube.player.YouTubePlayerView;

//https://www.youtube.com/watch?v=w9xfXsqIGKk - accessed 12/05/2021
public class MainActivity extends AppCompatActivity{

    EditText youTubeUrlTextEditor;
    Button playButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, YouTubeActivity.class);

        youTubeUrlTextEditor = findViewById(R.id.youtube_edit_text);
        playButton = findViewById(R.id.play_button);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if(youTubeUrlTextEditor.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter a YouTube Url", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(youTubeUrlTextEditor.getText().toString()
                        .contains("https://www.youtube.com/watch?v=")){
                        intent.putExtra("url", youTubeUrlTextEditor.getText().toString()
                                .replace("https://www.youtube.com/watch?v=", ""));
                    startActivity(intent);


                }
                else{
                    intent.putExtra("url", youTubeUrlTextEditor.getText().toString());
                    startActivity(intent);
                }


            }
        });
    }


}
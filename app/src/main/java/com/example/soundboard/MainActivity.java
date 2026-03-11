package com.example.soundboard;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private Button btnPlaySound;
    private Button btnPauseSound;
    private Button btnStopSound;
    private VideoView videoView;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlaySound = findViewById(R.id.btnPlaySound);
        btnPauseSound = findViewById(R.id.btnPauseSound);
        btnStopSound = findViewById(R.id.btnStopSound);

        videoView = findViewById(R.id.videoView);

        MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.sample_music);

        btnPlaySound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer != null) {
                    mediaPlayer.start();
                }
            }
        });

        btnPauseSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer != null) {
                    mediaPlayer.pause();
                }
            }
        });

        btnStopSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                }
            }
        });

        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.sample_video;
        Uri uri = Uri.parse(videoPath);

        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
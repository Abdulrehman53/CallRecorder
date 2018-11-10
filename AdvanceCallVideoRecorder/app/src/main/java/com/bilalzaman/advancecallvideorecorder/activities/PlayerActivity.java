package com.bilalzaman.advancecallvideorecorder.activities;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bilalzaman.advancecallvideorecorder.R;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PlayerActivity extends AppCompatActivity {

    private TextView txtTitle;
    private ImageButton imgBack, imgPlay, imgPause;
    private MediaPlayer mediaPlayer;
    private SeekBar seekBar;
    private double startTime = 0, endTime = 0;
    public static int oneTimeOnly = 0;
    @BindView(R.id.txtStartTime)
    TextView txtStartTime;
    @BindView(R.id.txtEndTime)
    TextView txtEndTime;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        ButterKnife.bind(this);

        init();
    }

    private void init() {
        txtTitle = findViewById(R.id.txtTitle);
        txtTitle.setText("Name Player");
        txtTitle.setVisibility(View.VISIBLE);

        imgPlay = findViewById(R.id.imgPlayer);
        imgPause = findViewById(R.id.imgPause);
        seekBar = findViewById(R.id.seekbar);
        seekBar.setClickable(false);
        seekBar.setEnabled(false);

        mediaPlayer = MediaPlayer.create(this, R.raw.otilia);


        startRecording();

        imgPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pauseRecording();
            }
        });

    }


    public void startRecording() {
        mediaPlayer.start();
        imgPlay.setVisibility(View.GONE);
        imgPause.setVisibility(View.VISIBLE);

        endTime = mediaPlayer.getDuration();
        startTime = mediaPlayer.getCurrentPosition();

        if (oneTimeOnly == 0) {

            seekBar.setMax((int) endTime);
            oneTimeOnly = 1;
        }

        txtStartTime.setText(String.format("%d min, %d sec",
                TimeUnit.MILLISECONDS.toMinutes((long) endTime),
                TimeUnit.MILLISECONDS.toSeconds((long) endTime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                        startTime))));

        txtEndTime.setText(String.format("%d min, %d sec",
                TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                TimeUnit.MILLISECONDS.toSeconds((long) startTime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                        startTime))));

        seekBar.setProgress((int) startTime);
        handler.postDelayed(updateRecordingTime, 100);
    }

    public void pauseRecording() {
        mediaPlayer.pause();
        Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show();
        startTime = mediaPlayer.getCurrentPosition();
        seekBar.setProgress((int) startTime);
        imgPause.setVisibility(View.GONE);
        imgPlay.setVisibility(View.VISIBLE);
    }

    private Runnable updateRecordingTime = new Runnable() {
        @Override
        public void run() {
            startTime = mediaPlayer.getCurrentPosition();
            txtEndTime.setText(String.format("%d min, %d sec",
                    TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                    TimeUnit.MILLISECONDS.toSeconds((long) startTime) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                            startTime)))
            );

            seekBar.setProgress((int) startTime);
            handler.postDelayed(this, 100);

        }
    };

    @OnClick(R.id.imgBack)
    void backScreen() {
        mediaPlayer.stop();
        finish();
    }

    @OnClick(R.id.imgPlayer)
    void playAudioAgain() {
        startRecording();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.stop();
    }

//    @Override
//    public void onResume() {
//        super.onResume();
//        startTime = mediaPlayer.getCurrentPosition();
//        seekBar.setProgress((int) startTime);
//        mediaPlayer.pause();
//    }
}

package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class StopWatchActivity extends AppCompatActivity {

    Button btnStart, btnReset, btnPause;
    ImageView icanchor;
    Animation roundingalone;
    Chronometer timeHere;
    private long pauseOffset;
    boolean running=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);

        btnStart =findViewById(R.id.btnget);
        btnReset =findViewById(R.id.btnReset);
        btnPause=findViewById(R.id.btnpause);
        icanchor=findViewById(R.id.icanchor);
        //chronometer
        timeHere=findViewById(R.id.timerHere);

        //create optional animation
        btnReset.setAlpha(0);
        btnPause.setAlpha(0);

        //load animation
        roundingalone = AnimationUtils.loadAnimation(this,R.anim.rotatealone);

        //import font
        Typeface MMedium=Typeface.createFromAsset(getAssets(),"fonts/MMedium.ttf");

        //cuztomize font
        btnStart.setTypeface(MMedium);
        btnReset.setTypeface(MMedium);
        btnPause.setTypeface(MMedium);

        //Chronometer stuff
        timeHere.setFormat("Time %s");
        //timeHere.setCountDown(true);
        //btnStart
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //passing animation
                icanchor.startAnimation(roundingalone);
                btnReset.animate().alpha(1).translationY(- 80).setDuration(300).start();
                btnPause.animate().alpha(1).translationY(- 100).setDuration(300).start();
                btnStart.animate().alpha(0).setDuration(300).start();

                //start time
                timeHere.setBase(SystemClock.elapsedRealtime()-pauseOffset);

                if(!running)
                {timeHere.start();
                running=true;}
            }
        });

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(running)
               {
                timeHere.stop();
                pauseOffset=SystemClock.elapsedRealtime()-timeHere.getBase();
                running=false;
               }
               else {
                   timeHere.start();
               timeHere.setBase(SystemClock.elapsedRealtime()-pauseOffset);
               running=true;     }
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeHere.setBase(SystemClock.elapsedRealtime());
                pauseOffset=0;
            }
        });





    }
}

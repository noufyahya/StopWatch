package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SearchRecentSuggestionsProvider;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvSplash, tvSubSplash;
    Button btngreen;
    Animation atg, btgone, btgtwo;
    ImageView ivSplash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSplash= findViewById(R.id.tvSplash);
        tvSubSplash =findViewById(R.id.tvSubSplash);
        btngreen =findViewById(R.id.btnget);
        //picture
        ivSplash=findViewById(R.id.ivsplash);

        //load animation
        atg= AnimationUtils.loadAnimation(this, R.anim.atg);
        btgone=AnimationUtils.loadAnimation(this,R.anim.btgone);
        btgtwo=AnimationUtils.loadAnimation(this,R.anim.btgtwo);

        //passing animation
        ivSplash.startAnimation(atg);
        tvSplash.startAnimation(btgone);
        tvSubSplash.startAnimation(btgone);
        btngreen.startAnimation(btgtwo);

        //Green btn passing event
        btngreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(MainActivity.this, StopWatchActivity.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });

        //FONTS
        //import font
        Typeface MLight =Typeface.createFromAsset(getAssets(), "fonts/MLight.ttf");
        Typeface MMedium =Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf");
        Typeface MRegular =Typeface.createFromAsset(getAssets(), "fonts/MRegular.ttf");
        //customize the font
        tvSplash.setTypeface(MRegular);
        tvSubSplash.setTypeface(MLight);
        btngreen.setTypeface(MMedium);
    }
}

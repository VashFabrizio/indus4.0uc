package com.example.maps;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {
    private final int DURACION_SPLASH = 900;
    ImageView logo;
    TextView txtlogo;
    ObjectAnimator animationAlpha;
    long animationDuration = 800;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        logo = findViewById(R.id.logo);
        txtlogo = findViewById(R.id.textlogo);

        animationAlpha = ObjectAnimator.ofFloat(logo, View.ALPHA, 1.0f, 0.0f);
        animationAlpha.setDuration(animationDuration);
        AnimatorSet animatorSetAlpha = new AnimatorSet();
        animatorSetAlpha.play(animationAlpha);
        animatorSetAlpha.start();

        animationAlpha = ObjectAnimator.ofFloat(txtlogo, View.ALPHA, 1.0f, 0.0f);
        animationAlpha.setDuration(animationDuration);
        AnimatorSet animatorSetAlpha2 = new AnimatorSet();
        animatorSetAlpha2.play(animationAlpha);
        animatorSetAlpha2.start();

        new Handler().postDelayed(new Runnable(){
            public void run(){
                Intent i = new Intent(SplashActivity.this,LoginActivity.class);
                startActivity(i);
                finish();
            }
        },DURACION_SPLASH);

    }
}

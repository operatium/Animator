package com.animation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by Administrator on 2017/2/9.
 */

public class TweenAnimationAcitivity extends AppCompatActivity {
    private ImageView im;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tween);
        im = (ImageView)findViewById(R.id.imageView2);
    }

    public void togother1(View view)
    {
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.tween1);
        im.startAnimation(animation);
    }
}

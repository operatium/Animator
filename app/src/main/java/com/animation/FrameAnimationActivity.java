package com.animation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Administrator on 2017/2/9.
 */

public class FrameAnimationActivity extends AppCompatActivity {
    private ImageView im;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame);
        im = (ImageView)findViewById(R.id.imageView3);
        im.setImageResource(R.drawable.load);
    }

    public void run(View v)
    {
        AnimationDrawable ad = (AnimationDrawable)im.getDrawable();
        ad.start();
    }
}

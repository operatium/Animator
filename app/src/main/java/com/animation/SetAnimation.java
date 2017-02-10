package com.animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AnimationSet;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Administrator on 2017/2/9.
 */

public class SetAnimation extends AppCompatActivity {
    private ImageView nv;
    private ObjectAnimator animationA;
    private ObjectAnimator animationB;
    private ObjectAnimator animationC;
    private ObjectAnimator animationD;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set);
        Button home = (Button)findViewById(R.id.button);
        nv = (ImageView)findViewById(R.id.imageView);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        animationA = ObjectAnimator.ofFloat(nv,View.SCALE_X,1f,0.5f);
        animationB = ObjectAnimator.ofFloat(nv,View.SCALE_Y,1f,0.5f);
        animationC = ObjectAnimator.ofFloat(nv,View.ALPHA,1f,0.5f);
        animationD = ObjectAnimator.ofFloat(nv,View.TRANSLATION_X,nv.getTranslationX(),nv.getTranslationX()+200);
    }

    public void togother(View view)
    {
        AnimatorSet set = new AnimatorSet();
        set.playTogether(animationA,animationB,animationC,animationD);
        set.setDuration(1000);
        set.start();
    }

    public void seq(View view)
    {
        AnimatorSet set = new AnimatorSet();
        set.playSequentially(animationA,animationB,animationC,animationD);
        set.setDuration(4000);
        set.start();
    }

    public void seq2(View view)
    {
        AnimatorSet set = new AnimatorSet();
        set.play(animationA).after(animationD).before(animationC).with(animationB);
        set.setDuration(4000);
        set.start();
    }
}

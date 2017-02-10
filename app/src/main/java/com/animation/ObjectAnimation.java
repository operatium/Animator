package com.animation;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Administrator on 2017/2/9.
 */

public class ObjectAnimation extends AppCompatActivity {
    private ImageView nv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.object);
        Button home = (Button)findViewById(R.id.button);
        nv = (ImageView)findViewById(R.id.id_ball);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void rotateyAnimRun(View view)
    {
        ObjectAnimator//
                .ofFloat(view, "rotationY",view.getRotationY(), view.getRotationY()+180.0f)//
                .setDuration(1500)//
                .start();
    }

    public void scale(View view)
    {
        ObjectAnimator.ofFloat(nv,"scaleX",2.0f,1.0f).setDuration(1000).start();
    }

    public void translate(View view)
    {
        ObjectAnimator.ofFloat(nv,"X",0,nv.getTranslationX()+500).setDuration(1000).start();
    }

    public void scroll(View view)
    {
        ObjectAnimator.ofFloat(nv,"rotation",0,45).setDuration(1000).start();
    }
}

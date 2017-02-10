package com.animation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private Button ObjectAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ObjectAnimation = (Button)findViewById(R.id.ObjectAnimation);
        ObjectAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,ObjectAnimation.class);
                startActivity(intent);
            }
        });
        addButton("setAnimator",SetAnimation.class,R.id.button5);
        addButton("ValueAnimator",ValueAnimatorActivity.class,R.id.button12);
        addButton("TweenAnimation",TweenAnimationAcitivity.class,R.id.button14);
        addButton("FrameAnimationActivity",FrameAnimationActivity.class,R.id.button18);
    }

    public void addButton(String title, final Class<?> cls,int id)
    {
        Button setAnimation= (Button)findViewById(id);
        setAnimation.setText(title);
        setAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,cls);
                startActivity(intent);
            }
        });
    }
}

package com.animation;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Administrator on 2017/2/9.
 */
public class ValueAnimatorActivity extends AppCompatActivity {
    private ImageView nv;
    private ValueAnimator valueAnimator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.value);
        Button home = (Button)findViewById(R.id.button);
        nv = (ImageView)findViewById(R.id.imageView1);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void moveX(View view)
    {
        final ValueAnimator va = ValueAnimator.ofFloat(0,500);
        va.setTarget(nv);
        va.setDuration(1000).start();
        va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                nv.setTranslationX((float)va.getAnimatedValue());
            }
        });
    }

    public void end(View view)
    {
        if(valueAnimator != null)
            valueAnimator.end();
    }

    public void cancel(View view)
    {
        if(valueAnimator != null)
            valueAnimator.cancel();
    }


    /**
     * 抛物线
     * @param view
     */
    public void paowuxian(View view)
    {
        nv.setScaleX(0.3f);
        nv.setScaleY(0.3f);

        valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(3000);
        valueAnimator.setObjectValues(new PointF(0, 0));
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setEvaluator(new TypeEvaluator<PointF>()
        {
            // fraction = t / duration
            @Override
            public PointF evaluate(float fraction, PointF startValue,
                                   PointF endValue)
            {
                Log.e("paohuxian", fraction * 3 + "");
                // x方向200px/s ，则y方向0.5 * 10 * t
                PointF point = new PointF();
                point.y = 200 * fraction * 3;
                point.x = 0.5f * 200 * (fraction * 3) * (fraction * 3);
                return point;
            }
        });

        valueAnimator.start();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
            @Override
            public void onAnimationUpdate(ValueAnimator animation)
            {
                PointF point = (PointF) animation.getAnimatedValue();
                nv.setX(point.x);
                nv.setY(point.y);
            }
        });
    }
}

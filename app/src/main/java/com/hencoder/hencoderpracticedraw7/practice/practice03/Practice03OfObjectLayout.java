package com.hencoder.hencoderpracticedraw7.practice.practice03;

import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.hencoder.hencoderpracticedraw7.R;

public class Practice03OfObjectLayout extends RelativeLayout {
    Practice03OfObjectView view;
    Button animateBt;

    public Practice03OfObjectLayout(Context context) {
        super(context);
    }

    public Practice03OfObjectLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice03OfObjectLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        view = (Practice03OfObjectView) findViewById(R.id.objectAnimatorView);
        animateBt = (Button) findViewById(R.id.animateBt);

        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator objectAnimator=ObjectAnimator.ofObject(view,"position",new PointFEvaluator(),new PointF(0,0),new PointF(0.5f,1));
                objectAnimator.setInterpolator(new LinearInterpolator());
                objectAnimator.setDuration(1000);
                objectAnimator.start();
            }
        });
    }

    private class PointFEvaluator implements TypeEvaluator<PointF>{
        PointF mPointF=new PointF();
        @Override
        public PointF evaluate(float fraction, PointF startValue, PointF endValue) {
            float x=startValue.x+(fraction*(endValue.x-startValue.x));
            float y=startValue.y+(fraction*(endValue.y-startValue.y));
            mPointF.set(x,y);
            return  mPointF;
        }
    }
}

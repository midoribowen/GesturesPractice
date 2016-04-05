package com.epicodus.gesturespractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.CycleInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.epicodus.gesturespractice.util.OnDoubleTapListener;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.puppyImageView) ImageView mPuppyImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mPuppyImageView.setOnTouchListener(new OnDoubleTapListener(this) {
            @Override
            public void onDoubleTap(MotionEvent e) {
                if (mPuppyImageView.getAlpha() == 1) {
                    mPuppyImageView.requestLayout();
                    mPuppyImageView.getLayoutParams().height = RelativeLayout.LayoutParams.WRAP_CONTENT;
                    mPuppyImageView.setAlpha(0.9f);
                } else if (mPuppyImageView.getAlpha() == 0.9f) {
                    ViewGroup.LayoutParams iv_params_b = mPuppyImageView.getLayoutParams();
                    iv_params_b.height = 300;
                    iv_params_b.width = RelativeLayout.LayoutParams.WRAP_CONTENT;
                    mPuppyImageView.setLayoutParams(iv_params_b);
                    mPuppyImageView.setAlpha(1.0f);
                }
            }

        });

    }

}

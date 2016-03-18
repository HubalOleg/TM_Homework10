package oleg.hubal.com.tm_homework10.Fragments;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageButton;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;

import oleg.hubal.com.tm_homework10.R;

/**
 * Created by User on 16.03.2016.
 */
public class HeartFragment extends Fragment implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    private View view;
    private ImageView imgHeart;
    private SeekBar sbScale, sbRotate, sbAlpha;
    private ImageButton ibScale, ibRotate, ibAlpha;
    private LinearLayout scaleLayout, rotateLayout, alphaLayout;
    private boolean alpha = true, scale = true, rotate = true;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frgm_heart, container, false);
        initViews();
        heartAnim();
        return view;
    }

    private void heartAnim() {
       Animation anim = AnimationUtils.loadAnimation(getContext(), R.anim.anim_heart);imgHeart.startAnimation(anim);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_alpha:
                if(alpha) {
                    hideSeekBarAnim(alphaLayout);
                    alpha = false;
                } else {
                    showSeekBarAnim(alphaLayout);
                    alpha = true;
                }
                break;
            case R.id.btn_rotate:
                if(rotate) {
                    hideSeekBarAnim(rotateLayout);
                    rotate = false;
                } else {
                    showSeekBarAnim(rotateLayout);
                    rotate = true;
                }
                break;
            case R.id.btn_scale:
                if(scale) {
                    hideSeekBarAnim(scaleLayout);
                    scale = false;
                } else {
                    showSeekBarAnim(scaleLayout);
                    scale = true;
                }
                break;
        }
    }

    private void showSeekBarAnim(LinearLayout seekbarLayout) {
        final ObjectAnimator transAnimator = ObjectAnimator.ofFloat(seekbarLayout,
                "translationX", -sbAlpha.getWidth(), 0.0f);
        transAnimator.setDuration(500);
        transAnimator.start();
    }

    private void hideSeekBarAnim(LinearLayout seekbarLayout) {
        final ObjectAnimator transAnimator = ObjectAnimator.ofFloat(seekbarLayout,
                "translationX", 0.0f, -sbAlpha.getWidth());
        transAnimator.setDuration(500);
        transAnimator.start();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()) {
            case R.id.alhpa_seekbar:
                imgHeart.setImageAlpha(progress * 2);
                break;
            case R.id.scale_seekbar:
                imgHeart.setScaleX(progress / 100.0f);
                imgHeart.setScaleY(progress / 100.0f);
                break;
            case R.id.rotate_seekbar:
                imgHeart.setRotation(progress * 3.6f);
                break;
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    private void initViews() {
        imgHeart = (ImageView) view.findViewById(R.id.iv_heart_FH);

        sbAlpha = (SeekBar) view.findViewById(R.id.alhpa_seekbar);
        sbRotate = (SeekBar) view.findViewById(R.id.rotate_seekbar);
        sbScale = (SeekBar) view.findViewById(R.id.scale_seekbar);

        ibAlpha = (ImageButton) view.findViewById(R.id.btn_alpha);
        ibRotate = (ImageButton) view.findViewById(R.id.btn_rotate);
        ibScale = (ImageButton) view.findViewById(R.id.btn_scale);

        scaleLayout = (LinearLayout) view.findViewById(R.id.scale_layout);
        alphaLayout = (LinearLayout) view.findViewById(R.id.alpha_layout);
        rotateLayout = (LinearLayout) view.findViewById(R.id.rotate_layout);

        sbAlpha.setOnSeekBarChangeListener(this);
        sbScale.setOnSeekBarChangeListener(this);
        sbRotate.setOnSeekBarChangeListener(this);

        ibAlpha.setOnClickListener(this);
        ibScale.setOnClickListener(this);
        ibRotate.setOnClickListener(this);
    }
}

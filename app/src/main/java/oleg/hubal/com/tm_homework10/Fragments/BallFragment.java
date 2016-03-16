package oleg.hubal.com.tm_homework10.Fragments;

import android.app.Instrumentation;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;

import oleg.hubal.com.tm_homework10.R;

/**
 * Created by User on 16.03.2016.
 */


public class BallFragment extends Fragment implements View.OnClickListener {

    private View view;
    private LinearLayout linearLayout;
    private ImageView ballImage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frgm_ball, container, false);
        initViews();
        return view;
    }

    private void initViews() {
        ballImage = (ImageView) view.findViewById(R.id.img_ball);
        linearLayout = (LinearLayout) view.findViewById(R.id.layout_ball);
        ballImage.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        v.startAnimation(getAnimation());
    }

    private AnimationSet getAnimation() {
//          Считываем размеры экрана и картинки
        int screenWidth = linearLayout.getWidth();
        int screenHeight = linearLayout.getHeight();
        int imageWidth = ballImage.getWidth();
        int imageHeight = ballImage.getHeight();
        float scaleCoof = screenWidth / imageWidth;

        final AnimationSet setAnimation = new AnimationSet(true);
        final TranslateAnimation translateAnimation =
                new TranslateAnimation(0, 0, 0, screenHeight - imageHeight- (imageHeight / 2) * (scaleCoof - 1) );
        final ScaleAnimation scaleAnimation =
                new ScaleAnimation(1f, scaleCoof, 1f, scaleCoof,
                        Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

        translateAnimation.setRepeatMode(Animation.REVERSE);
        translateAnimation.setRepeatCount(1);
        scaleAnimation.setRepeatMode(Animation.REVERSE);
        scaleAnimation.setRepeatCount(1);

        setAnimation.addAnimation(scaleAnimation);
        setAnimation.addAnimation(translateAnimation);
        setAnimation.setDuration(2000);
        setAnimation.setInterpolator(new BounceInterpolator());

        return setAnimation;
    }
}

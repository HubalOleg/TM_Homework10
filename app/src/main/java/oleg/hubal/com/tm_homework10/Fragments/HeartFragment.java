package oleg.hubal.com.tm_homework10.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import oleg.hubal.com.tm_homework10.R;

/**
 * Created by User on 16.03.2016.
 */
public class HeartFragment extends Fragment {

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frgm_heart, container, false);
        return view;
    }
}
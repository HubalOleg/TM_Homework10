package oleg.hubal.com.tm_homework10.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;

import java.util.ArrayList;
import java.util.List;

import oleg.hubal.com.tm_homework10.R;
import oleg.hubal.com.tm_homework10.RecyclerView.ListAdapter;

/**
 * Created by User on 16.03.2016.
 */
public class ListFragment extends Fragment {

    private List<String> list;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frgm_list, container, false);

        createList();
        setRecyclerView();

        return view;
    }

    private void createList() {
        list = new ArrayList<>();
        for(int i = 0; i < 100; i++) {
            list.add("Item #" + i);
        }
    }

    private void setRecyclerView() {
        RecyclerView cardList = (RecyclerView) view.findViewById(R.id.recycler_view_FL);
        cardList.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        cardList.setLayoutManager(layoutManager);

        ListAdapter listAdapter = new ListAdapter(list, getActivity());
        cardList.setAdapter(listAdapter);
    }
}

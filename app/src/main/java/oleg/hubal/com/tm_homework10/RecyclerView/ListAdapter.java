package oleg.hubal.com.tm_homework10.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.List;

import oleg.hubal.com.tm_homework10.R;

/**
 * Created by User on 16.03.2016.
 */
public class ListAdapter extends RecyclerView.Adapter<ListViewHolder> {

    private List<String> cards;
    private Context context;

    public ListAdapter(List<String> cards, Context context) {
        this.cards = cards;
        this.context = context;
    }


    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_card, parent, false);
        ListViewHolder listViewHolder = new ListViewHolder(v, context);
        return listViewHolder;
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
        holder.tvItemNumber.setText(cards.get(position));
        setAnimation(holder.card);
    }

    private void setAnimation(CardView card) {
        Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
        card.startAnimation(animation);
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }
}

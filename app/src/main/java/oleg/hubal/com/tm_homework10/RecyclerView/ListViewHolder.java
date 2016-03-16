package oleg.hubal.com.tm_homework10.RecyclerView;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import oleg.hubal.com.tm_homework10.MainActivity;
import oleg.hubal.com.tm_homework10.R;

/**
 * Created by User on 16.03.2016.
 */
public class ListViewHolder extends RecyclerView.ViewHolder {

    public CardView card;
    public TextView tvItemNumber;

    public ListViewHolder(View itemView, Context context) {
        super(itemView);
        card = (CardView) itemView.findViewById(R.id.item_card_IC);
        tvItemNumber = (TextView) itemView.findViewById(R.id.tv_card_name);
    }
}

package com.example.riteshlocal.githubexample.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.riteshlocal.githubexample.R;
import com.example.riteshlocal.githubexample.Model.HotEventListModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by ritesh.local on 5/10/2016.
 */
public class AdapterHotEvents extends RecyclerView.Adapter<AdapterHotEvents.MyViewHolder> {

    private ArrayList<HotEventListModel> eventList;
    private Context mContext;

    public AdapterHotEvents(Context context, ArrayList<HotEventListModel> eventList) {
        this.eventList = eventList;
        this.mContext = context;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.event_pic)
        ImageView eventPic;

        @Bind(R.id.end_date_txt)
        TextView end_date;

        @Bind(R.id.total_budget_txt)
        TextView totalBudgetTxt;

        @Bind(R.id.coast_per_seats_txt)
        TextView coastPerSeatTxt;

        @Bind(R.id.total_seats_txt)
        TextView totalSeatsTxt;

        @Bind(R.id.total_like_txt)
        TextView totalLikeTxt;

        @Bind(R.id.concert_name)
        TextView mConcertName;

        @Bind(R.id.instigator_name_txt)
        TextView mInstigatorName;

        @Bind(R.id.doer_name_txt)
        TextView mDoerName;

        @Bind(R.id.description_txt)
        TextView mDescription;

        @Bind(R.id.container)
        LinearLayout container;

        public MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_event_list, viewGroup, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder contactViewHolder, final int position) {

        contactViewHolder.end_date.setText("Expire: " + eventList.get(position).getEnd_date());
        contactViewHolder.mConcertName.setText(eventList.get(position).getEvent_title());
        contactViewHolder.mDescription.setText(eventList.get(position).getDescription());
        contactViewHolder.mInstigatorName.setText("Instigator - " + eventList.get(position).getInstigator_name());
        contactViewHolder.mDoerName.setText("Doer - " + eventList.get(position).getDoer_name());
        contactViewHolder.totalLikeTxt.setText(eventList.get(position).getTotal_likes());
        contactViewHolder.totalBudgetTxt.setText("$" + eventList.get(position).getPopup_amount());
        contactViewHolder.totalSeatsTxt.setText(eventList.get(position).getNumber_of_seats());
        contactViewHolder.coastPerSeatTxt.setText("$" + eventList.get(position).getSpectre_price());


        if (eventList.get(position).getEvent_image().equalsIgnoreCase("")) {

        } else {
            Picasso.with(mContext).load(eventList.get(position).getEvent_image()).error(R.drawable.placeholder).resize(300, 300)
                    .centerCrop().into(contactViewHolder.eventPic);
        }


    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

}
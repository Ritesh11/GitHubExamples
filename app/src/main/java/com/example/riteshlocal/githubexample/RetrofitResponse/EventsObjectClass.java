package com.example.riteshlocal.githubexample.RetrofitResponse;

/**
 * Created by ritesh.local on 5/19/2016.
 */
import com.example.riteshlocal.githubexample.Model.HotEventListModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by ritesh.local on 5/11/2016.
 */
public class EventsObjectClass {

    @SerializedName("Hot")
    @Expose
    private ArrayList<HotEventListModel> hot_event_list_model;

    public ArrayList<HotEventListModel> getHot_event_list_model() {
        return hot_event_list_model;
    }

    public void setHot_event_list_model(ArrayList<HotEventListModel> hot_event_list_model) {
        this.hot_event_list_model = hot_event_list_model;
    }
}


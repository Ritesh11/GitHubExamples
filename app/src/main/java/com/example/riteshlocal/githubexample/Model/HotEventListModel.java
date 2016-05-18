package com.example.riteshlocal.githubexample.Model;

/**
 * Created by ritesh.local on 5/19/2016.
 */
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by ritesh.local on 5/11/2016.
 */
public class HotEventListModel {

    @SerializedName("event_id")
    @Expose
    private String event_id;

    @SerializedName("user_id")
    @Expose
    private String user_id;

    @SerializedName("user_type")
    @Expose
    private String user_type;

    @SerializedName("event_image")
    @Expose
    private String event_image;

    @SerializedName("event_title")
    @Expose
    private String event_title;

    @SerializedName("doer_id")
    @Expose
    private String doer_id;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("end_date")
    @Expose
    private String end_date;

    @SerializedName("popup_amount")
    @Expose
    private String popup_amount;

    @SerializedName("spectre_price")
    @Expose
    private String spectre_price;

    @SerializedName("number_of_seats")
    @Expose
    private String number_of_seats;

    @SerializedName("event_channel")
    @Expose
    private String event_channel;

    @SerializedName("min_percent_of_amount")
    @Expose
    private String min_percent_of_amount;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("is_deleted")
    @Expose
    private String is_deleted;

    @SerializedName("created")
    @Expose
    private String created;


    @SerializedName("total_likes")
    @Expose
    private String total_likes;


    @SerializedName("Instigator_name")
    @Expose
    private String Instigator_name;

    @SerializedName("Doer_name")
    @Expose
    private String Doer_name;



    @SerializedName("event_channel_name")
    @Expose
    private String event_channel_name;


    @SerializedName("Comment")
    @Expose
    private String Comment;

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public String getEvent_channel_name() {
        return event_channel_name;
    }

    public void setEvent_channel_name(String event_channel_name) {
        this.event_channel_name = event_channel_name;
    }


    public String getEvent_id() {
        return event_id;
    }

    public void setEvent_id(String event_id) {
        this.event_id = event_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getEvent_image() {
        return event_image;
    }

    public void setEvent_image(String event_image) {
        this.event_image = event_image;
    }

    public String getEvent_title() {
        return event_title;
    }

    public void setEvent_title(String event_title) {
        this.event_title = event_title;
    }

    public String getDoer_id() {
        return doer_id;
    }

    public void setDoer_id(String doer_id) {
        this.doer_id = doer_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getPopup_amount() {
        return popup_amount;
    }

    public void setPopup_amount(String popup_amount) {
        this.popup_amount = popup_amount;
    }

    public String getSpectre_price() {
        return spectre_price;
    }

    public void setSpectre_price(String spectre_price) {
        this.spectre_price = spectre_price;
    }

    public String getNumber_of_seats() {
        return number_of_seats;
    }

    public void setNumber_of_seats(String number_of_seats) {
        this.number_of_seats = number_of_seats;
    }

    public String getEvent_channel() {
        return event_channel;
    }

    public void setEvent_channel(String event_channel) {
        this.event_channel = event_channel;
    }

    public String getMin_percent_of_amount() {
        return min_percent_of_amount;
    }

    public void setMin_percent_of_amount(String min_percent_of_amount) {
        this.min_percent_of_amount = min_percent_of_amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(String is_deleted) {
        this.is_deleted = is_deleted;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getTotal_likes() {
        return total_likes;
    }

    public void setTotal_likes(String total_likes) {
        this.total_likes = total_likes;
    }

    public String getInstigator_name() {
        return Instigator_name;
    }

    public void setInstigator_name(String instigator_name) {
        Instigator_name = instigator_name;
    }

    public String getDoer_name() {
        return Doer_name;
    }

    public void setDoer_name(String doer_name) {
        Doer_name = doer_name;
    }


}

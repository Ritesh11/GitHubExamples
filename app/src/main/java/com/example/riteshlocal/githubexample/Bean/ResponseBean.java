package com.example.riteshlocal.githubexample.Bean;

import com.example.riteshlocal.githubexample.RetrofitResponse.EventsObjectClass;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by bhawani on 15/4/16.
 */
public class ResponseBean {

    @SerializedName("status")
    @Expose
    private String status;


    @SerializedName("message")
    @Expose
    private String message;






    @SerializedName("Events")
    @Expose
    private EventsObjectClass events;



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }






    public EventsObjectClass getEvents() {
        return events;
    }

    public void setEvents(EventsObjectClass events) {
        this.events = events;
    }

}

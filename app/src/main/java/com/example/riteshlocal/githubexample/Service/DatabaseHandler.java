package com.example.riteshlocal.githubexample.Service;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.riteshlocal.githubexample.Model.HotEventListModel;

public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "eventsManager";

    // Contacts table name
    private static final String TABLE_CONTACTS = "events";

    // Contacts Table Columns names
    private static final String KEY_EVENT_ID = "event_id";
    private static final String KEY_USER_ID = "user_id";
    private static final String KEY_USER_TYPE = "user_type";
    private static final String KEY_IMAGE = "event_image";
    private static final String KEY_TITLE = "event_title";
    private static final String KEY_DOER_ID = "doer_id";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_END_DATE = "end_date";
    private static final String KEY_POPUP_AMOUNT = "popup_amount";
    private static final String KEY_SPECTRE_PRICE = "spectre_price";
    private static final String KEY_NUMBER_OF_SEATS = "number_of_seats";
    private static final String KEY_EVENT_CHANNEL = "event_channel";
    private static final String KEY_MIN_PERCENTAGE_AMOUNT = "min_percent_of_amount";
    private static final String KEY_STATUS = "status";
    private static final String KEY_IS_DETECTED = "is_deleted";
    private static final String KEY_CREATED = "created";
    private static final String KEY_TOTAL_LIKES = "total_likes";
    private static final String KEY_INSTIGATOR_NAME = "Instigator_name";
    private static final String KEY_DOER_NAME = "Doer_name";
    private static final String KEY_EVENT_CHANNEL_NAME = "event_channel_name";
    private static final String KEY_COMMENTS = "Comment";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_EVENT_ID + " VARCHAR PRIMARY KEY,"
                + KEY_USER_ID + " VARCHAR,"
                + KEY_USER_TYPE + " VARCHAR,"
                + KEY_IMAGE + " VARCHAR,"
                + KEY_TITLE + " VARCHAR,"
                + KEY_DOER_ID + " VARCHAR,"
                + KEY_DESCRIPTION + " VARCHAR,"
                + KEY_END_DATE + " VARCHAR,"
                + KEY_POPUP_AMOUNT + " VARCHAR,"
                + KEY_SPECTRE_PRICE + " VARCHAR,"
                + KEY_NUMBER_OF_SEATS + " VARCHAR,"
                + KEY_EVENT_CHANNEL + " VARCHAR,"
                + KEY_MIN_PERCENTAGE_AMOUNT + " VARCHAR,"
                + KEY_STATUS + " VARCHAR,"
                + KEY_IS_DETECTED + " VARCHAR,"
                + KEY_CREATED + " VARCHAR,"
                + KEY_TOTAL_LIKES + " VARCHAR,"
                + KEY_INSTIGATOR_NAME + " VARCHAR,"
                + KEY_DOER_NAME + " VARCHAR,"
                + KEY_EVENT_CHANNEL_NAME + " VARCHAR,"
                + KEY_COMMENTS + " VARCHAR"
                + ");";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

        // Create tables again
        onCreate(db);
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    // Adding new contact
    public void addContact(HotEventListModel events) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_EVENT_ID, events.getEvent_id());
        values.put(KEY_USER_ID, events.getUser_id());
        values.put(KEY_USER_TYPE, events.getUser_type());
        values.put(KEY_IMAGE, events.getEvent_image());
        values.put(KEY_TITLE, events.getEvent_title());
        values.put(KEY_DOER_ID, events.getDoer_id());
        values.put(KEY_DESCRIPTION, events.getDescription());
        values.put(KEY_END_DATE, events.getEnd_date());
        values.put(KEY_POPUP_AMOUNT, events.getPopup_amount());
        values.put(KEY_SPECTRE_PRICE, events.getSpectre_price());
        values.put(KEY_NUMBER_OF_SEATS, events.getNumber_of_seats());
        values.put(KEY_EVENT_CHANNEL, events.getEvent_channel());
        values.put(KEY_MIN_PERCENTAGE_AMOUNT, events.getMin_percent_of_amount());
        values.put(KEY_STATUS, events.getStatus());
        values.put(KEY_IS_DETECTED, events.getIs_deleted());
        values.put(KEY_CREATED, events.getCreated());
        values.put(KEY_TOTAL_LIKES, events.getTotal_likes());
        values.put(KEY_INSTIGATOR_NAME, events.getInstigator_name());
        values.put(KEY_DOER_NAME, events.getDoer_name());
        values.put(KEY_EVENT_CHANNEL_NAME, events.getEvent_channel_name());
        values.put(KEY_COMMENTS, events.getComment());


        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values);
        db.close(); // Closing database connection
    }

    // Getting single contact
    HotEventListModel getContact(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CONTACTS, new String[]{KEY_EVENT_ID, KEY_USER_ID,
                        KEY_USER_TYPE, KEY_IMAGE, KEY_TITLE, KEY_DOER_ID, KEY_DESCRIPTION, KEY_END_DATE, KEY_POPUP_AMOUNT,
                        KEY_SPECTRE_PRICE, KEY_NUMBER_OF_SEATS, KEY_EVENT_CHANNEL, KEY_MIN_PERCENTAGE_AMOUNT, KEY_STATUS, KEY_IS_DETECTED,
                        KEY_CREATED, KEY_TOTAL_LIKES, KEY_INSTIGATOR_NAME, KEY_DOER_NAME, KEY_EVENT_CHANNEL_NAME, KEY_COMMENTS}, KEY_EVENT_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        HotEventListModel event = new HotEventListModel();
        event.setEvent_id(cursor.getString(0));
        event.setUser_id(cursor.getString(1));
        event.setUser_type(cursor.getString(2));
        event.setEvent_image(cursor.getString(3));
        event.setEvent_title(cursor.getString(4));
        event.setDoer_id(cursor.getString(5));
        event.setDescription(cursor.getString(6));
        event.setEnd_date(cursor.getString(7));
        event.setPopup_amount(cursor.getString(8));
        event.setSpectre_price(cursor.getString(9));
        event.setNumber_of_seats(cursor.getString(10));
        event.setEvent_channel(cursor.getString(11));
        event.setMin_percent_of_amount(cursor.getString(12));
        event.setStatus(cursor.getString(13));
        event.setIs_deleted(cursor.getString(14));
        event.setCreated(cursor.getString(15));
        event.setTotal_likes(cursor.getString(16));
        event.setInstigator_name(cursor.getString(17));
        event.setDoer_name(cursor.getString(18));
        event.setEvent_channel_name(cursor.getString(19));
        event.setComment(cursor.getString(20));




        // return contact
        return event;
    }

    // Getting All Contacts
    public List<HotEventListModel> getAllContacts() {
        List<HotEventListModel> eventList = new ArrayList<HotEventListModel>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                HotEventListModel event = new HotEventListModel();
                event.setEvent_id(cursor.getString(0));
                event.setUser_id(cursor.getString(1));
                event.setUser_type(cursor.getString(2));
                event.setEvent_image(cursor.getString(3));
                event.setEvent_title(cursor.getString(4));
                event.setDoer_id(cursor.getString(5));
                event.setDescription(cursor.getString(6));
                event.setEnd_date(cursor.getString(7));
                event.setPopup_amount(cursor.getString(8));
                event.setSpectre_price(cursor.getString(9));
                event.setNumber_of_seats(cursor.getString(10));
                event.setEvent_channel(cursor.getString(11));
                event.setMin_percent_of_amount(cursor.getString(12));
                event.setStatus(cursor.getString(13));
                event.setIs_deleted(cursor.getString(14));
                event.setCreated(cursor.getString(15));
                event.setTotal_likes(cursor.getString(16));
                event.setInstigator_name(cursor.getString(17));
                event.setDoer_name(cursor.getString(18));
                event.setEvent_channel_name(cursor.getString(19));
                event.setComment(cursor.getString(20));
                // Adding contact to list
                eventList.add(event);
            } while (cursor.moveToNext());
        }

        // return contact list
        return eventList;
    }

    // Updating single contact
    public int updateContact(HotEventListModel contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_EVENT_ID, contact.getEvent_id());
        values.put(KEY_USER_ID, contact.getUser_id());
        values.put(KEY_USER_TYPE, contact.getUser_type());
        values.put(KEY_IMAGE, contact.getEvent_image());
        values.put(KEY_TITLE, contact.getEvent_title());
        values.put(KEY_DOER_ID, contact.getDoer_id());
        values.put(KEY_DESCRIPTION, contact.getDescription());
        values.put(KEY_END_DATE, contact.getEnd_date());
        values.put(KEY_POPUP_AMOUNT, contact.getPopup_amount());
        values.put(KEY_SPECTRE_PRICE, contact.getSpectre_price());
        values.put(KEY_NUMBER_OF_SEATS, contact.getNumber_of_seats());
        values.put(KEY_EVENT_CHANNEL, contact.getEvent_channel());
        values.put(KEY_MIN_PERCENTAGE_AMOUNT, contact.getMin_percent_of_amount());
        values.put(KEY_STATUS, contact.getStatus());
        values.put(KEY_IS_DETECTED, contact.getIs_deleted());
        values.put(KEY_CREATED, contact.getCreated());
        values.put(KEY_TOTAL_LIKES, contact.getTotal_likes());
        values.put(KEY_INSTIGATOR_NAME, contact.getInstigator_name());
        values.put(KEY_DOER_NAME, contact.getDoer_name());
        values.put(KEY_EVENT_CHANNEL_NAME, contact.getEvent_channel_name());

        // updating row
        return db.update(TABLE_CONTACTS, values, KEY_EVENT_ID + " = ?",
                new String[]{String.valueOf(contact.getEvent_id())});
    }

    // Deleting single contact
    public void deleteContact(HotEventListModel contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACTS, KEY_EVENT_ID + " = ?",
                new String[]{String.valueOf(contact.getEvent_id())});
        db.close();
    }


    // Getting contacts Count
    public int getContactsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_CONTACTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

}
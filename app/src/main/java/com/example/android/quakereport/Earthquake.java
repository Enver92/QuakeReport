package com.example.android.quakereport;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Enver on 04.04.2017.
 */

/*
* {@link Earthquake} class to hold all the relevant information for a single earthquake
* */
public class Earthquake {
    // Float to hold the EQ's magnitude
    private String mMagnitude;
    // String to hold the place of EQ
    private String mPlaceName;
    // Variable to hold the date of an EQ
    private long mMilliseconds;

    private String mUrl;

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        this.mUrl = url;
    }

    public Earthquake(String magnitude, String place, long date, String url) {
        setMagnitude(magnitude);
        setPlaceName(place);
        setMilliseconds(date);
        setUrl(url);
    }

    public String getMagnitude() {
        return mMagnitude;
    }

    public void setMagnitude(String magnitude) {
        mMagnitude = magnitude;
    }

    public String getPlaceName() {
        return mPlaceName;
    }

    public void setPlaceName(String place) {
        mPlaceName = place;
    }

    public long getMilliseconds() {
        return mMilliseconds;
    }

    public void setMilliseconds(long date) {
        mMilliseconds = date;
    }

    // Method to return a date
    public String getDate() {
        SimpleDateFormat date = new SimpleDateFormat("MMM DD, yyyy");
        return date.format(new Date(this.getMilliseconds()));
    }

    // Method to return time
    public String getTime(){
        SimpleDateFormat time = new SimpleDateFormat("h:mm a");
        return time.format(new Date(this.getMilliseconds()));
    }

    // Method to return place's offset
    public String getOffset() {
        return mSplitPlaceName()[0];
    }

    // Method to return place's primary location
    public String getLocation() {
        return mSplitPlaceName()[1];
    }

    // Split the place name into offset and primary location
    private String[] mSplitPlaceName() {
        String[] splittedPlace = new String[2];
        if(mPlaceName.contains("of")) {
            splittedPlace = mPlaceName.split("(?<=of)");
            return splittedPlace;
        } else {
            splittedPlace[0] = "Near of";
            splittedPlace[1] = mPlaceName;
        }
        return splittedPlace;
    }

}

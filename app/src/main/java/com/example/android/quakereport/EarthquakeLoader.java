package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.List;

/**
 * Created by Enver on 14.04.2017.
 */


public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {

    private static final String LOG_TAG = EarthquakeLoader.class.getSimpleName();

    private String requestUrl;

    public EarthquakeLoader(Context context, String url) {
        super(context);
        this.requestUrl = url;
    }

    @Override
    protected void onStartLoading() {
        Log.i(LOG_TAG, "Load is started");
        forceLoad();
    }

    @Override
    public List<Earthquake> loadInBackground() {
        Log.i(LOG_TAG, "Loading");
        // check the url is valid
        if(requestUrl == null) {
            return null;
        }
        // get the list of {@link Earthquake} objects
        List<Earthquake> result = QueryUtils.fetchEarthquakeData(requestUrl);
        return result;
    }

}

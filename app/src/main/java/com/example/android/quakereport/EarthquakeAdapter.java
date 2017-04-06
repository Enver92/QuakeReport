package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.android.quakereport.R.id.place_offset;

/**
 * Created by User on 04.04.2017.
 */

public class EarthquakeAdapter extends ArrayAdapter {

    public EarthquakeAdapter(@NonNull Context context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        // select the current {@link Earthquake} form the listArray
        Earthquake currentEQ = (Earthquake) getItem(position);

        // find and set data to Magnitude View
        TextView magnitudeView = (TextView)listItemView.findViewById(R.id.magnitude);
        String stringMag = currentEQ.getMagnitude();
        magnitudeView.setText(stringMag);

        // find and set data to the name of a Place
        TextView placeOffset = (TextView) listItemView.findViewById(place_offset);
        placeOffset.setText(currentEQ.getOffset());

        // find and set data to the name of a Place
        TextView placeLocation = (TextView) listItemView.findViewById(R.id.place_primary_location);
        placeLocation.setText(currentEQ.getLocation());

        // find and set data to the date of an EQ
        TextView date = (TextView) listItemView.findViewById(R.id.date);
        date.setText(currentEQ.getDate());

        // find and set data to the date of an EQ
        TextView time = (TextView) listItemView.findViewById(R.id.time);
        time.setText(currentEQ.getTime());

        return listItemView;
    }
}

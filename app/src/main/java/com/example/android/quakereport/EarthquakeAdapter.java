package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
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
        final Earthquake currentEQ = (Earthquake) getItem(position);

        // find and set data to Magnitude View
        TextView magnitudeView = (TextView)listItemView.findViewById(R.id.magnitude);
        String stringMag = currentEQ.getMagnitude();
        magnitudeView.setText(stringMag);

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEQ.getMagnitude());

        // find and set data to the name of a Place
        TextView placeOffset = (TextView) listItemView.findViewById(place_offset);
        placeOffset.setText(currentEQ.getOffset());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        // find and set data to the name of a Place
        TextView placeLocation = (TextView) listItemView.findViewById(R.id.place_primary_location);
        placeLocation.setText(currentEQ.getLocation());

        // find and set data to the date of an EQ
        TextView date = (TextView) listItemView.findViewById(R.id.date);
        date.setText(currentEQ.getDate());

        // find and set data to the time of an EQ
        TextView time = (TextView) listItemView.findViewById(R.id.time);
        time.setText(currentEQ.getTime());

        return listItemView;
    }


    /*
    * Method to set the appropriate color to the Magnitude View due to the Magnitude value
    * */
    private int getMagnitudeColor(String magnitude) {
        int magnitudeColor;

        // floor the double value of the Magnitude and cast into Integer
        int magIntValue = (int)Math.floor(Double.valueOf(magnitude));

        // change the background color with respect to the magnitude value
        switch (magIntValue) {
            case 0:
            case 1:
                magnitudeColor = R.color.magnitude1;
                break;
            case 2:
                magnitudeColor = R.color.magnitude2;
                break;
            case 3:
                magnitudeColor = R.color.magnitude3;
                break;
            case 4:
                magnitudeColor = R.color.magnitude4;
                break;
            case 5:
                magnitudeColor = R.color.magnitude5;
                break;
            case 6:
                magnitudeColor = R.color.magnitude6;
                break;
            case 7:
                magnitudeColor = R.color.magnitude7;
                break;
            case 8:
                magnitudeColor = R.color.magnitude8;
                break;
            case 9:
                magnitudeColor = R.color.magnitude9;
                break;
            default:
                magnitudeColor = R.color.magnitude10plus;
                break;

        }
        return ContextCompat.getColor(getContext(), magnitudeColor);
    }
}

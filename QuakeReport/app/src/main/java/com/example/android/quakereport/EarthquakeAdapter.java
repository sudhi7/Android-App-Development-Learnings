package com.example.android.quakereport;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> list) {
        super(context,R.layout.earthquake_listview,list);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(convertView==null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_listview, parent, false);
        }
        Earthquake earthquake = getItem(position);
        TextView mag = (TextView) listItemView.findViewById(R.id.magnitude);
        mag.setText(String.valueOf(earthquake.getMagnitude()));
        TextView offset = (TextView) listItemView.findViewById(R.id.offset);
        offset.setText(getLocationOffset(earthquake.getPlace()));
        TextView place = (TextView) listItemView.findViewById(R.id.place);
        place.setText(getPrimaryLocation(earthquake.getPlace()));
        TextView date = (TextView) listItemView.findViewById(R.id.date);
        date.setText(DateFormater.getFormatedDate(earthquake.getDate()));
        TextView time = (TextView) listItemView.findViewById(R.id.time);
        time.setText(DateFormater.getFormattedTime(earthquake.getDate()));
        return listItemView;
    }

    public String getLocationOffset(String json_location) {
        if(json_location.contains("Near the")) {
            return "Near the";
        }
        int slicing_index;
        slicing_index = json_location.indexOf("of");
        if(slicing_index==-1)
            return "";
        return json_location.substring(0,slicing_index+2);
    }

    public String getPrimaryLocation(String json_location) {
        if (json_location.contains("Near the")) {
            return json_location.substring(10, json_location.length());
        }
        int slicing_index;
        slicing_index = json_location.indexOf("of");
        if(slicing_index==-1)
            return json_location;
        return json_location.substring(slicing_index+3,json_location.length());
    }
}

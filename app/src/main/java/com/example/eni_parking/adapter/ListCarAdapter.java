package com.example.eni_parking.adapter;

import android.app.LauncherActivity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.eni_parking.R;
import com.example.eni_parking.bo.Car;

import java.util.List;

public class ListCarAdapter  extends ArrayAdapter<Car> {

    public ListCarAdapter(@NonNull Context context, int resource,
                         List<Car> items) {
        super(context, resource, items);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView,
                        @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(this.getContext());

        View view;

        if (convertView == null) {
            view = inflater
                    .inflate(R.layout.lstcar_item, parent, false);
        } else {
            view = convertView;
        }

        ((TextView)view.findViewById(R.id.car_id))
                .setText(String.valueOf(this.getItem(position).getId()));
        ((TextView)view.findViewById(R.id.car_price))
                .setText(String.valueOf(this.getItem(position).getPrice()));

        String isBooked;
        if(this.getItem(position).getIsBooked() == 1) {
            isBooked = "Loué";
        } else {
            isBooked = "Disponible";
        }
        ((TextView)view.findViewById(R.id.car_isBooked))
                .setText(isBooked);

        return view;
    }
}

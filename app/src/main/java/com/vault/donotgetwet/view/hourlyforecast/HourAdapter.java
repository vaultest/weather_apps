package com.vault.donotgetwet.view.hourlyforecast;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.vault.donotgetwet.R;
import com.vault.donotgetwet.model.weather.Hour;

/**
 * Created by Vault on 29.12.2017.
 */

public class HourAdapter extends RecyclerView.Adapter<HourAdapter.HourlyViewHolder> {

    private Hour[] mHours;

    public HourAdapter (Hour[] hours){
        mHours = hours;
    }

    @Override
    public HourlyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hourly_list_item, parent, false);
        HourlyViewHolder hourlyViewHolder = new HourlyViewHolder(view);
        return hourlyViewHolder;
    }

    @Override
    public void onBindViewHolder(HourlyViewHolder holder, int position) {
        holder.bindHour(mHours[position]);
    }

    @Override
    public int getItemCount() {
        return mHours.length;
    }



    public class HourlyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView mTimeLabel;
        public TextView mSummary;
        public TextView mTemperatureLabel;
        public ImageView mIconImageView;

        public HourlyViewHolder(View itemView) {
            super(itemView);

            mTimeLabel = itemView.findViewById(R.id.timeLabel);
            mSummary = itemView.findViewById(R.id.summaryLabel);
            mTemperatureLabel = itemView.findViewById(R.id.temperatureLabel);
            mIconImageView = itemView.findViewById(R.id.iconImageView);

            itemView.setOnClickListener(this);
        }

        public void bindHour(Hour hour) {
            mTimeLabel.setText(hour.getHour());
            mSummary.setText(hour.getSummary());
            mTemperatureLabel.setText(String.valueOf(hour.getTemperature()));
            mIconImageView.setImageResource(hour.getIconId());
        }

        @Override
        public void onClick(View view) {
            String time = mTimeLabel.getText().toString();
            String temperature = mTemperatureLabel.getText().toString();
            String summary = mSummary.getText().toString();
            String message = String.format("At %s it will be %s and %s", time, temperature, summary);
        }
    }
}

package com.vault.donotgetwet.model.weather;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Vault on 27.12.2017.
 */

public class Day implements Parcelable {

    private long mTime;
    private String mSummary;
    private double mTemperatureMax;
    private String mIcon;
    private String mTimeZone;

    public long getTime() {
        return mTime;
    }

    public void setTime(long time) {
        mTime = time;
    }

    public String getSummary() {
        return mSummary;
    }

    public void setSummary(String summary) {
        mSummary = summary;
    }

    public long getTemperatureMax() {
        return Math.round(mTemperatureMax);
    }

    public void setTemperatureMax(double temperatureMax) {
        mTemperatureMax = temperatureMax;
    }

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }

    public String getTimeZone() {
        return mTimeZone;
    }

    public void setTimeZone(String timeZone) {
        mTimeZone = timeZone;
    }

    public int getIconId() {
        return Forecast.getIconId(mIcon);
    }

    public String getDayOfTheWeek() {
        SimpleDateFormat formater = new SimpleDateFormat("EEEE");
        formater.setTimeZone(TimeZone.getTimeZone(mTimeZone));
        Date dateTime = new Date(mTime * 1000);
        return formater.format(dateTime);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(mTime);
        dest.writeString(mSummary);
        dest.writeDouble(mTemperatureMax);
        dest.writeString(mIcon);
        dest.writeString(mTimeZone);
    }

    public Day(){}

    private Day(Parcel in) {
        mTime = in.readLong();
        mSummary = in.readString();
        mTemperatureMax = in.readDouble();
        mIcon = in.readString();
        mTimeZone = in.readString();
    }

    public static final Creator<Day> CREATOR = new Creator<Day>() {
        @Override
        public Day createFromParcel(Parcel parcel) {
            return new Day(parcel);
        }

        @Override
        public Day[] newArray(int size) {
            return new Day[size];
        }
    };
}

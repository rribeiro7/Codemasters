package pt.andreiaribeiro.com.andreiaribeiro.repositories.model;

/**
 * Created by Rui on 13/09/2017.
 */

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.PrimaryKey;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Services {

    @PrimaryKey
    @JsonProperty("ServiceID")
    protected int mServiceID;

    @ColumnInfo(name = "name")
    @JsonProperty("ServiceName")
    protected String mServiceName;

    @ColumnInfo(name = "price")
    @JsonProperty("Price")
    protected double mPrice;

    @ColumnInfo(name = "activity_id")
    @JsonProperty("ActivityID")
    protected int mActivityID;

    @ColumnInfo(name = "activity_name")
    @JsonProperty("ActivityName")
    protected String mActivityName;

    public Services() {
    }

    public int getServiceID() {
        return mServiceID;
    }

    public void setServiceID(int serviceID) {
        mServiceID = serviceID;
    }

    public String getServiceName() {
        return mServiceName;
    }

    public void setServiceName(String serviceName) {
        mServiceName = serviceName;
    }

    public double getPrice() {
        return mPrice;
    }

    public void setPrice(double price) {
        mPrice = price;
    }

    public int getActivityID() {
        return mActivityID;
    }

    public void setActivityID(int activityID) {
        mActivityID = activityID;
    }

    public String getActivityName() {
        return mActivityName;
    }

    public void setActivityName(String activityName) {
        mActivityName = activityName;
    }
}

package pt.andreiaribeiro.com.andreiaribeiro.repositories.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.PrimaryKey;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Services {

    @PrimaryKey
    @JsonProperty("ServiceID")
    private int serviceID;

    @ColumnInfo(name = "name")
    @JsonProperty("ServiceName")
    private String serviceName;

    @ColumnInfo(name = "price")
    @JsonProperty("Price")
    private double price;

    @ColumnInfo(name = "activity_id")
    @JsonProperty("ActivityID")
    private int activityID;

    @ColumnInfo(name = "activity_name")
    @JsonProperty("ActivityName")
    private String activityName;

    public Services() {
    }

    public int getServiceID() {
        return serviceID;
    }

    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getActivityID() {
        return activityID;
    }

    public void setActivityID(int activityID) {
        this.activityID = activityID;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }
}

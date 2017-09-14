package pt.andreiaribeiro.com.andreiaribeiro.network;

/**
 * Created by Rui on 13/09/2017.
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Services {

    @JsonProperty("ServiceID")
    protected int mServiceID;
    @JsonProperty("ServiceName")
    protected String mServiceName;
    @JsonProperty("Price")
    protected double mPrice;
    @JsonProperty("ActivityID")
    protected int mActivityID;
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

package pt.andreiaribeiro.com.andreiaribeiro.network;

/**
 * Created by Rui on 13/09/2017.
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProfessionalService {

    @JsonProperty("ActivityID")
    protected int mActivityID;
    @JsonProperty("ActivityName")
    protected String mActivityName;
    @JsonProperty("ServiceID")
    protected int mServiceID;
    @JsonProperty("ServiceName")
    protected String mServiceName;
    @JsonProperty("Price")
    protected Double mPrice;

    public void ProfessionalService() {
    }

    public int getActivityID() {
        return mActivityID;
    }

    public void setActivityID(int mActivityID) {
        this.mActivityID = mActivityID;
    }

    public String getActivityName() {
        return mActivityName;
    }

    public void setActivityName(String mActivityName) {
        this.mActivityName = mActivityName;
    }

    public int getServiceID() {
        return mServiceID;
    }

    public void setServiceID(int mServiceID) {
        this.mServiceID = mServiceID;
    }

    public String getServiceName() {
        return mServiceName;
    }

    public void setServiceName(String mServiceName) {
        this.mServiceName = mServiceName;
    }

    public Double getPrice() {
        return mPrice;
    }

    public void setPrice(Double mPrice) {
        this.mPrice = mPrice;
    }
}

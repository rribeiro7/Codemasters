package pt.andreiaribeiro.com.andreiaribeiro.network;

/**
 * Created by Rui on 13/09/2017.
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ScheduleActions {
    @JsonProperty("ID")
    protected int mID;
    @JsonProperty("ProfessionalName")
    protected String mProfessionalName;
    @JsonProperty("UserName")
    protected String mUserName;
    @JsonProperty("ServiceName")
    protected String mServiceName;
    @JsonProperty("Date")
    protected String mDate;
    @JsonProperty("Duration")
    protected int mDuration;
    @JsonProperty("Price")
    protected double mPrice;
    @JsonProperty("Observations")
    protected String mObservations;
    @JsonProperty("Professional_Observations")
    protected String mProfessional_Observations;
    @JsonProperty("State")
    protected String mState;
    @JsonProperty("StateName")
    protected String mStateName;

    public ScheduleActions() {
    }

    public int getID() {
        return mID;
    }

    public void setID(int mID) {
        this.mID = mID;
    }

    public String getProfessionalName() {
        return mProfessionalName;
    }

    public void setProfessionalName(String mProfessionalName) {
        this.mProfessionalName = mProfessionalName;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String mUserName) {
        this.mUserName = mUserName;
    }

    public String getServiceName() {
        return mServiceName;
    }

    public void setServiceName(String mServiceName) {
        this.mServiceName = mServiceName;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String mDate) {
        this.mDate = mDate;
    }

    public int getDuration() {
        return mDuration;
    }

    public void setDuration(int mDuration) {
        this.mDuration = mDuration;
    }

    public double getPrice() {
        return mPrice;
    }

    public void setPrice(double mPrice) {
        this.mPrice = mPrice;
    }

    public String getObservations() {
        return mObservations;
    }

    public void setObservations(String mObservations) {
        this.mObservations = mObservations;
    }

    public String getProfessional_Observations() {
        return mProfessional_Observations;
    }

    public void setProfessional_Observations(String mProfessional_Observations) {
        this.mProfessional_Observations = mProfessional_Observations;
    }

    public String getState() {
        return mState;
    }

    public void setState(String mState) {
        this.mState = mState;
    }

    public String getStateName() {
        return mStateName;
    }

    public void setStateName(String mStateName) {
        this.mStateName = mStateName;
    }
}

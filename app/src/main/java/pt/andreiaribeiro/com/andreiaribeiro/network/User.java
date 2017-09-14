package pt.andreiaribeiro.com.andreiaribeiro.network;

/**
 * Created by Rui on 14/09/2017.
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    @JsonProperty("ID")
    protected int mID;
    @JsonProperty("Name")
    protected String mName;
    @JsonProperty("Birthdate")
    protected String mBirthdate;
    @JsonProperty("Email")
    protected String mEmail;
    @JsonProperty("IBAN")
    protected String mIBAN;
    @JsonProperty("CreditCard")
    protected String mCreditCard;

    public User() {
    }

    public int getID() {
        return mID;
    }

    public void setID(int mID) {
        this.mID = mID;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getBirthdate() {
        return mBirthdate;
    }

    public void setBirthdate(String mBirthdate) {
        this.mBirthdate = mBirthdate;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getIBAN() {
        return mIBAN;
    }

    public void setIBAN(String mIBAN) {
        this.mIBAN = mIBAN;
    }

    public String getCreditCard() {
        return mCreditCard;
    }

    public void setCreditCard(String mCreditCard) {
        this.mCreditCard = mCreditCard;
    }
}

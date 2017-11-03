package pt.andreiaribeiro.com.andreiaribeiro.repositories.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(tableName = "user")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    @PrimaryKey
    @JsonProperty("ID")
    protected int mID;

    @ColumnInfo(name = "name")
    @JsonProperty("Name")
    protected String mName;

    @ColumnInfo(name = "birth_date")
    @JsonProperty("Birthdate")
    protected String mBirthdate;

    @ColumnInfo(name = "email")
    @JsonProperty("Email")
    protected String mEmail;

    @ColumnInfo(name = "iban")
    @JsonProperty("IBAN")
    protected String mIBAN;

    @ColumnInfo(name = "credit_card")
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

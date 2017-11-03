package pt.andreiaribeiro.com.andreiaribeiro.repositories.model;

/**
 * Created by Rui on 13/09/2017.
 */

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "professional")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Profissional {

    @JsonProperty("Services")
    public List<Services> mServices = new ArrayList<>();


    @PrimaryKey
    @JsonProperty("Id")
    protected int mId;

    @ColumnInfo(name = "name")
    @JsonProperty("Name")
    protected String mName;

    @ColumnInfo(name = "description")
    @JsonProperty("Description")
    protected String mDescription;

    @ColumnInfo(name = "birth_date")
    @JsonProperty("Birthdate")
    protected String mBirthdate;

    @ColumnInfo(name = "email")
    @JsonProperty("Email")
    protected String mEmail;

    @ColumnInfo(name = "main_photo_url")
    @JsonProperty("MainPhotoURL")
    protected String mMainPhotoURL;

    @ColumnInfo(name = "geo_one")
    @JsonProperty("GeoOne")
    protected KeyValue mGeoOne;

    @ColumnInfo(name = "geo_two")
    @JsonProperty("GeoTwo")
    protected KeyValue mGeoTwo;

    @ColumnInfo(name = "geo_three")
    @JsonProperty("GeoThree")
    protected KeyValue mGeoThree;

    // Confidential
    @ColumnInfo(name = "vat")
    @JsonProperty("VAT")
    protected String mVAT;

    @ColumnInfo(name = "iban")
    @JsonProperty("IBAN")
    protected String mIBAN;

    @ColumnInfo(name = "formation")
    @JsonProperty("Formation")
    protected String mFormation;

    @ColumnInfo(name = "cedula")
    @JsonProperty("Cedula")
    protected String mCedula;

    @ColumnInfo(name = "experience")
    @JsonProperty("Experience")
    protected int mExperience;

    public void Profissional() {
    }

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
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

    public List<Services> getServices() {
        return mServices;
    }

    public void setServices(List<Services> mServices) {
        this.mServices = mServices;
    }

    public String getMainPhotoURL() {
        return mMainPhotoURL;
    }

    public void setMainPhotoURL(String mMainPhotoURL) {
        this.mMainPhotoURL = mMainPhotoURL;
    }

    public KeyValue getGeoOne() {
        return mGeoOne;
    }

    public void setGeoOne(KeyValue mGeoOne) {
        this.mGeoOne = mGeoOne;
    }

    public KeyValue getGeoTwo() {
        return mGeoTwo;
    }

    public void setGeoTwo(KeyValue mGeoTwo) {
        this.mGeoTwo = mGeoTwo;
    }

    public KeyValue getGeoThree() {
        return mGeoThree;
    }

    public void setGeoThree(KeyValue mGeoThree) {
        this.mGeoThree = mGeoThree;
    }

    public String getVAT() {
        return mVAT;
    }

    public void setVAT(String mVAT) {
        this.mVAT = mVAT;
    }

    public String getIBAN() {
        return mIBAN;
    }

    public void setIBAN(String mIBAN) {
        this.mIBAN = mIBAN;
    }

    public String getFormation() {
        return mFormation;
    }

    public void setFormation(String mFormation) {
        this.mFormation = mFormation;
    }

    public String getCedula() {
        return mCedula;
    }

    public void setCedula(String mCedula) {
        this.mCedula = mCedula;
    }

    public int getExperience() {
        return mExperience;
    }

    public void setExperience(int mExperience) {
        this.mExperience = mExperience;
    }
}

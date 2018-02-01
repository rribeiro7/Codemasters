package pt.andreiaribeiro.com.andreiaribeiro.repositories.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "professional")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProfessionalModel {

    //TODO See all the columns that don't have primitive data types for the Database. Ignored for now.

    @Ignore
    @JsonProperty("ServicesModel")
    private List<ServicesModel> mServices = new ArrayList<>();

    @PrimaryKey
    @JsonProperty("Id")
    private int id;

    @ColumnInfo(name = "name")
    @JsonProperty("Name")
    private String name;

    @ColumnInfo(name = "description")
    @JsonProperty("Description")
    private String description;

    @ColumnInfo(name = "birth_date")
    @JsonProperty("Birthdate")
    private String birthdate;

    @ColumnInfo(name = "email")
    @JsonProperty("Email")
    private String email;

    @ColumnInfo(name = "main_photo_url")
    @JsonProperty("MainPhotoURL")
    private String mainPhotoURL;

    @Ignore
    @JsonProperty("GeoOne")
    private KeyValueModel geoOne;

    @Ignore
    @JsonProperty("GeoTwo")
    private KeyValueModel geoTwo;

    @Ignore
    @JsonProperty("GeoThree")
    private KeyValueModel geoThree;

    // Confidential
    @ColumnInfo(name = "vat")
    @JsonProperty("VAT")
    private String vat;

    @ColumnInfo(name = "iban")
    @JsonProperty("IBAN")
    private String iban;

    @ColumnInfo(name = "formation")
    @JsonProperty("Formation")
    private String formation;

    @ColumnInfo(name = "cedula")
    @JsonProperty("Cedula")
    private String cedula;

    @ColumnInfo(name = "experience")
    @JsonProperty("Experience")
    private int experience;

    public void Profissional() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMainPhotoURL() {
        return mainPhotoURL;
    }

    public void setMainPhotoURL(String mainPhotoURL) {
        this.mainPhotoURL = mainPhotoURL;
    }

    public KeyValueModel getGeoOne() {
        return geoOne;
    }

    public void setGeoOne(KeyValueModel geoOne) {
        this.geoOne = geoOne;
    }

    public KeyValueModel getGeoTwo() {
        return geoTwo;
    }

    public void setGeoTwo(KeyValueModel geoTwo) {
        this.geoTwo = geoTwo;
    }

    public KeyValueModel getGeoThree() {
        return geoThree;
    }

    public void setGeoThree(KeyValueModel geoThree) {
        this.geoThree = geoThree;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getFormation() {
        return formation;
    }

    public void setFormation(String formation) {
        this.formation = formation;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}

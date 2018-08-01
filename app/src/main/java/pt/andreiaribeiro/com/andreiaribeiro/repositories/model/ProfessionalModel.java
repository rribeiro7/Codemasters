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

    @PrimaryKey
    @JsonProperty("ID")
    private int id;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Description")
    private String description;

    @JsonProperty("Birthdate")
    private String birthdate;

    @JsonProperty("Formation")
    private String formation;

    @JsonProperty("Experience")
    private String experience;

    @JsonProperty("Tags")
    private String tags;

    @JsonProperty("CustomTags")
    private String customTags;

    @JsonProperty("Video")
    private String video;

    @JsonProperty("DistinctActivities")
    private List<String> distinctActivities;

    @JsonProperty("Service")
    private List<ServicesModel> services;

    @JsonProperty("AvgPrice")
    private String avgPrice;

    //@JsonProperty("Geos")
    //private List<Geos> geos;

    @JsonProperty("MainPhoto")
    private String mainPhoto;

    @JsonProperty("MainPhotoURL")
    private String mainPhotoURL;

    @JsonProperty("OtherPhotos")
    private List<String> otherPhotos;

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

    public String getFormation() {
        return formation;
    }

    public void setFormation(String formation) {
        this.formation = formation;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getCustomTags() {
        return customTags;
    }

    public void setCustomTags(String customTags) {
        this.customTags = customTags;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public List<String> getDistinctActivities() {
        return distinctActivities;
    }

    public void setDistinctActivities(List<String> distinctActivities) {
        this.distinctActivities = distinctActivities;
    }

    public List<ServicesModel> getServices() {
        return services;
    }

    public void setServices(List<ServicesModel> services) {
        this.services = services;
    }

    public String getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(String avgPrice) {
        this.avgPrice = avgPrice;
    }

    public String getMainPhoto() {
        return mainPhoto;
    }

    public void setMainPhoto(String mainPhoto) {
        this.mainPhoto = mainPhoto;
    }

    public String getMainPhotoURL() {
        return mainPhotoURL;
    }

    public void setMainPhotoURL(String mainPhotoURL) {
        this.mainPhotoURL = mainPhotoURL;
    }

    public List<String> getOtherPhotos() {
        return otherPhotos;
    }

    public void setOtherPhotos(List<String> otherPhotos) {
        this.otherPhotos = otherPhotos;
    }
}

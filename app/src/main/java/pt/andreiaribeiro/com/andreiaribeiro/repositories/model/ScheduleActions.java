package pt.andreiaribeiro.com.andreiaribeiro.repositories.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ScheduleActions {

    @JsonProperty("ID")
    private int id;

    @JsonProperty("ProfessionalName")
    private String professionalName;

    @JsonProperty("UserName")
    private String userName;

    @JsonProperty("ServiceName")
    private String serviceName;

    @JsonProperty("Date")
    private String date;

    @JsonProperty("Duration")
    private int duration;

    @JsonProperty("Price")
    private double price;

    @JsonProperty("Observations")
    private String observations;

    @JsonProperty("Professional_Observations")
    private String professional_Observations;

    @JsonProperty("State")
    private String state;

    @JsonProperty("StateName")
    private String stateName;

    public ScheduleActions() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProfessionalName() {
        return professionalName;
    }

    public void setProfessionalName(String professionalName) {
        this.professionalName = professionalName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public String getProfessional_Observations() {
        return professional_Observations;
    }

    public void setProfessional_Observations(String professional_Observations) {
        this.professional_Observations = professional_Observations;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
}

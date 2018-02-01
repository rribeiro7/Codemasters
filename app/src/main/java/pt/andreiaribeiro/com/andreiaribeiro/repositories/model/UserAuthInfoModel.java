package pt.andreiaribeiro.com.andreiaribeiro.repositories.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserAuthInfoModel {

    @JsonProperty("UserID")
    private int userId;

    @JsonProperty("Username")
    private String username;

    @JsonProperty("Language")
    private int Language;

    @JsonProperty("DisplayName")
    private String displayName;

    @JsonProperty("UserType")
    private int userType;

    @JsonProperty("IncompleteProfile_Location")
    private boolean incompleteProfileLocation;

    @JsonProperty("IncompleteProfile_Services")
    private boolean incompleteProfileServices;

    @JsonProperty("IncompleteProfile_PaymentInfo")
    private boolean incompleteProfilePaymentInfo;

    public UserAuthInfoModel() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getLanguage() {
        return Language;
    }

    public void setLanguage(int language) {
        Language = language;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public boolean getIncompleteProfileLocation() {
        return incompleteProfileLocation;
    }

    public void setIncompleteProfileLocation(boolean incompleteProfileLocation) {
        this.incompleteProfileLocation = incompleteProfileLocation;
    }

    public boolean getIncompleteProfileServices() {
        return incompleteProfileServices;
    }

    public void setIncompleteProfileServices(boolean incompleteProfileServices) {
        this.incompleteProfileServices = incompleteProfileServices;
    }

    public boolean getIncompleteProfilePaymentInfo() {
        return incompleteProfilePaymentInfo;
    }

    public void setIncompleteProfilePaymentInfo(boolean incompleteProfilePaymentInfo) {
        this.incompleteProfilePaymentInfo = incompleteProfilePaymentInfo;
    }
}

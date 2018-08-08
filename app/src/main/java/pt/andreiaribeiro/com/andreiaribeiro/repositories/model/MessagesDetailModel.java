package pt.andreiaribeiro.com.andreiaribeiro.repositories.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MessagesDetailModel {

    @JsonProperty("UserId")
    private int userId;

    @JsonProperty("UserName")
    private String userName;

    @JsonProperty("ProfessionalId")
    private int professionalId;

    @JsonProperty("ProfessionalName")
    private String professionalName;

    @JsonProperty("OriginDestination")
    private boolean originDestination;

    @JsonProperty("Message")
    private String message;

    @JsonProperty("Timestamp")
    private String timestamp;

    @JsonProperty("MessageRead")
    private boolean messageRead;

    @JsonProperty("Filename")
    private String filename;

    @JsonProperty("IsFileMessage")
    private boolean isFileMessage;

    @JsonProperty("FilenameURL")
    private String filenameURL;

    @JsonProperty("OriginName")
    private String originName;

    @JsonProperty("FriendlyTimestamp")
    private String friendlyTimestamp;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getProfessionalId() {
        return professionalId;
    }

    public void setProfessionalId(int professionalId) {
        this.professionalId = professionalId;
    }

    public String getProfessionalName() {
        return professionalName;
    }

    public void setProfessionalName(String professionalName) {
        this.professionalName = professionalName;
    }

    public boolean isOriginDestination() {
        return originDestination;
    }

    public void setOriginDestination(boolean originDestination) {
        this.originDestination = originDestination;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isMessageRead() {
        return messageRead;
    }

    public void setMessageRead(boolean messageRead) {
        this.messageRead = messageRead;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public boolean isFileMessage() {
        return isFileMessage;
    }

    public void setFileMessage(boolean fileMessage) {
        isFileMessage = fileMessage;
    }

    public String getFilenameURL() {
        return filenameURL;
    }

    public void setFilenameURL(String filenameURL) {
        this.filenameURL = filenameURL;
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public String getFriendlyTimestamp() {
        return friendlyTimestamp;
    }

    public void setFriendlyTimestamp(String friendlyTimestamp) {
        this.friendlyTimestamp = friendlyTimestamp;
    }
}

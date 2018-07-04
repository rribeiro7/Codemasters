package pt.andreiaribeiro.com.andreiaribeiro.view.chat;

public class Messages {

    private int UserId;
    private String UserName;
    private int ProfessionalId;
    private String ProfessionalName;
    private boolean OriginDestination;
    private String Message;
    private String Timestamp;
    private boolean MessageRead;
    private String Filename;
    private boolean IsFileMessage;
    private String FilenameURL;
    private String OriginName;
    private String FriendlyTimestamp;


    public Messages(int userId, String userName, int professionalId, String professionalName, boolean originDestination,
                    String message, String timestamp, boolean messageRead, String filename, boolean isFileMessage, String filenameURL,
                    String originName, String friendlyTimestamp) {
        this.UserId = userId;
        this.UserName = userName;
        this.ProfessionalId = professionalId;
        this.ProfessionalName = professionalName;
        this.OriginDestination = originDestination;
        this.Message = message;
        this.Timestamp = timestamp;
        this.MessageRead = messageRead;
        this.Filename = filename;
        this.IsFileMessage = isFileMessage;
        this.FilenameURL = filenameURL;
        this.OriginName = originName;
        this.FriendlyTimestamp = friendlyTimestamp;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public int getProfessionalId() {
        return ProfessionalId;
    }

    public void setProfessionalId(int professionalId) {
        ProfessionalId = professionalId;
    }

    public String getProfessionalName() {
        return ProfessionalName;
    }

    public void setProfessionalName(String professionalName) {
        ProfessionalName = professionalName;
    }

    public boolean isOriginDestination() {
        return OriginDestination;
    }

    public void setOriginDestination(boolean originDestination) {
        OriginDestination = originDestination;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(String timestamp) {
        Timestamp = timestamp;
    }

    public boolean isMessageRead() {
        return MessageRead;
    }

    public void setMessageRead(boolean messageRead) {
        MessageRead = messageRead;
    }

    public String getFilename() {
        return Filename;
    }

    public void setFilename(String filename) {
        Filename = filename;
    }

    public boolean isFileMessage() {
        return IsFileMessage;
    }

    public void setFileMessage(boolean fileMessage) {
        IsFileMessage = fileMessage;
    }

    public String getFilenameURL() {
        return FilenameURL;
    }

    public void setFilenameURL(String filenameURL) {
        FilenameURL = filenameURL;
    }

    public String getOriginName() {
        return OriginName;
    }

    public void setOriginName(String originName) {
        OriginName = originName;
    }

    public String getFriendlyTimestamp() {
        return FriendlyTimestamp;
    }

    public void setFriendlyTimestamp(String friendlyTimestamp) {
        FriendlyTimestamp = friendlyTimestamp;
    }
}

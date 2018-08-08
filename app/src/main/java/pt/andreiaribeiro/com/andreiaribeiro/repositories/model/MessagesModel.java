package pt.andreiaribeiro.com.andreiaribeiro.repositories.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MessagesModel {

    @JsonProperty("Id")
    private int id;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Messages")
    private List<MessagesDetailModel> Messages;

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

    public List<MessagesDetailModel> getMessages() {
        return Messages;
    }

    public void setMessages(List<MessagesDetailModel> messages) {
        Messages = messages;
    }
}

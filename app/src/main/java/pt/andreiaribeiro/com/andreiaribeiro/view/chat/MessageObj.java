package pt.andreiaribeiro.com.andreiaribeiro.view.chat;

import java.util.List;

public class MessageObj {
    private int Id;
    private String Name;
    private List<Messages> message;

    public MessageObj(int id, String name, List<Messages> message) {
        Id = id;
        Name = name;
        this.message = message;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List<Messages> getMessage() {
        return message;
    }

    public void setMessage(List<Messages> message) {
        this.message = message;
    }
}

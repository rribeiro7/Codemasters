package pt.andreiaribeiro.com.andreiaribeiro.view.chat;

public class ChatMessage {

    /**
     * 0 - Received
     * 1 - Sent
     */
    public int direction;
    public String message;

    public ChatMessage(int direction, String message) {
        this.direction = direction;
        this.message = message;
    }
}

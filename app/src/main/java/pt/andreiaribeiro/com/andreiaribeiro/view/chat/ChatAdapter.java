package pt.andreiaribeiro.com.andreiaribeiro.view.chat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pt.andreiaribeiro.com.andreiaribeiro.R;

public class ChatAdapter extends ArrayAdapter<ChatMessage> {

    private List<ChatMessage> chatMessageList = new ArrayList<>();

    @Override
    public void add(ChatMessage object) {
        chatMessageList.add(object);
        super.add(object);
    }

    public ChatAdapter(Context context, List<ChatMessage> chatMessageList) {
        super(context, R.layout.activity_chat);
        this.chatMessageList = chatMessageList;
    }

    public int getCount() {
        return this.chatMessageList.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ChatMessage chatMessageObj = getItem(position);

        if (chatMessageObj == null) {
            return convertView;
        }

        LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        TextView tvChatMessage;
        if (chatMessageObj.direction == 1) {
            convertView = inflater.inflate(R.layout.chat_send, parent, false);
            tvChatMessage = (TextView) convertView.findViewById(R.id.tv_message_sent);
        } else {
            convertView = inflater.inflate(R.layout.chat_receive, parent, false);
            tvChatMessage = (TextView) convertView.findViewById(R.id.tv_message_received);
        }

        tvChatMessage.setText(chatMessageObj.message);

        return convertView;
    }

    @Override
    public ChatMessage getItem(int position) {
        return chatMessageList.get(position);
    }
}
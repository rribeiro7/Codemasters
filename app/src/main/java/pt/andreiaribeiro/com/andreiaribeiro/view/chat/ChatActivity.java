package pt.andreiaribeiro.com.andreiaribeiro.view.chat;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import pt.andreiaribeiro.com.andreiaribeiro.R;

public class ChatActivity extends AppCompatActivity {

    private ChatAdapter chatAdapter;
    private ListView lvChat;
    private EditText etChatMessage;
    private Button btSendMessage;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);


        List<ChatMessage> chatMessageListMocked = new ArrayList<>();
        chatMessageListMocked.add(new ChatMessage(0, "Wazzuppppp"));
        chatAdapter = new ChatAdapter(this, chatMessageListMocked);
        lvChat = (ListView) findViewById(R.id.lv_chat);
        lvChat.setTranscriptMode(AbsListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
        lvChat.setAdapter(chatAdapter);

        //to scroll the list view to bottom on data change
        chatAdapter.registerDataSetObserver(new DataSetObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                lvChat.setSelection(chatAdapter.getCount() - 1);
            }
        });

        etChatMessage = (EditText) findViewById(R.id.et_message);
        etChatMessage.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                return (event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER) && sendChatMessage();
            }
        });

        btSendMessage = (Button) findViewById(R.id.bt_send_message);
        btSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                sendChatMessage();
            }
        });

    }

    private boolean sendChatMessage() {
        //always true when it's the user
        if (!etChatMessage.getText().toString().trim().equals("")) {
            chatAdapter.add(new ChatMessage(1, etChatMessage.getText().toString()));
            etChatMessage.setText("");
        }
        //side = !side;
        return true;
    }
}
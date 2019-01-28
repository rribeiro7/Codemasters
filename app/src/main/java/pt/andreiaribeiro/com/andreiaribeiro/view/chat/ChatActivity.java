package pt.andreiaribeiro.com.andreiaribeiro.view.chat;

import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pt.andreiaribeiro.com.andreiaribeiro.LiberiixApplication;
import pt.andreiaribeiro.com.andreiaribeiro.R;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.BaseListResponse;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.BaseResponse;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.MessagesDetailModel;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.MessagesModel;
import pt.andreiaribeiro.com.andreiaribeiro.utils.PreferencesUtils;
import pt.andreiaribeiro.com.andreiaribeiro.view.chat.adapters.MessagesAdapter;
import pt.andreiaribeiro.com.andreiaribeiro.view.schedule.ScheduleActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChatActivity extends AppCompatActivity implements Callback<BaseListResponse<MessagesDetailModel>> {

    List<ChatMessage> chatMessageList;
    private ChatAdapter chatAdapter;
    private ListView lvChat;
    private EditText etChatMessage;
    private Button btSendMessage;
    private Button btSchedule;
    private int idUser=-1;
    String cookie;
    private boolean isUser=false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        Intent intent = getIntent();
        idUser = intent.getExtras().getInt("iduser");
        cookie = PreferencesUtils.getPreferencesString(this, "cookie");
        isUser = PreferencesUtils.getPreferencesBoolean(this, "user");

        LiberiixApplication.getApiRepositoryInstance(this).getMessageById(cookie,idUser,this);

        chatMessageList = new ArrayList<>();
        chatAdapter = new ChatAdapter(this, chatMessageList);

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


        btSchedule = (Button) findViewById(R.id.bt_messagetoschedule);
        if(isUser){
            btSchedule.setVisibility(View.GONE);
        }else{
            btSchedule.setVisibility(View.VISIBLE);
        }
        btSchedule.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ChatActivity.this, ScheduleActivity.class);
                i.putExtra("id", idUser);
                startActivity(i);
            }
        });

    }

    private boolean sendChatMessage() {
        //always true when it's the user
        if (!etChatMessage.getText().toString().trim().equals("")) {
            chatAdapter.add(new ChatMessage(1, etChatMessage.getText().toString()));
            sendMessagetoServer(etChatMessage.getText().toString());
            etChatMessage.setText("");
        }
         //side = !side;
        return true;
    }

    private void sendMessagetoServer(String strMessage) {
        Call<BaseResponse<MessagesModel>> call1 = LiberiixApplication.getApiRepositoryInstance(this).getSendMessages(cookie, idUser, strMessage);
        call1.enqueue(new Callback<BaseResponse<MessagesModel>>(){
            @Override
            public void onResponse(Call<BaseResponse<MessagesModel>> call, Response<BaseResponse<MessagesModel>> response) {
                if (response.body() != null && response.errorBody() == null && response.body().getBodyResponse() != null
                        && response.body().getBodyResponse().isOk()) {
                    //Toast.makeText(ChatActivity.this, "Mensagem enviada", Toast.LENGTH_SHORT).show();
                    //to scroll the list view to bottom on data change
                    chatAdapter.registerDataSetObserver(new DataSetObserver() {
                        @Override
                        public void onChanged() {
                            super.onChanged();
                            lvChat.setSelection(chatAdapter.getCount() - 1);
                        }
                    });
                } else {
                    Toast.makeText(ChatActivity.this, "DEU CERTO MAS SEM RESPOSTA", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<MessagesModel>> call, Throwable t) {
                Toast.makeText(ChatActivity.this, "ERRO NO DOWNLOAD", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onResponse(@NonNull Call<BaseListResponse<MessagesDetailModel>> call, @NonNull Response<BaseListResponse<MessagesDetailModel>> response) {
        if (response.body() != null && response.errorBody() == null && response.body().getBodyResponse() != null
                && response.body().getBodyResponse().getObj() != null) {
            addMessages(response.body().getBodyResponse().getObj());

        } else {
            Toast.makeText(this, "DEU CERTO MAS SEM RESPOSTA", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(@NonNull Call<BaseListResponse<MessagesDetailModel>> call, Throwable t) {
        Toast.makeText(this, "ERRO NO DOWNLOAD", Toast.LENGTH_SHORT).show();
    }

    private void addMessages(List<MessagesDetailModel> obj){

        for (MessagesDetailModel mdm : obj){
            if (mdm.isOriginDestination()){
                chatMessageList.add(new ChatMessage(0, mdm.getMessage()));
            }
            else{
                chatMessageList.add(new ChatMessage(1, mdm.getMessage()));
            }
        }
        //chatMessageListMocked.add(new ChatMessage(0, "Wazzuppppp"));
        chatAdapter = new ChatAdapter(this, chatMessageList);
        chatAdapter.notifyDataSetChanged();
        lvChat.setAdapter(new ChatAdapter(this, chatMessageList));

    }
}
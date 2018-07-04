package pt.andreiaribeiro.com.andreiaribeiro.view.chat;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import pt.andreiaribeiro.com.andreiaribeiro.R;
import pt.andreiaribeiro.com.andreiaribeiro.utils.Constants;
import pt.andreiaribeiro.com.andreiaribeiro.view.chat.fragments.MessageListFragment;
import pt.andreiaribeiro.com.andreiaribeiro.view.services.fragments.ServicesListFragment;

public class MessageListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services_list);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container_services, new MessageListFragment(), MessageListFragment.class.getSimpleName())
                .commit();
    }

}

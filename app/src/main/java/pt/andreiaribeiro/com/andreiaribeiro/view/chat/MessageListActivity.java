package pt.andreiaribeiro.com.andreiaribeiro.view.chat;

import android.os.Bundle;

import pt.andreiaribeiro.com.andreiaribeiro.R;
import pt.andreiaribeiro.com.andreiaribeiro.view.BaseActivity;
import pt.andreiaribeiro.com.andreiaribeiro.view.chat.fragments.MessageListFragment;

public class MessageListActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_services_list);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container_services, new MessageListFragment(), MessageListFragment.class.getSimpleName())
                .commit();
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_services_list;
    }

    @Override
    public int getNavigationMenuItemId() {
        return R.id.navigation_chat;
    }
}
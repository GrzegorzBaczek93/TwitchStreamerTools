package com.grzegorzbaczek.twitchstreamertools.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.grzegorzbaczek.twitchstreamertools.R;
import com.grzegorzbaczek.twitchstreamertools.ui.list.ListFragment;

public class MainActivity extends AppCompatActivity {

    public static final int FRAGMENT_CONTAINER = R.id.fragment_container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setMainFragment();
    }

    private void setMainFragment() {
        getSupportFragmentManager().beginTransaction().replace(FRAGMENT_CONTAINER, new ListFragment()).commit();
    }
}

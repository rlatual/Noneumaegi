package com.nonu.noneumaegi;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.nonu.noneumaegi.Adapter.MainListAdatper;

public class MyNoneuActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_noneu);

        listView = findViewById(R.id.lv_list);
        MainListAdatper adatper = new MainListAdatper();
        listView.setAdapter(adatper);
    }
}

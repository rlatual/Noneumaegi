package com.nonu.noneumaegi;

import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.nonu.noneumaegi.Adapter.MainListAdatper;
import com.nonu.noneumaegi.VO.MainItemVO;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ListView listView;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.dl_main_drawer_root);
        navigationView = findViewById(R.id.nv_main_navigation_root);
        listView = findViewById(R.id.lv_list);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
        getSupportActionBar().setTitle("");

        MobileAds.initialize(this, "ca-app-pub-4927595503113139~4626369512");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        //testcode
        MainListAdatper adatper = new MainListAdatper();
        listView.setAdapter(adatper);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        adatper.addItem(ContextCompat.getDrawable(this, R.drawable.ic_add_primcolor_24dp),
                ContextCompat.getDrawable(this, R.drawable.ic_add_primcolor_24dp),"산곡동", "상품명", "1000원","3개");

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case android.R.id.home:
                drawerLayout.openDrawer(navigationView);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

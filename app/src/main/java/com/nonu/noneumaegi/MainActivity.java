package com.nonu.noneumaegi;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.nonu.noneumaegi.Adapter.MainListAdatper;
import com.nonu.noneumaegi.VO.MainItemVO;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ListView listView;
    private AdView mAdView;
    Button btn_new;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.dl_main_drawer_root);
        btn_new = findViewById(R.id.btn_new);

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

        final MainListAdatper adatper = new MainListAdatper();
        listView.setAdapter(adatper);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = new Intent(MainActivity.this, NoneuDetailActivity.class);
                MainItemVO vo = (MainItemVO) adatper.getItem(position);
                it.putExtra("item", vo);
                startActivity(it);
            }
        });

        btn_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), NoneuDetailActivity.class);
                it.putExtra("type", "new");
                startActivity(it);
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.item_myinfo:
                        startActivity(new Intent(MainActivity.this, MyInfoActivity.class));
                        break;
                    case R.id.item_noneumaegi:
                        startActivity(new Intent(MainActivity.this, MyNoneuActivity.class));
                        break;
                    case R.id.item_favorite:
                        break;
                    case R.id.item_setting:
                        startActivity(new Intent(MainActivity.this, SettingActivity.class));
                        break;
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return false;
            }
        });

        //testcode
        adatper.addItem(BitmapFactory.decodeResource(this.getResources(), R.drawable.ic_favorite_pink_24dp), "산곡동", "상품명", "1000원", "3개", 3, 2);
        adatper.addItem(BitmapFactory.decodeResource(this.getResources(), R.drawable.ic_add_primcolor_24dp), "산곡동", "상품명", "1000원", "3개", 2, 1);
        adatper.addItem(BitmapFactory.decodeResource(this.getResources(), R.drawable.ic_add_primcolor_24dp), "산곡동", "상품명", "1000원", "3개", 2, 2);
        adatper.addItem(BitmapFactory.decodeResource(this.getResources(), R.drawable.ic_add_primcolor_24dp), "산곡동", "상품명", "1000원", "3개", 5, 1);
        adatper.addItem(BitmapFactory.decodeResource(this.getResources(), R.drawable.ic_add_primcolor_24dp), "산곡동", "상품명", "1000원", "3개", 5, 2);
        adatper.addItem(BitmapFactory.decodeResource(this.getResources(), R.drawable.ic_add_primcolor_24dp), "산곡동", "상품명", "1000원", "3개", 4, 4);
        adatper.addItem(BitmapFactory.decodeResource(this.getResources(), R.drawable.ic_add_primcolor_24dp), "산곡동", "상품명", "1000원", "3개", 5, 4);
        adatper.addItem(BitmapFactory.decodeResource(this.getResources(), R.drawable.ic_add_primcolor_24dp), "산곡동", "상품명", "1000원", "3개", 2, 1);

        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if (!task.isSuccessful()) {
                            Log.w("MainActivity", "getInstanceId failed", task.getException());
                            return;
                        }
                        // Get new Instance ID token
                        String token = task.getResult().getToken();
                    }
                });

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

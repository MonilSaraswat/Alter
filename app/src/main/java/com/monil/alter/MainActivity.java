package com.monil.alter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_showroom:
                    Showroom showroom = new Showroom() ;
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content , showroom).commit();

                    return true;
                case R.id.navigation_workshop:
                     Workshop workshop = new Workshop() ;
                    FragmentManager fragmentManager1 = getSupportFragmentManager();
                    fragmentManager1.beginTransaction().replace(R.id.content , workshop).commit();
                    return true;
                case R.id.navigation_records:
                    Record record = new Record();
                    FragmentManager fragmentManager2 = getSupportFragmentManager();
                    fragmentManager2.beginTransaction().replace(R.id.content , record).commit() ;

                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Showroom showroom = new Showroom() ;
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content , showroom).commit();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}

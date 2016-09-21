package com.example.randona.blackwizzard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TabHost tabHost = getTabHost();

        TabHost.TabSpec Dayspec = tabHost.newTabSpec("Tab1");
        Dayspec.setIndicator("Tab1");
        Intent intentDay = new Intent(this, Tab1.class);
        Dayspec.setContent(intentDay);

        TabHost.TabSpec twoSpec = tabHost.newTabSpec("Tab2");
        twoSpec.setIndicator("Tab2");
        Intent i = new Intent(this, Tab2.class);
        twoSpec.setContent(i);
        tabHost.addTab(Dayspec);
        tabHost.addTab(twoSpec);

        for (int r = 0; r < tabHost.getTabWidget().getChildCount(); r++) {

            System.out.println("color changed");
            TextView tv = (TextView) tabHost.getTabWidget().getChildAt(r)
                    .findViewById(android.R.id.title);
            tv.setTextColor(Color.WHITE);
            // tv.setBackgroundResource(R.drawable.tab_selected);
        }

        tabHost.getTabWidget().getChildAt(0)
                .setBackgroundResource(R.drawable.btmbtnslct);
        tabHost.getTabWidget().getChildAt(1)
                .setBackgroundResource(R.drawable.btmbtnunslct);
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {

            public void onTabChanged(String tabId) {
                if (TextUtils.equals(tabId, "Tab1")) {
                    tabHost.getTabWidget().getChildAt(0)
                            .setBackgroundResource(R.drawable.btmbtnslct);
                    tabHost.getTabWidget().getChildAt(1)
                            .setBackgroundResource(R.drawable.btmbtnunslct);

                } else if (TextUtils.equals(tabId, "Tab2")) {
                    tabHost.getTabWidget().getChildAt(0)
                            .setBackgroundResource(R.drawable.btmbtnslct);
                    tabHost.getTabWidget().getChildAt(1)
                            .setBackgroundResource(R.drawable.btmbtnunslct);
                }

            }
        });

    }
    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        super.onBackPressed();
    }
}
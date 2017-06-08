package com.diycheng.gsonstudy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.diycheng.gsonstudy.generic.GenericActivity;
import com.diycheng.gsonstudy.handlenull.HandleNullActivity;
import com.diycheng.gsonstudy.mapset.MapSetActivity;
import com.diycheng.gsonstudy.primer.PrimerActivity;
import com.diycheng.gsonstudy.util.NavigationManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_primer:
                NavigationManager.overlay(this, PrimerActivity.class);
                break;
            case R.id.btn_map_set:
                NavigationManager.overlay(this, MapSetActivity.class);
                break;
            case R.id.btn_generic:
                NavigationManager.overlay(this, GenericActivity.class);
                break;
            case R.id.btn_handlenull:
                NavigationManager.overlay(this, HandleNullActivity.class);
                break;
        }
    }
}

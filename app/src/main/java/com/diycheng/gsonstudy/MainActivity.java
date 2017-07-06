package com.diycheng.gsonstudy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.diycheng.gsonstudy.annotation.AnnotationActivity;
import com.diycheng.gsonstudy.deserialize.DeserializerActivity;
import com.diycheng.gsonstudy.enumtest.EnumTestActivity;
import com.diycheng.gsonstudy.exclusionstrategy.ExclusionStrategyActivity;
import com.diycheng.gsonstudy.faulttolerant.FaultTolerantActivity;
import com.diycheng.gsonstudy.fieldnamingpolicy.FieldNamingPolicyActivity;
import com.diycheng.gsonstudy.fixbugs.FixBugsActivity;
import com.diycheng.gsonstudy.generic.GenericActivity;
import com.diycheng.gsonstudy.handlenull.HandleNullActivity;
import com.diycheng.gsonstudy.mapset.MapSetActivity;
import com.diycheng.gsonstudy.primer.PrimerActivity;
import com.diycheng.gsonstudy.serialize.SerializerActivity;
import com.diycheng.gsonstudy.streamapi.StreamApiActivity;
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
            case R.id.btn_annotation:
                NavigationManager.overlay(this, AnnotationActivity.class);
                break;
            case R.id.btn_field_naming_policy:
                NavigationManager.overlay(this, FieldNamingPolicyActivity.class);
                break;
            case R.id.btn_exclusion_strategy:
                NavigationManager.overlay(this, ExclusionStrategyActivity.class);
                break;
            case R.id.btn_fault_tolerant:
                NavigationManager.overlay(this, FaultTolerantActivity.class);
                break;
            case R.id.btn_enum_test:
                NavigationManager.overlay(this, EnumTestActivity.class);
                break;
            case R.id.btn_fix_bugs:
                NavigationManager.overlay(this, FixBugsActivity.class);
                break;
            case R.id.btn_serializer:
                NavigationManager.overlay(this, SerializerActivity.class);
                break;
            case R.id.btn_deserializer:
                NavigationManager.overlay(this, DeserializerActivity.class);
                break;
            case R.id.btn_streamapi:
                NavigationManager.overlay(this, StreamApiActivity.class);
                break;
        }
    }
}

package com.instwall.lbsmap_demo;

import android.content.Intent;
import android.location.Geocoder;
import android.location.Location;
import android.net.Uri;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.geocoder.GeocodeQuery;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.amap.api.services.geocoder.RegeocodeResult;

public class MainActivity extends AppCompatActivity implements AMap.OnMyLocationChangeListener, GeocodeSearch.OnGeocodeSearchListener {

    private static final String TAG = "BLS_DEMO";

    private MapView main_map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView(savedInstanceState);
        initLBS_Map();
    }

    private void initLBS_Map() {
        MyLocationStyle myLocationStyle;
        myLocationStyle = new MyLocationStyle();
        myLocationStyle.interval(2000);
        myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATE);
        main_map.getMap().setMyLocationStyle(myLocationStyle);
        main_map.getMap().setMyLocationEnabled(true);
    }

    private void initView(Bundle savedInstanceState) {
        main_map = findViewById(R.id.main_map);
        main_map.getMap().setOnMyLocationChangeListener(this);
        main_map.onCreate(savedInstanceState);
    }


    @Override
    protected void onResume() {
        super.onResume();
        main_map.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();

        main_map.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();


    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        main_map.onSaveInstanceState(outState);
    }

    @Override
    public void onMyLocationChange(Location location) {



        //Test 逆地理获取信息
//        GeocodeSearch search = new GeocodeSearch(getApplicationContext());
//        search.setOnGeocodeSearchListener(this);
//        LatLonPoint point = new LatLonPoint(location.getLatitude(), location.getLongitude());
//        RegeocodeQuery query = new RegeocodeQuery(point,1000,"gps");
    }


    @Override
    public void onRegeocodeSearched(RegeocodeResult regeocodeResult, int i) {

    }

    @Override
    public void onGeocodeSearched(GeocodeResult geocodeResult, int i) {

    }
}

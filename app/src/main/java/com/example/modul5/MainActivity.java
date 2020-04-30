package com.example.modul5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.widget.SearchView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback {

    //atribut dari main activity
    GoogleMap mapAPI;
    SupportMapFragment mapFragment;
    SearchView searchView;

    //mengambil android:id agar widget di xml terhubung ke java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchView = findViewById(R.id.sv_location);
        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapAPI);
        mapFragment.getMapAsync(this);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                String location = searchView.getQuery().toString();
                List<Address> addressList = null;

                if (location != null || !location.equals("")){
                    Geocoder geocoder = new Geocoder(MainActivity.this);
                    try{
                        addressList = geocoder.getFromLocationName(location,1);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Address address = addressList.get(0);
                    LatLng latLng = new LatLng(address.getLatitude(),address.getLongitude());
                    mapAPI.addMarker(new MarkerOptions().position(latLng).title(location));
                    mapAPI.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,10));
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mapAPI = googleMap;

        LatLng satu = new LatLng(-7.885841, 112.670736);
        mapAPI.addMarker(new MarkerOptions().position(satu).title("SMPN 1 Singosari"));
        mapAPI.moveCamera(CameraUpdateFactory.newLatLng(satu));

        LatLng dua = new LatLng(-7.884722, 112.647247);
        mapAPI.addMarker(new MarkerOptions().position(dua).title("SMPN 2 Singosari"));
        mapAPI.moveCamera(CameraUpdateFactory.newLatLng(dua));

        LatLng tiga = new LatLng(-7.898123, 112.689028);
        mapAPI.addMarker(new MarkerOptions().position(tiga).title("SMPN 3 Singosari"));
        mapAPI.moveCamera(CameraUpdateFactory.newLatLng(tiga));

        LatLng empat = new LatLng(-7.898018, 112.732301);
        mapAPI.addMarker(new MarkerOptions().position(empat).title("SMPN 4 Singosari"));
        mapAPI.moveCamera(CameraUpdateFactory.newLatLng(empat));

        LatLng lima = new LatLng(-7.855410, 112.626284);
        mapAPI.addMarker(new MarkerOptions().position(lima).title("SMPN 5 Singosari"));
        mapAPI.moveCamera(CameraUpdateFactory.newLatLng(lima));

        LatLng enam = new LatLng(-7.914075, 112.641095);
        mapAPI.addMarker(new MarkerOptions().position(enam).title("SMPN 6 Singosari"));
        mapAPI.moveCamera(CameraUpdateFactory.newLatLng(enam));

        LatLng tujuh = new LatLng(-7.895147, 112.680643);
        mapAPI.addMarker(new MarkerOptions().position(tujuh).title("SMP Angkasa Singosari"));
        mapAPI.moveCamera(CameraUpdateFactory.newLatLng(tujuh));

        LatLng delapan = new LatLng(-7.903020, 112.663317);
        mapAPI.addMarker(new MarkerOptions().position(delapan).title("SMP Islam Bani Hasyim Singosari"));
        mapAPI.moveCamera(CameraUpdateFactory.newLatLng(delapan));

        LatLng sembilan = new LatLng(-7.904671, 112.670423);
        mapAPI.addMarker(new MarkerOptions().position(sembilan).title("Rumah"));
        mapAPI.moveCamera(CameraUpdateFactory.newLatLng(sembilan));
    }
}

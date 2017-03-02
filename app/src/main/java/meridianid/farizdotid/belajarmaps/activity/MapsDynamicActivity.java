package meridianid.farizdotid.belajarmaps.activity;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import meridianid.farizdotid.belajarmaps.R;
import meridianid.farizdotid.belajarmaps.helper.GPSTracker;

public class MapsDynamicActivity extends FragmentActivity implements OnMapReadyCallback {

    private static final String TAG = "MapsDynamicActivity";
    private GoogleMap mMap;
    private GPSTracker gpsTracker;
    double _lat, _long;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_dynamic);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        gpsTracker = new GPSTracker(this);
        if (gpsTracker.canGetLocation()){
            _lat = gpsTracker.getLatitude();
            _long = gpsTracker.getLongitude();
            Log.d(TAG, "onCreate: LAT > " + _lat + " LONG > " + _long);
        } else {
            gpsTracker.showSettingsAlert();
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng kordinatDevice = new LatLng(_lat, _long);
        mMap.addMarker(new MarkerOptions().position(kordinatDevice).title("Kamu Disini"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(kordinatDevice, 16));
    }
}

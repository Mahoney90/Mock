package com.mahoneyapps.tapitfinal;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Brendan on 3/7/2016.
 */

public class GenerateMapFragment extends SupportMapFragment implements OnMapReadyCallback {
    private GoogleMap mMap;
    LatLng GP = new LatLng(-41.2952851, 174.7678296);
    LatLng RV = new LatLng(-41.2934317, 174.774445);
    Marker marker;
    GoogleApiClient mGoogleApiClient;
    private static final int REQUEST_CODE_LOCATION = 2;

    public GenerateMapFragment() {

    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("My Map", "onResume");
        setUpMapIfNeeded();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    private void setUpMapIfNeeded() {
        if (mMap == null) {
            Log.d("My Map", "setUpMapIfNeeded");
            getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        Log.d("MyMap", "onMapReady");
        mMap = googleMap;
        setUpMap();

    }

    private void setUpMap() {
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    public void requestPermissions(@NonNull String[] permissions, int requestCode)
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for Activity#requestPermissions for more details.
            return;
        }
        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(getContext())
                    .addApi(LocationServices.API)
                    .build();


            mMap.setMyLocationEnabled(true);
            mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            mMap.getUiSettings().setMapToolbarEnabled(false);

            Marker GarageProject = mMap.addMarker(new MarkerOptions().position(GP).title("Garage Project"));
            Marker RogueAndVagabond = mMap.addMarker(new MarkerOptions().position(RV).title("Rogue and Vagabond")
                    .snippet("Love this place"));

            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(GP, 14.0f));

        }
    }
}





//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.map_fragment, container, false);
//
//        return view;
//    }
//
//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//
//        mMap = ((MapFragment) getChildFragmentManager().findFragmentById(R.id.map)).getA
//    }
//











//public class GenerateMapFragment extends Fragment {
//
//    private static View view;
//    private static GoogleMap mMap;
//    private static Double latitude, longitude;
//    Context mContext;
//
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//
//        if (mMap != null) {
//            MainActivity.fragmentManager.beginTransaction().remove(MainActivity.fragmentManager.
//                    findFragmentById(R.id.map)).commit();
//            mMap = null;
//        }
//    }
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        view = inflater.inflate(R.layout.map_fragment, container, false);
//
//        SupportMapFragment mapFragment = (SupportMapFragment) this.getChildFragmentManager().findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);
//
//        if (container == null) {
//            return null;
//        }
//
//        latitude = -41.2952851;
//        longitude = 174.7678296;
//
//        setUpMapIfNeeded(mContext);
//
//        return view;
//    }
//
//    public void onMapReady(GoogleMap googleMap) {
//        mMap = googleMap;
//
//
//        // Add a marker in Sydney, Australia, and move the camera.
//        LatLng garageProject = new LatLng(-41.2952851, 174.7678296);
//        mMap.addMarker(new MarkerOptions().position(garageProject).title("Garage Project").
//                icon(BitmapDescriptorFactory.defaultMarker(145)));
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(garageProject, 14.0f));
//        newMarker("The Malthouse", -41.2935125, 174.7816054);
//        newMarker("Tuatara - The Third Eye", -41.2972423, 174.7743407);
//        newMarker("Parrotdog", -41.2968188, 174.780145);
//        newMarker("Rogue and Vagabond", -41.2934317, 174.774445);
//    }
//
//    public void newMarker(String place, double lat, double lng) {
//        LatLng coords = new LatLng(lat, lng);
//        mMap.addMarker(new MarkerOptions().position(coords).title(place));
//    }
//
//    @Override
//    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//
//        mContext = getContext();
//        if (mMap != null) {
//            setUpMap(mContext);
//        }
//
//        if (mMap == null) {
//            mMap = ((SupportMapFragment) MainActivity.fragmentManager.findFragmentById(R.id.map)).getMapAsync(this);
//
//            if (mMap != null) {
//                setUpMap(mContext);
//            }
//        }
//
//
//    }
//
//    public static void setUpMapIfNeeded(Context context) {
//
//        if (mMap == null) {
//            mMap = ((MapFragment) MainActivity.fragmentManager.findFragmentById(R.id.map));
//
//            if (mMap != null) {
//                setUpMap(context);
//            }
//        }
//    }
//
//    private static void setUpMap(Context context) {
//        if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION)
//                != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION)
//                != PackageManager.PERMISSION_GRANTED) {
//            // TODO: Consider calling
//            //    public void requestPermissions(@NonNull String[] permissions, int requestCode)
//            // here to request the missing permissions, and then overriding
//            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//            //                                          int[] grantResults)
//            // to handle the case where the user grants the permission. See the documentation
//            // for Activity#requestPermissions for more details.
//            return;
//        }
//        mMap.setMyLocationEnabled(true);
//        mMap.addMarker(new MarkerOptions().position(new LatLng(latitude, longitude)).
//                title("Garage Project").snippet("Beer Address"));
//        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latitude, longitude), 14.0f));
//    }
//
//}

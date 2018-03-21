package com.example.chat.locationtracker;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Destination extends AppCompatActivity implements LoaderCallbacks<Cursor> {
    private PlaceLocation mAuthTask = null;
    private EditText mLat;
    private EditText mLong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination);
        mLat = (EditText) findViewById(R.id.lat_text);
        mLong = (EditText) findViewById(R.id.long_text);
        Button addDestinationButton = (Button) findViewById(R.id.add_destination_button);
        addDestinationButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                getDestinationCoords();
            }
        });
    }

    private void getDestinationCoords() {
        Intent intent = new Intent(this, MapsActivityCurrentPlace.class);
        String latitude = mLat.getText().toString();
        String longitude = mLong.getText().toString();
        intent.putExtra("Latitude",latitude);
        intent.putExtra("Longitude",longitude);
        startActivity(intent);
    }
    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return null;
    }
    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) { }
    @Override
    public void onLoaderReset(Loader<Cursor> loader) { }
    public class PlaceLocation extends AsyncTask<Void, Void, Boolean> {
        private final String mLatitude;
        private final String mLongitude;
        PlaceLocation(String mLat, String mLong) {
            mLatitude = mLat;
            mLongitude = mLong;
        }
        @Override
        protected Boolean doInBackground(Void... voids) {
            return null;
        }
        @Override
        protected void onCancelled() {
            mAuthTask = null;
        }
    }
}
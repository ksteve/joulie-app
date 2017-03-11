package com.example.kyle.joulieapp;

import android.graphics.drawable.Drawable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.kyle.joulieapp.Models.Device;
import com.example.kyle.joulieapp.Models.DummyContent;
import com.example.kyle.joulieapp.api.ApiClient;
import com.example.kyle.joulieapp.api.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewDeviceActivity extends AppCompatActivity {

    //controls
    private Spinner deviceType;
    private EditText deviceNameView;
    private ImageView deviceImageView;
    private Drawable defaultDeviceImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_device);
        ActionBar ab = getSupportActionBar();
        ab.setTitle("Add Device");
        ab.setDisplayHomeAsUpEnabled(true);

        deviceImageView = (ImageView) findViewById(R.id.deviceImage);
        deviceNameView = (EditText) findViewById(R.id.device_name);
        deviceType = (Spinner) findViewById(R.id.device_type);

        defaultDeviceImage = ContextCompat.getDrawable(NewDeviceActivity.this, R.mipmap.ic_outlet);
        deviceImageView.setImageDrawable(defaultDeviceImage);

        ArrayAdapter spinnerArrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.device_types));
        deviceType.setAdapter(spinnerArrayAdapter);

        //deviceType.setAdapter(new SpinnerAdapter() {

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (deviceNameView.getText().toString().trim().isEmpty()) {
                    deviceNameView.setError("Device Name is Required");
                } else {

                    final Device device = new Device("1",
                            deviceType.getSelectedItem().toString(),
                            deviceNameView.getText().toString(),
                            defaultDeviceImage);

                    ApiInterface apiInterface = ApiClient.getClient(NewDeviceActivity.this).create(ApiInterface.class);
                    Call<Device> call = apiInterface.createDevice("Test", device);
                    call.enqueue(new Callback<Device>() {
                        @Override
                        public void onResponse(Call<Device> call, Response<Device> response) {
                            DummyContent.MY_DEVICES.add(device);
                            finish();
                        }

                        @Override
                        public void onFailure(Call<Device> call, Throwable t) {
                            finish();
                        }
                    });
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

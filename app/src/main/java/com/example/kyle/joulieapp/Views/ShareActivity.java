package com.example.kyle.joulieapp.Views;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.kyle.joulieapp.Contracts.ShareContract;
import com.example.kyle.joulieapp.Models.Device;
import com.example.kyle.joulieapp.Models.DummyContent;
import com.example.kyle.joulieapp.Presenters.SharePresenter;
import com.example.kyle.joulieapp.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ShareActivity extends AppCompatActivity implements ShareContract.View{

    private ShareContract.Presenter mSharePresenter;
    private Spinner permissionDropdown;
    private Button btnShare;
    private Button btnSearch;
    private TextView tvEmail;
    private Device mCurrentDevice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        Bundle extras = getIntent().getExtras();
        int device_index = -1;
        if (extras != null) {
            device_index = extras.getInt("index");
            mCurrentDevice = DummyContent.MY_DEVICES.get(device_index);
            //The key argument here must match that used in the other activity
        }

        new SharePresenter(this, this);

        ActionBar ab = getSupportActionBar();
        if (device_index == -1){
            ab.setTitle("Share");
        }
        else{
            ab.setTitle("Share " + DummyContent.MY_DEVICES.get(device_index).getDeviceName());
        }

        ab.setDisplayHomeAsUpEnabled(true);

        //populate permission dropdown
        permissionDropdown = (Spinner) findViewById(R.id.permission_dropdown);
        List<String> permissionList = new ArrayList<String>();
        permissionList.add("Can edit");
        permissionList.add("Can view only");

        ArrayAdapter<String> permissionDataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, permissionList);
        permissionDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        permissionDropdown.setAdapter(permissionDataAdapter);

        //start with permission dropdown and share button as disabled
        permissionDropdown.setEnabled(false);

        btnSearch = (Button) findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSharePresenter.findUserByEmail(tvEmail.getText().toString());
            }
        });

        tvEmail = (TextView) findViewById(R.id.email_input);

        btnShare = (Button) findViewById(R.id.btnShare);
        btnShare.setEnabled(false);
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSharePresenter.shareDeviceWithUser(mCurrentDevice.getId());
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        mSharePresenter.start();
        btnShare.setEnabled(false);

    }

    @Override
    public void setPresenter(ShareContract.Presenter presenter) {
        mSharePresenter = presenter;
    }

    @Override
    public void showFoundUser() {
        btnShare.setEnabled(true);
        Snackbar snackbar = Snackbar.make(findViewById(R.id.parent), "User Found", Snackbar.LENGTH_SHORT);
        snackbar.show();
    }

    @Override
    public void showRequestFailed(String message) {
        Snackbar snackbar = Snackbar.make(findViewById(R.id.parent), message, Snackbar.LENGTH_SHORT);
        snackbar.setActionTextColor(Color.RED);
        snackbar.show();
    }

    @Override
    public void showDeviceShared() {
        finish();
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

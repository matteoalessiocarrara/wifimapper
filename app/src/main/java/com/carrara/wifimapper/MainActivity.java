package com.carrara.wifimapper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


// TODO Dark theme
// TODO About
// TODO Rivedere codice
// FIXME Ridurre dimensione icone
public class MainActivity extends AppCompatActivity {

    static final int PICK_WIFI_REQUEST = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_new_scan:
                Intent i = new Intent(this, WifiNetworksActivity.class);
                startActivityForResult(i, PICK_WIFI_REQUEST);
                return true;
            case R.id.action_load_scan:
                // FIXME
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    protected void startNewScan() {
        TextView t = (TextView) findViewById(R.id.empty_main_textview);
        t.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PICK_WIFI_REQUEST) {
            if (resultCode == RESULT_OK) {
                startNewScan();
            }
        }
    }
}

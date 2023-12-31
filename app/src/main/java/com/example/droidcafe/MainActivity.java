package com.example.droidcafe;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.droidcafe.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private MenuItem item;
    private String mOrderMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        com.example.droidcafe.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        this.item = item;
        int id = item.getItemId();
        if(id == R.id.action_order){
            Intent intent = new Intent(this, OrderActivity.class);
            intent.putExtra("textData", mOrderMessage);
            startActivity(intent);
            finish();
            return true;
        } else if(id == R.id.action_status){
            displayToast(getString(R.string.action_status_message));
            return true;
        } else if (id == R.id.action_favorites) {
            displayToast(getString(R.string.action_favorites_message));
            return true;
        } else if (id == R.id.action_contact) {
            displayToast(getString(R.string.action_contact_message));
        } else if (id == R.id.action_account) {
            Intent accountIntent = new Intent(this, AccountActivity.class);
            startActivity(accountIntent);
            return true;
        } else if(id == R.id.action_alert){
            Intent alertIntent = new Intent(this, AlertActivity.class);
            startActivity(alertIntent);
            return true;
        } else if(id == R.id.action_picker) {
            Intent pickerIntent = new Intent(this, PickerActivity.class);
            startActivity(pickerIntent);
            return true;
        } else if (id == R.id.beta_test) {
            Intent betaIntent = new Intent(this, TabActivity.class);
            startActivity(betaIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void showDonutOrder(View view) {
        displayToast(getString(R.string.donut_order_message));
        mOrderMessage = getString(R.string.donut_order_message);
        Intent intent = new Intent(this, OrderActivity.class);
        intent.putExtra("textData", mOrderMessage);
        startActivity(intent);
        finish();
    }

    public void showIceCreamOrder(View view) {
        displayToast(getString(R.string.ice_cream_order_message));
        mOrderMessage = getString(R.string.ice_cream_order_message);
        Intent intent = new Intent(this, OrderActivity.class);
        intent.putExtra("textData", mOrderMessage);
        startActivity(intent);
        finish();
    }

    public void onFroyoOrder(View view) {
        displayToast(getString(R.string.froyo_order_message));
        mOrderMessage = getString(R.string.froyo_order_message);
        Intent intent = new Intent(this, OrderActivity.class);
        intent.putExtra("textData", mOrderMessage);
        startActivity(intent);
        finish();
    }

    public void onClick(View view){
        Intent intent = new Intent(MainActivity.this, OrderActivity.class);
        intent.putExtra("textData", mOrderMessage);
        startActivity(intent);
        finish();
    }
}
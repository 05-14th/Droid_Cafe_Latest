package com.example.droidcafe;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class OrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private TextView orderText;
    private EditText phoneEdit;
    private ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        onRadioButtonClick();
        Intent intent = getIntent();
        orderText = findViewById(R.id.order_text);
        orderText.setText(intent.getStringExtra("textData"));
        Spinner spinner = findViewById(R.id.label_spinner);
        if(spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.labels_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        if(spinner != null){
            spinner.setAdapter(adapter);
        }

        phoneEdit = findViewById(R.id.phone_text);
        phoneEdit.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if(i == EditorInfo.IME_ACTION_SEND || (keyEvent != null && keyEvent.getKeyCode() == keyEvent.KEYCODE_ENTER)){
                    dialPhoneNumber();
                    return true;
                }
                return false;
            }
        });
    }



    public void displayToast(String message) {
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void onRadioButtonClick() {
        RadioGroup radioGroup = findViewById(R.id.delivery_mode);
        RadioButton sameDay = findViewById(R.id.sameday);
        sameDay.setChecked(true);

        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            // Handle the RadioButton selection change here
            if (checkedId == R.id.sameday){
                displayToast(getString(R.string.same_day_messenger_service));
            } else if (checkedId == R.id.nextday){
                displayToast(getString(R.string.next_day_ground_delivery));
            } else if (checkedId == R.id.pickup) {
                displayToast(getString(R.string.pick_up));
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String spinnerLabel = adapterView.getItemAtPosition(i).toString();
        displayToast(spinnerLabel);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void dialPhoneNumber(){
        String phoneNumber = phoneEdit.getText().toString().trim();
        if (!phoneNumber.isEmpty()){
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + phoneNumber));
            if(intent.resolveActivity(getPackageManager()) != null){
                startActivity(intent);
            }
        }
    }

    public void returnHome(View view){
        Intent homeIntent = new Intent(this, MainActivity.class);
        startActivity(homeIntent);
        finish();
    }



}




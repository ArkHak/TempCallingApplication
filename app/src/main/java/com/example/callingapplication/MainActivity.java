package com.example.callingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private final static String VALUE_SEND = "VALUE_SEND";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        final EditText sendValueEditText = findViewById(R.id.valuesCalling);
        Button sendValueButton = findViewById(R.id.buttonSend);
        sendValueButton.setOnClickListener(v -> {
            Uri uri = Uri.parse("example://intent");
            Intent runEchoIntent = new Intent(Intent.ACTION_VIEW, uri);
            runEchoIntent.putExtra(VALUE_SEND, sendValueEditText.getText().toString());
            ActivityInfo activityInfo =
                    runEchoIntent.resolveActivityInfo(getPackageManager(),
                            runEchoIntent.getFlags());
            if (activityInfo != null) {
                startActivity(runEchoIntent);
            }
        });
    }
}
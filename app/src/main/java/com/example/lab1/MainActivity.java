package com.example.lab1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.List;

public class MainActivity extends Activity {

    List<String> availableColors = List.of("red", "green", "blue");

    @Override
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.main_activity);
    }

    public void changeBackground(View view) {
        EditText colourInputField = findViewById(R.id.user_field);
        String inputColor = colourInputField.getText().toString().toLowerCase();
        TextView errorMessage = findViewById(R.id.error_message);

        if (!availableColors.contains(inputColor)) {
            errorMessage.setVisibility(View.VISIBLE);
            return;
        }
        errorMessage.setVisibility(View.INVISIBLE);
        Intent intent = new Intent(this, BackgroundActivity.class);
        intent.putExtra("color", inputColor);
        startActivity(intent);
    }
}
package com.example. womensafety;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Feedback extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextMessage;
    private Button buttonSubmit;
    private TextView textViewReview;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        editTextName = findViewById(R.id.Name);
        editTextMessage = findViewById(R.id.Message);
        buttonSubmit = findViewById(R.id.Submit);
        textViewReview = findViewById(R.id.Review);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitReview();
            }
        });
    }

    private void submitReview() {
        String name = editTextName.getText().toString().trim();
        String message = editTextMessage.getText().toString().trim();

        if (TextUtils.isEmpty(name)) {
            editTextName.setError("Name is required");
            return;
        }

        if (TextUtils.isEmpty(message)) {
            editTextMessage.setError("Review message is required");
            return;
        }

        // Display the review message
        String review = "Review by " + name + ":\n" + message;
        textViewReview.setText(review);

        // Clear the input fields
        editTextName.setText("");
        editTextMessage.setText("");

        // Optionally, show a toast message
        Toast.makeText(Feedback.this, "Thank you for your review!", Toast.LENGTH_LONG).show();
    }
}

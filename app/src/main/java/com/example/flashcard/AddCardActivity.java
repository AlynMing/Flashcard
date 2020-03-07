package com.example.flashcard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

                // get current question and answer to edit
        String question = getIntent().getStringExtra("question");
        String answer = getIntent().getStringExtra("answer");
        ((TextView)findViewById(R.id.questionTextField)).setText(question);
        ((TextView)findViewById(R.id.answerTextField)).setText(answer);


        findViewById(R.id.cancelButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        findViewById(R.id.saveButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String question = ((EditText) findViewById(R.id.questionTextField)).getText().toString();
                String answer = ((EditText) findViewById(R.id.answerTextField)).getText().toString();

                // if either text fields are empty, display toast message
                if (question.isEmpty() || answer.isEmpty())
                {
                    Toast toast = Toast.makeText(getApplicationContext(), "Must enter both Question and Answer!", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.BOTTOM|Gravity.CENTER, 0,300);
                    toast.show();
                }


                if(!question.isEmpty() && !answer.isEmpty())
                {
                    Intent data = new Intent(); // create a new Intent, where we will put our data
                    data.putExtra("question", question);
                    data.putExtra("answer", answer);
                    setResult(RESULT_OK, data); // set result code and bundle data for response
                    finish(); // close this activity and pass data to original activity that launched this activity
                }


            }
        });

    }

}

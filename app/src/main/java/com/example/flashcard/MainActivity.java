package com.example.flashcard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.flaschard_question).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                findViewById(R.id.flaschard_answer).setVisibility(View.VISIBLE);
                findViewById(R.id.flaschard_question).setVisibility(View.INVISIBLE);
            }
        });

        findViewById(R.id.flaschard_answer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                findViewById(R.id.flaschard_answer).setVisibility(View.INVISIBLE);
                findViewById(R.id.flaschard_question).setVisibility(View.VISIBLE);
            }
        });

        findViewById(R.id.plusButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddCardActivity.class);
                MainActivity.this.startActivityForResult(intent, 100);
            }
        });

        findViewById(R.id.editButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddCardActivity.class);
                intent.putExtra("question", ((TextView)findViewById(R.id.flaschard_question)).getText().toString());
                intent.putExtra("answer", ((TextView)findViewById(R.id.flaschard_answer)).getText().toString());
                MainActivity.this.startActivityForResult(intent, 100);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 100 && resultCode == RESULT_OK) { // this 100 needs to match the 100 we used when we called startActivityForResult
            String question = data.getExtras().getString("question"); // 'question' matches key used when string put in intent
            String answer = data.getExtras().getString("answer");

            // set the text for the flashcard question and answer
            ((TextView) findViewById(R.id.flaschard_question)).setText(question);
            ((TextView) findViewById(R.id.flaschard_answer)).setText(answer);


            // display snackbar message
            Snackbar.make(findViewById(R.id.flaschard_question), "Card successfully created!", Snackbar.LENGTH_SHORT).show();

        }

    }
}

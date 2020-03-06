package com.akiria.flash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

//        findViewById(R.id.flashcard_question).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                findViewById(R.id.flashcard_answer).setVisibility(View.VISIBLE);
//                findViewById(R.id.flashcard_question).setVisibility(View.INVISIBLE);
//            }
//        });
        findViewById(R.id.flashcard_answer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.flashcard_answer).setBackgroundResource(R.drawable.correct_backg);
            }
        });
        findViewById(R.id.wrong_answer1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.wrong_answer1).setBackgroundResource(R.drawable.wrong_backg);
                findViewById(R.id.flashcard_answer).setBackgroundResource(R.drawable.correct_backg);

            }
        });
        findViewById(R.id.wrong_answer2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.wrong_answer2).setBackgroundResource(R.drawable.wrong_backg);
                findViewById(R.id.flashcard_answer).setBackgroundResource(R.drawable.correct_backg);

            }
        });

        findViewById(R.id.rootView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // reset text color back to pink
                findViewById(R.id.wrong_answer1).setBackgroundResource(R.drawable.answer_grad);
                findViewById(R.id.wrong_answer2).setBackgroundResource(R.drawable.answer_grad);
                findViewById(R.id.flashcard_answer).setBackgroundResource(R.drawable.answer_grad);

            }
        });

        findViewById(R.id.myBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddCardActivity.class);
                startActivityForResult(intent, 100);
                //startActivity(intent);

            }
        });


    }
//    onActivityResult();
    //super.onActivityResult(requestCode, resultCode, data);
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 100 && resultCode == RESULT_OK) { // this 100 needs to match the 100 we used when we called startActivityForResult!
            String editQuestion = data.getExtras().getString("editQuestion"); //  needs to match the key we used when we put the string in the Intent
            String editAnswer = data.getExtras().getString("editAnswer");
            String editWrongAnswer1 = data.getExtras().getString("editWrongAnswer1");
            String editWrongAnswer2 = data.getExtras().getString("editWrongAnswer2");
            //Toast.makeText(this, name, Toast.LENGTH_SHORT).show()
            ((TextView) findViewById(R.id.flashcard_question)).setText(editQuestion);
            ((TextView) findViewById(R.id.flashcard_answer)).setText(editAnswer);
            ((TextView) findViewById(R.id.wrong_answer1)).setText(editWrongAnswer1);
            ((TextView) findViewById(R.id.wrong_answer2)).setText(editWrongAnswer2);
        }
    }

}

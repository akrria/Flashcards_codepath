package com.akiria.flash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        //dismiss
        findViewById(R.id.exitbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Intent(AddCardActivity.this, MainActivity.class);
                finish();
            }
        });
        //save
        findViewById(R.id.savebtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Intent(AddCardActivity.this, MainActivity.class);

                EditText editQuestion = findViewById(R.id.editQuestion);
                EditText editAnswer = findViewById(R.id.editAnswer);
                EditText editWrongAnswer1 = findViewById(R.id.editWrongAnswer1);
                EditText editWrongAnswer2 = findViewById(R.id.editWrongAnswer2);

                Intent data = new Intent(); // create a new Intent, this is where we will put our data
                data.putExtra("editQuestion", editQuestion.getText().toString()); // puts one string into the Intent, with the key as 'string1'
                data.putExtra("editAnswer", editAnswer.getText().toString()); // puts another string into the Intent, with the key as 'string2
                data.putExtra("editWrongAnswer1", editWrongAnswer1.getText().toString());
                data.putExtra("editWrongAnswer2", editWrongAnswer2.getText().toString());
                setResult(RESULT_OK, data); // set result code and bundle data for response

                finish();

            }
        });
    }

}

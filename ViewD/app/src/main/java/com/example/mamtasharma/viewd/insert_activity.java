package com.example.mamtasharma.viewd;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class insert_activity extends AppCompatActivity {

    EditText et_roll,et_name,et_sem;
    Button bt;
    String roll,name,sem;

    Context context=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_activity);

        et_roll=(EditText)findViewById(R.id.editText5);
        et_name=(EditText)findViewById(R.id.editText6);
        et_sem=(EditText)findViewById(R.id.editText7);
        bt=(Button) findViewById(R.id.button9);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                roll= et_roll.getText().toString();
                name= et_name.getText().toString();
                sem= et_sem.getText().toString();

                et_roll.setText("");
                et_sem.setText("");
                et_name.setText("");

                DBHelper dbHelper=new DBHelper(context);
                dbHelper.putInfo(dbHelper,roll,name,sem);
                Toast.makeText(getBaseContext(),"data vales saved in DB",Toast.LENGTH_SHORT).show();
                finish();
            }
        });


        }

    }

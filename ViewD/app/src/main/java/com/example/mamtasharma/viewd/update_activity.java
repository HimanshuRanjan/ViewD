package com.example.mamtasharma.viewd;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class update_activity extends AppCompatActivity {

    Button btn;
    TextView et_roll,et_name,et_sem;
    String str;
    String rollS,nameS,semS;
    Context context=this;
    ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_activity);

        et_roll=(EditText)findViewById(R.id.editText8);
        et_name=(EditText)findViewById(R.id.editText9);
        et_sem=(EditText)findViewById(R.id.editText10);
        btn=(Button) findViewById(R.id.button10);
        toggleButton=(ToggleButton) findViewById(R.id.toggleButton);

        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollS=et_roll.getText().toString();
                DBHelper dbHelper=new DBHelper(context);

                Cursor cursor= dbHelper.getInfo(dbHelper,rollS);
                cursor.moveToFirst();
                //et_roll.setText(""+cursor.getInt(cursor.getColumnIndex("roll_no")));
                et_name.setText(cursor.getString(cursor.getColumnIndex("name")));
                et_sem.setText(""+cursor.getInt(cursor.getColumnIndex("sem")));


            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                DBHelper dbHelper=new DBHelper(context);
                nameS=et_name.getText().toString();
                semS=et_sem.getText().toString();


                et_roll.setText("");
                et_sem.setText("");
                et_name.setText("");

                dbHelper.update1(dbHelper ,rollS,nameS,semS);
                Toast.makeText(getApplicationContext(),"Data Of Student Updated!",Toast.LENGTH_SHORT).show();
                finish();



            }
        });
    }
}

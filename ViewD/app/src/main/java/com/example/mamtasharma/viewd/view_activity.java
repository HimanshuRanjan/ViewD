package com.example.mamtasharma.viewd;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class view_activity extends AppCompatActivity {
    EditText getroll;
    Button retr;
    TextView et_roll,et_name,et_sem;
    String str;
    String roll,name,sem;
    Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_activity);


        getroll=(EditText)findViewById(R.id.editText12);
        retr=(Button)findViewById(R.id.button13);
        et_roll=(TextView)findViewById(R.id.textView22);
        et_name=(TextView)findViewById(R.id.textView23);
        et_sem=(TextView)findViewById(R.id.textView26);

        retr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                str=getroll.getText().toString();
                getroll.setText("");
                DBHelper dbHelper=new DBHelper(context);

                Cursor cursor= dbHelper.getInfo(dbHelper,str);
                cursor.moveToFirst();
                //finish();
               et_roll.setText(""+cursor.getInt(cursor.getColumnIndex("roll_no")));
                et_name.setText(cursor.getString(cursor.getColumnIndex("name")));
                et_sem.setText(""+cursor.getInt(cursor.getColumnIndex("sem")));


            }
        });


    }
}

package com.example.mamtasharma.viewd;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class delete_activity extends AppCompatActivity {

    Button btn;
    EditText editText;
    String str;
    Context context=this;
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_activity);

        btn=(Button)findViewById(R.id.button11);
        editText=(EditText)findViewById(R.id.editText11);

           btn.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {

                   str=editText.getText().toString();
                   if (str!=null)
                       Toast.makeText(getApplicationContext(),"Data Of Student Deleted!",Toast.LENGTH_SHORT).show();

                   editText.setText("");

                   DBHelper dbHelper=new DBHelper(context);
                   dbHelper.delete1(dbHelper,str);
                   finish();


               }
           });


    }
}

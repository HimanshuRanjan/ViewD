package com.example.mamtasharma.viewd;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editname;
    EditText editpass;

    TextView txtv7;

    Button log;
    Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editname=(EditText)findViewById(R.id.namebox);
        editpass=(EditText)findViewById(R.id.passbox);
        txtv7= (TextView)findViewById(R.id.textView7);

        log =(Button)findViewById(R.id.logbutton);
        save =(Button)findViewById(R.id.button5);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editname .getText().toString();
                String pass = editpass.getText().toString();

                SharedPreferences Name_of_Student= getSharedPreferences("PREFS1",MODE_PRIVATE);
                SharedPreferences Password_of_Student= getSharedPreferences("PREFS2",MODE_PRIVATE);

                SharedPreferences.Editor editor= Name_of_Student.edit();
                editor.putString("myname", name);
                editor.commit();

                SharedPreferences.Editor editor1= Password_of_Student.edit();
                editor.putString("mypass", pass);
                editor.commit();
                Toast.makeText(getApplicationContext(),"Values Saved!",Toast.LENGTH_LONG).show();

            }
        });
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(intent);

            }
        });


    }
}

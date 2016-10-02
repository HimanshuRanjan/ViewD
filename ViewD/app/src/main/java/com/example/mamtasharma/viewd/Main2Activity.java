package com.example.mamtasharma.viewd;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2Activity extends AppCompatActivity {

    EditText editText;
    EditText editText1;
    TextView textView;
    TextView textView1;
    Button saveEx;
    Button getEx;
    Button saveI,getI;
    Button dbb;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        editText=(EditText)findViewById(R.id.editText);
        editText1=(EditText)findViewById(R.id.editText13);
        textView=(TextView)findViewById(R.id.textView6);
        textView1=(TextView)findViewById(R.id.textView21);
        textView.setVisibility(View.GONE);
        textView1.setVisibility(View.GONE);

        TextView txtv= (TextView)findViewById(R.id.textView3);

        SharedPreferences Name_of_Student= getSharedPreferences("PREFS1",MODE_PRIVATE);

        String name= Name_of_Student.getString("myname", "Nothing found!");
        txtv.setText("Welcome "+name);

        saveEx=(Button)findViewById(R.id.button);
        getEx=(Button)findViewById(R.id.button4);

        saveI=(Button)findViewById(R.id.button2);
        getI=(Button)findViewById(R.id.button3);

        dbb=(Button)findViewById(R.id.dbButton);
        dbb.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Main3Activity.class);
                startActivity(intent);
                //Toast.makeText(getApplicationContext(),"Message Saved!",Toast.LENGTH_SHORT).show();
            }
        });

        saveI.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                    saveMessage();
                //Toast.makeText(getApplicationContext(),"Message Saved!",Toast.LENGTH_SHORT).show();
            }
        });

        getI.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                getMessage();
                //Toast.makeText(getApplicationContext(),"Message Saved!",Toast.LENGTH_SHORT).show();
            }
        });

        saveEx.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                saveMessageEx();
                textView.setText("");
                //Toast.makeText(getApplicationContext(),"Message Saved!",Toast.LENGTH_SHORT).show();
            }
        });

        getEx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //textView1.setText("");
                getMessageEx();
                //String s=editText1.toString();
                //Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
                //textView1.setText(s);
                //textView1.setVisibility(View.VISIBLE);
            }
        });
    }
    public void saveMessage()
    {    textView.setText("");
        String msg=editText.getText().toString();
        String file_name="Internal_File";
        try {
            FileOutputStream fileOutputStream= openFileOutput(file_name,MODE_PRIVATE);   //so thet no other application can access this file
            fileOutputStream.write(msg.getBytes());
            fileOutputStream.close();
            Toast.makeText(getApplicationContext(),"Message saved in file !",Toast.LENGTH_SHORT).show();
            editText.setText("");// clear the text area after saving message

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getMessage()
    {
        try {
            String msg;
            FileInputStream fileInputStream= openFileInput("Internal_File");
            InputStreamReader inputStreamReader= new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader= new BufferedReader(inputStreamReader);

            StringBuffer stringBuffer=new StringBuffer();
            while((msg=bufferedReader.readLine())!= null)
            {
                stringBuffer.append(msg+"\n");
            }
                textView.setText(stringBuffer.toString());
                textView.setVisibility(View.VISIBLE);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void saveMessageEx()
    {    textView1.setText("");
        String state;
        state= Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(state))
        {
            File root=Environment.getExternalStorageDirectory();
            if(!root.exists())
            {
                root.mkdir();
               // Toast.makeText(getApplicationContext(),"hi",Toast.LENGTH_SHORT).show();
            }
            File txtFile= new File(root,"MyText1.txt");
           // Toast.makeText(getApplicationContext(),"h1",Toast.LENGTH_SHORT).show();
            String msg=editText1.getText().toString();


            try {
                FileOutputStream fileOutputStream= new FileOutputStream(txtFile);
                fileOutputStream.write(msg.getBytes());
                fileOutputStream.close();
                editText1.setText("");
                //Toast.makeText(getApplicationContext(),"hi2",Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(),"Message Saved Externally!",Toast.LENGTH_LONG).show();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_SHORT).show();
            } catch (IOException e)
            {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_SHORT).show();
            }

        }
        else
        {
            Toast.makeText(getApplicationContext(),"SD Card Not Found!",Toast.LENGTH_LONG).show();
        }


    }

    public void getMessageEx()
    {
        File root=Environment.getExternalStorageDirectory();
        File txtfile=new File(root.getAbsolutePath()+"MyText1.txt");

        String msg;

        try {
            FileInputStream fileInputStream= new FileInputStream(txtfile);
            InputStreamReader inputStreamReader= new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader= new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer=new StringBuffer();

            while((msg=bufferedReader.readLine())!= null)
            {
                stringBuffer.append(msg+"\n");
            }
            textView1.setVisibility(View.VISIBLE);

        } catch (FileNotFoundException e) {
            Toast.makeText(getApplicationContext(),"File not found!",Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(),"error11",Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }


    }
}

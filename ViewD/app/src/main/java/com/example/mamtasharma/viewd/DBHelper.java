package com.example.mamtasharma.viewd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import static com.example.mamtasharma.viewd.Student_Info.*;

/**
 * Created by Mamta Sharma on 10/1/2016.
 */

class DBHelper extends SQLiteOpenHelper
{
    public static final int DB_Version=1;
    public String CREATE_Query="create table "+ ColoumnTable.Table_Name+"("+ ColoumnTable.Roll_No+" int, "+ ColoumnTable.Name+" TEXT, "+ ColoumnTable.Sem+" int);";
    public DBHelper(Context context) {
        super(context, ColoumnTable.Data_Base, null, DB_Version);
        Log.d("operations of DB","DB created!");
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_Query);
        Log.d("operations of DB","Table created!");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void putInfo(DBHelper dbHelper, String roll, String name, String sem)
    {
        SQLiteDatabase SQ=dbHelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(ColoumnTable.Roll_No,roll);
        contentValues.put(ColoumnTable.Name,name);
        contentValues.put(ColoumnTable.Sem,sem);

        SQ.insert(ColoumnTable.Table_Name,null,  contentValues);
        Log.d("operations of DB","Table data one row entered!");
        //SQ.close();

    }
    public Cursor getInfo(DBHelper dbHelper, String str)
    {
        SQLiteDatabase SQ=dbHelper.getReadableDatabase();

        Cursor cr=SQ.rawQuery("Select * FROM "+ColoumnTable.Table_Name+" Where roll_no= " +str+";",null);
        //SQ.close();
        return cr;
    }
    public void delete1(DBHelper dbHelper,String str)
    {
        SQLiteDatabase SQ=dbHelper.getWritableDatabase();
        SQ.delete(ColoumnTable.Table_Name,ColoumnTable.Roll_No + "=" +str,null);
        //SQ.execSQL(" delete from " +ColoumnTable.Table_Name+" Where roll_no= " +str+";",null);
        //SQ.close();

    }

    public void update1(DBHelper dbHelper,String roll,String name, String sem)
    {
        SQLiteDatabase SQ=dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("roll_no",roll);
        cv.put("name",name);
        cv.put("sem",sem);
        SQ.update(ColoumnTable.Table_Name, cv, "roll_no= "+roll, null);
        //SQ.close();
    }
}

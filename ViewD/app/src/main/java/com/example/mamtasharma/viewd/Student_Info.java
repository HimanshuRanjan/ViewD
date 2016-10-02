package com.example.mamtasharma.viewd;

import android.provider.BaseColumns;

/**
 * Created by Mamta Sharma on 10/1/2016.
 */

public class Student_Info
{
    public Student_Info()
    {

    }

    public static abstract class ColoumnTable implements BaseColumns
    {
        public static final String Roll_No ="roll_no";
        public static final String Name ="name";
        public static final String Sem ="sem";
        public static final String Data_Base="Student";
        public static final String Table_Name="Student_Data";


    }

}

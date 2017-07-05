package com.nsu.advising.QuickAdvising;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.nsu.advising.advising.R;


public class SecondSemester extends AppCompatActivity {

    ListView listView;
    DatabasedHelper mydb;
    Cursor cursor;
    ListDataAdapterSecond listDataAdpter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_semester);

        Button btnadd = (Button) findViewById(R.id.buttonADD);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(SecondSemester.this,AddResultSecond.class);
                i.putExtra("called", "add");
                startActivity(i);
                finish();
            }
        });


        Button clearall = (Button) findViewById(R.id.ClearAllData);
        clearall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder adb = new AlertDialog.Builder(SecondSemester.this);
                adb.setTitle("Clear All?");
                adb.setMessage("Are you sure you want to Clear All Data?");
                adb.setNegativeButton("Cancel",null);
                adb.setPositiveButton("Ok", new AlertDialog.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        int del=mydb.delAllSecond();
                        if(del>0)
                        {
                            Toast.makeText(getApplicationContext(),"Semester 2: All Data Deleted",Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(SecondSemester.this,SecondSemester.class);
                            startActivity(i);
                            finish();
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"Nothing To Delete",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                AlertDialog alertDialog = adb.create();
                alertDialog.show();
            }
        });


        listView = (ListView) findViewById(R.id.listView);
        mydb=new DatabasedHelper(this);
        cursor= mydb.getInfoFromSecondSemester();
        listDataAdpter= new ListDataAdapterSecond(SecondSemester.this, R.layout.contactlistview);
        listView.setAdapter(listDataAdpter);

        double AddCredit=0.0;
        double gpa;
        double a,b;
        double res=0;

        String s1=null;
        String s2=null;

        if (cursor.moveToFirst())
        {
            do {
                String classname,time,room,Lettergrade,totalcredit,totalcrgpa;

                classname=cursor.getString(cursor.getColumnIndex(TableInfo.Newinfo.Usub));
                time = cursor.getString(cursor.getColumnIndex(TableInfo.Newinfo.Ugradepoint));
                room = cursor.getString(cursor.getColumnIndex(TableInfo.Newinfo.Ucredit));
                totalcredit = cursor.getString(cursor.getColumnIndex(TableInfo.Newinfo.Utotal_credit));
                totalcrgpa = cursor.getString((cursor.getColumnIndex(TableInfo.Newinfo.Utotal_crgp)));
                Lettergrade = cursor.getString((cursor.getColumnIndex(TableInfo.Newinfo.Uletter)));

                // Semester Total Credit Store
                AddCredit+=Double.parseDouble(totalcredit);

                //Semester Total Credit * gpa
                a=Double.parseDouble(time);//Gradepoint
                b=Double.parseDouble(room);//Credithour
                res+=(a*b);
                totalcrgpa = String.format("%.2f",res);

                //Semester Final GPA
                gpa=(res/AddCredit);

                ContactInfo contactInfo =new ContactInfo(classname,time,room,Lettergrade,totalcredit,totalcrgpa);
                listDataAdpter.add(contactInfo);

                // Semester Total Credit show
                String test = String.format("%.2f",AddCredit);
                String test2 = String.format("%.2f",gpa);


                TextView textViewcredit = (TextView) findViewById(R.id.tvCreditFirstSem);
                TextView textViewgpa = (TextView) findViewById(R.id.tvGpaFirstSem);
                //textViewcredit.setTextColor(Color.parseColor("#2C3E50"));
                textViewcredit.setText(test);
                textViewgpa.setText(test2);
            }
            while (cursor.moveToNext());
            {

            }
        }
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(SecondSemester.this,CgpaActivity.class);
        startActivity(i);
        finish();
    }



}

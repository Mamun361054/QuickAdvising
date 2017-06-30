package com.nsu.dorbesh.QuickAdvising;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.nsu.dorbesh.webview.R;

public class CgpaActivity extends AppCompatActivity {

    DatabasedHelper mydb;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cgpa);

        Button help = (Button) findViewById(R.id.help);

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Dialog dialog = new Dialog(CgpaActivity.this);
                dialog.setTitle("Grading Sytem");
                dialog.setContentView(R.layout.custom_gradingsystem_layout);
                dialog.show();

            }
        });

        mydb = new DatabasedHelper(this);
        fetch();

    }


    public void first(View v)
    {
        //TextView title= (TextView) findViewById(R.id.textView2);

        Intent i=new Intent(CgpaActivity.this,FirstSemester.class);
        startActivity(i);
        finish();
    }

    public void second(View v)
    {
        //TextView title= (TextView) findViewById(R.id.textView2);

        Intent i=new Intent(CgpaActivity.this,SecondSemester.class);
        startActivity(i);
        finish();
    }


    public void third(View v)
    {
        //TextView title= (TextView) findViewById(R.id.textView2);

        Intent i=new Intent(CgpaActivity.this,ThirdSemester.class);
        startActivity(i);
        finish();
    }

    public void fourth(View v)
    {
        //TextView title= (TextView) findViewById(R.id.textView2);

        Intent i=new Intent(CgpaActivity.this,FourthSemester.class);
        startActivity(i);
        finish();
    }


    public void fifth(View v)
    {
        //TextView title= (TextView) findViewById(R.id.textView2);

        Intent i=new Intent(CgpaActivity.this,FifthSemester.class);
        startActivity(i);
        finish();
    }

    public void sixth(View v)
    {
        //TextView title= (TextView) findViewById(R.id.textView2);

        Intent i=new Intent(CgpaActivity.this,SixthSemester.class);
        startActivity(i);
        finish();
    }


    public void seventh(View v)
    {
        //TextView title= (TextView) findViewById(R.id.textView2);

        Intent i=new Intent(CgpaActivity.this,SeventhSemester.class);
        startActivity(i);
        finish();
    }

    public void eighth(View v)
    {
        //TextView title= (TextView) findViewById(R.id.textView2);

        Intent i=new Intent(CgpaActivity.this,EighthSemester.class);
        startActivity(i);
        finish();
    }


    public void nineth(View v)
    {
        //TextView title= (TextView) findViewById(R.id.textView2);

        Intent i=new Intent(CgpaActivity.this,NinethSemester.class);
        startActivity(i);
        finish();
    }

    public void tenth(View v)
    {
        //TextView title= (TextView) findViewById(R.id.textView2);

        Intent i=new Intent(CgpaActivity.this,TenthSemester.class);
        startActivity(i);
        finish();
    }


    public void eleventh(View v)
    {
        //TextView title= (TextView) findViewById(R.id.textView2);

        Intent i=new Intent(CgpaActivity.this,EleventhSemester.class);
        startActivity(i);
        finish();
    }

    public void twelveth(View v)
    {
        //TextView title= (TextView) findViewById(R.id.textView2);

        Intent i=new Intent(CgpaActivity.this,TwelvethSemester.class);
        startActivity(i);
        finish();
    }


    public void delall(View v)
    {

        AlertDialog.Builder adb = new AlertDialog.Builder(CgpaActivity.this);
        adb.setTitle("Caution!");
        adb.setMessage("Are you sure you want to Perform Master Reset?");
        adb.setNegativeButton("Cancel",null);
        adb.setPositiveButton("Ok", new AlertDialog.OnClickListener()
        {

            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                // TODO SET TEXTVIEWS To NULL
                TextView textViewcgpa = (TextView) findViewById(R.id.tvFinalCPA);
                TextView textViewfinalcredit = (TextView) findViewById(R.id.tvfinalCredit);
                textViewcgpa.setText("0.0");
                textViewfinalcredit.setText("0.0");

                CgpaActivity.this.deleteDatabase("kita_kobor");
                Toast.makeText(getApplicationContext(),"Master Cleared",Toast.LENGTH_SHORT).show();
                //recreate();
            }
        });

        AlertDialog alertDialog = adb.create();
        alertDialog.show();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            return true;
        }*/

        if(id==R.id.action_settings)
        {
            Intent i = new Intent(this,dev.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }


    public void fetch()
    {
        double AddCredit=0.0;
        double totalcrgp=0.0;
        double cgpa;
        for(int i=1;i<=12;i++)
        {
            if(i==1)
            {
                cursor = mydb.getInfoFromFirstSemester();
                if(cursor.moveToFirst())
                {
                    do
                    {
                        String totalcredit = cursor.getString(cursor.getColumnIndex(TableInfo.Newinfo.Utotal_credit));
                        String totalcrgpa = cursor.getString(cursor.getColumnIndex(TableInfo.Newinfo.Utotal_crgp));

                        // Semester Total Credit Store
                        AddCredit+=Double.parseDouble(totalcredit);
                        totalcrgp+=Double.parseDouble(totalcrgpa);

                    }
                    while (cursor.moveToNext());
                    {

                    }
                }
            }
            else if(i==2)
            {
                cursor = mydb.getInfoFromSecondSemester();
                if(cursor.moveToFirst())
                {
                    do
                    {
                        String totalcredit = cursor.getString(cursor.getColumnIndex(TableInfo.Newinfo.Utotal_credit));
                        String totalcrgpa = cursor.getString(cursor.getColumnIndex(TableInfo.Newinfo.Utotal_crgp));

                        // Semester Total Credit Store
                        AddCredit+=Double.parseDouble(totalcredit);
                        totalcrgp+=Double.parseDouble(totalcrgpa);

                    }
                    while (cursor.moveToNext());
                    {

                    }
                }
            }
            else if(i==3)
            {
                cursor = mydb.getInfoFromThirdSemester();
                if(cursor.moveToFirst())
                {
                    do
                    {
                        String totalcredit = cursor.getString(cursor.getColumnIndex(TableInfo.Newinfo.Utotal_credit));
                        String totalcrgpa = cursor.getString(cursor.getColumnIndex(TableInfo.Newinfo.Utotal_crgp));

                        // Semester Total Credit Store
                        AddCredit+=Double.parseDouble(totalcredit);
                        totalcrgp+=Double.parseDouble(totalcrgpa);

                    }
                    while (cursor.moveToNext());
                    {

                    }
                }
            }
            else if(i==4)
            {
                cursor = mydb.getInfoFromFourthSemester();
                if(cursor.moveToFirst())
                {
                    do
                    {
                        String totalcredit = cursor.getString(cursor.getColumnIndex(TableInfo.Newinfo.Utotal_credit));
                        String totalcrgpa = cursor.getString(cursor.getColumnIndex(TableInfo.Newinfo.Utotal_crgp));

                        // Semester Total Credit Store
                        AddCredit+=Double.parseDouble(totalcredit);
                        totalcrgp+=Double.parseDouble(totalcrgpa);

                    }
                    while (cursor.moveToNext());
                    {

                    }
                }
            }
            else if(i==5)
            {
                cursor = mydb.getInfoFromFifthSemester();
                if(cursor.moveToFirst())
                {
                    do
                    {
                        String totalcredit = cursor.getString(cursor.getColumnIndex(TableInfo.Newinfo.Utotal_credit));
                        String totalcrgpa = cursor.getString(cursor.getColumnIndex(TableInfo.Newinfo.Utotal_crgp));

                        // Semester Total Credit Store
                        AddCredit+=Double.parseDouble(totalcredit);
                        totalcrgp+=Double.parseDouble(totalcrgpa);
                    }
                    while (cursor.moveToNext());
                    {

                    }
                }
            }
            else if(i==6)
            {
                cursor = mydb.getInfoFromSixthSemester();
                if(cursor.moveToFirst())
                {
                    do
                    {
                        String totalcredit = cursor.getString(cursor.getColumnIndex(TableInfo.Newinfo.Utotal_credit));
                        String totalcrgpa = cursor.getString(cursor.getColumnIndex(TableInfo.Newinfo.Utotal_crgp));

                        // Semester Total Credit Store
                        AddCredit+=Double.parseDouble(totalcredit);
                        totalcrgp+=Double.parseDouble(totalcrgpa);

                    }
                    while (cursor.moveToNext());
                    {

                    }
                }
            }
            else if(i==7)
            {
                cursor = mydb.getInfoFromSevenSemester();
                if(cursor.moveToFirst())
                {
                    do
                    {
                        String totalcredit = cursor.getString(cursor.getColumnIndex(TableInfo.Newinfo.Utotal_credit));
                        String totalcrgpa = cursor.getString(cursor.getColumnIndex(TableInfo.Newinfo.Utotal_crgp));

                        // Semester Total Credit Store
                        AddCredit+=Double.parseDouble(totalcredit);
                        totalcrgp+=Double.parseDouble(totalcrgpa);;

                    }
                    while (cursor.moveToNext());
                    {

                    }
                }
            }
            else if(i==8)
            {
                cursor = mydb.getInfoFromEighthSemester();
                if(cursor.moveToFirst())
                {
                    do
                    {
                        String totalcredit = cursor.getString(cursor.getColumnIndex(TableInfo.Newinfo.Utotal_credit));
                        String totalcrgpa = cursor.getString(cursor.getColumnIndex(TableInfo.Newinfo.Utotal_crgp));

                        // Semester Total Credit Store
                        AddCredit+=Double.parseDouble(totalcredit);
                        totalcrgp+=Double.parseDouble(totalcrgpa);
                    }
                    while (cursor.moveToNext());
                    {

                    }
                }
            }
            else if(i==9)
            {
                cursor = mydb.getInfoFromNinethSemester();
                if(cursor.moveToFirst())
                {
                    do
                    {
                        String totalcredit = cursor.getString(cursor.getColumnIndex(TableInfo.Newinfo.Utotal_credit));
                        String totalcrgpa = cursor.getString(cursor.getColumnIndex(TableInfo.Newinfo.Utotal_crgp));

                        // Semester Total Credit Store
                        AddCredit+=Double.parseDouble(totalcredit);
                        totalcrgp+=Double.parseDouble(totalcrgpa);

                    }
                    while (cursor.moveToNext());
                    {

                    }
                }
            }
            else if(i==10)
            {
                cursor = mydb.getInfoFromTenthSemester();
                if(cursor.moveToFirst())
                {
                    do
                    {
                        String totalcredit = cursor.getString(cursor.getColumnIndex(TableInfo.Newinfo.Utotal_credit));
                        String totalcrgpa = cursor.getString(cursor.getColumnIndex(TableInfo.Newinfo.Utotal_crgp));

                        // Semester Total Credit Store
                        AddCredit+=Double.parseDouble(totalcredit);
                        totalcrgp+=Double.parseDouble(totalcrgpa);

                    }
                    while (cursor.moveToNext());
                    {

                    }
                }
            }
            else if(i==11)
            {
                cursor = mydb.getInfoFromEleventhSemester();
                if(cursor.moveToFirst())
                {
                    do
                    {
                        String totalcredit = cursor.getString(cursor.getColumnIndex(TableInfo.Newinfo.Utotal_credit));
                        String totalcrgpa = cursor.getString(cursor.getColumnIndex(TableInfo.Newinfo.Utotal_crgp));

                        // Semester Total Credit Store
                        AddCredit+=Double.parseDouble(totalcredit);
                        totalcrgp+=Double.parseDouble(totalcrgpa);

                    }
                    while (cursor.moveToNext());
                    {

                    }
                }
            }
            else if(i==12)
            {
                cursor = mydb.getInfoFromTwelvethSemester();
                if(cursor.moveToFirst())
                {
                    do
                    {
                        String totalcredit = cursor.getString(cursor.getColumnIndex(TableInfo.Newinfo.Utotal_credit));
                        String totalcrgpa = cursor.getString(cursor.getColumnIndex(TableInfo.Newinfo.Utotal_crgp));

                        // Semester Total Credit Store
                        AddCredit+=Double.parseDouble(totalcredit);
                        totalcrgp+=Double.parseDouble(totalcrgpa);

                    }
                    while (cursor.moveToNext());
                    {

                    }
                }
            }
        }

        TextView textViewcgpa = (TextView) findViewById(R.id.tvFinalCPA);
        TextView textViewfinalcredit = (TextView) findViewById(R.id.tvfinalCredit);

        cgpa = (totalcrgp/AddCredit);

        String finalallcredit = String.format("%.2f",AddCredit);
        String finalallcrgp = String.format("%.2f",cgpa);

        if(AddCredit>0.0)
        {
            textViewfinalcredit.setText(finalallcredit);
            textViewcgpa.setText(finalallcrgp);
        }
        else
        {
            textViewfinalcredit.setText("0.0");
            textViewcgpa.setText("0.0");
        }
    }


}

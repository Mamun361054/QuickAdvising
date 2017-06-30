package com.nsu.dorbesh.QuickAdvising;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nsu.dorbesh.webview.R;


public class AddResultFifth extends AppCompatActivity {

    AutoCompleteTextView gpa;
    String[] gradepoint;
    AutoCompleteTextView credit;
    String[] credithour;
    AutoCompleteTextView sub;
    String[] subject;
    EditText etSub, etgpa, etcredit;
    Button add, update;
    DatabasedHelper mydb;
    String class_name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_result_fifth);


        gpa = (AutoCompleteTextView) findViewById(R.id.editTxtGPA);
        gradepoint = getResources().getStringArray(R.array.GPA);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, gradepoint);
        gpa.setAdapter(adapter1);
        gpa.setThreshold(1);


        credit = (AutoCompleteTextView) findViewById(R.id.editTxtCredit);
        credithour = getResources().getStringArray(R.array.Credit);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, credithour);
        credit.setAdapter(adapter2);
        credit.setThreshold(1);

        sub = (AutoCompleteTextView) findViewById(R.id.editTxtSubject);
        subject = getResources().getStringArray(R.array.subject);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, subject);
        sub.setAdapter(adapter3);
        sub.setThreshold(1);


        mydb = new DatabasedHelper(this);

        casting();

        String called_from = getIntent().getStringExtra("called");
        if(called_from.equalsIgnoreCase("add"))
        {
            add.setVisibility(View.VISIBLE);
            update.setVisibility(View.GONE);
        }
        else
        {
            add.setVisibility(View.GONE);
            update.setVisibility(View.VISIBLE);

            class_name = getIntent().getStringExtra("class_name");
            Cursor cursor = mydb.searchFromFifthSemseter(class_name);

            if (cursor.moveToFirst()) {
                String Sub, GPA, Credit;
                Sub = cursor.getString(cursor.getColumnIndex(TableInfo.Newinfo.Usub));
                GPA = cursor.getString(cursor.getColumnIndex(TableInfo.Newinfo.Ugradepoint));
                Credit = cursor.getString(cursor.getColumnIndex(TableInfo.Newinfo.Ucredit));

                etSub.setText(Sub);
                etgpa.setText(GPA);
                etcredit.setText(Credit);
            }
        }
    }


    public void updateData(View view)
    {
        String Sub, GPA, Credit,TotalCredit,TotalCrgp,Lettergrade = null;

        Sub = etSub.getText().toString();
        GPA = etgpa.getText().toString();
        Credit = etcredit.getText().toString();


        if(TextUtils.isEmpty(Sub) || TextUtils.isEmpty(GPA) || TextUtils.isEmpty(Credit))
        {
            Toast.makeText(getApplicationContext(),"Please fill all the info",Toast.LENGTH_SHORT).show();
            return ;
        }
        else if(TextUtils.equals("0",Credit) || TextUtils.equals("0",GPA))
        {
            Toast.makeText(getApplicationContext(),"Please fill Correct info",Toast.LENGTH_SHORT).show();
            return;
        }


        double doubleTotalCredit = Double.parseDouble(Credit);
        TotalCredit = String.valueOf(doubleTotalCredit);

        double doubleTotalCreditGPA = Double.parseDouble(Credit) * Double.parseDouble(GPA);
        TotalCrgp = String.valueOf(doubleTotalCreditGPA);

        if(GPA.equals("4.0"))
        {
            Lettergrade = "A";
        }
        else if(GPA.equals("3.70"))
        {
            Lettergrade = "A-";
        }
        else if(GPA.equals("3.30"))
        {
            Lettergrade = "B+";
        }
        else if(GPA.equals("3.00"))
        {
            Lettergrade = "B";
        }
        else if(GPA.equals("2.70"))
        {
            Lettergrade = "B-";
        }
        else if(GPA.equals("2.30"))
        {
            Lettergrade = "C+";
        }
        else if(GPA.equals("2.00"))
        {
            Lettergrade = "C";
        }
        else if(GPA.equals("1.70"))
        {
            Lettergrade = "C-";
        }
        else if(GPA.equals("1.3"))
        {
            Lettergrade = "D+";
        }
        else if(GPA.equals("1.00"))
        {
            Lettergrade = "D";
        }
        else if(GPA.equals("0.0"))
        {
            Lettergrade = "F";
        }

        long updated = mydb.fifthSemesterUpdate(class_name, Sub, Credit, GPA,Lettergrade,TotalCredit,TotalCrgp);

        if(updated>0)
        {
            Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_SHORT).show();

        }
        else
        {
            Toast.makeText(getApplicationContext(), "No data updated", Toast.LENGTH_SHORT).show();
        }

        Intent intent = new Intent(AddResultFifth.this, FifthSemester.class);
        startActivity(intent);
        finish();

    }

    public void savedata(View view)
    {
        String Sub, GPA, Credit,Lettergrade=null,TotalCredit,TotalCrgp;

        Sub = etSub.getText().toString();
        GPA = etgpa.getText().toString();
        Credit = etcredit.getText().toString();

        if(TextUtils.isEmpty(Sub) || TextUtils.isEmpty(GPA) || TextUtils.isEmpty(Credit))
        {
            Toast.makeText(getApplicationContext(),"Please fill all the info",Toast.LENGTH_SHORT).show();
            return ;
        }
        else if(TextUtils.equals("0",Credit) || TextUtils.equals("0",GPA))
        {
            Toast.makeText(getApplicationContext(),"Please fill Correct info",Toast.LENGTH_SHORT).show();
            return;
        }


        double doubleTotalCredit = Double.parseDouble(Credit);
        TotalCredit = String.valueOf(doubleTotalCredit);

        double doubleTotalCreditGPA = Double.parseDouble(Credit) * Double.parseDouble(GPA);
        TotalCrgp = String.valueOf(doubleTotalCreditGPA);


        if(GPA.equals("4.0"))
        {
            Lettergrade = "A+";
        }
        else if(GPA.equals("3.70"))
        {
            Lettergrade = "A-";
        }
        else if(GPA.equals("3.30"))
        {
            Lettergrade = "B+";
        }
        else if(GPA.equals("3.00"))
        {
            Lettergrade = "B";
        }
        else if(GPA.equals("2.70"))
        {
            Lettergrade = "B-";
        }
        else if(GPA.equals("2.30"))
        {
            Lettergrade = "C+";
        }
        else if(GPA.equals("2.00"))
        {
            Lettergrade = "C";
        }
        else if(GPA.equals("1.70"))
        {
            Lettergrade = "C-";
        }
        else if(GPA.equals("1.3"))
        {
            Lettergrade = "D+";
        }
        else if(GPA.equals("1.00"))
        {
            Lettergrade = "D";
        }
        else if(GPA.equals("0.0"))
        {
            Lettergrade = "F";
        }

        long inserted = mydb.insertFifthSemester(Sub, Credit, GPA,Lettergrade, TotalCredit,TotalCrgp);
        Intent i = new Intent(AddResultFifth.this, FifthSemester.class);
        startActivity(i);
        finish();
    }

    public void back(View v) {
        finish();
    }

    public void casting() {
        etSub = (EditText) findViewById(R.id.editTxtSubject);
        etgpa = (EditText) findViewById(R.id.editTxtGPA);
        etcredit = (EditText) findViewById(R.id.editTxtCredit);
        add = (Button) findViewById(R.id.btnButton);
        update = (Button) findViewById(R.id.btnUpdate);

        add.setVisibility(View.GONE);
        update.setVisibility(View.GONE);
    }
    @Override
    public void onBackPressed() {
        Intent i = new Intent(AddResultFifth.this,FifthSemester.class);
        startActivity(i);
        finish();
    }
}
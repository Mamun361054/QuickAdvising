package com.nsu.dorbesh.QuickAdvising;

/**
 * Created by Shuvo on 3/8/2017.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabasedHelper extends SQLiteOpenHelper {

    private static final String DataBaseName = "kita_kobor";
    private static final int DB_Version = 1;



    public static final String Create_table_first = "CREATE TABLE " + TableInfo.Newinfo.TableFirstSem + " ( "
            + TableInfo.Newinfo.Usub + " TEXT, " + TableInfo.Newinfo.Ucredit + " TEXT, "
            + TableInfo.Newinfo.Ugradepoint + " TEXT, " + TableInfo.Newinfo.Uletter + " TEXT, "
            + TableInfo.Newinfo.Utotal_credit + " TEXT, " + TableInfo.Newinfo.Utotal_crgp + " TEXT )";

    public static final String Create_table_second = "CREATE TABLE " + TableInfo.Newinfo.TableSecondSem + " ( "
            + TableInfo.Newinfo.Usub + " TEXT, " + TableInfo.Newinfo.Ucredit + " TEXT, "
            + TableInfo.Newinfo.Ugradepoint + " TEXT, " + TableInfo.Newinfo.Uletter + " TEXT, "
            + TableInfo.Newinfo.Utotal_credit + " TEXT, " + TableInfo.Newinfo.Utotal_crgp + " TEXT )";

    public static final String Create_table_third = "CREATE TABLE " + TableInfo.Newinfo.TableThirdSem + " ( "
            + TableInfo.Newinfo.Usub + " TEXT, " + TableInfo.Newinfo.Ucredit + " TEXT, "
            + TableInfo.Newinfo.Ugradepoint + " TEXT, " + TableInfo.Newinfo.Uletter + " TEXT, "
            + TableInfo.Newinfo.Utotal_credit + " TEXT, " + TableInfo.Newinfo.Utotal_crgp + " TEXT )";

    public static final String Create_table_fourth = "CREATE TABLE " + TableInfo.Newinfo.TableFourthSem + " ( "
            + TableInfo.Newinfo.Usub + " TEXT, " + TableInfo.Newinfo.Ucredit + " TEXT, "
            + TableInfo.Newinfo.Ugradepoint + " TEXT, " + TableInfo.Newinfo.Uletter + " TEXT, "
            + TableInfo.Newinfo.Utotal_credit + " TEXT, " + TableInfo.Newinfo.Utotal_crgp + " TEXT )";

    public static final String Create_table_five = "CREATE TABLE " + TableInfo.Newinfo.TableFiveSem + " ( "
            + TableInfo.Newinfo.Usub + " TEXT, " + TableInfo.Newinfo.Ucredit + " TEXT, "
            + TableInfo.Newinfo.Ugradepoint + " TEXT, " + TableInfo.Newinfo.Uletter + " TEXT, "
            + TableInfo.Newinfo.Utotal_credit + " TEXT, " + TableInfo.Newinfo.Utotal_crgp + " TEXT )";

    public static final String Create_table_six = "CREATE TABLE " + TableInfo.Newinfo.TableSixSem + " ( "
            + TableInfo.Newinfo.Usub + " TEXT, " + TableInfo.Newinfo.Ucredit + " TEXT, "
            + TableInfo.Newinfo.Ugradepoint + " TEXT, " + TableInfo.Newinfo.Uletter + " TEXT, "
            + TableInfo.Newinfo.Utotal_credit + " TEXT, " + TableInfo.Newinfo.Utotal_crgp + " TEXT )";

    public static final String Create_table_seven = "CREATE TABLE " + TableInfo.Newinfo.TableSevenSem + " ( "
            + TableInfo.Newinfo.Usub + " TEXT, " + TableInfo.Newinfo.Ucredit + " TEXT, "
            + TableInfo.Newinfo.Ugradepoint + " TEXT, " + TableInfo.Newinfo.Uletter + " TEXT, "
            + TableInfo.Newinfo.Utotal_credit + " TEXT, " + TableInfo.Newinfo.Utotal_crgp + " TEXT )";

    public static final String Create_table_eight = "CREATE TABLE " + TableInfo.Newinfo.TableEightSem + " ( "
            + TableInfo.Newinfo.Usub + " TEXT, " + TableInfo.Newinfo.Ucredit + " TEXT, "
            + TableInfo.Newinfo.Ugradepoint + " TEXT, " + TableInfo.Newinfo.Uletter + " TEXT, "
            + TableInfo.Newinfo.Utotal_credit + " TEXT, " + TableInfo.Newinfo.Utotal_crgp + " TEXT )";

    public static final String Create_table_nine = "CREATE TABLE " + TableInfo.Newinfo.TableNineSem + " ( "
            + TableInfo.Newinfo.Usub + " TEXT, " + TableInfo.Newinfo.Ucredit + " TEXT, "
            + TableInfo.Newinfo.Ugradepoint + " TEXT, " + TableInfo.Newinfo.Uletter + " TEXT, "
            + TableInfo.Newinfo.Utotal_credit + " TEXT, " + TableInfo.Newinfo.Utotal_crgp + " TEXT )";

    public static final String Create_table_ten = "CREATE TABLE " + TableInfo.Newinfo.TableTenSem + " ( "
            + TableInfo.Newinfo.Usub + " TEXT, " + TableInfo.Newinfo.Ucredit + " TEXT, "
            + TableInfo.Newinfo.Ugradepoint + " TEXT, " + TableInfo.Newinfo.Uletter + " TEXT, "
            + TableInfo.Newinfo.Utotal_credit + " TEXT, " + TableInfo.Newinfo.Utotal_crgp + " TEXT )";

    public static final String Create_table_eleven = "CREATE TABLE " + TableInfo.Newinfo.TableElevenSem + " ( "
            + TableInfo.Newinfo.Usub + " TEXT, " + TableInfo.Newinfo.Ucredit + " TEXT, "
            + TableInfo.Newinfo.Ugradepoint + " TEXT, " + TableInfo.Newinfo.Uletter + " TEXT, "
            + TableInfo.Newinfo.Utotal_credit + " TEXT, " + TableInfo.Newinfo.Utotal_crgp + " TEXT )";

    public static final String Create_table_twelve = "CREATE TABLE " + TableInfo.Newinfo.TableTwelveSem + " ( "
            + TableInfo.Newinfo.Usub + " TEXT, " + TableInfo.Newinfo.Ucredit + " TEXT, "
            + TableInfo.Newinfo.Ugradepoint + " TEXT, " + TableInfo.Newinfo.Uletter + " TEXT, "
            + TableInfo.Newinfo.Utotal_credit + " TEXT, " + TableInfo.Newinfo.Utotal_crgp + " TEXT )";


    public DatabasedHelper(Context context) {
        super(context, DataBaseName, null, DB_Version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Create_table_first);
        db.execSQL(Create_table_second);
        db.execSQL(Create_table_third);
        db.execSQL(Create_table_fourth);
        db.execSQL(Create_table_five);
        db.execSQL(Create_table_six);
        db.execSQL(Create_table_seven);
        db.execSQL(Create_table_eight);
        db.execSQL(Create_table_nine);
        db.execSQL(Create_table_ten);
        db.execSQL(Create_table_eleven);
        db.execSQL(Create_table_twelve);


        Log.e("Table Create", Create_table_first);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Create_table_first);
        db.execSQL("DROP TABLE IF EXISTS " + Create_table_second);
        db.execSQL("DROP TABLE IF EXISTS " + Create_table_third);
        db.execSQL("DROP TABLE IF EXISTS " + Create_table_fourth);
        db.execSQL("DROP TABLE IF EXISTS " + Create_table_five);
        db.execSQL("DROP TABLE IF EXISTS " + Create_table_six);
        db.execSQL("DROP TABLE IF EXISTS " + Create_table_seven);
        db.execSQL("DROP TABLE IF EXISTS " + Create_table_eight);
        db.execSQL("DROP TABLE IF EXISTS " + Create_table_nine);
        db.execSQL("DROP TABLE IF EXISTS " + Create_table_ten);
        db.execSQL("DROP TABLE IF EXISTS " + Create_table_eleven);
        db.execSQL("DROP TABLE IF EXISTS " + Create_table_twelve);

        onCreate(db);
    }


    // Insert data
    public long insertFirstSemester(String sub, String credit, String gradepoint,String letter, String totalcredit,String totalcrgp) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(TableInfo.Newinfo.Usub, sub);
        values.put(TableInfo.Newinfo.Ucredit, credit);
        values.put(TableInfo.Newinfo.Ugradepoint, gradepoint);
        values.put(TableInfo.Newinfo.Uletter,letter);
        values.put(TableInfo.Newinfo.Utotal_credit, totalcredit);
        values.put(TableInfo.Newinfo.Utotal_crgp, totalcrgp);

        long inserted = db.insert(TableInfo.Newinfo.TableFirstSem, null, values);
        db.close();
        return inserted;
    }

    // Insert data 
    public long insertSecondSemester(String sub, String credit, String gradepoint,String letter, String totalcredit,String totalcrgp) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(TableInfo.Newinfo.Usub, sub);
        values.put(TableInfo.Newinfo.Ucredit, credit);
        values.put(TableInfo.Newinfo.Ugradepoint, gradepoint);
        values.put(TableInfo.Newinfo.Uletter,letter);
        values.put(TableInfo.Newinfo.Utotal_credit, totalcredit);
        values.put(TableInfo.Newinfo.Utotal_crgp, totalcrgp);

        long inserted = db.insert(TableInfo.Newinfo.TableSecondSem, null, values);
        db.close();

        return inserted;
    }

    // Insert data 
    public long insertThirdSemester(String sub, String credit, String gradepoint,String letter, String totalcredit,String totalcrgp) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(TableInfo.Newinfo.Usub, sub);
        values.put(TableInfo.Newinfo.Ucredit, credit);
        values.put(TableInfo.Newinfo.Ugradepoint, gradepoint);
        values.put(TableInfo.Newinfo.Uletter,letter);
        values.put(TableInfo.Newinfo.Utotal_credit, totalcredit);
        values.put(TableInfo.Newinfo.Utotal_crgp, totalcrgp);

        long inserted = db.insert(TableInfo.Newinfo.TableThirdSem, null, values);
        db.close();

        return inserted;
    }

    // Insert data
    public long insertFourthSemester(String sub, String credit, String gradepoint,String letter, String totalcredit,String totalcrgp) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(TableInfo.Newinfo.Usub, sub);
        values.put(TableInfo.Newinfo.Ucredit, credit);
        values.put(TableInfo.Newinfo.Ugradepoint, gradepoint);
        values.put(TableInfo.Newinfo.Uletter,letter);
        values.put(TableInfo.Newinfo.Utotal_credit, totalcredit);
        values.put(TableInfo.Newinfo.Utotal_crgp, totalcrgp);

        long inserted = db.insert(TableInfo.Newinfo.TableFourthSem, null, values);
        db.close();

        return inserted;
    }

    // Insert data
    public long insertFifthSemester(String sub, String credit, String gradepoint,String letter, String totalcredit,String totalcrgp) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(TableInfo.Newinfo.Usub, sub);
        values.put(TableInfo.Newinfo.Ucredit, credit);
        values.put(TableInfo.Newinfo.Ugradepoint, gradepoint);
        values.put(TableInfo.Newinfo.Uletter,letter);
        values.put(TableInfo.Newinfo.Utotal_credit, totalcredit);
        values.put(TableInfo.Newinfo.Utotal_crgp, totalcrgp);


        long inserted = db.insert(TableInfo.Newinfo.TableFiveSem, null, values);
        db.close();

        return inserted;
    }

    // Insert data
    public long insertSixthSemester(String sub, String credit, String gradepoint,String letter, String totalcredit,String totalcrgp) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(TableInfo.Newinfo.Usub, sub);
        values.put(TableInfo.Newinfo.Ucredit, credit);
        values.put(TableInfo.Newinfo.Ugradepoint, gradepoint);
        values.put(TableInfo.Newinfo.Uletter,letter);
        values.put(TableInfo.Newinfo.Utotal_credit, totalcredit);
        values.put(TableInfo.Newinfo.Utotal_crgp, totalcrgp);


        long inserted = db.insert(TableInfo.Newinfo.TableSixSem, null, values);
        db.close();

        return inserted;
    }

    // Insert data
    public long insertSeventhSemester(String sub, String credit, String gradepoint,String letter, String totalcredit,String totalcrgp) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(TableInfo.Newinfo.Usub, sub);
        values.put(TableInfo.Newinfo.Ucredit, credit);
        values.put(TableInfo.Newinfo.Ugradepoint, gradepoint);
        values.put(TableInfo.Newinfo.Uletter,letter);
        values.put(TableInfo.Newinfo.Utotal_credit, totalcredit);
        values.put(TableInfo.Newinfo.Utotal_crgp, totalcrgp);


        long inserted = db.insert(TableInfo.Newinfo.TableSevenSem, null, values);
        db.close();

        return inserted;
    }

    // Insert data
    public long insertEighthSemester(String sub, String credit, String gradepoint,String letter, String totalcredit,String totalcrgp) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(TableInfo.Newinfo.Usub, sub);
        values.put(TableInfo.Newinfo.Ucredit, credit);
        values.put(TableInfo.Newinfo.Ugradepoint, gradepoint);
        values.put(TableInfo.Newinfo.Uletter,letter);
        values.put(TableInfo.Newinfo.Utotal_credit, totalcredit);
        values.put(TableInfo.Newinfo.Utotal_crgp, totalcrgp);


        long inserted = db.insert(TableInfo.Newinfo.TableEightSem, null, values);
        db.close();

        return inserted;
    }

    public long insertNinethSemester(String sub, String credit, String gradepoint,String letter, String totalcredit,String totalcrgp) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(TableInfo.Newinfo.Usub, sub);
        values.put(TableInfo.Newinfo.Ucredit, credit);
        values.put(TableInfo.Newinfo.Ugradepoint, gradepoint);
        values.put(TableInfo.Newinfo.Uletter,letter);
        values.put(TableInfo.Newinfo.Utotal_credit, totalcredit);
        values.put(TableInfo.Newinfo.Utotal_crgp, totalcrgp);


        long inserted = db.insert(TableInfo.Newinfo.TableNineSem, null, values);
        db.close();

        return inserted;
    }

    public long insertTenthSemester(String sub, String credit, String gradepoint,String letter, String totalcredit,String totalcrgp) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(TableInfo.Newinfo.Usub, sub);
        values.put(TableInfo.Newinfo.Ucredit, credit);
        values.put(TableInfo.Newinfo.Ugradepoint, gradepoint);
        values.put(TableInfo.Newinfo.Uletter,letter);
        values.put(TableInfo.Newinfo.Utotal_credit, totalcredit);
        values.put(TableInfo.Newinfo.Utotal_crgp, totalcrgp);


        long inserted = db.insert(TableInfo.Newinfo.TableTenSem, null, values);
        db.close();

        return inserted;
    }


    public long insertEleventhSemester(String sub, String credit, String gradepoint,String letter, String totalcredit,String totalcrgp) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(TableInfo.Newinfo.Usub, sub);
        values.put(TableInfo.Newinfo.Ucredit, credit);
        values.put(TableInfo.Newinfo.Ugradepoint, gradepoint);
        values.put(TableInfo.Newinfo.Uletter,letter);
        values.put(TableInfo.Newinfo.Utotal_credit, totalcredit);
        values.put(TableInfo.Newinfo.Utotal_crgp, totalcrgp);


        long inserted = db.insert(TableInfo.Newinfo.TableElevenSem, null, values);
        db.close();

        return inserted;
    }

    public long insertTwelvethSemester(String sub, String credit, String gradepoint,String letter, String totalcredit,String totalcrgp) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(TableInfo.Newinfo.Usub, sub);
        values.put(TableInfo.Newinfo.Ucredit, credit);
        values.put(TableInfo.Newinfo.Ugradepoint, gradepoint);
        values.put(TableInfo.Newinfo.Uletter,letter);
        values.put(TableInfo.Newinfo.Utotal_credit, totalcredit);
        values.put(TableInfo.Newinfo.Utotal_crgp, totalcrgp);


        long inserted = db.insert(TableInfo.Newinfo.TableTwelveSem, null, values);
        db.close();

        return inserted;
    }


    //  get information from saturday
    public Cursor getInfoFromFirstSemester() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TableInfo.Newinfo.TableFirstSem, null, null, null, null, null, null);

        return cursor;
    }

    //  get information from Sunday
    public Cursor getInfoFromSecondSemester() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TableInfo.Newinfo.TableSecondSem, null, null, null, null, null, null);

        return cursor;
    }

    //  get information from Monday
    public Cursor getInfoFromThirdSemester() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TableInfo.Newinfo.TableThirdSem, null, null, null, null, null, null);

        return cursor;
    }

    //  get information from Tuesday
    public Cursor getInfoFromFourthSemester() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TableInfo.Newinfo.TableFourthSem, null, null, null, null, null, null);

        return cursor;
    }

    //  get information from Wednesday
    public Cursor getInfoFromFifthSemester() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TableInfo.Newinfo.TableFiveSem, null, null, null, null, null, null);

        return cursor;
    }

    //  get information from Thursday
    public Cursor getInfoFromSixthSemester() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TableInfo.Newinfo.TableSixSem, null, null, null, null, null, null);

        return cursor;
    }

    //  get information from Friday
    public Cursor getInfoFromSevenSemester() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TableInfo.Newinfo.TableSevenSem, null, null, null, null, null, null);

        return cursor;
    }

    public Cursor getInfoFromEighthSemester() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TableInfo.Newinfo.TableEightSem, null, null, null, null, null, null);

        return cursor;
    }


    public Cursor getInfoFromNinethSemester() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TableInfo.Newinfo.TableNineSem, null, null, null, null, null, null);

        return cursor;
    }


    public Cursor getInfoFromTenthSemester() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TableInfo.Newinfo.TableTenSem, null, null, null, null, null, null);

        return cursor;
    }


    public Cursor getInfoFromEleventhSemester() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TableInfo.Newinfo.TableElevenSem, null, null, null, null, null, null);

        return cursor;
    }

    public Cursor getInfoFromTwelvethSemester() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TableInfo.Newinfo.TableTwelveSem, null, null, null, null, null, null);

        return cursor;
    }




    // Search for all table
    public Cursor searchFromFirstSemester(String keyword) {
        Cursor cursor;
        String[] projections = {TableInfo.Newinfo.Usub, TableInfo.Newinfo.Ucredit, TableInfo.Newinfo.Ugradepoint,
                TableInfo.Newinfo.Uletter, TableInfo.Newinfo.Utotal_credit ,TableInfo.Newinfo.Utotal_crgp};
        String selection = TableInfo.Newinfo.Usub + " LIKE ?";
        String[] selection_args = {keyword};
        SQLiteDatabase db = this.getReadableDatabase();

        cursor = db.query(TableInfo.Newinfo.TableFirstSem, projections, selection, selection_args, null, null, null);
        // if i not include "name" column in the projection then the cursor not going to this colum and i can't retreive the data from the columm
        return cursor;
    }

    public Cursor searchFromSecondSemester(String keyword) {
        Cursor cursor;
        String[] projections = {TableInfo.Newinfo.Usub, TableInfo.Newinfo.Ucredit, TableInfo.Newinfo.Ugradepoint,
                TableInfo.Newinfo.Uletter, TableInfo.Newinfo.Utotal_credit ,TableInfo.Newinfo.Utotal_crgp};
        String selection = TableInfo.Newinfo.Usub + " LIKE ?";
        String[] selection_args = {keyword};
        SQLiteDatabase db = this.getReadableDatabase();


        cursor = db.query(TableInfo.Newinfo.TableSecondSem, projections, selection, selection_args, null, null, null);
        // if i not include "name" column in the projection then the cursor not going to this colum and i can't retreive the data from the columm
        return cursor;
    }

    public Cursor searchFromThirdSemester(String keyword) {
        Cursor cursor;
        String[] projections = {TableInfo.Newinfo.Usub, TableInfo.Newinfo.Ucredit, TableInfo.Newinfo.Ugradepoint,
                TableInfo.Newinfo.Uletter, TableInfo.Newinfo.Utotal_credit ,TableInfo.Newinfo.Utotal_crgp};
        String selection = TableInfo.Newinfo.Usub + " LIKE ?";
        String[] selection_args = {keyword};
        SQLiteDatabase db = this.getReadableDatabase();


        cursor = db.query(TableInfo.Newinfo.TableThirdSem, projections, selection, selection_args, null, null, null);
        // if i not include "name" column in the projection then the cursor not going to this colum and i can't retreive the data from the columm
        return cursor;
    }

    public Cursor searchFromFourthSemester(String keyword) {
        Cursor cursor;
        String[] projections = {TableInfo.Newinfo.Usub, TableInfo.Newinfo.Ucredit, TableInfo.Newinfo.Ugradepoint,
                TableInfo.Newinfo.Uletter, TableInfo.Newinfo.Utotal_credit ,TableInfo.Newinfo.Utotal_crgp};
        String selection = TableInfo.Newinfo.Usub + " LIKE ?";
        String[] selection_args = {keyword};
        SQLiteDatabase db = this.getReadableDatabase();


        cursor = db.query(TableInfo.Newinfo.TableFourthSem, projections, selection, selection_args, null, null, null);
        // if i not include "name" column in the projection then the cursor not going to this colum and i can't retreive the data from the columm
        return cursor;
    }

    public Cursor searchFromFifthSemseter(String keyword) {
        Cursor cursor;
        String[] projections = {TableInfo.Newinfo.Usub, TableInfo.Newinfo.Ucredit, TableInfo.Newinfo.Ugradepoint,
                TableInfo.Newinfo.Uletter, TableInfo.Newinfo.Utotal_credit ,TableInfo.Newinfo.Utotal_crgp};
        String selection = TableInfo.Newinfo.Usub + " LIKE ?";
        String[] selection_args = {keyword};
        SQLiteDatabase db = this.getReadableDatabase();


        cursor = db.query(TableInfo.Newinfo.TableFiveSem, projections, selection, selection_args, null, null, null);
        // if i not include "name" column in the projection then the cursor not going to this colum and i can't retreive the data from the columm
        return cursor;
    }

    public Cursor searchFromSixthSemester(String keyword) {
        Cursor cursor;
        String[] projections = {TableInfo.Newinfo.Usub, TableInfo.Newinfo.Ucredit, TableInfo.Newinfo.Ugradepoint,
                TableInfo.Newinfo.Uletter, TableInfo.Newinfo.Utotal_credit ,TableInfo.Newinfo.Utotal_crgp};
        String selection = TableInfo.Newinfo.Usub + " LIKE ?";
        String[] selection_args = {keyword};
        SQLiteDatabase db = this.getReadableDatabase();


        cursor = db.query(TableInfo.Newinfo.TableSixSem, projections, selection, selection_args, null, null, null);
        // if i not include "name" column in the projection then the cursor not going to this colum and i can't retreive the data from the columm
        return cursor;
    }

    public Cursor searchFromSevenSemester(String keyword) {
        Cursor cursor;
        String[] projections = {TableInfo.Newinfo.Usub, TableInfo.Newinfo.Ucredit, TableInfo.Newinfo.Ugradepoint,
                TableInfo.Newinfo.Uletter, TableInfo.Newinfo.Utotal_credit ,TableInfo.Newinfo.Utotal_crgp};
        String selection = TableInfo.Newinfo.Usub + " LIKE ?";
        String[] selection_args = {keyword};
        SQLiteDatabase db = this.getReadableDatabase();


        cursor = db.query(TableInfo.Newinfo.TableSevenSem, projections, selection, selection_args, null, null, null);
        // if i not include "name" column in the projection then the cursor not going to this colum and i can't retreive the data from the columm
        return cursor;
    }

    public Cursor searchFromEightSemester(String keyword) {
        Cursor cursor;
        String[] projections = {TableInfo.Newinfo.Usub, TableInfo.Newinfo.Ucredit, TableInfo.Newinfo.Ugradepoint,
                TableInfo.Newinfo.Uletter, TableInfo.Newinfo.Utotal_credit ,TableInfo.Newinfo.Utotal_crgp};
        String selection = TableInfo.Newinfo.Usub + " LIKE ?";
        String[] selection_args = {keyword};
        SQLiteDatabase db = this.getReadableDatabase();


        cursor = db.query(TableInfo.Newinfo.TableEightSem, projections, selection, selection_args, null, null, null);
        // if i not include "name" column in the projection then the cursor not going to this colum and i can't retreive the data from the columm
        return cursor;
    }


    public Cursor searchFromNinethSemester(String keyword) {
        Cursor cursor;
        String[] projections = {TableInfo.Newinfo.Usub, TableInfo.Newinfo.Ucredit, TableInfo.Newinfo.Ugradepoint,
                TableInfo.Newinfo.Uletter, TableInfo.Newinfo.Utotal_credit ,TableInfo.Newinfo.Utotal_crgp};
        String selection = TableInfo.Newinfo.Usub + " LIKE ?";
        String[] selection_args = {keyword};
        SQLiteDatabase db = this.getReadableDatabase();


        cursor = db.query(TableInfo.Newinfo.TableNineSem, projections, selection, selection_args, null, null, null);
        // if i not include "name" column in the projection then the cursor not going to this colum and i can't retreive the data from the columm
        return cursor;
    }


    public Cursor searchFromTenthSemester(String keyword) {
        Cursor cursor;
        String[] projections = {TableInfo.Newinfo.Usub, TableInfo.Newinfo.Ucredit, TableInfo.Newinfo.Ugradepoint,
                TableInfo.Newinfo.Uletter, TableInfo.Newinfo.Utotal_credit ,TableInfo.Newinfo.Utotal_crgp};
        String selection = TableInfo.Newinfo.Usub + " LIKE ?";
        String[] selection_args = {keyword};
        SQLiteDatabase db = this.getReadableDatabase();

        cursor = db.query(TableInfo.Newinfo.TableTenSem, projections, selection, selection_args, null, null, null);
        // if i not include "name" column in the projection then the cursor not going to this colum and i can't retreive the data from the columm
        return cursor;
    }


    public Cursor searchFromEleventhSemester(String keyword) {
        Cursor cursor;
        String[] projections = {TableInfo.Newinfo.Usub, TableInfo.Newinfo.Ucredit, TableInfo.Newinfo.Ugradepoint,
                TableInfo.Newinfo.Uletter, TableInfo.Newinfo.Utotal_credit ,TableInfo.Newinfo.Utotal_crgp};
        String selection = TableInfo.Newinfo.Usub + " LIKE ?";
        String[] selection_args = {keyword};
        SQLiteDatabase db = this.getReadableDatabase();


        cursor = db.query(TableInfo.Newinfo.TableElevenSem, projections, selection, selection_args, null, null, null);
        // if i not include "name" column in the projection then the cursor not going to this colum and i can't retreive the data from the columm
        return cursor;
    }


    public Cursor searchFromTwelvethSemester(String keyword) {
        Cursor cursor;
        String[] projections = {TableInfo.Newinfo.Usub, TableInfo.Newinfo.Ucredit, TableInfo.Newinfo.Ugradepoint,
                TableInfo.Newinfo.Uletter, TableInfo.Newinfo.Utotal_credit ,TableInfo.Newinfo.Utotal_crgp};
        String selection = TableInfo.Newinfo.Usub + " LIKE ?";
        String[] selection_args = {keyword};
        SQLiteDatabase db = this.getReadableDatabase();


        cursor = db.query(TableInfo.Newinfo.TableTwelveSem, projections, selection, selection_args, null, null, null);
        // if i not include "name" column in the projection then the cursor not going to this colum and i can't retreive the data from the columm
        return cursor;
    }



    // Update For all Table

    public int firstSemesterUpdate(String old_name, String sub, String credit, String gradepoint,String letter, String totalcredit, String totalcrgp) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String selection = TableInfo.Newinfo.Usub + " LIKE ?";   // NAME column is my where_cluse
        String[] selection_args = {old_name};                              // old_name is my where_args

        values.put(TableInfo.Newinfo.Usub, sub);
        values.put(TableInfo.Newinfo.Ucredit, credit);
        values.put(TableInfo.Newinfo.Ugradepoint, gradepoint);
        values.put(TableInfo.Newinfo.Uletter, letter);
        values.put(TableInfo.Newinfo.Utotal_credit, totalcredit);
        values.put(TableInfo.Newinfo.Utotal_crgp, totalcrgp);

        int updated = db.update(TableInfo.Newinfo.TableFirstSem, values, selection, selection_args);

        return updated;
    }

    public int secondSemesterUpdate(String old_name, String sub, String credit, String gradepoint,String letter, String totalcredit, String totalcrgp) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String selection = TableInfo.Newinfo.Usub + " LIKE ?";   // NAME column is my where_cluse
        String[] selection_args = {old_name};                              // old_name is my where_args

        values.put(TableInfo.Newinfo.Usub, sub);
        values.put(TableInfo.Newinfo.Ucredit, credit);
        values.put(TableInfo.Newinfo.Ugradepoint, gradepoint);
        values.put(TableInfo.Newinfo.Uletter, letter);
        values.put(TableInfo.Newinfo.Utotal_credit, totalcredit);
        values.put(TableInfo.Newinfo.Utotal_crgp, totalcrgp);


        int updated = db.update(TableInfo.Newinfo.TableSecondSem, values, selection, selection_args);

        return updated;
    }

    public int thirdSemseterUpdate(String old_name, String sub, String credit, String gradepoint,String letter, String totalcredit, String totalcrgp) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String selection = TableInfo.Newinfo.Usub + " LIKE ?";   // NAME column is my where_cluse
        String[] selection_args = {old_name};                              // old_name is my where_args

        values.put(TableInfo.Newinfo.Usub, sub);
        values.put(TableInfo.Newinfo.Ucredit, credit);
        values.put(TableInfo.Newinfo.Ugradepoint, gradepoint);
        values.put(TableInfo.Newinfo.Uletter, letter);
        values.put(TableInfo.Newinfo.Utotal_credit, totalcredit);
        values.put(TableInfo.Newinfo.Utotal_crgp, totalcrgp);


        int updated = db.update(TableInfo.Newinfo.TableThirdSem, values, selection, selection_args);

        return updated;
    }

    public int forthSemesterUpdate(String old_name, String sub, String credit, String gradepoint,String letter, String totalcredit, String totalcrgp) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String selection = TableInfo.Newinfo.Usub + " LIKE ?";   // NAME column is my where_cluse
        String[] selection_args = {old_name};                              // old_name is my where_args

        values.put(TableInfo.Newinfo.Usub, sub);
        values.put(TableInfo.Newinfo.Ucredit, credit);
        values.put(TableInfo.Newinfo.Ugradepoint, gradepoint);
        values.put(TableInfo.Newinfo.Uletter, letter);
        values.put(TableInfo.Newinfo.Utotal_credit, totalcredit);
        values.put(TableInfo.Newinfo.Utotal_crgp, totalcrgp);

        int updated = db.update(TableInfo.Newinfo.TableFourthSem, values, selection, selection_args);

        return updated;
    }

    public int fifthSemesterUpdate(String old_name, String sub, String credit, String gradepoint,String letter, String totalcredit, String totalcrgp) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String selection = TableInfo.Newinfo.Usub + " LIKE ?";   // NAME column is my where_cluse
        String[] selection_args = {old_name};                              // old_name is my where_args

        values.put(TableInfo.Newinfo.Usub, sub);
        values.put(TableInfo.Newinfo.Ucredit, credit);
        values.put(TableInfo.Newinfo.Ugradepoint, gradepoint);
        values.put(TableInfo.Newinfo.Uletter, letter);
        values.put(TableInfo.Newinfo.Utotal_credit, totalcredit);
        values.put(TableInfo.Newinfo.Utotal_crgp, totalcrgp);


        int updated = db.update(TableInfo.Newinfo.TableFiveSem, values, selection, selection_args);

        return updated;
    }

    public int sixthSemesterUpdate(String old_name, String sub, String credit, String gradepoint,String letter, String totalcredit, String totalcrgp) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String selection = TableInfo.Newinfo.Usub + " LIKE ?";   // NAME column is my where_cluse
        String[] selection_args = {old_name};                              // old_name is my where_args

        values.put(TableInfo.Newinfo.Usub, sub);
        values.put(TableInfo.Newinfo.Ucredit, credit);
        values.put(TableInfo.Newinfo.Ugradepoint, gradepoint);
        values.put(TableInfo.Newinfo.Uletter, letter);
        values.put(TableInfo.Newinfo.Utotal_credit, totalcredit);
        values.put(TableInfo.Newinfo.Utotal_crgp, totalcrgp);


        int updated = db.update(TableInfo.Newinfo.TableSixSem, values, selection, selection_args);

        return updated;
    }

    public int sevenSemesterUpdate(String old_name, String sub, String credit, String gradepoint,String letter, String totalcredit, String totalcrgp) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String selection = TableInfo.Newinfo.Usub + " LIKE ?";   // NAME column is my where_cluse
        String[] selection_args = {old_name};                              // old_name is my where_args

        values.put(TableInfo.Newinfo.Usub, sub);
        values.put(TableInfo.Newinfo.Ucredit, credit);
        values.put(TableInfo.Newinfo.Ugradepoint, gradepoint);
        values.put(TableInfo.Newinfo.Uletter, letter);
        values.put(TableInfo.Newinfo.Utotal_credit, totalcredit);
        values.put(TableInfo.Newinfo.Utotal_crgp, totalcrgp);


        int updated = db.update(TableInfo.Newinfo.TableSevenSem, values, selection, selection_args);

        return updated;
    }

    public int eighthSemesterUpdate(String old_name, String sub, String credit, String gradepoint,String letter, String totalcredit, String totalcrgp) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String selection = TableInfo.Newinfo.Usub + " LIKE ?";   // NAME column is my where_cluse
        String[] selection_args = {old_name};                              // old_name is my where_args

        values.put(TableInfo.Newinfo.Usub, sub);
        values.put(TableInfo.Newinfo.Ucredit, credit);
        values.put(TableInfo.Newinfo.Ugradepoint, gradepoint);
        values.put(TableInfo.Newinfo.Uletter, letter);
        values.put(TableInfo.Newinfo.Utotal_credit, totalcredit);
        values.put(TableInfo.Newinfo.Utotal_crgp, totalcrgp);


        int updated = db.update(TableInfo.Newinfo.TableEightSem, values, selection, selection_args);

        return updated;
    }

    public int ninethSemesterUpdate(String old_name, String sub, String credit, String gradepoint,String letter, String totalcredit, String totalcrgp) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String selection = TableInfo.Newinfo.Usub + " LIKE ?";   // NAME column is my where_cluse
        String[] selection_args = {old_name};                              // old_name is my where_args

        values.put(TableInfo.Newinfo.Usub, sub);
        values.put(TableInfo.Newinfo.Ucredit, credit);
        values.put(TableInfo.Newinfo.Ugradepoint, gradepoint);
        values.put(TableInfo.Newinfo.Uletter, letter);
        values.put(TableInfo.Newinfo.Utotal_credit, totalcredit);
        values.put(TableInfo.Newinfo.Utotal_crgp, totalcrgp);


        int updated = db.update(TableInfo.Newinfo.TableNineSem, values, selection, selection_args);

        return updated;
    }


    public int tenthSemesterUpdate(String old_name, String sub, String credit, String gradepoint,String letter, String totalcredit, String totalcrgp) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String selection = TableInfo.Newinfo.Usub + " LIKE ?";   // NAME column is my where_cluse
        String[] selection_args = {old_name};                              // old_name is my where_args

        values.put(TableInfo.Newinfo.Usub, sub);
        values.put(TableInfo.Newinfo.Ucredit, credit);
        values.put(TableInfo.Newinfo.Ugradepoint, gradepoint);
        values.put(TableInfo.Newinfo.Uletter, letter);
        values.put(TableInfo.Newinfo.Utotal_credit, totalcredit);
        values.put(TableInfo.Newinfo.Utotal_crgp, totalcrgp);


        int updated = db.update(TableInfo.Newinfo.TableTenSem, values, selection, selection_args);

        return updated;
    }

    public int eleventhSemesterUpdate(String old_name, String sub, String credit, String gradepoint,String letter, String totalcredit, String totalcrgp) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String selection = TableInfo.Newinfo.Usub + " LIKE ?";   // NAME column is my where_cluse
        String[] selection_args = {old_name};                              // old_name is my where_args

        values.put(TableInfo.Newinfo.Usub, sub);
        values.put(TableInfo.Newinfo.Ucredit, credit);
        values.put(TableInfo.Newinfo.Ugradepoint, gradepoint);
        values.put(TableInfo.Newinfo.Uletter, letter);
        values.put(TableInfo.Newinfo.Utotal_credit, totalcredit);
        values.put(TableInfo.Newinfo.Utotal_crgp, totalcrgp);


        int updated = db.update(TableInfo.Newinfo.TableElevenSem, values, selection, selection_args);

        return updated;
    }

    public int twelvethSemesterUpdate(String old_name, String sub, String credit, String gradepoint,String letter, String totalcredit, String totalcrgp) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String selection = TableInfo.Newinfo.Usub + " LIKE ?";   // NAME column is my where_cluse
        String[] selection_args = {old_name};                              // old_name is my where_args

        values.put(TableInfo.Newinfo.Usub, sub);
        values.put(TableInfo.Newinfo.Ucredit, credit);
        values.put(TableInfo.Newinfo.Ugradepoint, gradepoint);
        values.put(TableInfo.Newinfo.Uletter, letter);
        values.put(TableInfo.Newinfo.Utotal_credit, totalcredit);
        values.put(TableInfo.Newinfo.Utotal_crgp, totalcrgp);


        int updated = db.update(TableInfo.Newinfo.TableTwelveSem, values, selection, selection_args);

        return updated;
    }

    // Delete  method for all table

    public int deleteFromFirstSemester(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = TableInfo.Newinfo.Usub + " LIKE ?"; // whereCluse
        String[] seletion_args = {name};   // Where_args
        int deleted = db.delete(TableInfo.Newinfo.TableFirstSem, selection, seletion_args);

        return deleted;
    }

    public int deleteFromSecondSemester(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = TableInfo.Newinfo.Usub + " LIKE ?"; // whereCluse
        String[] seletion_args = {name};   // Where_args
        int deleted = db.delete(TableInfo.Newinfo.TableSecondSem, selection, seletion_args);

        return deleted;
    }

    public int deleteFromThirdSemester(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = TableInfo.Newinfo.Usub + " LIKE ?"; // whereCluse
        String[] seletion_args = {name};   // Where_args
        int deleted = db.delete(TableInfo.Newinfo.TableThirdSem, selection, seletion_args);

        return deleted;
    }

    public int deleteFromFourthSemseter(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = TableInfo.Newinfo.Usub + " LIKE ?"; // whereCluse
        String[] seletion_args = {name};   // Where_args
        int deleted = db.delete(TableInfo.Newinfo.TableFourthSem, selection, seletion_args);

        return deleted;
    }

    public int deleteFromFifthSemester(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = TableInfo.Newinfo.Usub + " LIKE ?"; // whereCluse
        String[] seletion_args = {name};   // Where_args
        int deleted = db.delete(TableInfo.Newinfo.TableFiveSem, selection, seletion_args);

        return deleted;
    }

    public int deleteFromSixthSemester(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = TableInfo.Newinfo.Usub + " LIKE ?"; // whereCluse
        String[] seletion_args = {name};   // Where_args
        int deleted = db.delete(TableInfo.Newinfo.TableSixSem, selection, seletion_args);

        return deleted;
    }

    public int deleteFromSevenSemester(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = TableInfo.Newinfo.Usub + " LIKE ?"; // whereCluse
        String[] seletion_args = {name};   // Where_args
        int deleted = db.delete(TableInfo.Newinfo.TableSevenSem, selection, seletion_args);

        return deleted;
    }

    public int deleteFromEightSemester(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = TableInfo.Newinfo.Usub + " LIKE ?"; // whereCluse
        String[] seletion_args = {name};   // Where_args
        int deleted = db.delete(TableInfo.Newinfo.TableEightSem, selection, seletion_args);

        return deleted;
    }

    public int deleteFromNineSemester(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = TableInfo.Newinfo.Usub + " LIKE ?"; // whereCluse
        String[] seletion_args = {name};   // Where_args
        int deleted = db.delete(TableInfo.Newinfo.TableNineSem, selection, seletion_args);

        return deleted;
    }

    public int deleteFromTenSemester(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = TableInfo.Newinfo.Usub + " LIKE ?"; // whereCluse
        String[] seletion_args = {name};   // Where_args
        int deleted = db.delete(TableInfo.Newinfo.TableTenSem, selection, seletion_args);

        return deleted;
    }

    public int deleteFromEleventhSemester(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = TableInfo.Newinfo.Usub + " LIKE ?"; // whereCluse
        String[] seletion_args = {name};   // Where_args
        int deleted = db.delete(TableInfo.Newinfo.TableElevenSem, selection, seletion_args);

        return deleted;
    }

    public int deleteFromTwelveSemester(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = TableInfo.Newinfo.Usub + " LIKE ?"; // whereCluse
        String[] seletion_args = {name};   // Where_args
        int deleted = db.delete(TableInfo.Newinfo.TableTwelveSem, selection, seletion_args);

        return deleted;
    }


    public int delAllFirst() {
        SQLiteDatabase db = this.getWritableDatabase();
        int res = db.delete(TableInfo.Newinfo.TableFirstSem, null, null);
        return res;
    }

    public int delAllSecond() {
        SQLiteDatabase db = this.getWritableDatabase();
        int res = db.delete(TableInfo.Newinfo.TableSecondSem, null, null);
        return res;
    }

    public int delAllThird() {
        SQLiteDatabase db = this.getWritableDatabase();
        int res = db.delete(TableInfo.Newinfo.TableThirdSem, null, null);
        return res;
    }

    public int delAllFour() {
        SQLiteDatabase db = this.getWritableDatabase();
        int res = db.delete(TableInfo.Newinfo.TableFourthSem, null, null);
        return res;
    }

    public int delAllFive() {
        SQLiteDatabase db = this.getWritableDatabase();
        int res = db.delete(TableInfo.Newinfo.TableFiveSem, null, null);
        return res;
    }

    public int delAllSix() {
        SQLiteDatabase db = this.getWritableDatabase();
        int res = db.delete(TableInfo.Newinfo.TableSixSem, null, null);
        return res;
    }

    public int delAllSeven() {
        SQLiteDatabase db = this.getWritableDatabase();
        int res = db.delete(TableInfo.Newinfo.TableSevenSem, null, null);
        return res;
    }

    public int delAllEight() {
        SQLiteDatabase db = this.getWritableDatabase();
        int res = db.delete(TableInfo.Newinfo.TableEightSem, null, null);
        return res;
    }

    public int delAllNine() {
        SQLiteDatabase db = this.getWritableDatabase();
        int res = db.delete(TableInfo.Newinfo.TableNineSem, null, null);
        return res;
    }

    public int delAllTen() {
        SQLiteDatabase db = this.getWritableDatabase();
        int res = db.delete(TableInfo.Newinfo.TableTenSem, null, null);
        return res;
    }

    public int delAllEleven() {
        SQLiteDatabase db = this.getWritableDatabase();
        int res = db.delete(TableInfo.Newinfo.TableElevenSem, null, null);
        return res;
    }

    public int delAllTwelve() {
        SQLiteDatabase db = this.getWritableDatabase();
        int res = db.delete(TableInfo.Newinfo.TableTwelveSem, null, null);
        return res;
    }

}
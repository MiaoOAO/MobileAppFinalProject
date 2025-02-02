package com.ebookfrenzy.finalproject1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class coffeeFavDB extends SQLiteOpenHelper {

    private static int DB_VERSION = 1;
    private static String DATABASE_NAME = "juiceDB";
    private static String TABLE_NAME = "favoriteTable";
    public static String KEY_ID = "id";
    public static String ITEM_TITLE = "itemTitle";
    public static String ITEM_IMAGE = "itemImage";
    public static String FAVORITE_STATUS = "fStatus";
    public static String ITEM_CATEGORY = "itemCategory";
    public static String ITEM_COUNTRY = "itemCountry";
    public static String ITEM_INSTRUCTION = "itemInstructions";
    public static String ITEM_INGREDIENT = "itemIngredient";
    public static String ITEM_MEASURE = "itemMeasure";
    //private Context context;

    private static String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
            + KEY_ID + " TEXT," + ITEM_TITLE + " TEXT,"
            + ITEM_IMAGE + " TEXT," + FAVORITE_STATUS + " TEXT, " + ITEM_CATEGORY + " TEXT," + ITEM_COUNTRY + " TEXT," + ITEM_INSTRUCTION + " TEXT," + ITEM_INGREDIENT
            + " TEXT, " + ITEM_MEASURE + " TEXT)";

    public coffeeFavDB(Context context){
        super(context, DATABASE_NAME, null,DB_VERSION);
        //this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //create empty table
    public void insertEmpty(){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        for(int x = 1; x < 10; x++ )
        {
            cv.put(KEY_ID, x);
            cv.put(FAVORITE_STATUS, "0");

            db.insert(TABLE_NAME, null, cv);
        }
    }

    //insert data into database
    public void insertIntoTheDatabase(String item_title, int item_image, String id, String fav_status, String item_category, String item_country, String item_instructions, String item_ingredient, String item_measure) {
        SQLiteDatabase db;
        db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(ITEM_TITLE, item_title);
        cv.put(ITEM_IMAGE, item_image);
        cv.put(KEY_ID, id);
        cv.put(FAVORITE_STATUS, fav_status);
        cv.put(ITEM_CATEGORY, item_category);
        cv.put(ITEM_COUNTRY, item_country);
        cv.put(ITEM_INSTRUCTION,item_instructions);
        cv.put(ITEM_INGREDIENT,item_ingredient);
        cv.put(ITEM_MEASURE,item_measure);
        db.insert(TABLE_NAME, null, cv);
        Log.d("FavDB Status", item_title + ", favstatus - " + fav_status + " - , " + cv);
    }

    //read all data
    public Cursor read_all_data(String id){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "select * from " + TABLE_NAME + " where " + KEY_ID+"="+id+"";
        return db.rawQuery(sql, null, null);
    }

    //remove line from database
    public void remove_fav(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "UPDATE " + TABLE_NAME + " SET " + FAVORITE_STATUS+" = '0' WHERE "+KEY_ID+"="+id+"";
        db.execSQL(sql);
        Log.d("remove", id.toString());
    }

    //select all favor list
    public Cursor select_all_favorite_list(){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "select * from " + TABLE_NAME + " where " + FAVORITE_STATUS+ " ='1'" ;
        return db.rawQuery(sql, null, null);
    }
}

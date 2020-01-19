package com.example.longmemoryv2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "Dictionary";
    private static final String TABLE_NAME = "Vocab";
    public static String eng,read,tha;
    public static String status = "NotRemember";
    public static String[] Vocab = {"A แอ้น มด","B เบิร์ด นก","C แคท แมว","D ด็อก สุนัข","E เอ้ก ไข่",
            "F ฟิช ปลา","G จิราฟ ยีราฟ","H ฮอซ ม้า","I อิ้ง น้ำหมึก","J จา โอ่ง",
            "K คีย์ กุญแจ","L ไลออน สิงโต","M แม็ท เสื่อ","N เน็ท ตาข่าย","O อ็อกซ์ วัว",
            "P พิก หมู","Q ควีน ราชินี","R แรบบิท กระต่าย","S สเน็ก งู","T ทรี ต้นไม้",
            "U อัมเบลล่า ร่ม","V แวน รถตู้","W วาฬ ปลาวาฬ","X เอ็ก-เรย์ เอ็กเรย์",
            "Y เยลโล่ สีเหลือง","Z ซีบลา ม้าลาย"};
    public MyDatabase(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE "+TABLE_NAME+" (eng VARCHAR(30) PRIMARY KEY,"+" read TEXT(100),"+" tha TEXT(100),"+" status TEXT(100));");
        Log.d("Create Table", "Create table Successfully");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    public long insertRawVocab() {
        //try {
            SQLiteDatabase db;
            db = this.getWritableDatabase();
            String[] word ;
            ContentValues val = new ContentValues();
            long rows = 0;
            for (int i = 0; i < Vocab.length; i++) {
                word = Vocab[i].split(" ");
                eng = word[0];
                read = word[1];
                tha = word[2];
                val.put("eng", "A"+i);
                val.put("read", "B");
                val.put("tha", "C");
                val.put("status","D");
                rows = db.insert(MyDatabase.TABLE_NAME, null, val);
                val.clear();
            }
            db.close();
            return rows;
        //} catch (Exception e) {
         //   return -1;
        //}
    }
    public long updateToRemember(String eng){
        try {
            SQLiteDatabase db;
            db = this.getWritableDatabase();
            ContentValues val = new ContentValues();
            val.put("status","Remember");
            long rows = db.update(MyDatabase.TABLE_NAME,val,"eng="+eng,null);
            db.close();
            return rows;
        }catch (Exception e){
            return  -1;
        }
    }
    public String[][] queryNotRemember() {
        try {
            String arrData[][] = null;
            SQLiteDatabase db;
            db = this.getReadableDatabase();
            //String strSQL = "SELECT "+eng+" FROM "+ TABLE_NAME;
            //Cursor cursor = db.rawQuery(strSQL,null);
            Cursor cursor = db.query(TABLE_NAME,new String[] {"eng","read","tha","status"}, "status = NotRemember", null, null, null, eng, null);
            arrData = new String[cursor.getColumnCount()][4];
            if(cursor != null)
            {
                if (cursor.moveToFirst()) {

                    for (int i = 0; i < cursor.getColumnCount(); i++){
                        arrData[i][0] = cursor.getString(0);
                        arrData[i][1] = cursor.getString(1);
                        arrData[i][2] = cursor.getString(2);
                        arrData[i][3] = cursor.getString(3);
                    }
                }
            }else{
                arrData[0][0] = "AAA";
            }
            cursor.close();
            db.close();
            return arrData;
        } catch (Exception e) {
            String arrData[][] = null;
            arrData = new String[4][4];
            arrData[0][0] = "AAA";
            return arrData;
        }
    }
}

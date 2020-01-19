package com.example.longmemoryv2;

import android.app.Activity;
import android.util.Range;

import java.awt.font.NumericShaper;
import java.util.ArrayList;
import java.util.Collections;

public class vocabulary extends Activity {
    public static ArrayList<String> vocabulary = new ArrayList<String>();
    public static ArrayList<String> Remember = new ArrayList<String>();
    public static ArrayList<String> NonRemember = new ArrayList<String>();
    public static String[] Vocab = {"A แอ้น มด","B เบิร์ด นก","C แคท แมว","D ด็อก สุนัข","E เอ้ก ไข่",
            "F ฟิช ปลา","G จิราฟ ยีราฟ","H ฮอซ ม้า","I อิ้ง น้ำหมึก","J จา โอ่ง",
            "K คีย์ กุญแจ","L ไลออน สิงโต","M แม็ท เสื่อ","N เน็ท ตาข่าย","O อ็อกซ์ วัว",
            "P พิก หมู","Q ควีน ราชินี","R แรบบิท กระต่าย","S สเน็ก งู","T ทรี ต้นไม้",
            "U อัมเบลล่า ร่ม","V แวน รถตู้","W วาฬ ปลาวาฬ","X เอ็ก-เรย์ เอ็กเรย์",
            "Y เยลโล่ สีเหลือง","Z ซีบลา ม้าลาย"};
    public static void insertVocab(){
        for (String e : Vocab){
            vocabulary.add(e);
        }
        Collections.shuffle(vocabulary);
    }
    public ArrayList<String> getVocabulary (){
        return vocabulary;
    }
    public static Boolean addVocabularyToRemember(ArrayList<String> vocab){
        Boolean status;
        status = Remember.add(vocab.get(0));
        return status;
    }
    public static Boolean addVocabularyToNonRemember(ArrayList<String> vocab){
        Boolean status;
        status = NonRemember.add(vocab.get(0));
        return status;
    }
    public static void removeVocab(ArrayList<String> vocab){
        if (main.isNew){
            vocabulary.remove(vocab.get(0));
        }else {
            NonRemember.remove(vocab.get(0));
        }
    }
}

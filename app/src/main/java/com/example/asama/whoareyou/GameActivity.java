package com.example.asama.whoareyou;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.Image;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.asama.whoareyou.Database.DB;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

public class GameActivity extends AppCompatActivity {

    private ImageView img;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private DB dbMain;
    private SQLiteDatabase db;
    Cursor cursor;
    String result;
    int countRount;
    ArrayList<String> choice;
    String text1;
    String text2;
    String text3;
    String text4;
    int score;
    String[] allResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        choice = new ArrayList<String>();
        dbMain = new DB(getApplicationContext());
        db = dbMain.getWritableDatabase();
        String select = "SELECT * FROM " + DB.TABLE_PICTURE_NAME;
        cursor = db.rawQuery(select, null);
        cursor.moveToFirst();
        allResult = getResultString();
        result = allResult[0];
        score = 0;
        String firstResult = cursor.getString(cursor.getColumnIndex(DB.COL_PICTURE_RESULT));
        choice.add(firstResult);
        getChoice(allResult);
        img = (ImageView) findViewById(R.id.imageView2);
        btn1 = (Button) findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);
        countRount = 0;
        setView();


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++countRount;
                if(text1.equals(result)) {
                    score++;
                    Context context = getApplicationContext();
                    CharSequence text = "ถูก";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else {
                    Context context = getApplicationContext();
                    CharSequence text = "ผิด";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                if(countRount == 9) {
                    alertShow();
                }
                cursor.moveToNext();
                result = allResult[countRount];
                choice = new ArrayList<String>();
                choice.add(result);
                getChoice(allResult);
                setView();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++countRount;
                if(text2.equals(result)) {
                    score++;
                    Context context = getApplicationContext();
                    CharSequence text = "ถูก";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else {
                    Context context = getApplicationContext();
                    CharSequence text = "ผิด";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }

                if(countRount == 9) {
                    alertShow();
                }
                cursor.moveToNext();
                result = allResult[countRount];
                choice = new ArrayList<String>();
                choice.add(result);
                getChoice(allResult);
                setView();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++countRount;
                if(text3.equals(result)) {
                    score++;
                    Context context = getApplicationContext();
                    CharSequence text = "ถูก";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else {
                    Context context = getApplicationContext();
                    CharSequence text = "ผิด";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                if(countRount == 9) {
                    alertShow();
                }
                cursor.moveToNext();
                result = allResult[countRount];
                choice = new ArrayList<String>();
                choice.add(result);
                getChoice(allResult);
                setView();
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++countRount;
                if(text4.equals(result)) {
                    score++;
                    Context context = getApplicationContext();
                    CharSequence text = "ถูก";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else {
                    Context context = getApplicationContext();
                    CharSequence text = "ผิด";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                if(countRount == 9) {
                    alertShow();
                }
                cursor.moveToNext();
                result = allResult[countRount];
                choice = new ArrayList<String>();
                choice.add(result);
                getChoice(allResult);
                setView();
            }
        });
    }

    private void alertShow() {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("Your Score is " + score);
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Play Again",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(GameActivity.this, GameActivity.class);
                        startActivity(intent);
                        dialog.cancel();
                    }
                });

        builder1.setNegativeButton(
                "Closed",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                        System.exit(0);
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

    private void setView() {
        int id = this.getResources().getIdentifier(String.valueOf(cursor.getString(cursor.getColumnIndex(DB.COL_PICTURE_NAMEFILE)).charAt(0)), "drawable", this.getPackageName());
        img.setImageResource(id);
        btn1.setText(choice.get(0));
        text1 = choice.get(0);
        btn2.setText(choice.get(1));
        text2 = choice.get(1);
        btn3.setText(choice.get(2));
        text3 = choice.get(2);
        btn4.setText(choice.get(3));
        text4 = choice.get(3);
    }

    private void getChoice(String[] str) {
        while(choice.size() < 4) {
            int ran = (int)(Math.random()*10);
            String s = str[ran];
            if(!isInList(s)) {
                choice.add(s);
            }
        }
        Collections.shuffle(choice);
    }

    private boolean isInList(String str) {
        for(int i = 0; i < choice.size(); ++i) {
            if(str.equals(choice.get(i))) {
                return true;
            }
        }
        return false;
    }

    private String[] getResultString() {
        String select = "SELECT " + DB.COL_PICTURE_RESULT + " FROM " + DB.TABLE_PICTURE_NAME;
        Cursor cursor = db.rawQuery(select, null);
        cursor.moveToFirst();
        String[] str = new String[10];
        for(int i = 0; i < 10; ++i) {
            str[i] = cursor.getString(cursor.getColumnIndex(DB.COL_PICTURE_RESULT));
            cursor.moveToNext();
        }
        return str;
    }
}

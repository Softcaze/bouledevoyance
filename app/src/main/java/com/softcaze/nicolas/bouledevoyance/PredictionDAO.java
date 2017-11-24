package com.softcaze.nicolas.bouledevoyance;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.Date;

/**
 * Created by Nicolas on 20/11/2017.
 */

public class PredictionDAO {
    protected final int VERSION = 3;
    protected final String NOM_DB = "bouledatabase.db";

    public static final String NOM_TABLE = "prediction";
    public static final String COL_ID = "id";
    public static final int NUM_COL_ID = 0;
    public static final String COL_TEXT = "text";
    public static final int NUM_COL_TEXT = 1;
    public static final String COL_DEJA_LU = "deja_lu";
    public static final int NUM_COL_DEJA_LU = 2;

    public static final String NOM_TABLE_NBR_PREDICT = "nbr_predict";
    public static final String COL_NBR = "nbr";
    public static final int NUM_COL_NBR = 0;
    public static final String COL_DATE_PREDICT = "date_predict";
    public static final int NUM_COL_DATE_PREDICT = 1;

    protected SQLiteDatabase database;
    protected DatabaseHandler handler;

    public PredictionDAO(Context context)
    {
        handler = new DatabaseHandler(context, NOM_DB, null, VERSION);
        // TODO Auto-generated constructor stub
    }

    public void open()
    {
        database = handler.getWritableDatabase();
    }

    public void close()
    {
        database.close();
    }

    public SQLiteDatabase getDatabase()
    {
        return database;
    }

    public void insertFirstTime(String d){
        Cursor c = database.rawQuery("SELECT * FROM " + NOM_TABLE, null);

        if(c.getCount() == 0){
            ContentValues value = new ContentValues();
            value.put(COL_NBR, 0);
            value.put(COL_DATE_PREDICT, d);
            database.insert(NOM_TABLE_NBR_PREDICT, null, value);

            value = new ContentValues();
            value.put(COL_TEXT, "Ne jouez pas aux jeux d’argent cette semaine !");
            value.put(COL_DEJA_LU, 0);
            database.insert(NOM_TABLE, null, value);

            value = new ContentValues();
            value.put(COL_TEXT, "Vous allez prochainement faire une rencontre qui va changer votre vie !");
            value.put(COL_DEJA_LU, 0);
            database.insert(NOM_TABLE, null, value);

            value = new ContentValues();
            value.put(COL_TEXT, "En un regard, vous saurez qui est la personne que vous attendez.");
            value.put(COL_DEJA_LU, 0);
            database.insert(NOM_TABLE, null, value);

            value = new ContentValues();
            value.put(COL_TEXT, "Dans les prochains jours, un sourire illuminera votre vie !");
            value.put(COL_DEJA_LU, 0);
            database.insert(NOM_TABLE, null, value);

            value = new ContentValues();
            value.put(COL_TEXT, "Une énorme surprise vous attend dans les jours à venir !");
            value.put(COL_DEJA_LU, 0);
            database.insert(NOM_TABLE, null, value);

            value = new ContentValues();
            value.put(COL_TEXT, "Votre bonheur peut dépendre de votre façon de penser.");
            value.put(COL_DEJA_LU, 0);
            database.insert(NOM_TABLE, null, value);

            value = new ContentValues();
            value.put(COL_TEXT, "Une personne proche de vous souffre en secret !");
            value.put(COL_DEJA_LU, 0);
            database.insert(NOM_TABLE, null, value);

            value = new ContentValues();
            value.put(COL_TEXT, "Vos désirs ont tendances à être surréalistes !");
            value.put(COL_DEJA_LU, 0);
            database.insert(NOM_TABLE, null, value);

            value = new ContentValues();
            value.put(COL_TEXT, "Vous devriez penser à chercher un voyage, cela vous permettra de vous ressourcer.");
            value.put(COL_DEJA_LU, 0);
            database.insert(NOM_TABLE, null, value);

            value = new ContentValues();
            value.put(COL_TEXT, "Vous devriez tenter votre chance plus souvent !");
            value.put(COL_DEJA_LU, 0);
            database.insert(NOM_TABLE, null, value);

            value = new ContentValues();
            value.put(COL_TEXT, "Ne réfutez pas vos désirs !");
            value.put(COL_DEJA_LU, 0);
            database.insert(NOM_TABLE, null, value);

            value = new ContentValues();
            value.put(COL_TEXT, "Une éclaircie dans votre vie est à venir !");
            value.put(COL_DEJA_LU, 0);
            database.insert(NOM_TABLE, null, value);

            value = new ContentValues();
            value.put(COL_TEXT, "Vous avez beaucoup souffert dans votre vie, continuez à garder du courage.");
            value.put(COL_DEJA_LU, 0);
            database.insert(NOM_TABLE, null, value);

            value = new ContentValues();
            value.put(COL_TEXT, "Un nouveau départ pourrait vous apporter beaucoup de surprises !");
            value.put(COL_DEJA_LU, 0);
            database.insert(NOM_TABLE, null, value);

            value = new ContentValues();
            value.put(COL_TEXT, "Si vous partez loin, l’amour vous tendra les bras !");
            value.put(COL_DEJA_LU, 0);
            database.insert(NOM_TABLE, null, value);

            value = new ContentValues();
            value.put(COL_TEXT, "Que vous soyez seule ou en couple, attendez-vous à ce que l’amour soit au centre de tout.");
            value.put(COL_DEJA_LU, 0);
            database.insert(NOM_TABLE, null, value);

            value = new ContentValues();
            value.put(COL_TEXT, "La semaine prochaine sera palpitante côté amour pour vous !");
            value.put(COL_DEJA_LU, 0);
            database.insert(NOM_TABLE, null, value);

            value = new ContentValues();
            value.put(COL_TEXT, "Il y a des risques que votre avenir amoureux soit sombre si vous privilégiez votre travail ou vos études.");
            value.put(COL_DEJA_LU, 0);
            database.insert(NOM_TABLE, null, value);

            value = new ContentValues();
            value.put(COL_TEXT, "Ne vous laissez pas décourager par votre travail !");
            value.put(COL_DEJA_LU, 0);
            database.insert(NOM_TABLE, null, value);

            value = new ContentValues();
            value.put(COL_TEXT, "Vous avez un de vos amis qui attend un signe venant de vous, mais vous avez peur de quelque chose…");
            value.put(COL_DEJA_LU, 0);
            database.insert(NOM_TABLE, null, value);

            value = new ContentValues();
            value.put(COL_TEXT, "Vous regrettez des erreurs mais on ne peut pas revenir en arrière, acceptez-les.");
            value.put(COL_DEJA_LU, 0);
            database.insert(NOM_TABLE, null, value);

            value = new ContentValues();
            value.put(COL_TEXT, "Ne vous enfermez pas dans votre passé, votre avenir peut être angélique.");
            value.put(COL_DEJA_LU, 0);
            database.insert(NOM_TABLE, null, value);

            value = new ContentValues();
            value.put(COL_TEXT, "Vous êtes en manque de câlins. Vous aimeriez qu’on vous en propose plus souvent.");
            value.put(COL_DEJA_LU, 0);
            database.insert(NOM_TABLE, null, value);

            value = new ContentValues();
            value.put(COL_TEXT, "Il ne faut pas avoir peur de vous exprimer mais il vaut mieux trouver des arguments solides pour vous défendre.");
            value.put(COL_DEJA_LU, 0);
            database.insert(NOM_TABLE, null, value);

            value = new ContentValues();
            value.put(COL_TEXT, "Une personne vous reproche de ne pas assez sourire, elle a raison. Profitez de la vie !");
            value.put(COL_DEJA_LU, 0);
            database.insert(NOM_TABLE, null, value);

            value = new ContentValues();
            value.put(COL_TEXT, "Vous allez être sur un petit nuage avec votre partenaire et oublier vos soucis. Les célibataires, des manifestations d’affection vont vous arriver, ça sera le moment d’approfondir un lien amoureux.");
            value.put(COL_DEJA_LU, 0);
            database.insert(NOM_TABLE, null, value);

            value = new ContentValues();
            value.put(COL_TEXT, "Ne comptez pas sur les autres pour trouver la force de faire avancer votre vie !");
            value.put(COL_DEJA_LU, 0);
            database.insert(NOM_TABLE, null, value);

            value = new ContentValues();
            value.put(COL_TEXT, "N’oubliez jamais vos objectifs dans la vie !");
            value.put(COL_DEJA_LU, 0);
            database.insert(NOM_TABLE, null, value);

            value = new ContentValues();
            value.put(COL_TEXT, "Vous risquez de vous disputer avec une amie, mais elle reviendra vite vers vous car elle tient à vous.");
            value.put(COL_DEJA_LU, 0);
            database.insert(NOM_TABLE, null, value);

            value = new ContentValues();
            value.put(COL_TEXT, "Vous regrettez de ne pas lui avoir dit assez souvent « je t’aime » !");
            value.put(COL_DEJA_LU, 0);
            database.insert(NOM_TABLE, null, value);

            value = new ContentValues();
            value.put(COL_TEXT, "Une période positive s’annonce à l’horizon.");
            value.put(COL_DEJA_LU, 0);
            database.insert(NOM_TABLE, null, value);

            value = new ContentValues();
            value.put(COL_TEXT, "Une personne de votre entourage vous veut du mal.");
            value.put(COL_DEJA_LU, 0);
            database.insert(NOM_TABLE, null, value);

            value = new ContentValues();
            value.put(COL_TEXT, "Vous risquez de souffrir dans peu de temps mais gardez espoir.");
            value.put(COL_DEJA_LU, 0);
            database.insert(NOM_TABLE, null, value);

            value = new ContentValues();
            value.put(COL_TEXT, "Vous avez besoin d’être aimé(e) et admiré(e), et pourtant vous êtes critique avec vous-même.");
            value.put(COL_DEJA_LU, 0);
            database.insert(NOM_TABLE, null, value);

            value = new ContentValues();
            value.put(COL_TEXT, "La semaine prochaine sera palpitante côté travail pour toi.");
            value.put(COL_DEJA_LU, 0);
            database.insert(NOM_TABLE, null, value);

            value = new ContentValues();
            value.put(COL_TEXT, "Une personne de votre entourage fait tout pour vous rendre heureux(se).");
            value.put(COL_DEJA_LU, 0);
            database.insert(NOM_TABLE, null, value);

            value = new ContentValues();
            value.put(COL_TEXT, "Vous allez être surpris par un membre de votre famille dans les jours à venir.");
            value.put(COL_DEJA_LU, 0);
            database.insert(NOM_TABLE, null, value);

            value = new ContentValues();
            value.put(COL_TEXT, "Ne faites pas attention aux regards des autres.");
            value.put(COL_DEJA_LU, 0);
            database.insert(NOM_TABLE, null, value);

            value = new ContentValues();
            value.put(COL_TEXT, "Ayez plus confiance en vous.");
            value.put(COL_DEJA_LU, 0);
            database.insert(NOM_TABLE, null, value);

            value = new ContentValues();
            value.put(COL_TEXT, "Mangez bien, riez souvent, aimez beaucoup, cela peut vous apportez que du bonheur au quotidien.");
            value.put(COL_DEJA_LU, 0);
            database.insert(NOM_TABLE, null, value);

            value = new ContentValues();
            value.put(COL_TEXT, "Ne prenez pas tout au premier degré, pensez à relativiser.");
            value.put(COL_DEJA_LU, 0);
            database.insert(NOM_TABLE, null, value);
        }
    }

    public Prediction getRandomPrediction(){
        Prediction predic = null;
        int MAX = 0;

        Cursor c = database.rawQuery("SELECT * FROM " + NOM_TABLE + " WHERE " + COL_DEJA_LU + " = 0", null);

        MAX = c.getCount();

        if(MAX == 0)
        {
            resetDejaLu();
            //getRandomPrediction();
        }
        else{
            int random = 0 + (int)(Math.random() * ((MAX - 1 - 0) + 1));

            for (int i =0; i < random; i++){
                c.moveToNext();
            }

            c.moveToPosition(random);

            int ID = c.getInt(NUM_COL_ID);

            predic = new Prediction(c.getInt(NUM_COL_ID), c.getString(NUM_COL_TEXT), c.getInt(NUM_COL_DEJA_LU));

            ContentValues value = new ContentValues();
            value.put(COL_DEJA_LU, 1);

            database.update(NOM_TABLE, value, COL_ID + " = " + ID, null);

            return predic;
        }

        return null;
    }

    public void resetDejaLu(){
        ContentValues value = new ContentValues();
        value.put(COL_DEJA_LU, 0);

        database.update(NOM_TABLE, value, null, null);
    }

    public boolean usedFullPredictToday(String d){
        Cursor c = database.rawQuery("SELECT * FROM " + NOM_TABLE_NBR_PREDICT, null);

        c.moveToFirst();

        if(c.getString(NUM_COL_DATE_PREDICT).equals(d)){
            if(c.getInt(NUM_COL_NBR) > 4){
                return true;
            }
            else {
                int compteur = c.getInt(NUM_COL_NBR) + 1;

                ContentValues value = new ContentValues();
                value.put(COL_NBR, compteur);

                database.update(NOM_TABLE_NBR_PREDICT, value, null, null);

                return false;
            }
        }
        else{
            // UPDATE TABLE
            ContentValues value = new ContentValues();
            value.put(COL_DATE_PREDICT, d);
            value.put(COL_NBR, 0);

            database.update(NOM_TABLE_NBR_PREDICT, value, null, null);

            return false;
        }
    }
}

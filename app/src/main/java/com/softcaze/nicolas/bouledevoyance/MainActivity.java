package com.softcaze.nicolas.bouledevoyance;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends Activity implements RewardedVideoAdListener {
    ImageView imgBoule = null;
    TextView txtBoule = null;
    PredictionDAO predicDAO = null;
    AlertDialog dialog;
    DateFormat dateFormat = null;
    String today = "";
    RewardedVideoAd mRewardedVideoAd;
    ProgressBar progressBar  = null;
    boolean isVideoLoaded = false;
    boolean isRewarded = false;
    Animation fadeIn;

    MediaPlayer media;
    MediaPlayer touchBall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date todayDate = new Date();
        today = dateFormat.format(todayDate);

        media = MediaPlayer.create(getApplicationContext(), R.raw.ambiance);
        touchBall = MediaPlayer.create(getApplicationContext(), R.raw.touch_ball);
        media.start();

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        imgBoule = (ImageView) findViewById(R.id.boule_img);
        txtBoule = (TextView) findViewById(R.id.txt_boule);

        predicDAO = new PredictionDAO(this);

        // ADs Video
        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        mRewardedVideoAd.setRewardedVideoAdListener(this);

        loadRewardedVideoAd();

        // ADs BANNER
        AdView adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().setRequestAgent("android_studio:ad_template").build();

        adView.loadAd(adRequest);

        // Animvation
        fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setInterpolator(new DecelerateInterpolator()); //add this
        fadeIn.setDuration(4000);

        /*final Animation fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setInterpolator(new AccelerateInterpolator()); //and this
        //fadeOut.setStartOffset(2000);
        fadeOut.setDuration(2000);*/

        /*final AnimationSet animation = new AnimationSet(false); //change to false
        animation.addAnimation(fadeOut);
        animation.addAnimation(fadeIn);
        txtBoule.setAnimation(animation);*/

        // DIALOG BUILDER
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // ADD TITLE & MESSAGE
        builder.setMessage("La boule de voyance vous a fait assez de prédictions pour ajourd'hui. \nRevenez demain ou regardez une vidéo.")
                .setTitle("Avertissement");


        // ADD BUTTON OK
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // Lancer la pub vidéo
                if (mRewardedVideoAd.isLoaded()) {
                    mRewardedVideoAd.show();
                }
                else{
                    progressBar.setVisibility(View.VISIBLE);
                    new loadAdsVideo().execute((Void) null);
                }
            }
        });

        // ADD BUTTON CANCEL
        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // Ne rien faire
            }
        });


        dialog = builder.create();

        predicDAO.open();

        predicDAO.insertFirstTime(today);

        predicDAO.close();

        imgBoule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            if(progressBar.getVisibility() == View.INVISIBLE){
                predicDAO.open();
                if(!predicDAO.usedFullPredictToday(today)){

                    touchBall.setVolume((float) 0.80, (float) 0.80);
                    touchBall.start();

                    Prediction p = predicDAO.getRandomPrediction();

                    if(p == null){
                        p = predicDAO.getRandomPrediction();
                    }

                    txtBoule.startAnimation(fadeIn);
                    txtBoule.setText("La boule vous répond : \n" + p.getTxt());
                }
                else{
                    dialog.show();
                }

                predicDAO.close();
            }
            }
        });

        txtBoule.startAnimation(fadeIn);
    }

    private void loadRewardedVideoAd() {
        mRewardedVideoAd.loadAd("ca-app-pub-9468199307439621/5759611922",
                new AdRequest.Builder().build());
    }

    @Override
    protected void onPause() {
        mRewardedVideoAd.pause(this);

        try{
            media.stop();
        }
        catch (Exception e){
            ;
        }

        super.onPause();
    }

    @Override
    public void onDestroy() {
        mRewardedVideoAd.destroy(this);
        super.onDestroy();
    }

    @Override
    public void onResume() {
        mRewardedVideoAd.resume(this);

        media = MediaPlayer.create(getApplicationContext(), R.raw.ambiance);
        media.start();
        super.onResume();

    }

    @Override
    public void onRewardedVideoAdLoaded() {
        isVideoLoaded = true;
    }

    @Override
    public void onRewardedVideoAdOpened() {

    }

    @Override
    public void onRewardedVideoStarted() {

    }

    @Override
    public void onRewardedVideoAdClosed() {
        isVideoLoaded = false;
        loadRewardedVideoAd();

        if(isRewarded){
            touchBall.setVolume((float) 0.80, (float) 0.80);
            touchBall.start();

            txtBoule.startAnimation(fadeIn);

            isRewarded = false;
        }
    }

    @Override
    public void onRewarded(RewardItem rewardItem) {
        predicDAO.open();
        Prediction p = predicDAO.getRandomPrediction();

        if(p == null){
            p = predicDAO.getRandomPrediction();
        }

        predicDAO.close();

        txtBoule.setText("La boule vous répond : \n" + p.getTxt());

        isRewarded = true;
    }

    @Override
    public void onRewardedVideoAdLeftApplication() {

    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {
        isVideoLoaded = false;
        loadRewardedVideoAd();
    }

    private class loadAdsVideo extends AsyncTask<Void, Void, Void>{
        @Override
        protected Void doInBackground(Void... voids) {
            while(!isVideoLoaded){

            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            progressBar.setVisibility(View.INVISIBLE);

            mRewardedVideoAd.show();
        }
    }
}

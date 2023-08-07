package com.example.spinthebottle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView bot;
    private Random rand=new Random();
    private int lstdr;
    private boolean spn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bot = findViewById(R.id.imageView);
        bot.setOnClickListener(new View.OnClickListener() {
            @Override
            //onclick on image
            public void onClick(View v) {
                //check if the bottle has stopped spinning
                if(!spn) {

                    //generate a random number from 1-1800
                    int num = rand.nextInt(1800);

                    //set the pivot to the center of the image
                    //px-pivotX   py-pivotY
                    float px = bot.getWidth() / 2;
                    float py = bot.getHeight() / 2;

                    //pass parameters in rotate animation function
                    Animation rot = new RotateAnimation(lstdr, num, px, py);

                    //rotation duration
                    rot.setDuration(2500);

                    //rotation will continue after bottle stop spinning
                    rot.setFillAfter(true);
                    rot.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                            spn = true;
                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            spn = false;
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });

                    //change the last direction
                    lstdr = num;

                    //start animation
                    bot.startAnimation(rot);
                }
            }
        });
    }

}
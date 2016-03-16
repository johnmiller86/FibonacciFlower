package com.twh5257_jdm5908_bw.ist402.fibonacciflower;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<ImageView> allPetals;
    private LayoutInflater layoutInflater;
    private Button pinkBtn, goldBtn, clearBtn;
    private RelativeLayout relativeLayout;
    Flower myFlower;
    private int width, height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myFlower = new Flower();
        allPetals = new ArrayList<>();
        initialize();
        layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout1);

        relativeLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                relativeLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                width = relativeLayout.getWidth();
                height = relativeLayout.getHeight();
            }
        });

        pinkBtn = (Button) findViewById(R.id.button1);
        goldBtn = (Button) findViewById(R.id.button2);
        clearBtn = (Button) findViewById(R.id.button3);
        pinkBtn.setOnClickListener(addPetal);
        goldBtn.setOnClickListener(addPetal);
        clearBtn.setOnClickListener(clearPetals);
    }

    private void initialize(){
        myFlower.setRotate(0);
        myFlower.setScaleX((float) .3);
        myFlower.setScaleY((float) .3);
        myFlower.setDegenerate((float) 1.001);
        myFlower.initializeAngle();
    }

    private View.OnClickListener addPetal = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            ImageView petal;
            String buttonText = ((Button) v).getText().toString();
            if (buttonText.equals("Add Pink")){
                petal = (ImageView) layoutInflater.inflate(R.layout.petal_pink, null);
            }
            else{
                petal = (ImageView) layoutInflater.inflate(R.layout.petal_gold, null);
            }
            petal.setX(width / 2 - width / 8);
            petal.setY(height / 2 - 32);
            petal.setPivotX(100);
            petal.setPivotY(0);
            petal.setScaleX(myFlower.getScaleX());
            petal.setScaleY(myFlower.getScaleY());
            float x = petal.getX();
            float y =  petal.getY();
            float petalWidth = petal.getWidth();
            float petalIntrinsicWidth = petal.getDrawable().getIntrinsicWidth();
            float petalHeight = petal.getHeight();
            float petalIntrinsicHeight = petal.getDrawable().getIntrinsicWidth();
            petal.setRotation(myFlower.getRotate());
            relativeLayout.addView(petal, 0);
            allPetals.add(petal);
            myFlower.updatePetalValues();
        }
    };

    private View.OnClickListener clearPetals = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            for (int i = 0; i < allPetals.size(); i++){
                ImageView petal = allPetals.get(i);
                relativeLayout.removeView(petal);
            }
            allPetals.clear();
            initialize();
        }
    };
}

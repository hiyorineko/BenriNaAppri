package com.example.hiyoriaya.aug0114;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class YGO extends Activity implements View.OnClickListener{

    private TextView lpy;
    private TextView lpe;
    private int lpyn;
    private int lpen;
    private CheckBox modec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ygo);
        RelativeLayout rl= (RelativeLayout)findViewById(R.id.rl);
        rl.setBackgroundColor(Color.WHITE);

        lpy = (TextView)findViewById(R.id.lpy);
        lpe = (TextView)findViewById(R.id.lpe);
        lpyn = 8000;
        lpen = 8000;
        lpy.setText("8000");
        lpe.setText("8000");

        modec = (CheckBox)findViewById(R.id.modec);

        Button y1000 = (Button)findViewById(R.id.y1000);
        y1000.setOnClickListener(this);

        Button y500 = (Button)findViewById(R.id.y500);
        y500.setOnClickListener(this);

        Button y100 = (Button)findViewById(R.id.y100);
        y100.setOnClickListener(this);

        Button y50 = (Button)findViewById(R.id.y50);
        y50.setOnClickListener(this);

        Button yharf = (Button)findViewById(R.id.yharf);
        yharf.setOnClickListener(this);

        Button e1000 = (Button)findViewById(R.id.e1000);
        e1000.setOnClickListener(this);

        Button e500 = (Button)findViewById(R.id.e500);
        e500.setOnClickListener(this);

        Button e100 = (Button)findViewById(R.id.e100);
        e100.setOnClickListener(this);

        Button e50 = (Button)findViewById(R.id.e50);
        e50.setOnClickListener(this);

        Button eharf = (Button)findViewById(R.id.eharf);
        eharf.setOnClickListener(this);

        Button reset = (Button)findViewById(R.id.reset);
        reset.setOnClickListener(this);
    }
    public void onClick(View v){
        if(modec.isChecked() == true) {
            switch (v.getId()) {
                case R.id.y1000:
                    lpyn = lpyn + 1000;
                    lpy.setText(String.valueOf(lpyn));
                    break;

                case R.id.y500:
                    lpyn = lpyn + 500;
                    lpy.setText(String.valueOf(lpyn));
                    break;

                case R.id.y100:
                    lpyn = lpyn + 100;
                    lpy.setText(String.valueOf(lpyn));
                    break;

                case R.id.y50:
                    lpyn = lpyn + 50;
                    lpy.setText(String.valueOf(lpyn));
                    break;

                case R.id.yharf:
                    lpyn = lpyn / 2;
                    lpy.setText(String.valueOf(lpyn));
                    break;

                case R.id.e1000:
                    lpen = lpen + 1000;
                    lpe.setText(String.valueOf(lpen));
                    break;

                case R.id.e500:
                    lpen = lpen + 500;
                    lpe.setText(String.valueOf(lpen));
                    break;

                case R.id.e100:
                    lpen = lpen + 100;
                    lpe.setText(String.valueOf(lpen));
                    break;

                case R.id.e50:
                    lpen = lpen + 50;
                    lpe.setText(String.valueOf(lpen));
                    break;

                case R.id.eharf:
                    lpen = lpen / 2;
                    lpe.setText(String.valueOf(lpen));
                    break;

                case R.id.reset:
                    lpyn = 8000;
                    lpen = 8000;
                    lpy.setText(String.valueOf(lpyn));
                    lpe.setText(String.valueOf(lpen));
            }

        }else{

            switch(v.getId()){
                case R.id.y1000:
                    lpyn = lpyn - 1000;
                    lpy.setText(String.valueOf(lpyn));
                    break;

                case R.id.y500:
                    lpyn = lpyn - 500;
                    lpy.setText(String.valueOf(lpyn));
                    break;

                case R.id.y100:
                    lpyn = lpyn - 100;
                    lpy.setText(String.valueOf(lpyn));
                    break;

                case R.id.y50:
                    lpyn = lpyn - 50;
                    lpy.setText(String.valueOf(lpyn));
                    break;

                case R.id.yharf:
                    lpyn = lpyn/2;
                    lpy.setText(String.valueOf(lpyn));
                    break;

                case R.id.e1000:
                    lpen = lpen - 1000;
                    lpe.setText(String.valueOf(lpen));
                    break;

                case R.id.e500:
                    lpen = lpen - 500;
                    lpe.setText(String.valueOf(lpen));
                    break;

                case R.id.e100:
                    lpen = lpen - 100;
                    lpe.setText(String.valueOf(lpen));
                    break;

                case R.id.e50:
                    lpen = lpen - 50;
                    lpe.setText(String.valueOf(lpen));
                    break;

                case R.id.eharf:
                    lpen = lpen/2;
                    lpe.setText(String.valueOf(lpen));
                    break;

                case R.id.reset:
                    lpyn = 8000;
                    lpen = 8000;
                    lpy.setText(String.valueOf(lpyn));
                    lpe.setText(String.valueOf(lpen));
            }

        }
    }

    @Override
    public boolean onKeyDown(int keyCode,KeyEvent event){
        if(keyCode == KeyEvent.KEYCODE_BACK){
            Intent menu = new Intent(this,SecondActivity.class);
            startActivity(menu);
            return true;
        }
        return super.onKeyDown(keyCode,event);
    }

}

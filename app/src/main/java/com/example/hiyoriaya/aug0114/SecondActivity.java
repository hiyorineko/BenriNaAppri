package com.example.hiyoriaya.aug0114;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class SecondActivity extends Activity implements View.OnTouchListener{

    private ImageView kisuu;
    private ImageView ygo;
    private ImageView cat;
    private ImageView kaku;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        RelativeLayout rl= (RelativeLayout)findViewById(R.id.rl);
        rl.setBackgroundColor(Color.WHITE);

        kisuu = (ImageView)findViewById(R.id.kisuu);
        kisuu.setOnTouchListener(this);
        ygo = (ImageView)findViewById(R.id.ygo);
        ygo.setOnTouchListener(this);
        cat = (ImageView)findViewById(R.id.cat);
        cat.setOnTouchListener(this);
        kaku = (ImageView)findViewById(R.id.kaku);
        kaku.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v,MotionEvent e){
        if(e.getAction() == e.ACTION_UP) {
            switch (v.getId()) {

                case R.id.kisuu:
                    Intent kisuuit = new Intent(this, Kisuu.class);
                    startActivity(kisuuit);
                    break;
                case R.id.ygo:
                    Intent ygoit = new Intent(this, YGO.class);
                    startActivity(ygoit);
                    break;
                case R.id.cat:
                    Toast.makeText(this, "ねこ「にゃーん。」", Toast.LENGTH_LONG).show();
                    break;
                case R.id.kaku:
                    AlertDialog.Builder alkaku = new AlertDialog.Builder(this);
                    alkaku.setTitle("核が発射されました");
                    alkaku.setMessage("都市がまた一つ失われました");
                    alkaku.setPositiveButton("OK", null);
                    alkaku.show();
                    break;
            }
        }
        return true;
    }

}

package com.example.hiyoriaya.aug0114;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Kisuu extends Activity implements View.OnTouchListener, View.OnKeyListener {

    private EditText tf1;
    private Button b1;
    private InputMethodManager inputMethodManager;
    private RelativeLayout rl;
    private TextView ans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kisuu);
        rl= (RelativeLayout)findViewById(R.id.rl);
        rl.setBackgroundColor(Color.WHITE);

        tf1 = (EditText)findViewById(R.id.tf1);
        tf1.setWidth(300);
        tf1.setOnKeyListener(this);
        b1 = (Button)findViewById(R.id.button);
        b1.setOnTouchListener(this);
        inputMethodManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        ans= (TextView)findViewById(R.id.ans);
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

    @Override
    public boolean onTouch(View v,MotionEvent e) {
        if (e.getAction() == e.ACTION_UP) {
            switch (v.getId()) {

                case R.id.button :
                    ans.setText("");
                    SpannableStringBuilder sb = (SpannableStringBuilder)tf1.getText();
                    int input = Integer.parseInt(sb.toString());
                    String conpn = "";
                    int[] pn = new int[16];
                    if(input <65536 && input >=0){
                        for(int i=0;i<16;i++) {
                            if (input != 0) {
                                pn[i] = input % 2;
                                input = input / 2;
                            } else {
                                pn[i] = 0;
                            }
                        }
                        for(int i=15;i>=0;i--){
                            conpn = conpn + (String.valueOf(pn[i]));
                        }
                        ans.setText(conpn);
                    }else{
                        ans.setText("無効な入力です。");
                    }
                    break;
            }
        }
        return true;
    }
        //コールバックとしてonKey()メソッドを定義
        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            //イベントを取得するタイミングには、ボタンが押されてなおかつエンターキーだったときを指定
            if((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)){
                //キーボードを閉じる
                inputMethodManager.hideSoftInputFromWindow(tf1.getWindowToken(), InputMethodManager.RESULT_UNCHANGED_SHOWN);
                return true;
            }

            return false;
        }

}

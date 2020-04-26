package com.example.asus.wechatvideoview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * 作者：林冠宏
 * <p>
 * author: LinGuanHong.
 * <p>
 * My GitHub : https://github.com/af913337456/
 * <p>
 * My Blog   : http://www.cnblogs.com/linguanh/
 * <p>
 * on 2017/4/26.
 */

public class WelcomeActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setVerticalGravity(LinearLayout.HORIZONTAL);

        Button cache = new Button(this);
        Button down  = new Button(this);

        cache.setText("cache");
        down .setText("down");

        linearLayout.addView(cache);
        linearLayout.addView(down);

        final Intent intent = new Intent(WelcomeActivity.this,MainActivity.class);
        cache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("useCache",true);
                startActivity(intent);
            }
        });

        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("useCache",false);
                startActivity(intent);
            }
        });

        setContentView(linearLayout);
    }
}

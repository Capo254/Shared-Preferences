package com.example.emobilis.sharedpreferances;

import android.content.SharedPreferences;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button red,green,blue;
    android.support.v7.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        red=findViewById(R.id.button);
        green=findViewById(R.id.button2);
        blue=findViewById(R.id.button3);
        toolbar=findViewById(R.id.toolbar);

        toolbar.setTitle("My Shared Preference");

        if (getColor() !=getResources().getColor(R.color.colorPrimary));
        toolbar.setBackgroundColor(getColor());
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            getWindow().setStatusBarColor(getColor());
        }

        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                toolbar.setBackgroundColor(getResources().getColor(R.color.colorRed));
                if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
                    getWindow().setStatusBarColor(getResources().getColor(R.color.colorRed));
                }
                storeColors(getResources().getColor(R.color.colorRed));

            }
        });
        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toolbar.setBackgroundColor(getResources().getColor(R.color.colorGreen));
                if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
                    getWindow().setStatusBarColor(getResources().getColor(R.color.colorRed));
                }
                storeColors(getResources().getColor(R.color.colorGreen));
            }
        });
        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toolbar.setBackgroundColor(getResources().getColor(R.color.colorBlue));
                if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
                    getWindow().setStatusBarColor(getResources().getColor(R.color.colorBlue));
                }
                storeColors(getResources().getColor(R.color.colorBlue));
            }
        });
    }
    private void storeColors(int color){
        SharedPreferences mSharedPreferences=getSharedPreferences("ToolbarColor",MODE_PRIVATE);
        SharedPreferences.Editor editor=mSharedPreferences.edit();
        editor.putInt("color",color);
        editor.apply();
    }
    private int getColor(){
        SharedPreferences mSharedPreferences=getSharedPreferences("ToolbarColor",MODE_PRIVATE);
        int SelectedColor=mSharedPreferences.getInt("color",getResources().getColor(R.color.colorPrimary));
        return SelectedColor;
    }

}

package com.example.harshasrikara.testapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SecondActivity extends AppCompatActivity{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_3);

    }

    public void assist(View view)
    {
       Intent intent = new Intent(this, ThirdActivity.class);
       startActivity(intent);
    }


    public void idea(View view)
    {
        setContentView(R.layout.layout_4);
    }



}

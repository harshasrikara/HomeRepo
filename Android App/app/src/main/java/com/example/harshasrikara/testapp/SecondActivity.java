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

  //  ImageView im = findViewById(R.id.imager);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_3);

    }

    public void assist(View view)
    {
        setContentView(R.layout.layout_2);
        Button btn = findViewById(R.id.button_capture);

     /*   btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
             //   startActivityForResult(intent,0);
            }
        });*/
    }


    public void idea(View view)
    {
        setContentView(R.layout.layout_4);
    }


/*    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode , resultCode, data );
        Bitmap bitmap = (Bitmap) data.getExtras().get("data");
        im.setImageBitmap(bitmap);
    }*/
}

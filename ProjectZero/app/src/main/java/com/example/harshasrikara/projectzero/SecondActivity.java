package com.example.harshasrikara.projectzero;

import android.app.DownloadManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.nfc.Tag;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

public class SecondActivity extends AppCompatActivity {


    Button btnpic;
    ImageView imgTakenPic;
    ByteArrayOutputStream stream;
    private static final int CAM_REQUEST=1313;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_2);

        btnpic = (Button) findViewById(R.id.button);
        imgTakenPic = (ImageView)findViewById(R.id.imageView);
        btnpic.setOnClickListener(new btnTakePhotoClicker());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == CAM_REQUEST) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imgTakenPic.setImageBitmap(bitmap);
            Button btn = findViewById(R.id.send);
            btn.setVisibility(View.VISIBLE);
            stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);


        }
    }
    public void sendReq(View view)
    {
        byte[] byteImage_photo =  stream.toByteArray();
        final String encodedImage = Base64.encodeToString(byteImage_photo,Base64.DEFAULT);
        String URL = "https://k38qggm8ak.execute-api.us-east-1.amazonaws.com/default/ImageAPI";
         /*       "https://raw.githubusercontent.com/google/web-starter-kit/master/app/manifest" ;

                .json";
*/
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest
                (Request.Method.POST, URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    //    Log.d("app", response.toString());
                        TextView t = findViewById(R.id.hi);
                        Log.e("error","error");
                        if(response==null)
                        {
                            t.setText("it returned null");
                        }
                        else {
                            t.setText(response);
                        }
                    }},
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.e("error",  "Error");
                            }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();

                params.put("comment", encodedImage);
                Log.e("Image", "Encoded Image: " + encodedImage);

                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/json");
                return params;
            }
        };

        queue.add(stringRequest);
    }

    class btnTakePhotoClicker implements  Button.OnClickListener{

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent,CAM_REQUEST);
        }
    }

}
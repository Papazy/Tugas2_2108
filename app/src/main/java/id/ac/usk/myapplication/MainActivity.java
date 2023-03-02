package id.ac.usk.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    String[] arr = {"logo_unsyiah.png", "logo_unsyiah_2.png", "logo_informatika.png"};
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView iv = findViewById(R.id.logoUSK);
        // Load Gambar 1

        try {
            InputStream ip = getAssets().open(arr[0]);
            Drawable img1 = Drawable.createFromStream(ip, null);
            iv.setImageDrawable(img1);
            index = 0;
        } catch (Exception e) {
            Log.e("Gambar Error", e.getMessage());
        }
    }
    public void tombolAsset(View view){
        Drawable img;
        ImageView iv = findViewById(R.id.logoUSK);
        if(index == arr.length - 1){
            index = 0;
        }else{
            index++;
        }
        try{
            InputStream ip = getAssets().open(arr[index]);
            img = Drawable.createFromStream(ip, null);
            iv.setImageDrawable(img);
        }catch(Exception e){
            Log.e("Error Gambar", e.getMessage());
        }
    }
}
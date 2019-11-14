package com.example.allseries;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SerieActivity extends AppCompatActivity {

    private TextView tvtitle, tvcategory, tvdescription;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serie);

        tvtitle = findViewById(R.id.txtTitle);
        tvcategory = findViewById(R.id.txtCat);
        tvdescription = findViewById(R.id.txtDesc);
        img = findViewById(R.id.seriethumbnail);

        Intent intent = getIntent();
        String Title = intent.getExtras().getString("Title");
        String Description = intent.getExtras().getString("Description");
        int Image = intent.getExtras().getInt("Thumbnail");

        tvtitle.setText(Title);
        tvdescription.setText(Description);
        img.setImageResource(Image);

    }
}

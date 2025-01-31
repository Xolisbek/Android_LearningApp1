package uz.kholisbek.myaplicationforlearning;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import org.chromium.base.Callback;

public class DownloadingImagesFromInternet extends AppCompatActivity {

    private ImageView imageView;
    private Button btn;

    private ProgressBar progressBar;

    private String url = "https://storage.kun.uz/source/thumbnails/_medium/10/IVhjLTpenc_xMWKs3S1J7obW0aWA-klV_medium.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        findViews
        imageView = findViewById(R.id.image);
        btn = findViewById(R.id.setBtn);
        progressBar = findViewById(R.id.loadingBar);

        btn.setOnClickListener(view -> {
            progressBar.setVisibility(View.VISIBLE);

            Picasso.get().load(url).error(R.drawable.error).into(imageView, new Callback() {
                @Override
                public void onSuccess() {
                    progressBar.setVisibility(View.INVISIBLE);

                }

                @Override
                public void onError(Exception e) {
                    progressBar.setVisibility(View.INVISIBLE);
                    Toast.makeText(DownloadingImagesFromInternet.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        });


    }
}
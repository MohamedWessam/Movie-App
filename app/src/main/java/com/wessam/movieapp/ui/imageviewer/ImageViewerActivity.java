package com.wessam.movieapp.ui.imageviewer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.squareup.picasso.Picasso;
import com.wessam.movieapp.R;
import com.wessam.movieapp.databinding.ActivityImageViewerBinding;
import com.wessam.movieapp.utils.Constants;

public class ImageViewerActivity extends AppCompatActivity {

    private ActivityImageViewerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_image_viewer);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        loadImage();
    }

    private void loadImage() {
        Intent intent = getIntent();
        String url = intent.getStringExtra(Constants.IMAGE_URL_KEY);
        Picasso.get().load(url).placeholder(R.drawable.logo).into(binding.zoomImageView);
    }
}

package com.example.baithi_giuaky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivityB extends AppCompatActivity {
    private ImageView imageView;
    private TextView tvName;
    private TextView tvPrice;

    private ImageButton imgMinus;
    private ImageButton imgAdd;
    private TextView tvQuan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_b);

        imageView = findViewById(R.id.imagesB);
        tvName = findViewById(R.id.tvNameB);
        tvPrice = findViewById(R.id.tvPriceB);

        imgMinus = findViewById(R.id.imgButMinus);
        imgAdd = findViewById(R.id.imgButAdd);
        tvQuan = findViewById(R.id.tvQuanB);

        Intent intent = getIntent();
        Coffee coffee = (Coffee) intent.getSerializableExtra("coffee");

        imageView.setBackgroundResource(coffee.getImagesCoffee());
        tvName.setText(coffee.getNameCoffee());
        tvPrice.setText(coffee.getPriceCoffee()+"$");

        imgMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sl = Integer.parseInt(tvQuan.getText().toString());
                if(sl < 1){
                    tvQuan.setText("0");
                }else{
                    sl--;
                    tvQuan.setText(String.valueOf(sl));
                }
            }
        });
        imgAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sl = Integer.parseInt(tvQuan.getText().toString());
                sl++;
                tvQuan.setText(String.valueOf(sl));
            }
        });
    }
}
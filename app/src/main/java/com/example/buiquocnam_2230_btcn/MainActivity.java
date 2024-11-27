package com.example.buiquocnam_2230_btcn;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private Button btnOk;
    private Button btnBuy;
    private Button btnSell;
    private CheckBox checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        AnhXa();
        sharedPreferences = getSharedPreferences("myChoice",MODE_PRIVATE);

        btnOk.setOnClickListener(v -> {
            savePreference();
            // mo gia dien 2
            boolean remember = checkBox.isChecked();
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);
        });

    }
    private  void AnhXa(){
        btnOk = findViewById(R.id.okBtn);
        btnBuy = findViewById(R.id.buyBtn);
        btnSell = findViewById(R.id.sellBtn);
        checkBox = findViewById(R.id.rmbCb);
    }
    private void savePreference(){
        // Lưu thông tin đăng nhập
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("remember", true);
            editor.apply();
    }
}
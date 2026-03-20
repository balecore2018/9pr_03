package com.example.pr9_03;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.uicomponents.BthBig;
import com.example.uicomponents.BthCustom;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        BthBig bthPrimary = findViewById(R.id.bthPrimary);
        BthBig bthEnable = findViewById(R.id.bthEnable);
        BthBig bthTertiary = findViewById(R.id.bthTertiary);
        BthBig bthSecondary = findViewById(R.id.bthSecondary);

        bthPrimary.init("Отправить", BthCustom.TypeButton.PRIMARY);
        bthEnable.setEnabled(false);
        bthTertiary.init("Авторизоваться", BthCustom.TypeButton.TETRYALY);
        bthSecondary.init("Забыли пароль?", BthCustom.TypeButton.SECONDARY);
    }
}

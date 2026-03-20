package com.example.pr9_03;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.uicomponents.BthBig;
import com.example.uicomponents.BthCustom;
import com.example.uicomponents.edittext.EditTextCustom;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Инициализация кнопок
        BthBig bthPrimary = findViewById(R.id.bthPrimary);
        BthBig bthEnable = findViewById(R.id.bthEnable);
        BthBig bthTertiary = findViewById(R.id.bthTertiary);
        BthBig bthSecondary = findViewById(R.id.bthSecondary);

        // Инициализация EditTextCustom
        EditTextCustom editTextName = findViewById(R.id.editTextName);
        editTextName.init("Укажите фамилию", "Иванов", "123123");

        // Получаем внутренний EditText и добавляем слушатель
        EditText innerEditText = editTextName.getEditText();
        if (innerEditText != null) {
            innerEditText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    String text = s.toString();

                    // Проверка на наличие цифр
                    if (text.matches(".*\\d.*")) {
                        editTextName.setErrorState(true, "Ошибка: фамилия не может содержать цифры");
                    }
                    // Проверка на английские буквы
                    else if (text.matches(".*[a-zA-Z].*")) {
                        editTextName.setErrorState(true, "Ошибка: фамилия должна быть на русском языке");
                    }
                    else {
                        editTextName.setErrorState(false, null);
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {
                }
            });
        }

        // Настройка кнопок
        bthPrimary.init("Отправить", BthCustom.TypeButton.PRIMARY);
        bthPrimary.setOnClickListener(v -> {
            if (editTextName.isValid()) {
                String text = editTextName.getText();
                // Дополнительная проверка при отправке
                if (text.matches(".*\\d.*")) {
                    editTextName.setErrorState(true, "Ошибка: фамилия не может содержать цифры");
                } else if (text.matches(".*[a-zA-Z].*")) {
                    editTextName.setErrorState(true, "Ошибка: фамилия должна быть на русском языке");
                } else {
                    Toast.makeText(this, "Данные отправлены: " + text, Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Исправьте ошибки в поле", Toast.LENGTH_SHORT).show();
            }
        });

        bthEnable.setEnabled(false);
        bthTertiary.init("Авторизоваться", BthCustom.TypeButton.TETRYALY);
        bthSecondary.init("Забыли пароль?", BthCustom.TypeButton.SECONDARY);
    }
}
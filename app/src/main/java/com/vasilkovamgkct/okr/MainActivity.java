package com.vasilkovamgkct.okr;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText inputD1, inputD2, inputGamma;
    private TextView resultView;
    private Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputD1 = findViewById(R.id.editD1);
        inputD2 = findViewById(R.id.editD2);
        inputGamma = findViewById(R.id.editGamma);
        resultView = findViewById(R.id.resultText);
        btnCalculate = findViewById(R.id.calculateButton);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateArea();
            }
        });
    }

    private void calculateArea() {
        try {
            double d1 = Double.parseDouble(inputD1.getText().toString());
            double d2 = Double.parseDouble(inputD2.getText().toString());
            double gamma = Double.parseDouble(inputGamma.getText().toString());

            if (d1 < 0 || d2 < 0 || gamma > 90) {
                showErrorToast("Недопустимые значения");
                return;
            }

            // Перевод угла из градусов в радианы
            double gammaRad = Math.toRadians(gamma);

            // Формула площади
            double area = 0.5 * d1 * d2 * Math.sin(gammaRad);

            resultView.setText(String.format("Площадь: %.3f", area));
        } catch (NumberFormatException e) {
            showErrorToast("Некорректный ввод");
        }
    }

    private void showErrorToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
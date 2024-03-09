package com.example.santiago_aplicacion2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Resultado extends AppCompatActivity {

    Button btnVolverMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultado);

        // Recuperar los valores y el tipo de cálculo del Intent
        double lado1 = getIntent().getDoubleExtra("lado1", 0.0);
        double lado2 = getIntent().getDoubleExtra("lado2", 0.0);
        double angulo = getIntent().getDoubleExtra("angulo", 0.0);
        boolean calcularArea = getIntent().getBooleanExtra("calcularArea", true);
        double seno = getIntent().getDoubleExtra("seno", 0.0);
        double coseno = getIntent().getDoubleExtra("coseno", 0.0);

        // Calcular área y perímetro
        double area = lado1 * lado2;
        double perimetro = 2 * (lado1 + lado2);

        // Mostrar los resultados en TextViews según el tipo de cálculo
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView senoTextView = findViewById(R.id.senoTextView);
        senoTextView.setText("Seno (Ángulo): " + seno);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView cosenoTextView = findViewById(R.id.cosenoTextView);
        cosenoTextView.setText("Coseno (Ángulo): " + coseno);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView resultadoTextView = findViewById(R.id.resultadoTV);

        if (calcularArea) {
            resultadoTextView.setText("Área: " + area);
        } else {
            resultadoTextView.setText("Perímetro: " + perimetro);
        }

        btnVolverMain = findViewById(R.id.volverMain);

        btnVolverMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VolverAlMainActivity(); // Acción para volver al MainActivity
            }
        });
    }

    private void VolverAlMainActivity() {
        Intent intent = new Intent(Resultado.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
package com.example.santiago_aplicacion2;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    EditText lado1, lado2, angulo;
    RadioGroup radioGroup;
    Button calcularButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lado1= findViewById(R.id.lado1);
        lado2 = findViewById(R.id.lado2);
        angulo = findViewById(R.id.angulo);
        radioGroup = findViewById(R.id.rgroup);
        calcularButton = findViewById(R.id.calcularButton);

        calcularButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Llamar al método calcular
                calcular();
            }
        });
    }

    // Método para realizar los cálculos
    private void calcular() {
        // Obtener valores de los EditText
        double l1 = Double.parseDouble(lado1.getText().toString());
        double l2 = Double.parseDouble(lado2.getText().toString());
        double angul = Double.parseDouble(angulo.getText().toString());

        // Obtener el ID del radio button seleccionado
        int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);

        // Crear un Intent para iniciar Resultado
        Intent intent = new Intent(MainActivity.this, Resultado.class);

        // Pasar los valores y el tipo de cálculo como extras al Intent
        intent.putExtra("lado1", l1);
        intent.putExtra("lado2", l2);
        intent.putExtra("angulo", angul);

        // Verificar si el usuario quiere calcular el área o el perímetro
        boolean calcularArea = selectedRadioButton.getText().toString().equals(getString(R.string.area));
        intent.putExtra("calcularArea", calcularArea);

        // Calcular seno y coseno
        double seno = Math.sin(Math.toRadians(angul));
        double coseno = Math.cos(Math.toRadians(angul));
        intent.putExtra("seno", seno);
        intent.putExtra("coseno", coseno);

        // Iniciar la nueva actividad
        startActivity(intent);
    }
}
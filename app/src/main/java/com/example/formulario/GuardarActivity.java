package com.example.formulario;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;




public class GuardarActivity extends AppCompatActivity {


    EditText etNombres, etDatos;
    Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_guardar);


        etNombres = findViewById(R.id.etNombres);
        etDatos = findViewById(R.id.etDatos);
        btnVolver = findViewById(R.id.btnVolver);

        String nombresApellidos = getIntent().getStringExtra("nombres");
        String datosMostrar = "Correo " + getIntent().getStringExtra("correo") + "\nDireccion: " + getIntent().getStringExtra("direccion") + "\nSexo: " + getIntent().getStringExtra("sexo") + "\nOcupacion: " + getIntent().getStringExtra("ocupacion");

        etNombres.setText(nombresApellidos);
        etDatos.setText(datosMostrar);

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volver();
            }
        });




//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
    }

    public void volver(){
        finish();
    }
}
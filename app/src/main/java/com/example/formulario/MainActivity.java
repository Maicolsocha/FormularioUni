package com.example.formulario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    EditText etNombreApellido, etCorreo, etDireccion;
    Spinner spOcupacion;
    RadioGroup rgSexo;
    RadioButton rbMasculino, rbFemenino;
    Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        etNombreApellido = findViewById(R.id.etNombreApellido);
        etCorreo = findViewById(R.id.etCorreo);
        etDireccion = findViewById(R.id.etDireccion);
        spOcupacion = findViewById(R.id.spOcupacion);
        rgSexo = findViewById(R.id.rgSexo);
        rbMasculino = findViewById(R.id.rbMasculino);
        rbFemenino = findViewById(R.id.rbFemenino);
        btnGuardar = findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validar();
            }
        });
    }

    public void validar(){
        if(etNombreApellido.getText().toString().isEmpty() || etCorreo.getText().toString().isEmpty()){
            Toast.makeText(MainActivity.this, "Ingrese Nombres Y Correos", Toast.LENGTH_SHORT).show();
        }else{
            registrar();
            limpiar();
        }
    }

    public void registrar(){
        Intent intent = new Intent(MainActivity.this, GuardarActivity.class);
        intent.putExtra("nombres", etNombreApellido.getText().toString());
        intent.putExtra("correo", etCorreo.getText().toString());
        intent.putExtra("direccion", etDireccion.getText().toString());
        intent.putExtra("ocupacion", spOcupacion.getSelectedItem().toString());
        String sexo = "";
        if(rbMasculino.isChecked()){
            sexo = "Masculino";
        }else{
            sexo = "Femenino";
        }
        intent.putExtra("sexo", sexo);
        startActivity(intent);
    }

    public void limpiar(){
        etNombreApellido.setText("");
        etCorreo.setText("");
        etDireccion.setText("");
        spOcupacion.setSelection(0);
        rgSexo.clearCheck();
        etNombreApellido.requestFocus();
    }


}
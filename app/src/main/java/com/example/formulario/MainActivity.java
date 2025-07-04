package com.example.formulario;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {


    EditText etNombreApellido, etCorreo, etDireccion;
    Spinner spOcupacion;
    RadioGroup rgSexo;
    RadioButton rbMasculino, rbFemenino;
    Button btnGuardar;

    ConstraintLayout main;

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
        main = findViewById(R.id.main);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validar();
            }
        });
        CrearPopup();
    }

    private void CrearPopup() {
        LayoutInflater inflater= (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popUpView=inflater.inflate(R.layout.popup, null);

        int width= ViewGroup.LayoutParams.MATCH_PARENT;
        int height= ViewGroup.LayoutParams.MATCH_PARENT;
        boolean focusable=true;
        PopupWindow popupWindow = new PopupWindow(popUpView, width, height, focusable);
        main.post(new Runnable() {
            @Override
            public void run() {
                popupWindow.showAtLocation(main, Gravity.BOTTOM, 0,0);
            }
        });
        TextView continuar = popUpView.findViewById(R.id.continuar);
        continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        popUpView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
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
package com.example.semana7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.semana7.service.ServiceCategoriaLibro;
import com.example.semana7.service.ServiceLibro;
import com.example.semana7.service.ServicePais;

import java.util.ArrayList;

public class LibroFormularioCrudActivity extends AppCompatActivity {
Button btnEnviar, btnRegresar;
/*Variable global*/
String metodo;
    //Pais
    Spinner spnPais;
    ArrayAdapter<String> adaptadorPais;
    ArrayList<String> paises = new ArrayList<>();

    //Categoria
    Spinner spnCategoria;
    ArrayAdapter<String> adaptadorCategoria;
    ArrayList<String> categorias = new ArrayList<>();

    //Servicio
    ServiceLibro serviceLibro;
    ServicePais servicePais;
    ServiceCategoriaLibro serviceCategoriaLibro;

    EditText txtTitulo, txtAnio, txtSerie;
TextView idTitelPage;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_libro_formulario_crud);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

         metodo =(String)getIntent().getExtras().get("var_metodo");
        idTitelPage=findViewById(R.id.idTitlePage);

         btnEnviar =findViewById(R.id.btnRegLibEnviar);
        btnRegresar=findViewById(R.id.btnRegLibRegresar);

        if(metodo.equals(("REGISTRAR"))){
            idTitelPage.setText(("Registrar Libro"));
            btnEnviar.setText("Registrar");

        }else if(metodo.equals("ACTUALIZAR")){
            idTitelPage.setText(("Actualizar Libro"));
            btnEnviar.setText("Actualizar");
        }


        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LibroFormularioCrudActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });


    }
}
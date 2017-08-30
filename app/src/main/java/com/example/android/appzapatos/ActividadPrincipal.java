package com.example.android.appzapatos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class ActividadPrincipal extends AppCompatActivity {

    private EditText cantidad;
    private TextView total, subtotal;
    private Spinner cmbsexo, cmbtipo, cmbzapato;
    private String[] sexo;
    private String[] tipo;
    private String[] zapato;
    private ArrayAdapter adapter1;
    private ArrayAdapter adapter2;
    private ArrayAdapter adapter3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_principal);

        cantidad = (EditText)findViewById(R.id.txtCantidad);
        total = (TextView)findViewById(R.id.txtTotal);
        subtotal = (TextView)findViewById(R.id.txtSubtotal);
        cmbsexo = (Spinner) findViewById(R.id.cmbSexo);
        cmbtipo = (Spinner)findViewById(R.id.cmbTipo);
        cmbzapato = (Spinner)findViewById(R.id.cmbMarca);

        sexo = this.getResources().getStringArray(R.array.sexo);
        adapter1 = new ArrayAdapter(this,android.R.layout.simple_list_item_1,sexo);
        cmbsexo.setAdapter(adapter1);

        tipo = this.getResources().getStringArray(R.array.tipo);
        adapter2 = new ArrayAdapter(this,android.R.layout.simple_list_item_1,tipo);
        cmbtipo.setAdapter(adapter2);

        zapato = this.getResources().getStringArray(R.array.zapato);
        adapter3 = new ArrayAdapter(this,android.R.layout.simple_list_item_1,zapato);
        cmbzapato.setAdapter(adapter3);

    }

    public void total (View v){

        int opcionSexo, opcionTipo, opcionMarca;
        double resultado = 0, unidad = 0, cant = 0;

        if (validar()){
            opcionSexo = cmbsexo.getSelectedItemPosition();
            opcionTipo = cmbtipo.getSelectedItemPosition();
            opcionMarca = cmbzapato.getSelectedItemPosition();
            cant = Integer.parseInt(cantidad.getText().toString());

            switch (opcionSexo) {
                case 0:
                    switch (opcionTipo) {
                        case 0:
                            switch (opcionMarca) {
                                case 0:
                                    unidad = 120000;
                                    resultado = cant * 120000;
                                    break;
                                case 1:
                                    unidad = 140000;
                                    resultado = cant * 140000;
                                    break;
                                case 2:
                                    unidad = 130000;
                                    resultado = cant * 130000;
                                    break;
                            }
                            break;
                        case 1:
                            switch (opcionMarca) {
                                case 0:
                                    unidad = 50000;
                                    resultado = cant * 50000;
                                    break;
                                case 1:
                                    unidad = 80000;
                                    resultado = cant * 80000;
                                    break;
                                case 2:
                                    unidad = 100000;
                                    resultado = cant * 100000;
                                    break;
                            }
                    }
                    break;
                case 1:
                    switch (opcionTipo) {
                        case 0:
                            switch (opcionMarca) {
                                case 0:
                                    unidad = 100000;
                                    resultado = cant * 100000;
                                    break;
                                case 1:
                                    unidad = 130000;
                                    resultado = cant * 130000;
                                    break;
                                case 2:
                                    unidad = 110000;
                                    resultado = cant * 110000;
                                    break;
                            }
                            break;
                        case 1:
                            switch (opcionMarca) {
                                case 0:
                                    unidad = 60000;
                                    resultado = cant * 60000;
                                    break;
                                case 1:
                                    unidad = 70000;
                                    resultado = cant * 70000;
                                    break;
                                case 2:
                                    unidad = 120000;
                                    resultado = cant * 120000;
                                    break;
                            }

                    }
                    break;

            }
            subtotal.setText(" " + unidad);
            total.setText(" "  + resultado);
        }


    }

    public boolean validar (){
        if (cantidad.getText().toString().isEmpty()){
            cantidad.setError(this.getResources().getString(R.string.errorVacio));
            cantidad.requestFocus();
            return false;
        }
        if (Double.parseDouble(cantidad.getText().toString())==0){
            cantidad.setError(this.getResources().getString(R.string.error2));
            cantidad.requestFocus();
            return false;
        }
        return true;
    }

    public void borrar(View v){
        cantidad.setText("");
        subtotal.setText("");
        total.setText("");
        cantidad.requestFocus();

    }


}

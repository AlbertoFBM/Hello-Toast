package com.albertoserrano.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Variables declaration
    private Button button_toast;
    private Button button_count;
    private TextView textNumber;
    private int numero = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find ID
        button_toast = (Button) findViewById(R.id.button_toast);
        button_count = (Button) findViewById(R.id.button_count);
        textNumber = (TextView) findViewById(R.id.show_count);

        // Create the listener

        button_count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countUpAndShow();
            }
        });

        button_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast();
            }
        });

    }


    private void countUpAndShow(){

        numero ++;
        textNumber.setText(String.valueOf(numero));
    }

    private void showToast(){

        Toast.makeText(getApplicationContext(), "The number is " + numero, Toast.LENGTH_SHORT).show();
    }

    // Para recuperar los datos al hacer LANDSCAPE usamos estos dos métodos
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("NUM", numero);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        numero = savedInstanceState.getInt("NUM");
        textNumber.setText(String.valueOf(numero));
    }
}
package com.projetoapp.gasolinaouetanol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public abstract class MainActivity extends AppCompatActivity {

    private SeekBar seekBarGasolina;
    private SeekBar seekBarEtanol;
    private TextView textGasolina;
    private TextView textEtanol;
    private TextView resultado;
    private TextView valorGasolina;
    private TextView valorEtanol;
    private ImageView imagem;


    private double resultadoGasolina = 0;
    private double resultadoEtanol = 0;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBarGasolina = findViewById(R.id.seekBarGasolina);
        seekBarEtanol = findViewById(R.id.seekBarEtanol);
        resultado = findViewById(R.id.resultado);
        textEtanol = findViewById(R.id.textEtanol);
        textGasolina = findViewById(R.id.textGasolina);
        valorGasolina = findViewById(R.id.valorGasolina);
        valorEtanol = findViewById(R.id.valorEtanol);
        imagem = findViewById(R.id.imagem);

        seekBarGasolina.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                valorGasolina.setText(""+progress);
                resultadoGasolina = progress;


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });

        seekBarEtanol.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                valorEtanol.setText(""+progress);
                resultadoEtanol = progress;

                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        Toast.makeText(this, "Versão final", Toast.LENGTH_SHORT).show();

    }


    public void calcular() {
        double resultado2 = resultadoEtanol / resultadoGasolina;

        if (resultado2 >= 0.7) {
            resultado.setText(R.string.nomeGasolina);
            imagem.setImageResource(R.drawable.gasolina);
        }
        else if(resultado2<=0.7)
            {
                resultado.setText(R.string.nomeEtanol);
                imagem.setImageResource(R.drawable.etanol);
            }
            else
            {
                resultado.setText(" ");
                imagem.setImageResource(R.drawable.logo);

            }

        }






}


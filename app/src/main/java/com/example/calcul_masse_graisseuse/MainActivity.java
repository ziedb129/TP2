package com.example.calcul_masse_graisseuse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView _lblResultat ;
    TextView _lblInterpretation ;
    EditText _txtTaille;
    EditText _txtPoids;
    EditText _txtAge;
    RadioButton _rdbHomme;
    RadioButton _rdbFemme;
    Button _btnCalculIMG;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _txtTaille=(EditText) findViewById(R.id.txtTaille);
        _txtAge=(EditText) findViewById(R.id.txtAge);
        _txtPoids=(EditText) findViewById(R.id.txtPoids);
        _lblResultat=(TextView) findViewById(R.id.lblResultat);
        _lblInterpretation=(TextView) findViewById(R.id.lblInterpretation);
        _rdbHomme=(RadioButton) findViewById(R.id.rdbHomme);
        _rdbFemme=(RadioButton) findViewById(R.id.rdbFemme);
        _btnCalculIMG=(Button) findViewById(R.id.btnCalculIMG);

        _btnCalculIMG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float resIMG=0;
                int Age= Integer.parseInt(_txtAge.getText().toString());
                float Taille = Float.parseFloat(_txtTaille.getText().toString());
                float Poids= Float.parseFloat(_txtPoids.getText().toString());
                float IMC= (float) (Poids / Math.pow(Taille/ 100.0,2));
                if (Age >= 16){
                  if (_rdbHomme.isChecked()){
                      resIMG = (float) (((1.20 * IMC) + (0.23 * Age)) - (10.8 * 1) - 5.4);
                  }else{

                      resIMG = (float) (((1.20 * IMC) + (0.23 * Age)) - (10.8 * 0) - 5.4);
                  }

            } else{
                    if (_rdbHomme.isChecked()){
                        resIMG = (float) (((1.51 * IMC) + (0.70 * Age)) - (3.6 * 1) - 1.4);
                    }else{

                        resIMG = (float) (((1.51 * IMC) + (0.70 * Age)) - (3.6 * 1) - 1.4);
                    }
                }
                _lblResultat.setText("your IMG is" + resIMG+"%");

                if(_rdbHomme.isChecked()){
                    if(resIMG<25){
                        _lblInterpretation.setText("you are very thin");
                    }
                    else if (resIMG>25 && resIMG<31){
                        _lblInterpretation.setText("you  have a normale percentage");
                    }else {
                        _lblInterpretation.setText("you have extra Fat");
                    }
                }else{
                    if(resIMG<15){
                        _lblInterpretation.setText("you are very thin");
                    }
                    else if (resIMG>15 && resIMG<21){
                        _lblInterpretation.setText("you  have a normale percentage");
                    }else {
                        _lblInterpretation.setText("you have extra Fat");
                    }

                }
            }
        } );
    }
}
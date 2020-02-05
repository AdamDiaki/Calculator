package com.example.calculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    int indice;
    String buffer = "";
    String buffer2 = "";

    TextView ZoneVal;
    TextView ZoneVal2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ZoneVal = (TextView) findViewById(R.id.resultat);
        ZoneVal2 = (TextView) findViewById(R.id.resultatBis);

        Button btnEnvoyer1 = (Button) findViewById(R.id.button1);
        btnEnvoyer1.setOnClickListener(btnQuitterOnClickListener1);

        Button btnEnvoyer2 = (Button) findViewById(R.id.button2);
        btnEnvoyer2.setOnClickListener(btnQuitterOnClickListener2);

        Button btnEnvoyer3 = (Button) findViewById(R.id.button3);
        btnEnvoyer3.setOnClickListener(btnQuitterOnClickListener3);

        Button btnEnvoyer4 = (Button) findViewById(R.id.button4);
        btnEnvoyer4.setOnClickListener(btnQuitterOnClickListener4);

        Button btnEnvoyer5 = (Button) findViewById(R.id.button5);
        btnEnvoyer5.setOnClickListener(btnQuitterOnClickListener5);

        Button btnEnvoyer6 = (Button) findViewById(R.id.button6);
        btnEnvoyer6.setOnClickListener(btnQuitterOnClickListener6);

        Button btnEnvoyer7 = (Button) findViewById(R.id.button7);
        btnEnvoyer7.setOnClickListener(btnQuitterOnClickListener7);

        Button btnEnvoyer8 = (Button) findViewById(R.id.button8);
        btnEnvoyer8.setOnClickListener(btnQuitterOnClickListener8);

        Button btnEnvoyer9 = (Button) findViewById(R.id.button9);
        btnEnvoyer9.setOnClickListener(btnQuitterOnClickListener9);

        Button btnEnvoyerPlus = (Button) findViewById(R.id.buttonPlus);
        btnEnvoyerPlus.setOnClickListener(btnQuitterOnClickListenerPlus);

        Button btnEnvoyerMoins = (Button) findViewById(R.id.buttonMoins);
        btnEnvoyerMoins.setOnClickListener(btnQuitterOnClickListenerMoins);

        Button btnEnvoyerFois = (Button) findViewById(R.id.buttonFois);
        btnEnvoyerFois.setOnClickListener(btnQuitterOnClickListenerFois);

        Button btnEnvoyerEgale = (Button) findViewById(R.id.buttonEgale);
        btnEnvoyerEgale.setOnClickListener(btnQuitterOnClickListenerEgale);

        Button btnEnvoyerC = (Button) findViewById(R.id.buttonC);
        btnEnvoyerC.setOnClickListener(btnQuitterOnClickListenerC);

        Button btnEnvoyerZero = (Button) findViewById(R.id.button0);
        btnEnvoyerZero.setOnClickListener(btnQuitterOnClickListener0);

        Button btnEnvoyerPoint = (Button) findViewById(R.id.buttonPoint);
        btnEnvoyerPoint.setOnClickListener(btnQuitterOnClickListenerPoint);


    }

    View.OnClickListener btnQuitterOnClickListener1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            buffer += "1";
            setTxTValeur(buffer);
        }
    };
    View.OnClickListener btnQuitterOnClickListener2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            buffer += "2";
            setTxTValeur(buffer);
        }
    };
    View.OnClickListener btnQuitterOnClickListener3 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            buffer += "3";
            setTxTValeur(buffer);
        }
    };
    View.OnClickListener btnQuitterOnClickListener4 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            buffer += "4";
            setTxTValeur(buffer);
        }
    };
    View.OnClickListener btnQuitterOnClickListener5 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            buffer += "5";
            setTxTValeur(buffer);
        }
    };

    View.OnClickListener btnQuitterOnClickListener6 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            buffer += "6";
            setTxTValeur(buffer);
        }
    };
    View.OnClickListener btnQuitterOnClickListener7 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            buffer += "7";
            setTxTValeur(buffer);
        }
    };
    View.OnClickListener btnQuitterOnClickListener8 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            buffer += "8";
            setTxTValeur(buffer);
        }
    };
    View.OnClickListener btnQuitterOnClickListener9 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            buffer += "9";
            setTxTValeur(buffer);
        }
    };
    View.OnClickListener btnQuitterOnClickListener0 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            buffer += "0";
            setTxTValeur(buffer);
        }
    };

    View.OnClickListener btnQuitterOnClickListenerPlus = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            buffer += "+";
            setTxTValeur(buffer);
        }
    };
    View.OnClickListener btnQuitterOnClickListenerMoins = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            buffer += "-";
            setTxTValeur(buffer);
        }
    };
    View.OnClickListener btnQuitterOnClickListenerFois = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            buffer += "*";
            setTxTValeur(buffer);
        }
    };

    View.OnClickListener btnQuitterOnClickListenerEgale = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            result();
        }
    };

    View.OnClickListener btnQuitterOnClickListenerPoint = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            buffer += ".";
            setTxTValeur(buffer);

        }
    };
    View.OnClickListener btnQuitterOnClickListenerC = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (buffer.length() != 0) buffer = buffer.substring(0, buffer.length() - 1);
            if (buffer2.length() != 0) {
                buffer = buffer2.charAt(buffer2.length() - 1) + buffer;
                buffer2 = buffer2.substring(0, buffer2.length() - 1);

                indice = 1;
            }

            setTxTValeur(buffer);
        }
    };


    public void setTxTValeur(String valeur) {

        if (getLimite() && indice == 0) {

            buffer2 += buffer.charAt(0);

            buffer = buffer.substring(1);

        }
        indice = 0;
        ZoneVal.setText(buffer);
        ZoneVal2.setText(buffer2);
    }

    public boolean getLimite() {
        if (buffer.length() > 9) {
            return true;
        } else return false;

    }

    public void result() {


        String premierNombre = "";
        String deuxiemeNombre = "";
        int res = 0;

        int n1 = 0;

        String bufferfinal = buffer2 + buffer;

        for (int i = 0; i < buffer.length(); i++) {

            if (bufferfinal.charAt(i) == '+') {

                for (int y = 0; y < i; y++) {
                    premierNombre += bufferfinal.charAt(y);


                }
                for (int z = i + 1; z < bufferfinal.length(); z++) {
                    deuxiemeNombre += bufferfinal.charAt(z);

                }


                n1 = Integer.parseInt(premierNombre);
                int n2 = Integer.parseInt(deuxiemeNombre);
                res = n1 + n2;

                ZoneVal.setText(String.valueOf(res));


                break;

            }


            ZoneVal.setText(String.valueOf(res));
            ZoneVal2.setText(bufferfinal);

        }
    }

}

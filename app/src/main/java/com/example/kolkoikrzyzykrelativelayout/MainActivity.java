package com.example.kolkoikrzyzykrelativelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String znak ="X";
    int licznik = 0;
    Button p11;
    Button p12;
    Button p13;
    Button p21;
    Button p22;
    Button p23;
    Button p31;
    Button p32;
    Button p33;
    Button reset;
    TextView wynik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        p11 = (Button) findViewById(R.id.pole_1_1);
        p12 = (Button) findViewById(R.id.pole_1_2);
        p13 = (Button) findViewById(R.id.pole_1_3);

        p21 = (Button) findViewById(R.id.pole_2_1);
        p22 = (Button) findViewById(R.id.pole_2_2);
        p23 = (Button) findViewById(R.id.pole_2_3);

        p31 = (Button) findViewById(R.id.pole_3_1);
        p32 = (Button) findViewById(R.id.pole_3_2);
        p33 = (Button) findViewById(R.id.pole_3_3);
        reset = (Button) findViewById(R.id.reset);
        wynik = (TextView) findViewById(R.id.wynik);
    }

    public void przycisk(View view) {
        Button przycisk = (Button) view;
        przycisk.setText(znak);
        licznik ++;
        if(sprawdzWygrana()){
            wynik.setText("Wygrywa: " + znak + "!!!");
            reset.setVisibility(View.VISIBLE);
            odblokuj(false);
        } else
        if(licznik==9){
            wynik.setText("Remis !!!");
            reset.setVisibility(View.VISIBLE);
        }
        if(znak.equals("X")) znak="O";
        else znak="X";
        przycisk.setEnabled(false);
    }

    public void odblokuj(Boolean odblokowany){
        p11.setEnabled(odblokowany);   p12.setEnabled(odblokowany);   p13.setEnabled(odblokowany);
        p21.setEnabled(odblokowany);   p22.setEnabled(odblokowany);   p23.setEnabled(odblokowany);
        p31.setEnabled(odblokowany);   p32.setEnabled(odblokowany);   p33.setEnabled(odblokowany);
    }

    public boolean sprawdzWygrana(){
        boolean wygrana = false;

        String p11s = p11.getText().toString();
        String p12s = p12.getText().toString();
        String p13s = p13.getText().toString();

        String p21s = p21.getText().toString();
        String p22s = p22.getText().toString();
        String p23s = p23.getText().toString();

        String p31s = p31.getText().toString();
        String p32s = p32.getText().toString();
        String p33s = p33.getText().toString();

        if(p11s.equals(p12s) && p11s.equals(p13s) && p11s.length()>0 ||
                p21s.equals(p22s) && p21s.equals(p23s) && p21s.length()>0 ||
                p31s.equals(p32s) && p31s.equals(p33s) && p31s.length()>0 ||

                p11s.equals(p21s) && p11s.equals(p31s) && p11s.length()>0 ||
                p12s.equals(p22s) && p12s.equals(p32s) && p12s.length()>0 ||
                p13s.equals(p23s) && p13s.equals(p33s) && p13s.length()>0 ||

                p11s.equals(p22s) && p11s.equals(p33s) && p11s.length()>0 ||
                p13s.equals(p22s) && p13s.equals(p31s) && p13s.length()>0
        ) wygrana = true;
        return wygrana;

    }

    public void resetuj(View view) {
        p11.setText(""); p12.setText(""); p13.setText("");
        p21.setText(""); p22.setText(""); p23.setText("");
        p31.setText(""); p32.setText(""); p33.setText("");
        odblokuj(true);
        licznik = 0;
        reset.setVisibility(View.INVISIBLE);
        wynik.setText("Tu pojawi się wynik");
    }
}
package com.example.tomer;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tomer.BancoController;
import com.example.tomer.Frase;
import com.example.tomer.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private List<Frase> frases = new ArrayList<>();
    private Frase fraseEscolhida;
    private int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(contador <= 0) {
            BancoController crud = new BancoController(getBaseContext());
            new InserirFrases().inserirTodas(crud);
            frases = crud.carregaDados();
            contador++;
        }

        mudaFrase();
    }

    public void like(View v){
        BancoController crud = new BancoController(getBaseContext());
        crud.alteraRegistro(fraseEscolhida.getId(), fraseEscolhida.getPontos() + 1);
        frases.get(fraseEscolhida.getId()).setPontos(fraseEscolhida.getPontos() + 1);
        mudaFrase();
    }

    public void dislike(View v) {
        if(fraseEscolhida.getPontos() > 0){
            BancoController crud = new BancoController(getBaseContext());
            crud.alteraRegistro(fraseEscolhida.getId(), fraseEscolhida.getPontos() - 1);
            frases.get(fraseEscolhida.getId()).setPontos(fraseEscolhida.getPontos() - 1);
        }
        mudaFrase();
    }

    public void mudaFrase(){
        TextView tv = (TextView)findViewById(R.id.txtFrase);
        Random random = new Random();
        
        fraseEscolhida = carregaFrasePorId(random.nextInt(39));
        String texto = fraseEscolhida.getConteudo() + "\n\nPontos: " + fraseEscolhida.getPontos();
        tv.setText(texto);
    }

    public Frase carregaFrasePorId(int i){
        return frases.get(i);
    }

    public List<Frase> getFrases() {
        return frases;
    }

    public Frase getFraseEscolhida() {
        return fraseEscolhida;
    }

    public void setFraseEscolhida(Frase fraseEscolhida) {
        this.fraseEscolhida = fraseEscolhida;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
}

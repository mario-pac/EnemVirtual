package com.jose.bonusenem;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    Spinner spinner2;
    Spinner spinner3;
    int contador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);

        carregarSpinner1();
        carregarSpinner2();
        carregarSpinner3();
    }

    public void popupMessage(String msg, String titulo){
        AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        alerta.setMessage(msg);
        alerta.setTitle(titulo);
        alerta.setNegativeButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        AlertDialog alertDialog = alerta.create();
        alertDialog.show();
    }

    private void carregarSpinner1() {
        spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.questao1, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    private void carregarSpinner2() {
        spinner2 = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.questao2, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter);
    }

    private void carregarSpinner3() {
        spinner3 = findViewById(R.id.spinner3);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.questao3, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter);
    }

    public String verificarSpinner(){
        String resposta = spinner.getSelectedItem().toString();
        if(resposta.equals("c) 16")){
            contador = contador+1;
            return "Parabéns, você acertou!";
        }
        else{
            return "Que pena, você errou! A resposta certa era c) 16...";
        }
    }

    public String verificarSpinner2(){
        String resposta = spinner2.getSelectedItem().toString();
        if(resposta.equals("d) 3h10min")){
            contador = contador+1;
            return "Parabéns, você acertou!";
        }
        else{
            return "Que pena, você errou! A resposta certa era d) 3h10min...";
        }
    }

    public String verificarSpinner3(){
        String resposta = spinner3.getSelectedItem().toString();
        if(resposta.equals("a) 126")){
            contador = contador+1;
            return "Parabéns, você acertou!";
        }
        else{
            return "Que pena, você errou! A resposta certa era a) 126...";
        }
    }
    public String verificarRadioQuestao4(){
        RadioGroup questao4 = findViewById(R.id.questao4);
        final String value = ((RadioButton)findViewById(questao4.getCheckedRadioButtonId()))
                .getText().toString();
        if (value.equals("b) 67,5")){
            contador = contador+1;
            return "Parabéns, você acertou!";
        }
        else{
            return "Que pena, você errou! A resposta certa era b) 67,5...";
        }
    }

    public String verificarRadioQuestao5(){
        RadioGroup questao5 = findViewById(R.id.questao5);
        final String value = ((RadioButton)findViewById(questao5.getCheckedRadioButtonId()))
                .getText().toString();
        if (value.equals("a) 0,04%")){
            contador = contador+1;
            return "Parabéns, você acertou!";
        }
        else{
            return "Que pena, você errou! A resposta certa era a) 0,04%...";
        }
    }
    public String verificarRadioQuestao6(){
        RadioGroup questao6 = findViewById(R.id.questao6);
        final String value = ((RadioButton)findViewById(questao6.getCheckedRadioButtonId()))
                .getText().toString();
        if (value.equals("c) duas pessoas não puderam sentar")){
            contador = contador+1;
            return "Parabéns, você acertou!";
        }
        else{
            return "Que pena, você errou! A resposta certa era c) duas pessoas não puderam sentar...";
        }
    }
    public String avaliacao(int cont){
        if (cont<=3){
            return "Precisa estudar mais!";
        }
        else if (cont>3 && cont<=5){
            return "Foi bem, porém poderia ser melhor!";
        }
        else{
            return "Parabéns, tá muito bem mesmo!";
        }
    }
    public void mostrarDados(View v){
        //por ele fazer tudo invertido, tive que chamar os métodos aqui pra contar as respostas
        //se não ele sempre vai mostrar que errou tudo
        verificarSpinner();
        verificarSpinner2();
        verificarSpinner3();
        verificarRadioQuestao4();
        verificarRadioQuestao5();
        verificarRadioQuestao6();
        popupMessage("Você acertou "+contador+" de 6 questões!\n"+avaliacao(contador)
                ,"Resultado Final");
        popupMessage(verificarRadioQuestao6(), "Questão 6:");
        popupMessage(verificarRadioQuestao5(), "Questão 5:");
        popupMessage(verificarRadioQuestao4(), "Questão 4:");
        popupMessage(verificarSpinner3(), "Questão 3:");
        popupMessage(verificarSpinner2(), "Questão 2:");
        popupMessage(verificarSpinner(), "Questão 1:");
    }
}

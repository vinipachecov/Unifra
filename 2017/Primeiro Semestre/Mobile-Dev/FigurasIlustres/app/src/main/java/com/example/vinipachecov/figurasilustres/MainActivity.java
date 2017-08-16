package com.example.vinipachecov.figurasilustres;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

//    Enunciado
//    1 - No AutoCompleteTextView deverão estar cadastrados 3 países: Brasil, Bolívia e Jamaica.
//    Quando o usuário seleciona um desses países e pressiona o botão, deverá ser exibida na tela
// uma mensagem (com Toast) dizendo qual é a figura ilustre do país selecionado pelo usuário.
//    Para o Brasil a figura Ilustre é Lula, Bolívia é Evo Moralez e Jamaica é Bob Marley.
//    Crie uma classe chamada Pais que possua um método para verificar qual o país foi selecionado
//    pelo usuário e retornar para a interface da aplicação a respectiva figura ilustre correspondente ao país.


public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView textView;

    private static final String[] COUNTRIES = new String[] {
            "Brasil", "Bolívia", "Jamaica"
    };

    public void countryCheck(View v) {

       switch (textView.getText().toString()){
           case "Bolívia":
               Toast.makeText(this, "Evo Morales", Toast.LENGTH_SHORT).show();
               break;
           case "Brasil":
               Toast.makeText(this, "Lula", Toast.LENGTH_SHORT).show();
               break;
           case "Jamaica":
               Toast.makeText(this, "Bob Marley", Toast.LENGTH_SHORT).show();
               break;
       }
        //if(textView.getListSelection() == 1);
        //Toast.makeText(this, , Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, COUNTRIES);
        textView = (AutoCompleteTextView)findViewById(R.id.countriesList);
        textView.setAdapter(adapter);
    }


}


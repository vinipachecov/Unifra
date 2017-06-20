package com.example.vinipachecov.trabalhofinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Boletos extends AppCompatActivity {

    ArrayList<String> pagamentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boletos);

        ListView listaPagamentos = (ListView)findViewById(R.id.listaPagamentos);
        pagamentos = new ArrayList<>();

        pagamentos.add("pagamento 1");
        pagamentos.add("pagamento 2");
        pagamentos.add("pagamento 3");
        pagamentos.add("pagamento 4");
        pagamentos.add("pagamento 5");
        pagamentos.add("pagamento 6");
        pagamentos.add("pagamento 7");


        ArrayAdapter arrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, pagamentos);
        listaPagamentos.setAdapter(arrayAdapter);
    }
}

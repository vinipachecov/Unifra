package com.example.root.checkedtextview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<CheckedTextView> listoption;
    Button continuar;

    public void initialize(){
        listoption = new ArrayList<CheckedTextView>();
        for (int i = 1; i <= 6; i++){
            switch (i){
                case 1:
                    listoption.add((CheckedTextView)findViewById(R.id.bairro1checkedTextView));
                    break;
                case 2:
                    listoption.add((CheckedTextView)findViewById(R.id.bairro2checkedTextView));
                    break;
                case 3:
                    listoption.add((CheckedTextView)findViewById(R.id.bairro3CheckedTextView));
                    break;
                case 4:
                    listoption.add((CheckedTextView)findViewById(R.id.bairro4checkedTextView));
                    break;
                case 5:
                    listoption.add((CheckedTextView)findViewById(R.id.bairro5CheckTextView));
                    break;
                case 6:
                    listoption.add((CheckedTextView)findViewById(R.id.bairro6checkedTextView));
                    break;
            }
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }


    public void CheckBairro(View view) {
        unMark();
        switch (view.getId()){
            case R.id.bairro1checkedTextView:
                listoption.get(0).setChecked(true);
                listoption.get(0).setCheckMarkDrawable(R.drawable.checked);
                break;
            case R.id.bairro2checkedTextView:
                listoption.get(1).setChecked(true);
                listoption.get(1).setCheckMarkDrawable(R.drawable.checked);
                break;
            case R.id.bairro3CheckedTextView:
                listoption.get(2).setChecked(true);
                listoption.get(2).setCheckMarkDrawable(R.drawable.checked);
                break;
            case R.id.bairro4checkedTextView:
                listoption.get(3).setChecked(true);
                listoption.get(3).setCheckMarkDrawable(R.drawable.checked);
                break;
            case R.id.bairro5CheckTextView:
                listoption.get(4).setChecked(true);
                listoption.get(4).setCheckMarkDrawable(R.drawable.checked);
                break;
            case R.id.bairro6checkedTextView:
                listoption.get(5).setChecked(true);
                listoption.get(5).setCheckMarkDrawable(R.drawable.checked);
                break;
        }

    }

    public void unMark(){
        for (int i = 0; i < listoption.size() -1 ; i++) {
            listoption.get(i).setChecked(false);
        }
    }
}

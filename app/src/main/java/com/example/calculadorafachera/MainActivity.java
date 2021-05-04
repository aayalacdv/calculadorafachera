package com.example.calculadorafachera;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    public String lastop = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void calculator(View view){
        Button b = (Button)view;
        String tag = b.getTag().toString();
        String text = b.getText().toString();
        TextView progression = (TextView)findViewById(R.id.textProgression);
        TextView answer = (TextView)findViewById(R.id.textAnswer);

        switch (tag){
            case "button":
                if(progression.getText().toString().equals("0")){
                    progression.setText(text);
                }else{
                    String finalText = progression.getText().toString() + text;
                    progression.setText( finalText);
                }
                break;
            case "equals":
                switch (lastop){
                    case "add":
                        float f = Float.parseFloat(progression.getText().toString());
                        float num = Math.round((Float.parseFloat(answer.getText().toString()) +  f ) * 100.0F)/100.0F;
                        progression.setText("0");
                        answer.setText(num + "");
                        break;
                    case "substract":
                        f = Float.parseFloat(progression.getText().toString());
                        num = Math.round((Float.parseFloat(answer.getText().toString())/ f ) - 100.0F)/100.0F;
                        progression.setText("0");
                        answer.setText(num + "");
                        break;
                    case "divide":
                        f = Float.parseFloat(progression.getText().toString());
                        num = Math.round((Float.parseFloat(answer.getText().toString())/ f ) * 100.0F)/100.0F;
                        progression.setText("0");
                        answer.setText(num + "");
                        break;
                    case "multiply":
                        f = Float.parseFloat(progression.getText().toString());
                        num = Float.parseFloat(answer.getText().toString())* f  ;
                        progression.setText("0");
                        answer.setText(num + "");
                        break;
                }
                lastop = "";
                break;

            case "add":
                lastop = tag;
                if(answer.getText().toString().equals("")){
                    float num = Float.parseFloat(progression.getText().toString());
                    answer.setText(num + "");
                    progression.setText("0");
                }
                else {
                    if(!progression.getText().toString().equals("0")){

                        float  f = Float.parseFloat(progression.getText().toString());
                        float num = Math.round((Float.parseFloat(answer.getText().toString()) + f ) * 100.0F)/100.0F;
                        progression.setText("0");
                        answer.setText(num + "");

                    }

                }

                break;
            case "substract":
                lastop = "substract";
                if(answer.getText().toString().equals("")){
                    float num = Float.parseFloat(progression.getText().toString());
                    answer.setText(num + "");
                    progression.setText("0");
                }
                else {
                    if(!progression.getText().toString().equals("0")) {
                        float f = Float.parseFloat(progression.getText().toString());
                        float num = Math.round((Float.parseFloat(answer.getText().toString()) - f) * 100.0F) / 100.0F;
                        progression.setText("0");
                        answer.setText(num + "");
                    }
                }

                break;
            case "divide":
                lastop = "divide";
                if(answer.getText().toString().equals("")){
                    float num = Float.parseFloat(progression.getText().toString());
                    answer.setText(num + "");
                    progression.setText("0");
                }
                else {
                    if(!progression.getText().toString().equals("0")) {
                        float f = Float.parseFloat(progression.getText().toString());
                        float num = Math.round((Float.parseFloat(answer.getText().toString()) / f) * 100.0F) / 100.0F;
                        progression.setText("0");
                        answer.setText(num + "");
                    }

                }

                break;
            case "multiply":
                lastop = "multiply";
                if(answer.getText().toString().equals("")){
                    float num = Float.parseFloat(progression.getText().toString());
                    answer.setText(num + "");
                    progression.setText("0");
                }
                else {
                    if(!progression.getText().toString().equals("0")) {
                        float f = Float.parseFloat(progression.getText().toString());
                        float num = Float.parseFloat(answer.getText().toString()) * f;
                        progression.setText("0");
                        answer.setText(num + "");
                    }
                }
                break;
            case "coma":
                if (progression.getText().toString().contains(".")){
                    String finalText = progression.getText().toString();
                    progression.setText( finalText);
                }
                else{
                    String finalText = progression.getText().toString() + ".";
                    progression.setText( finalText);
                }
                break;
            case "clear":
                lastop = "";
                answer.setText("");
                progression.setText("0");
                break;
        }
    }
}
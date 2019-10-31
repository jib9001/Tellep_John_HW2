package com.example.tellep_john_hw2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import static android.icu.text.CaseMap.toUpper;

public class MainActivity extends AppCompatActivity
{

    private TextView display;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display_text);

        ArrayList<View> allButtons;
        allButtons = (findViewById(R.id.calculator)).getTouchables();

        for (View view : allButtons)
        {
            Button button = (Button) view;

            button.setOnClickListener(genericButtonClick);
        }
    }

    private View.OnClickListener genericButtonClick = new View.OnClickListener()
    {
        @Override
        public void onClick(View b)
        {
            Button button = (Button) b;

            if(button.getText().equals("="))
            {
                String displayText = display.getText().toString();
                String[] operands;
                float answer;

                try {
                    if (displayText.contains("+")) {
                        operands = displayText.split("\\+");

                        answer = Float.parseFloat(operands[0]) + Float.parseFloat(operands[1]);

                        display.setText(String.valueOf(answer));
                    } else if (displayText.contains("-")) {
                        operands = displayText.split("-");

                        answer = Float.parseFloat(operands[0]) - Float.parseFloat(operands[1]);

                        display.setText(String.valueOf(answer));
                    } else if (displayText.contains("/")) {
                        operands = displayText.split("/");

                        answer = Float.parseFloat(operands[0]) / Float.parseFloat(operands[1]);

                        display.setText(String.valueOf(answer));
                    } else if (displayText.contains("*")) {
                        operands = displayText.split("\\*");

                        answer = Float.parseFloat(operands[0]) * Float.parseFloat(operands[1]);

                        display.setText(String.valueOf(answer));
                    } else {
                        display.setText("Error");
                    }
                }
                catch(Exception e)
                {
                    display.setText("Error");
                }

            }
            else if(button.getText().equals("C"))
            {
                display.setText("");
            }
            else
            {
                display.append(button.getText());
            }
        }
    };

}
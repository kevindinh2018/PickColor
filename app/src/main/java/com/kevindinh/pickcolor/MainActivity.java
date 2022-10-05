package com.kevindinh.pickcolor;

import static android.graphics.Color.argb;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    View v_Color;
    TextView tCode, tValue;
    EditText input_red, input_green, input_blue, input_alfa;
    SeekBar sRed, sGreen, sBlue, sAlfa;
    int red = 0, green = 0, blue = 0, alfa = 255;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        v_Color = findViewById(R.id.v_color);
        tCode   = findViewById(R.id.codeValue);
        tValue  = findViewById(R.id.rgbValue);

        input_red = findViewById(R.id.edit_red);
        input_green = findViewById(R.id.edit_green);
        input_blue = findViewById(R.id.edit_blue);

        sAlfa = findViewById(R.id.s_Alfa);
        sRed = findViewById(R.id.s_Red);
        sGreen = findViewById(R.id.s_Green);
        sBlue = findViewById(R.id.s_Blue);

        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                red = Integer.parseInt(input_red.getText().toString());
                green = Integer.parseInt(input_green.getText().toString());
                blue = Integer.parseInt(input_blue.getText().toString());

                v_Color.setBackgroundColor(Color.rgb(red,green,blue));
            }
        });

        sAlfa.setOnSeekBarChangeListener(this);
        sRed.setOnSeekBarChangeListener(this);
        sGreen.setOnSeekBarChangeListener(this);
        sBlue.setOnSeekBarChangeListener(this);

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

        switch (seekBar.getId()){

            case R.id.s_Red:
                red = i;
                break;
            case R.id.s_Green:
                green = i;
                break;
            case R.id.s_Blue:
                blue = i;
                break;
            case R.id.s_Alfa:
                alfa = i;
                break;
        }
        v_Color.setBackgroundColor(argb(alfa,red,green,blue));
        String code = HexCode(alfa,red,green,blue);
        tValue.setText(String.format("(%d,%d,%d,%d)",alfa,red,green,blue));
        tCode.setText(code.toUpperCase());
    }

    private String HexCode(int alfa, int red, int green, int blue) {
        String code;
        code = "#";
        code += Integer.toHexString(alfa);
        code += Integer.toHexString(red);
        code += Integer.toHexString(green);
        code += Integer.toHexString(blue);
        return code;

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
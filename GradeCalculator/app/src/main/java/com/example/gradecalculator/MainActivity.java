package com.example.gradecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static com.example.gradecalculator.R.id.mid;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText mid = findViewById(R.id.mid);
        EditText hw = findViewById(R.id.hw) ;
        EditText qz = findViewById(R.id.qz);
        EditText fnl = findViewById(R.id.fn) ;
        Button button = findViewById(R.id.btn) ;
        TextView result = findViewById(R.id.result) ;
        Button reset = findViewById(R.id.butt);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String midString = mid.getText().toString() ;
                String hwString = hw.getText().toString() ;
                String qzString = qz.getText().toString() ;
                String fnlString = fnl.getText().toString() ;
                int sum ;

                if (midString != null && hwString != null && qzString != null && fnlString != null) {
                    int  hwResult = Integer.parseInt(hwString) ;
                    int  midResult = Integer.parseInt(midString) ;
                    int  qzResult = Integer.parseInt(qzString) ;
                    int  fnlResult = Integer.parseInt(fnlString) ;

                    sum  = hwResult + midResult + qzResult + fnlResult ;

                    if (sum >= 90 ){
                        result.setText("A");
                        result.setTextColor(Color.parseColor("#606c38")); //check it again
                    } else if (sum >= 80 ) {
                        result.setText("B");
                        result.setTextColor(Color.parseColor("#283618"));
                    } else if (sum >= 70 ) {
                        result.setText("C");
                        result.setTextColor(Color.parseColor("#dda15e"));
                    } else if (sum >= 60 ){
                        result.setText("D");
                        result.setTextColor(Color.parseColor("#f48c06"));
                    } else if (sum <60){
                        result.setText("F");
                        result.setTextColor(Color.parseColor("#6a040f"));
                    }
                }
                else {
                    sum = 0;
                    result.setText("You should eneter a value");
                    result.setTextColor(Color.parseColor("#774936"));
                    Toast.makeText(MainActivity.this, "ENTER A VALUE PLEAAAAAAZ", Toast.LENGTH_LONG).show();
                }



            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mid.getText().clear();
                hw.getText().clear();
                qz.getText().clear();
                fnl.getText().clear();
                result.setTextColor(Color.parseColor("#774936"));
                result.setText("Please Enter A value");

            }
        });
    }

}
package com.project_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Basic_Calc extends AppCompatActivity {

    EditText n1, n2;
    Button add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_calc);

        n1 = findViewById(R.id.n1);
        n2 = findViewById(R.id.n2);
        add = findViewById(R.id.add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast toast = new Toast(Basic_Calc.this);
                ImageView view1 = new ImageView(getApplicationContext());

                int num1 = Integer.parseInt(n1.getText().toString());
                int num2 = Integer.parseInt(n2.getText().toString());
                Toast.makeText(Basic_Calc.this, "" + (num1+num2) + "", Toast.LENGTH_SHORT).show();

                view1.setImageResource(R.drawable.baseline_add_24);

                toast.setView(view1);
                toast.show();
            }
        });

    }
}
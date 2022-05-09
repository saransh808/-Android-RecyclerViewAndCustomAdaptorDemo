package com.example.recyclerviewseminar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etAge;
    EditText etUrl;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.et_name);
        etAge = findViewById(R.id.et_age);
        etUrl = findViewById(R.id.et_url);

        btnAdd = findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validateAndAddData(etName, etAge, etUrl)){
                    Toast.makeText(getApplicationContext(), "Adding to Data", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(getApplicationContext(), CustomRecyclerView.class);
                    startActivity(i);

                }else{
                    Toast.makeText(getApplicationContext(), "Input Invalid", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private boolean validateAndAddData(EditText etName, EditText etAge, EditText etUrl) {
        if(etName!= null && !etName.getText().toString().isEmpty() && etAge!=null && !etAge.getText().toString().isEmpty()){
            try{
                String name = etName.getText().toString();
                String ageString = etAge.getText().toString();
                Integer age = Integer.parseInt(ageString);
                String url = etUrl.getText().toString();
                DataInitializer dataInit = DataInitializer.getSingletonInitializer();
                dataInit.addData(name, age, url);
                return true;
            }catch (NumberFormatException e){
               return false;
            }
        }
        return false;
    }
}
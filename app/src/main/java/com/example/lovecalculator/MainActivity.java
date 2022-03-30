package com.example.lovecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText first_name,second_name;
    TextView per,msg;
    Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        first_name = findViewById(R.id.first_name);
        second_name = findViewById(R.id.second_name);
        per = findViewById(R.id.per);
        msg = findViewById(R.id.msg);
        calculate = findViewById(R.id.calculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
                apiInterface.getper(first_name.getText().toString(),second_name.getText().toString(),"love-calculator.p.rapidapi.com","a1464f9095mshfe252be4505c76ep116a54jsnd257ae6e221a")
                            .enqueue(new Callback<LoveData>() {
                                @Override
                                public void onResponse(Call<LoveData> call, Response<LoveData> response) {

                                    if (response.isSuccessful()){

                                        LoveData data = response.body();

                                        per.setText(data.getPercentage()+"%");
                                        msg.setText(data.getResult());

                                    }

                                }

                                @Override
                                public void onFailure(Call<LoveData> call, Throwable t) {

                                }
                            });
            }
        });


    }
}
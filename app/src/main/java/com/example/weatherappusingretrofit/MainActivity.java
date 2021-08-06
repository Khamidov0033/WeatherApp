package com.example.weatherappusingretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView temperatue;
    TextView weather;
    Button button;
    EditText editText;
    ConstraintLayout background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        temperatue = findViewById(R.id.temperatureTextView);
        weather = findViewById(R.id.weatherTextView);
        button = findViewById(R.id.button);
        editText = findViewById(R.id.cityEditText);
        background = findViewById(R.id.background);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWeatherData(editText.getText().toString());


            }
        });


    }

    public void getWeatherData(String cityname) {

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        APIIntergace apiIntergace = retrofit.create(APIIntergace.class);
        Call<Example> call = apiIntergace.getWeatherData(cityname);

        call.enqueue(new Callback<Example>() {
            float i;

            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                if (response.code()==200){
                String responseString = response.body().getMain().getTemp();
                float i = Float.parseFloat(responseString);
                temperatue.setText(String.format("%.1f", i) + "C");


                if (i > 30) {
                    background.setBackgroundResource(R.drawable.sunny);
                    weather.setText("Sunny");
                    weather.setTextColor(Color.WHITE);
                    temperatue.setTextColor(Color.WHITE);
                } else if (i < 30) {
                    background.setBackgroundResource(R.drawable.windy);
                    weather.setText("Cool");
                    weather.setTextColor(Color.BLACK);
                    temperatue.setTextColor(Color.BLACK);
                }
                }
                else {
                    Toast.makeText(MainActivity.this, "Enter valid city", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

            }
        });
    }
}
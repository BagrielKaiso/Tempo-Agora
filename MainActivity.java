package com.example.apiusandoglobal;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    Button btnlocalizar;
    EditText editcep;
    TextView txt1, txt2, txt3, txt4, txt_temperatura, txt_previsao_semanal;
    // TextViews para previsões e temperaturas mínimas/máximas de cada dia
    TextView txt_previsao_dia1, txt_max_temp_dia1, txt_min_temp_dia1;
    TextView txt_previsao_dia2, txt_max_temp_dia2, txt_min_temp_dia2;
    TextView txt_previsao_dia3, txt_max_temp_dia3, txt_min_temp_dia3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnlocalizar = findViewById(R.id.btnlocalizar);
        editcep = findViewById(R.id.editcep);
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);
        txt4 = findViewById(R.id.txt4);
        txt_temperatura = findViewById(R.id.txt_temperatura);

        // TextViews para as previsões e temperaturas mínimas e máximas de cada dia
        txt_previsao_dia1 = findViewById(R.id.txt_previsao_dia1);
        txt_max_temp_dia1 = findViewById(R.id.txt_max_temp_dia1);
        txt_min_temp_dia1 = findViewById(R.id.txt_min_temp_dia1);

        txt_previsao_dia2 = findViewById(R.id.txt_previsao_dia2);
        txt_max_temp_dia2 = findViewById(R.id.txt_max_temp_dia2);
        txt_min_temp_dia2 = findViewById(R.id.txt_min_temp_dia2);

        txt_previsao_dia3 = findViewById(R.id.txt_previsao_dia3);
        txt_max_temp_dia3 = findViewById(R.id.txt_max_temp_dia3);
        txt_min_temp_dia3 = findViewById(R.id.txt_min_temp_dia3);

        // Disable strict mode policy for threading (not recommended for production)
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    public void buscarCEP(View view) {
        String localizacao = editcep.getText().toString();
        String urlsite = "https://api.weatherapi.com/v1/forecast.json?key=b2e45f29d2e5460cb19164741242911&q=" + localizacao + "&days=3"; // Previsão para 3 dias
        String response = "";

        BufferedReader bufferedReader = null;
        try {
            URL url = new URL(urlsite);
            BufferedInputStream inputStream = new BufferedInputStream(url.openConnection().getInputStream());
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            response = bufferToString(bufferedReader);
        } catch (Exception e) {
            Log.e("Error", "Conexão falhou: " + e.getMessage());
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    Log.e("Error", "Erro ao fechar o BufferedReader: " + e.getMessage());
                }
            }
        }

        try {
            JSONObject jsonResponse = new JSONObject(response);
            JSONObject localidade = jsonResponse.getJSONObject("location");
            JSONObject tempo = jsonResponse.getJSONObject("current");
            JSONObject forecast = jsonResponse.getJSONObject("forecast");
            JSONArray forecastDays = forecast.getJSONArray("forecastday");

            String nomeregiao = localidade.getString("name");
            String regiao = localidade.getString("region");
            Double temperatura = tempo.getDouble("temp_c");
            String ultimo_update = tempo.getString("last_updated");


            txt1.setText("Nome da Região: " + nomeregiao);
            txt2.setText("Estado: " + regiao);
            txt3.setText("Temperatura Atual: " + temperatura + "°C");
            txt4.setText("Última Atualização: " + ultimo_update);
            txt_temperatura.setText(temperatura + "°C");


            JSONObject forecastDay1 = forecastDays.getJSONObject(0);
            String date1 = forecastDay1.getString("date");
            JSONObject day1 = forecastDay1.getJSONObject("day");
            String condition1 = day1.getJSONObject("condition").getString("text");
            double maxTemp1 = day1.getDouble("maxtemp_c");
            double minTemp1 = day1.getDouble("mintemp_c");


            String condicao1 = traduzirCondicao(condition1);


            txt_previsao_dia1.setText(date1 + ":\n" + "Condição: " + condicao1);
            txt_max_temp_dia1.setText("Máxima: " + maxTemp1 + "°C");
            txt_min_temp_dia1.setText("Mínima: " + minTemp1 + "°C");

            JSONObject forecastDay2 = forecastDays.getJSONObject(1);
            String date2 = forecastDay2.getString("date");
            JSONObject day2 = forecastDay2.getJSONObject("day");
            String condition2 = day2.getJSONObject("condition").getString("text");
            double maxTemp2 = day2.getDouble("maxtemp_c");
            double minTemp2 = day2.getDouble("mintemp_c");


            String condicao2 = traduzirCondicao(condition2);

            // Previsão para o segundo dia
            txt_previsao_dia2.setText(date2 + ":\n" + "Condição: " + condicao2);
            txt_max_temp_dia2.setText("Máxima: " + maxTemp2 + "°C");
            txt_min_temp_dia2.setText("Mínima: " + minTemp2 + "°C");

            JSONObject forecastDay3 = forecastDays.getJSONObject(2);
            String date3 = forecastDay3.getString("date");
            JSONObject day3 = forecastDay3.getJSONObject("day");
            String condition3 = day3.getJSONObject("condition").getString("text");
            double maxTemp3 = day3.getDouble("maxtemp_c");
            double minTemp3 = day3.getDouble("mintemp_c");


            String condicao3 = traduzirCondicao(condition3);


            txt_previsao_dia3.setText(date3 + ":\n" + "Condição: " + condicao3);
            txt_max_temp_dia3.setText("Máxima: " + maxTemp3 + "°C");
            txt_min_temp_dia3.setText("Mínima: " + minTemp3 + "°C");

        } catch (Exception e) {
            Log.e("Error", "Falha ao processar o JSON: " + e.getMessage());
        }
    }


    private String traduzirCondicao(String condition) {
        String condicaoTraduzida = "";


        String conditionLower = condition.toLowerCase();

        if (conditionLower.contains("sunny")) {
            condicaoTraduzida = "Sol";
        } else if (conditionLower.contains("partly cloudy")) {
            condicaoTraduzida = "Parcialmente Nublado";
        } else if (conditionLower.contains("cloudy")) {
            condicaoTraduzida = "Nublado";
        } else if (conditionLower.contains("overcast")) {
            condicaoTraduzida = "Nuvens Densas";
        } else if (conditionLower.contains("clear")) {
            condicaoTraduzida = "Principalmente Claro";
        } else if (conditionLower.contains("showers")) {
            condicaoTraduzida = "Chuvas rápidas";
        } else if (conditionLower.contains("rain")) {
            condicaoTraduzida = "Chuva";
        } else if (conditionLower.contains("thunderstorm")) {
            condicaoTraduzida = "Tempestade com Trovões";
        } else if (conditionLower.contains("snow")) {
            condicaoTraduzida = "Neve";
        } else if (conditionLower.contains("blizzard")) {
            condicaoTraduzida = "Nevasca";
        } else if (conditionLower.contains("sleet")) {
            condicaoTraduzida = "Chuva Congelada";
        } else if (conditionLower.contains("hail")) {
            condicaoTraduzida = "Granizo";
        } else if (conditionLower.contains("windy")) {
            condicaoTraduzida = "Ventoso";
        } else if (conditionLower.contains("fog")) {
            condicaoTraduzida = "Nebuloso";
        } else if (conditionLower.contains("mist")) {
            condicaoTraduzida = "Nevoeiro";
        } else {
            condicaoTraduzida = "Condição desconhecida";
        }

        return condicaoTraduzida;
    }

    private String bufferToString(BufferedReader reader) {
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            Log.e("Error", "Erro ao ler a resposta: " + e.getMessage());
        }
        return stringBuilder.toString();
    }
}

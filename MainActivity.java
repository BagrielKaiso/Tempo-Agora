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
        txt_previsao_semanal = findViewById(R.id.txt_previsao_semanal);

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
            Log.e("Error", "Connection failed: " + e.getMessage());
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    Log.e("Error", "Error closing BufferedReader: " + e.getMessage());
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

            // Exibindo informações gerais
            txt1.setText("Nome da Região: " + nomeregiao);
            txt2.setText("Estado: " + regiao);
            txt3.setText("Temperatura Atual: " + temperatura + "°C");
            txt4.setText("Última Atualização: " + ultimo_update);
            txt_temperatura.setText(temperatura + "°C");

            // Exibindo previsões de 3 dias
            StringBuilder previsao = new StringBuilder();
            for (int i = 0; i < forecastDays.length(); i++) {
                JSONObject forecastDay = forecastDays.getJSONObject(i);
                String date = forecastDay.getString("date");
                JSONObject day = forecastDay.getJSONObject("day");
                String condition = day.getJSONObject("condition").getString("text");
                double maxTemp = day.getDouble("maxtemp_c");
                double minTemp = day.getDouble("mintemp_c");

                previsao.append(date).append(":\n");
                previsao.append("Condição: ").append(condition).append("\n");
                previsao.append("Máxima: ").append(maxTemp).append("°C, Mínima: ").append(minTemp).append("°C\n\n");
            }

            txt_previsao_semanal.setText("Previsão para os próximos dias:\n\n" + previsao.toString());

        } catch (Exception e) {
            Log.e("Error", "Failed to parse JSON: " + e.getMessage());
        }
    }


    private String bufferToString(BufferedReader reader) {
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            Log.e("Error", "Error reading the response: " + e.getMessage());
        }
        return stringBuilder.toString();
    }
}

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;

public class TassiCambio {

    public String valuta;

    public TassiCambio(String valuta){
        this.valuta=valuta;
    }

    public double getTasso() throws IOException {
        Date oggi = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // Correct format for URL
        String formattedDate = sdf.format(oggi); // Format today's date

        // Construct URL with today's date
        URL url = new URL("https://tassidicambio.bancaditalia.it/terzevalute-wf-web/rest/v1.0/dailyRates?referenceDate=" + formattedDate + "&baseCurrencyIsoCode=EUR&currencyIsoCode=USD");

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Accept", "application/json");

        if (con.getResponseCode() != HttpURLConnection.HTTP_OK) {
            InputStream errorStream = con.getErrorStream();
            String errorResponse = new String(errorStream.readAllBytes());
            System.out.println("Error Response: " + errorResponse);
        }

        // Use InputStream to read the response
        try (InputStream inputStream = con.getInputStream()) {
            byte[] responseBytes = inputStream.readAllBytes(); // Read all bytes from the InputStream
            String responseString = new String(responseBytes); // Convert bytes to String

            // Parse JSON response
            JSONObject jsonResponse = new JSONObject(responseString);
            JSONArray ratesArray = jsonResponse.getJSONArray("rates");

            // Loop through rates to find the desired currency
            for (int i = 0; i < ratesArray.length(); i++) {
                if (ratesArray.getJSONObject(i).getString("isoCode").equals(this.valuta)) {
                    return ratesArray.getJSONObject(i).getDouble("avgRate");
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle potential IO exceptions
        }

        return 0; // Return 0 if currency not found or an error occurred
    }

}

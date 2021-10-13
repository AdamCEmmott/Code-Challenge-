import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;


public class Api {
    /*
        Sends a word to the api that returns details of the word including the definition.
     */
    public String getDefinitions(String word) {

        final String language = "en-gb";
        final String fields = "definitions";
        final String strictMatch = "false";
        final String word_id = word.toLowerCase();
        final String restUrl = "https://od-api.oxforddictionaries.com:443/api/v2/entries/" + language + "/" + word_id
                + "?" + "fields=" + fields + "&strictMatch=" + strictMatch;
        final String app_id = "aea02ccb";
        final String app_key = "5269170739ff44806426e82218cda54e";

        try {
            URL url = new URL(restUrl);
            HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
            urlConnection.setRequestProperty("Accept", "application/json");
            urlConnection.setRequestProperty("app_id", app_id);
            urlConnection.setRequestProperty("app_key", app_key);

            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }

            return stringBuilder.toString();

        } catch (IOException e) {
            return null;
        }

    }

}

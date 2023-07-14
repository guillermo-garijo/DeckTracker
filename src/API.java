import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class API {

    private static final String address = "http://127.0.0.1:21337/";

    public static String makeRequest(String endpoint) throws IOException {
        StringBuilder resultado = new StringBuilder();
        URL url = new URL(address + endpoint);
        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
        conexion.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
        String linea;
        while ((linea = rd.readLine()) != null) {
            resultado.append(linea);
        }
        rd.close();
        return resultado.toString();
    }

}

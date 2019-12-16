package Authentication;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.UUID;

public class Auth {

    // Connect to API with given path and return result
    public static String request(String path, String[] parameters, String method, String body) throws InvalidKeyException, NoSuchAlgorithmException {

        UUID uuid = UUID.randomUUID();

        // Seconds since Jan. 1, 1970
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        long secondsSinceEpoch = calendar.getTimeInMillis() / 1000L;

        // Fully qualified url before signature.
        String uri = "https://api.letterboxd.com/api/v0" + path +
                "?apikey=" + Passwords.CLIENT_KEY +
                "&nonce=" + uuid +
                "&timestamp=" + secondsSinceEpoch +
                "&Content-Type=application/x-www-form-urlencoded" +
                "&Accept=application/json";

        if (parameters != null)
            for (String str : parameters)
                uri += "&" + str;

        String saltedString = method + "\u0000" + uri + "\u0000" + (body == null ? "" : body);
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secretKey = new SecretKeySpec(Passwords.CLIENT_SECRET.getBytes(), "HmacSHA256");
        sha256_HMAC.init(secretKey);

        String signature = byteArrayToHex(sha256_HMAC.doFinal(saltedString.getBytes()));
        uri += "&signature=" + signature;

        URL url;
        HttpsURLConnection urlConnection;
        try {
            url = new URL(uri);
            urlConnection = (HttpsURLConnection) url.openConnection();
            urlConnection.setDoOutput(true);

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            return bufferedReader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private static String byteArrayToHex(byte[] a) {
        StringBuilder sb = new StringBuilder(a.length * 2);
        for(byte b: a)
            sb.append(String.format("%02x", b));
        return sb.toString();
    }
}

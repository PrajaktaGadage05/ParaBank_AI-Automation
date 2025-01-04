package utilities;

import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class BugUtils {

    // Replace with your actual API key
    private static final String API_KEY = "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";
    private static final String ENDPOINT_URL = "https://api.openai.com/v1/chat/completions";
    private static final String MODEL = "gpt-4"; // Use a valid model name

    public static String generateBugDetails(String prompt) {
        if (API_KEY == null || API_KEY.isEmpty()) {
            throw new IllegalArgumentException("API key is missing. Please provide a valid API key.");
        }

        try {
            URL url = new URL(ENDPOINT_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "Bearer " + API_KEY);
            connection.setRequestProperty("Content-Type", "application/json");

            // Construct request body
            String body = String.format(
                    "{\"model\": \"%s\", \"messages\": [{\"role\": \"user\", \"content\": \"%s\"}]}",
                    MODEL, prompt
            );
            connection.setDoOutput(true);

            try (OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream())) {
                writer.write(body);
                writer.flush();
            }

            // Handle response
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        response.append(line);
                    }
                    JSONObject jsonResponse = new JSONObject(response.toString());
                    return jsonResponse.getJSONArray("choices")
                            .getJSONObject(0)
                            .getJSONObject("message")
                            .getString("content");
                }
            } else if (responseCode == HttpURLConnection.HTTP_UNAUTHORIZED) {
                throw new IOException("Unauthorized: Check your API key.");
            } else {
                throw new IOException("HTTP error code: " + responseCode);
            }

        } catch (IOException e) {
            throw new RuntimeException("Error communicating with OpenAI API", e);
        }
    }
}

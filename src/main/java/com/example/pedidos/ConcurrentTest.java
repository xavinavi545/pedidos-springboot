package com.example.pedidos;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentTest {

    public static void main(String[] args) {
        int numThreads = 20; // Puedes probar con 10, 20, 50...
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        for (int i = 0; i < numThreads; i++) {
            int finalI = i;
            executor.submit(() -> {
                try {
                    long inicio = System.currentTimeMillis();
                    URL url = new URL("http://localhost:8081/api/pedidos");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Content-Type", "application/json");
                    conn.setDoOutput(true);

                    String jsonInputString = String.format(
                        "{\"descripcion\": \"Pedido %d\", \"estado\": \"activo\"}", finalI
                    );

                    try (OutputStream os = conn.getOutputStream()) {
                        byte[] input = jsonInputString.getBytes("utf-8");
                        os.write(input, 0, input.length);
                    }

                    int code = conn.getResponseCode();
                    long fin = System.currentTimeMillis();
                    System.out.println("Hilo " + finalI + " -> Código HTTP: " + code +
                                       ", tiempo: " + (fin - inicio) + " ms");
                } catch (Exception e) {
                    System.err.println("Hilo " + finalI + " falló: " + e.getMessage());
                }
            });
        }

        executor.shutdown();
    }
}

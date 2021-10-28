package fr.amicalelaiqueabbaretz.amicalelaiqueabbaretzapi.service;

import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;

@Service
public class FileStorage {

    public void writeStringToFile(String prefix, String data) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter(generateFileName(prefix)));
        writer.write(data);

        writer.close();
    }

    private String generateFileName(String prefix) {
        Instant now = Instant.now();
        String date = now.toString();
        return prefix + date + "." + "txt";
    }
}

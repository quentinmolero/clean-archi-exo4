package fr.esgi.qmolero.infrastructure;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LocalFileReader implements Reader {
    private final String path;

    public LocalFileReader(String path) {
        this.path = path;
    }

    @Override
    public List<Integer> readNumbers() {
        List<Integer> integers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                integers.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return integers;
    }
}

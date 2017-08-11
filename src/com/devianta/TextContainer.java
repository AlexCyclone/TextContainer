package com.devianta;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@SaveTo(path = "file.txt")
public class TextContainer {

    private String text;

    public TextContainer(String text) {
        this.text = text;
    }

    @Save
    public void save(String path) {
        File f = new File(path);
        if (f.exists() && f.isDirectory()) {
            throw new IllegalArgumentException();
        }

        try (FileWriter wr = new FileWriter(path)) {
            wr.write(text);
            wr.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

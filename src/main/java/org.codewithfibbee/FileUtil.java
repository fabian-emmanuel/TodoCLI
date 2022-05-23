package org.codewithfibbee;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileUtil {
    static void writeToFile(List<String> list) {
        try (FileWriter fileWriter = new FileWriter("/Users/mac/Desktop/todoCLI/todolist.json")) {
            ObjectMapper objectMapper = new ObjectMapper();

            for (String s : list) {
                fileWriter.write(objectMapper.writeValueAsString(s));
            }
        } catch(IOException ex) {
            ex.printStackTrace();
        }

    }

    static void readFromFile(List<String> list) {
        try (FileReader fileReader = new FileReader("/Users/mac/Desktop/todoCLI/todolist.json")) {

            list = new ObjectMapper().readValue(fileReader, List.class);

        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}

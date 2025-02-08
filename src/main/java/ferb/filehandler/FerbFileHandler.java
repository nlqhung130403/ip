package ferb.filehandler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import ferb.task.Task;

public class FerbFileHandler {
    private String filePath;
    private File file;

    public FerbFileHandler(String filepath) {
        this.filePath = filepath;
        this.file = new File(filepath);
    }

    // Reads file's content if it exists, else create it
    public String readContent(){
        String content = "";
        try {
            File parentDir = file.getParentFile();
            parentDir.mkdirs();
            if (!file.exists()) {
                file.createNewFile();
            } else if (file.exists()) {
                content = new String(Files.readAllBytes(Paths.get(filePath)));
            }
        } catch (IOException e) {
            System.err.println("An error occured" + e);
        } finally {
            return content;
        }
    }

    public void writeContent(List<Task> tasks) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data/Ferb.txt"))) {
            for (Task task : tasks) {
                String line = task.toSave();
                writer.write(line);
                writer.newLine();  // Add a newline after each line
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

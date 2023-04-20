package keyin.org;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

import java.io.FileWriter;
import java.io.IOException;


public class JSONWriter {
    private String avlFilePath;
    private String bstFilePath;

    public JSONWriter(String avlFilePath, String bstFilePath) {
        this.avlFilePath = avlFilePath;
        this.bstFilePath = bstFilePath;
    }

    public void writeAVL(String treeobj) {
        try (FileWriter file = new FileWriter(avlFilePath, true)) {
            file.write(treeobj + ",\n");
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeBST(String treeobj) {
        try (FileWriter file = new FileWriter(bstFilePath, true)) {
            file.write(treeobj + ",\n");
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




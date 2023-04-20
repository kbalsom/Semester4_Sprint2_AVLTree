package keyin.org;

import java.io.FileWriter;
import java.io.IOException;

//Creates public class JSONWriter:
public class JSONWriter {

    //Sets up variables:
    private String avlFilePath;
    private String bstFilePath;

    //JSONWriter Constructor:
    public JSONWriter(String avlFilePath, String bstFilePath) {
        this.avlFilePath = avlFilePath;
        this.bstFilePath = bstFilePath;
    }

    //writeAVL Method:
    public void writeAVL(String treeobj) {
        try (FileWriter file = new FileWriter(avlFilePath, true)) {
            file.write(treeobj + ",\n");
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //writeBST Method:
    public void writeBST(String treeobj) {
        try (FileWriter file = new FileWriter(bstFilePath, true)) {
            file.write(treeobj + ",\n");
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




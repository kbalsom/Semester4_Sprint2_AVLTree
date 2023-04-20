package keyin.org;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JSONWriterTest {
    private static final String avlTestFile = "test_avl.json";
    private static final String bstTestFile = "test_bst.json";
    private static final String testString = "{\"key\": \"value\"}";

    private JSONWriter jsonWriter;

    @BeforeEach
    public void setUp() {
        jsonWriter = new JSONWriter(avlTestFile, bstTestFile);
    }

    @Test
    public void testWriteAVL() throws IOException {
        jsonWriter.writeAVL(testString);

        File avlFile = new File(avlTestFile);
        assertTrue(avlFile.exists());

        String avlContents = Files.readString(avlFile.toPath());
        assertEquals(testString  + ",\n", avlContents);
    }

    @Test
    public void testWriteBST() throws IOException {
        jsonWriter.writeBST(testString);

        File bstFile = new File(bstTestFile);
        assertTrue(bstFile.exists());

        String bstContents = Files.readString(bstFile.toPath());
        assertEquals(testString  + ",\n", bstContents);
    }
}


package ex41;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class appTest {

    @Test
    void readFile_Test() {

        app testApp = new app();
        ArrayList<String> test = testApp.readFile();

    }
}
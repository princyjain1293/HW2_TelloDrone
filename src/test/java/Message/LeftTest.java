package Message;

import Common.CommandValuesCollection;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

public class LeftTest {

    @Test
    public void doAction() {
        int xx= 25;
        String command= CommandValuesCollection.LEFT+" "+xx;
        assertEquals("left 25", command);
    }
}
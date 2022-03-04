//CSDS 132 YINGYU ZHU

package chess;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ColorValueTest {

    @Test
    public void testToString() {
        for (ColorValue colorValue : ColorValue.values()) {
            assertNotNull(colorValue.toString());
        }
    }
}
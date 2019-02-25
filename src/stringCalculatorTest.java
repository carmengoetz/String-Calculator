import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class stringCalculatorTest {

    @Test
    void add() throws Exception {
    	//testing default add case
        assertEquals( stringCalculator.add("1,2,3"), 6);
    }
    
    @Test
    void addEmpty() throws Exception {
        //testing an empty string returns 0
        assertEquals(stringCalculator.add(""), 0);
    }
    
    @Test
    void addNewLine() throws Exception {
        //testing ignores new lines
        assertEquals( stringCalculator.add("1\n,2,3"), 6);
    }
    
    @Test
    void addCustomDelimiter() throws Exception {
        //testing can add custom delimiter
        assertEquals( stringCalculator.add("//&\n1&2&3"), 6);
    }
    
    @Test
    void addNegative() throws Exception {
        //testing negative throws exception
        assertThrows(Exception.class, () -> stringCalculator.add("-1,-2,-3"));
    }
    
    @Test
    void addLargerNumber() throws Exception {
    	//testing ignores numbers over 1000
        assertEquals( stringCalculator.add("1,2,3,2000"), 6);
    }
    
    @Test
    void addArbitraryLength() throws Exception {
    	//testing delimiters can be arbitrary length
        assertEquals( stringCalculator.add("//&&&\n1&&&2&&&3"), 6);
    }
    
    @Test
    void addMultipleDelimiter() throws Exception {
    	//testing delimiters can be arbitrary length
        assertEquals( stringCalculator.add("//&,@\n1&2@3"), 6);
    }
}
import org.example.DocumentSearch;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DocumentSearchTest {

    @Test
    public void testBasicFunctionality() {
        assertEquals(2, DocumentSearch.countCaseInsensitiveMatches("Welcome to the New World. The new challenge awaits.", "new"));
    }

    @Test
    public void testEmptyAndNullInputs() {
        assertEquals(0, DocumentSearch.countCaseInsensitiveMatches("", "query"));
        assertEquals(0, DocumentSearch.countCaseInsensitiveMatches("text", ""));
        assertEquals(0, DocumentSearch.countCaseInsensitiveMatches("", ""));
        assertEquals(0, DocumentSearch.countCaseInsensitiveMatches(null, "query"));
        assertEquals(0, DocumentSearch.countCaseInsensitiveMatches("text", null));
        assertEquals(0, DocumentSearch.countCaseInsensitiveMatches(null, null));
    }

    @Test
    public void testNoMatchesFound() {
        assertEquals(0, DocumentSearch.countCaseInsensitiveMatches("Hello world", "test"));
    }

    @Test
    public void testQuerySameAsText() {
        assertEquals(1, DocumentSearch.countCaseInsensitiveMatches("Hello", "Hello"));
    }

    @Test
    public void testSpecialCharactersInQuery() {
        assertEquals(1, DocumentSearch.countCaseInsensitiveMatches("Hello? Yes!", "Hello?"));
    }

    @Test
    public void testRepeatedWordsWithoutSpaces() {
        assertEquals(1, DocumentSearch.countCaseInsensitiveMatches("HelloHelloHello", "Hello"));
    }

    @Test
    public void testCaseSensitivity() {
        assertEquals(3, DocumentSearch.countCaseInsensitiveMatches("hello Hello hElLo", "hello"));
    }

    @Test
    public void testMultipleMatchesAcrossDifferentCases() {
        assertEquals(3, DocumentSearch.countCaseInsensitiveMatches("New news, new New, NEW!", "new"));
    }
}
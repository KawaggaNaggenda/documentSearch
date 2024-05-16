package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DocumentSearch {

    public static int countCaseInsensitiveMatches(String text, String query) {
        // Check if text or query is null or empty
        if (text == null || query == null || text.isEmpty() || query.isEmpty()) {
            return 0;
        }

        // Prepare a regex pattern, making it case insensitive

        Pattern pattern = Pattern.compile(Pattern.quote(query), Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        // Count matches
        int count = 0;
        while (matcher.find()) {
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        String text = "Welcome to the New World. The new challenge awaits.";
        String query = "new";
        int result = countCaseInsensitiveMatches(text, query);
        System.out.println("Output: " + result);
    }
}
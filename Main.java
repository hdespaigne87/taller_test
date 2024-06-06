import java.util.*;

public class Main {

    private static int getLongestSubstringLenghtWithoutRepeatingCharacters(String text) {
        if (Objects.isNull(text)) {
            return 0;
        }
        int maxLenght = 0;
        StringBuilder subst = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            if (subst.toString().contains(Character.toString(character))) {
                if (subst.length() > maxLenght)
                    maxLenght = subst.length();
                subst.delete(0, subst.length());
            }
            subst.append(character);
        }
        if (text.length() > maxLenght) {
            text = text.substring(1);
            int maxLenghtRecursive = getLongestSubstringLenghtWithoutRepeatingCharacters(text);
            if (maxLenghtRecursive > maxLenght)
                return maxLenghtRecursive;
        }
        return maxLenght;
    }

    public static void main(String[] args) {
        System.out.println(getLongestSubstringLenghtWithoutRepeatingCharacters(null));
        System.out.println(getLongestSubstringLenghtWithoutRepeatingCharacters("ABDEFGABEF"));
        System.out.println(getLongestSubstringLenghtWithoutRepeatingCharacters("BBBB"));
        System.out.println(getLongestSubstringLenghtWithoutRepeatingCharacters("GEEKSFORGEEKS"));
    }
}

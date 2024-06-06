import java.util.*;

public class Main {

    private static int getLongestSubstringWithoutRepeatingCharacters(String text) {
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
            int maxLenghtRecursive = getLongestSubstringWithoutRepeatingCharacters(text);
            if (maxLenghtRecursive > maxLenght)
                return maxLenghtRecursive;
        }
        return maxLenght;
    }

    public static void main(String[] args) {
        System.out.println(getLongestSubstringWithoutRepeatingCharacters(null));
        System.out.println(getLongestSubstringWithoutRepeatingCharacters("ABDEFGABEF"));
        System.out.println(getLongestSubstringWithoutRepeatingCharacters("BBBB"));
        System.out.println(getLongestSubstringWithoutRepeatingCharacters("GEEKSFORGEEKS"));
    }
}

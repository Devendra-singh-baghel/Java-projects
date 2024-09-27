import java.security.SecureRandom;
import java.util.Scanner;

class PasswordMethod{

    static String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    static String NUMBERS = "23456789"; // Ambiguous characters removed
    static String SPECIAL_CHARACTERS = "!@#$%&*";
    static String AMBIGUOUS = "l1O0";  // Ambiguous characters

    public static void characterSelector() 
    {
        Scanner sc = new Scanner(System.in);
        int length = 0;

        while (length < 8) 
        {
            System.out.print("Enter the desired password length (must be greater than 7): ");
            if (sc.hasNextInt()) 
            {
                length = sc.nextInt();
                if (length < 8) 
                {
                    System.out.println("Password must be longer than7 characters! Please try again.");
                }
            } 
            else 
            {
                System.out.println("Invalid input! Please enter a valid integer.");
                sc.next();
            }
        }

        System.out.print("Include uppercase letters? (y/n): ");
        boolean includeUppercase = sc.next().equalsIgnoreCase("y");

        System.out.print("Include lowercase letters? (y/n): ");
        boolean includeLowercase = sc.next().equalsIgnoreCase("y");

        System.out.print("Include numbers? (y/n): ");
        boolean includeNumbers = sc.next().equalsIgnoreCase("y");

        System.out.print("Include special characters? (y/n): ");
        boolean includeSpecialChars = sc.next().equalsIgnoreCase("y");

        System.out.print("Exclude ambiguous characters (l, 1, O, 0)? (y/n): ");
        boolean excludeAmbiguous = sc.next().equalsIgnoreCase("y");

        String password = generatePassword(length, includeUppercase, includeLowercase, includeNumbers, includeSpecialChars, excludeAmbiguous);
        System.out.println("Generated Password: " + password);

        sc.close();

    }

    public static String generatePassword(int length, boolean includeUppercase, boolean includeLowercase, boolean includeNumbers, boolean includeSpecialChars, boolean excludeAmbiguous) 
    {
        StringBuilder characterPool = new StringBuilder();
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(length);

        StringBuilder guaranteedCharacters = new StringBuilder();

        if (includeUppercase) 
        {
            characterPool.append(excludeAmbiguous ? UPPERCASE.replaceAll("[O]", "") : UPPERCASE);
            guaranteedCharacters.append(characterPool.charAt(random.nextInt(characterPool.length())));
        }
        if (includeLowercase) 
        {
            characterPool.append(excludeAmbiguous ? LOWERCASE.replaceAll("[l]", "") : LOWERCASE);
            guaranteedCharacters.append(characterPool.charAt(random.nextInt(characterPool.length())));
        }
        if (includeNumbers) 
        {
            characterPool.append(excludeAmbiguous ? NUMBERS : "0123456789");
            guaranteedCharacters.append(characterPool.charAt(random.nextInt(characterPool.length())));
        }
        if (includeSpecialChars) 
        {
            characterPool.append(SPECIAL_CHARACTERS);
            guaranteedCharacters.append(SPECIAL_CHARACTERS.charAt(random.nextInt(SPECIAL_CHARACTERS.length())));
        }

    
        if (characterPool.length() == 0) 
        {
            throw new IllegalArgumentException("At least one character type must be selected.");
        }

        for (int i = 0; i < guaranteedCharacters.length(); i++) 
        {
            password.append(guaranteedCharacters.charAt(i));
        }

        for (int i = guaranteedCharacters.length(); i < length; i++) 
        {
            int index = random.nextInt(characterPool.length());
            password.append(characterPool.charAt(index));
        }

        return shuffleString(password.toString(), random);
    }

    private static String shuffleString(String input, SecureRandom random) 
    {
        char[] characters = input.toCharArray();
        for (int i = 0; i < characters.length; i++) 
        {
            int randomIndex = random.nextInt(characters.length);
            
            char temp = characters[i];
            characters[i] = characters[randomIndex];
            characters[randomIndex] = temp;
        }
        return new String(characters);
    }
}

public class PasswordGenerator {
    
    public static void main(String[] args) {

        PasswordMethod.characterSelector();
    }
}


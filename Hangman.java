package Hangman;
import java.util.ArrayList;
import java.util.Scanner;

public class Hangman {
    Hangman(String word) {
        actualGame(word);
    }

    public void actualGame(String word) {
        int lostLives=0;
        ArrayList<String> guessedLetters = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        char[] letters = word.toUpperCase().toCharArray();

        ArrayList<String> revealedLetters = new ArrayList<>();

        for(Character x : letters) {
            revealedLetters.add("_");
        }
        System.out.println("Here's number of letters: ");

        while(lostLives<=7) {
            if(lostLives==7) {
                System.out.println(showIcon(7));
                System.out.println("You lost!");
                break;
            }
            for(String x : revealedLetters) {
                System.out.print(x+" ");
            }
            if(didWin(revealedLetters,word)) {
                System.out.println("You won!");
                break;
            }
            System.out.println();
            String hangman = showIcon(lostLives);
            System.out.println("\n"+hangman);
            System.out.println("Your guesses: ");
            System.out.println(guessedLetters);
            System.out.println("What letter do you think is there?: ");
            String letter = scanner.nextLine().toUpperCase();

            //Given line must be a single letter
            if(letter.length()==1) {
                //Checking whether letter has already been typed
                if(!guessedLetters.contains(letter)) {
                    //Checking whether this letter is in word
                    for (int i = 0; i < letters.length; i++) {
                        if (letters[i] == letter.charAt(0)) {
                            revealedLetters.set(i, letter);
                        }
                    }
                    if(!revealedLetters.contains(letter)) {
                        System.out.println("Your guess was wrong!");
                        guessedLetters.add(letter);
                        lostLives++;
                    }
                    else {
                        System.out.println("Your guess was correct!");
                        guessedLetters.add(letter);
                    }
                }
                else System.out.println("You have already typed this letter!");
            }

            else System.out.println("Type a single letter");

        }
    }

    public String showIcon(int lostLives) {
        String show = "";
        switch(lostLives) {
            case 1:show = """
                    |
                    |
                    |
                    |
                    |
                    """;
                break;
            case 2: show = """
                    ====
                    |
                    |
                    |
                    |
                    """;
                break;
            case 3: show = """
                    ====
                    |  |
                    |
                    |
                    |
                    |
                    """;
                break;
            case 4: show = """
                    ====
                    |  |
                    |  O
                    |
                    |
                    |
                    """;
                break;
            case 5: show = """
                    ====
                    |  |
                    |  O
                    |  |
                    |
                    |
                    """;
                break;
            case 6: show = """
                    ====
                    |  |
                    |  O
                    | /|\\
                    |
                    |
                    """;
                break;
            case 7: show = """
                    ====
                    |  |
                    |  O
                    | /|\\
                    | / \\
                    |
                    """;
                break;
            default:
                show="";
        }
        return show;
    }
    public boolean didWin(ArrayList<String> revealed, String word) {
        boolean didWin = false;
        String wordFromArray = "";
        for(String x : revealed) {
            wordFromArray+=x;
        }
        if(wordFromArray.equals(word.toUpperCase())) {
            didWin = true;
        }

        return  didWin;
    }
}

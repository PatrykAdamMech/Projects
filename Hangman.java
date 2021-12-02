import java.util.*;

public class Hangman {

    Hangman(String word) {
        game(word);
    }

    public void game(String word) {
        int livesLost = 0;

        ArrayList<String> wordLetters = wordIntoLetters(word);
        LinkedList<String> unknownLetters = wordIntoUnknowns(word);
        LinkedList<String> guessedLetters = new LinkedList<>();

        Scanner scanner = new Scanner(System.in);

        while(true) {

            if(livesLost<7) {
                showIcon(livesLost);
                showWord(unknownLetters);
                System.out.println("\nYour choices: \n" + guessedLetters);
                if(winCondition(wordLetters,unknownLetters)) {
                    System.out.println("You won!");
                    break;
                }
                String player = scanner.nextLine().toUpperCase();
                if (player.equals("0")) break;
                System.out.println(player);

                if(player.length()==1) {
                    if(!guessedLetters.contains(player)) {
                        if(wordLetters.contains(player)) {
                            unknownLetters = uncoverLetters(player,unknownLetters,wordLetters);
                            guessedLetters.add(player);
                        }
                        else {
                            System.out.println("Letter "+player+" is not in the word!");
                            livesLost++;
                            guessedLetters.add(player);
                        }
                    }
                    else {
                        System.out.println("You have already given this letter!");
                    }
                }
                else System.out.println("You must give a SINGLE letter!");


            }

            else {
                showIcon(livesLost);
                showWord(unknownLetters);
                System.out.println("\nYour choices: \n" + guessedLetters);
                System.out.println("You lost!");
                break;

            }
        }
    }


    public LinkedList<String> uncoverLetters(String letter, LinkedList<String> unknownLetters, ArrayList<String> wordLetters) {
        for(int i = 0;i<unknownLetters.size();i++) {
            if(wordLetters.get(i).equals(letter.toUpperCase())) unknownLetters.set(i,letter.toUpperCase());
        }
        return unknownLetters;
    }
    public ArrayList<String> wordIntoLetters(String word) {
        ArrayList<String> letters = new ArrayList<>();
        for(Character x : word.toUpperCase().toCharArray()) {
            letters.add(x.toString());
        }
        return letters;
    }
    public LinkedList<String> wordIntoUnknowns(String word) {
        LinkedList<String> unknownLetters = new LinkedList<>();
        for(Character x : word.toCharArray()) {
            unknownLetters.add("_");
        }
        return unknownLetters;
    }

    public void showIcon(int livesLost) {
        switch(livesLost) {
            case 1: System.out.println("""
                    |
                    |
                    |
                    |
                    |
                    """);
                break;
            case 2: System.out.println("""
                    ====
                    |
                    |
                    |
                    |
                    """);
                break;
            case 3: System.out.println("""
                    ====
                    |  |
                    |
                    |
                    |
                    |
                    """);
                break;
            case 4: System.out.println("""
                    ====
                    |  |
                    |  O
                    |
                    |
                    |
                    """);
                break;
            case 5: System.out.println("""
                    ====
                    |  |
                    |  O
                    |  |
                    |
                    |
                    """);
                break;
            case 6: System.out.println("""
                    ====
                    |  |
                    |  O
                    | /|\\
                    |
                    |
                    """);
                break;
            case 7: System.out.println("""
                    ====
                    |  |
                    |  O
                    | /|\\
                    | / \\
                    |
                    """);
                break;
            default:
                System.out.println();
        }
    }

    public void showWord(LinkedList<String> wordLetters) {
        for(String x : wordLetters) System.out.print(x+" ");
    }

    public boolean winCondition(ArrayList<String> wordLetters,LinkedList<String> unknownLetters) {
        String word1="";
        String word2="";
        for(String x : wordLetters) {
            word1+=x;
        }
        for(String x : unknownLetters) {
            word2+=x;
        }
        return word1.equals(word2);
    }

}


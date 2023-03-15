import java.util.Scanner;

public class HighScores {

    private static Person[] players = new Person[50];

//    // Create a Person object
//    private Person createPerson (String name, int score) {
//        return new Person(name, score);
//    }

    // Ask name question
    private static String askName(){
        Scanner input = new Scanner(System.in);
        String ans = "";
        System.out.println("Enter name: ");
        ans = input.nextLine();
        return ans;
    }

    // Ask score question + validate input
    private static int askScore(){
        int ans = 0;
        boolean isValid = false;
        Scanner input2 = new Scanner(System.in);

        while (!isValid) {
            System.out.println("Enter score: ");
            try {
                ans = Integer.parseInt(input2.nextLine());
                if (ans >= 0) {
                    isValid = true;
                }
                else {
                    System.out.println("ENTER A VALID SCORE!!!");
                }
            }
            catch (NumberFormatException e) {
                System.out.println("ONLY ENTER A NUMBER!!!");
            }
        }
        return ans;
    }

    // Ask for choice + Validate choice entry for options menu
    private static int validateEntry(){
        int ans = 0;
        boolean isValid = false;
        Scanner input = new Scanner(System.in);

        while (!isValid) {
            System.out.println("Select an option [1-4]: ");
            try {
                ans = Integer.parseInt(input.nextLine());
                if (ans == 1) {
                    isValid = true;
                }
                else if (ans == 2) {
                    isValid = true;
                }
                else if (ans == 3) {
                    isValid = true;
                }
                else if (ans == 4) {
                    isValid = true;
                }
                else {
                    System.out.println("ENTER BETWEEN 1-4!!!");
                }
            }
            catch (NumberFormatException e) {
                System.out.println("ONLY ENTER A NUMBER!!!");
            }
        }
        return ans;
    }

    // Validate printing of num of scores to list
    private static int validateScoresEntry(){
        int ans = 0;
        boolean isValid = false;
        Scanner input = new Scanner(System.in);

        while (!isValid) {
            System.out.println("How many scores to list? (n>0):");
            try {
                ans = Integer.parseInt(input.nextLine());
                if (ans >= 0) {
                    isValid = true;
                }
                else {
                    System.out.println("ENTER A VALID SCORE!!!");
                }
            }
            catch (NumberFormatException e) {
                System.out.println("ONLY ENTER A NUMBER!!!");
            }
        }
        return ans;
    }

    // Change an existing score of a player
    private static void changeScore(String name, int newScore) {
        boolean personExists = false;
        if (getLengthArray(players) == 0) {
            System.out.println("Add players first!");
        }
        else {
            for (Person p : players) {
                if (p.getName().equals(name)) {
                    p.setScore(newScore);
                    System.out.println("Player: " + name + "'s score has been changed");
                    personExists = true;
                    break;
                }
            }
            if (!personExists) {
                System.out.println("Couldn't find a player of that name!");
            }
        }
    }

    // Get length of array excluding null elements
    private static int getLengthArray(Person[] p){
        int length = 0;
        for (Person element : p) {
            if (element != null) {
                length += 1;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        int lenPlayers = 0;
        int numScoresPrint = 0;
        int playersCounter = 0;
        int choice = 0;

        while(choice != 4) {
            System.out.println("Options: (1) Enter a new score (2) Print top n scores (3) Change Player Score (4) Exit");
            choice = validateEntry();
            if (choice == 1) {
                Person player = new Person(askName(), askScore());
                players[playersCounter] = player;
                playersCounter++;
            }
            else if (choice == 2) {
                lenPlayers = getLengthArray(players);
                numScoresPrint = validateScoresEntry();
                if (numScoresPrint > lenPlayers) {
                    System.out.println("There aren't enough players records to print that amount!");
                }
                else {
                    for (int j = 0; j < lenPlayers; j++) {
                        Person temp = players[j];
                        System.out.println("#" + (j+1) + "\t" + temp.getName() + "\t" + temp.getScore());
                    }
                }
            }
            else if (choice == 3) {
                changeScore(askName(), askScore());
            }
        }
    }


}

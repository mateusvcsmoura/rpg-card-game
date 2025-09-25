import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Battle {
    private final String player1Name;
    private final String player2Name;
    private Player player1;
    private Player player2;
    private int round;
    private int player1Score;
    private int player2Score;


    public Battle (String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;

        this.round = 1;
        this.player1Score = 0;
        this.player2Score = 0;
    }

    public void playGame() {
        this.player1 = new Player(this.player1Name);
        this.player2 = new Player(this.player2Name);

        System.out.println("--- BATTLE START ---");

        // System.out.println(this.player1Name + "'s Deck:");
        // this.showPlayerDeck(player1);
        // System.out.println("\n" + this.player2Name + "'s Deck:");
        // this.showPlayerDeck(player2);
        // System.out.println("--------------------");

        Scanner scanner = new Scanner(System.in);

        // MD5
        while (!checkBattleWin()) {
            System.out.println("\n========================================");
            System.out.println("========= ROUND " + this.getRound() + " - PREPARE TO FIGHT! =========");
            System.out.println("========================================");
            System.out.println("SCORE: " + this.player1Name + " " + this.getPlayer1Score() + " x " + this.getPlayer2Score() + " " + this.player2Name);

            // --- CHAMPIONS SELECT ---
            System.out.println("\n" + this.player1Name + ", choose your champion for this round!");
            Character p1Char = selectCharacter(player1, scanner);

            System.out.println("\n" + this.player2Name + ", choose your champion for this round!");
            Character p2Char = selectCharacter(player2, scanner);

            System.out.println("\n--- COMBAT START: " + p1Char.getName() + " vs " + p2Char.getName() + " ---");

            while (p1Char.getIsAlive() && p2Char.getIsAlive()) {

                // --- p1 turn ---
                System.out.println("\n" + this.player1Name + "'s turn (" + p1Char.getName() + ")");
                int p1Action = selectAction(scanner);

                if (p1Action == 1) {
                    p1Char.attack(p2Char);
                } else {
                    p1Char.defend();
                }

                // IF P2 CHAR DIES ROUND IS OVER
                if (!p2Char.getIsAlive()) {
                    break;
                }

                // --- p2 turn ---
                System.out.println("\n" + this.player2Name + "'s turn (" + p2Char.getName() + ")");
                int p2Action = selectAction(scanner);
                if (p2Action == 1) {
                    p2Char.attack(p1Char);
                } else {
                    p2Char.defend();
                }

                // resets defense stance each round
                p1Char.setDefenseStance(false);
                p2Char.setDefenseStance(false);

                System.out.println("--- Turn End Status ---");
                p1Char.showCharacterStatus();
                p2Char.showCharacterStatus();
                System.out.println("-----------------------");
            }

            System.out.println("\n--- Round " + this.getRound() + " Result ---");
            checkRoundWin(p1Char, p2Char); // checks who won the round
            this.setRound(this.getRound() + 1); // goes to the next round
        }

        scanner.close();
        System.out.println("\n--- BATTLE FINISHED ---");
    }

    private Character selectCharacter(Player player, Scanner scanner) {
        List<Character> availableCards = new ArrayList<>();
        for (Character card : player.getCards()) {
            if (card.getIsAlive()) {
                availableCards.add(card);
            }
        }

        if (availableCards.isEmpty()) {
            System.out.println(player.getName() + " has no characters left!");
            return null;
        }

        int choice = -1;
        while (choice < 1 || choice > availableCards.size()) {
            System.out.println("Choose your character:");
            for (int i = 0; i < availableCards.size(); i++) {
                Character c = availableCards.get(i);
                System.out.println((i + 1) + ": " + c.getName() + " | " + c.getRpgClass() + " (HP: " + c.getLifePoints() + ", Power: " + c.getPower() + ")");
            }
            System.out.print("Enter number: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 1 || choice > availableCards.size()) {
                    System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        return availableCards.get(choice - 1);
    }

    private int selectAction(Scanner scanner) {
        int choice = -1;
        while (choice != 1 && choice != 2) {
            System.out.println("Choose your action:");
            System.out.println("1: Attack");
            System.out.println("2: Defend");
            System.out.print("Enter number: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice != 1 && choice != 2) {
                    System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        return choice;
    }

    private void showPlayerDeck(Player player) {
        for (Character card : player.getCards()) {
            card.showCharacterStatus();
        }
    }

    private boolean checkBattleWin() {
        if (this.getRound() > 5) {
            System.out.println("\nRound limit reached!");
            if (this.getPlayer1Score() > this.getPlayer2Score()) {
                System.out.println(this.player1Name + " won the Battle by score!");
            } else if (this.getPlayer2Score() > this.getPlayer1Score()) {
                System.out.println(this.player2Name + " won the Battle by score!");
            } else {
                System.out.println("The game has ended in a draw.");
            }
            return true;
        }

        if (this.getPlayer1Score() == 3) {
            System.out.println(this.player1Name + " won the Battle!");
            return true;
        } else if (this.getPlayer2Score() == 3) {
            System.out.println(this.player2Name + " won the Battle!");
            return true;
        }

        return false;
    }

    private void checkRoundWin(Character player1Char, Character player2Char) {
        boolean p1IsAlive = player1Char.getIsAlive();
        boolean p2IsAlive = player2Char.getIsAlive();

        if (p1IsAlive && !p2IsAlive) {
            System.out.println(this.player1Name + " has won the round!");
            this.setPlayer1Score(this.getPlayer1Score() + 1);
        } else if (!p1IsAlive && p2IsAlive) {
            System.out.println(this.player2Name + " has won the round!");
            this.setPlayer2Score(this.getPlayer2Score() + 1);
        } else if (!p1IsAlive && !p2IsAlive) {
            System.out.println("Both characters knocked each other out! It's a draw for this round.");
        } else {
            System.out.println("Both characters somehow survived the round.");
        }
    }

    private void setPlayer1Score(int score) { this.player1Score = score; }
    private void setPlayer2Score(int score) { this.player2Score = score; }
    private void setRound (int round) { this.round = round; }
    public String getPlayer1Name () { return this.player1Name; }
    public String getPlayer2Name () { return this.player2Name; }
    public int getPlayer1Score () { return this.player1Score; }
    public int getPlayer2Score () { return this.player2Score; }
    public int getRound () { return this.round; }
}
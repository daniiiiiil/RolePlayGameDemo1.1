import java.util.Scanner;

public class RolePlayGameDemo {
    private static final String HELLO_MESSAGE = "You are playing fighting role part game !!!";
    private static final String NAME_MESSAGE = " enter your name please";
    private static final String PLAYER_ONE = "Player one ";
    private static final String KICK_TURN = "choose your kick: 1 - high kick, 2 - middle kick, 3 - low kick";
    private static final String BLOCK_TURN = "choose your block: 1 - high block, 2 - middle block, 3 - low block";
    private static final int HIGH_KICK_DAMAGE = 3;
    private static final int MIDDLE_KICK_DAMAGE = 2;
    private static final int LOW_KICK_DAMAGE = 1;
    private static final String PLAYER_TWO = "Player two";
    private static String playerOneName;
    private static String playerTwoName;
    private static int playerOneKick;
    private static int playerOneBlock;
    private static int playerTwoKick;
    private static int playerTwoBlock;
    private static int playerOneHealth = 10;
    private static int playerTwoHealth = 10;

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        playerOneName = String.valueOf(playerName(scanner, PLAYER_ONE, NAME_MESSAGE));
        playerTwoName = String.valueOf(playerName(scanner, PLAYER_TWO, NAME_MESSAGE));


        System.out.println(playerOneName + " vs " + playerTwoName);

        while (playerOneHealth > 0 & playerTwoHealth > 0) {

            playerOneKick = getActionValue(scanner, playerOneName, KICK_TURN);
            playerOneBlock = getActionValue(scanner, playerTwoName, BLOCK_TURN);
            playerTwoKick = getActionValue(scanner, playerTwoName, KICK_TURN);
            playerTwoBlock = getActionValue(scanner, playerTwoName, BLOCK_TURN);


            System.out.println(playerOneName + " kick: " + playerOneKick + " block " + playerOneBlock);
            System.out.println(playerTwoName + " kick: " + playerTwoKick + " block " + playerTwoBlock);

            checkFirstPlayerKickAndSecondPlayerBlock(playerOneKick, playerTwoBlock);
            checkSecondPlayerKickAndFirstPlayerBlock(playerTwoKick, playerOneBlock);

            winnerChecker(playerOneHealth, playerTwoHealth);
        }
    }

    public static void printPlayerNameAndTurn(String playerName, String turn) {
        System.out.println(playerName + " " + turn);
    }

    public static int getActionValue(Scanner scanner, String playerName, String turn) {
        printPlayerNameAndTurn(playerName, turn);
        return scanner.nextInt();
    }

    public static void checkFirstPlayerKickAndSecondPlayerBlock(int playerOneKick, int playerTwoBlock) {
        if (playerOneKick != playerTwoBlock) {
            switch (playerOneKick) {
                case 1:
                    playerTwoHealth -= HIGH_KICK_DAMAGE;
                    break;
                case 2:
                    playerTwoHealth -= MIDDLE_KICK_DAMAGE;
                    break;
                case 3:
                    playerTwoHealth -= LOW_KICK_DAMAGE;
                    break;
            }
        }
    }

    public static void checkSecondPlayerKickAndFirstPlayerBlock(int playerTwoKick, int playerOneBlock) {
        if (playerTwoKick != playerOneBlock) {
            switch (playerTwoKick) {
                case 1:
                    playerOneHealth -= HIGH_KICK_DAMAGE;
                    break;
                case 2:
                    playerOneHealth -= MIDDLE_KICK_DAMAGE;
                    break;
                case 3:
                    playerOneHealth -= LOW_KICK_DAMAGE;
                    break;
            }
        }
    }

    public static void winnerChecker(int playerOneHealth, int playerTwoHeatlth) {
        if (playerTwoHealth <= 0 & playerOneHealth <= 0) {
            System.out.println("TIE");
            playerTwoHealth = 0;
            playerOneHealth = 0;
            System.out.println(playerOneName + " has " + playerOneHealth + " health");
            System.out.println(playerTwoName + " has " + playerTwoHealth + " health");

        } else if (playerTwoHealth <= 0) {
            System.out.println(playerOneName + " WINNER!!!");
            playerTwoHealth = 0;
            System.out.println(playerOneName + " has " + playerOneHealth + " health");
            System.out.println(playerTwoName + " has " + playerTwoHealth + " health");
        } else if (playerOneHealth <= 0) {
            System.out.println(playerTwoName + " WINNER!!!");
            playerOneHealth = 0;
            System.out.println(playerOneName + " has " + playerOneHealth + " health");
            System.out.println(playerTwoName + " has " + playerTwoHealth + " health");
        } else {
            System.out.println(playerOneName + " has " + playerOneHealth + " health");
            System.out.println(playerTwoName + " has " + playerTwoHealth + " health");
        }
    }

    public static String playerName(Scanner scanner, String Player, String Message) {
        getPlayerName(Player, Message);
        return scanner.next();
    }


    public static void getPlayerName(String Player, String Message) {
        System.out.println(Player + Message);
    }
}

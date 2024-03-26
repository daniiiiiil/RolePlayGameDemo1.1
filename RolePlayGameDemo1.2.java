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

        System.out.println(HELLO_MESSAGE);

        System.out.println(PLAYER_ONE + NAME_MESSAGE);
        playerOneName = scanner.nextLine();
        System.out.println(PLAYER_TWO + NAME_MESSAGE);
        playerTwoName = scanner.nextLine();


        System.out.println(playerOneName + " vs " + playerTwoName);

        while (playerOneHealth > 0 & playerTwoHealth > 0) {

            System.out.println(playerOneName + " " + KICK_TURN);
            playerOneKick = scanner.nextInt();
            System.out.println(playerOneName + " " + BLOCK_TURN);
            playerOneBlock = scanner.nextInt();

            System.out.println(playerTwoName + " " + KICK_TURN);
            playerTwoKick = scanner.nextInt();
            System.out.println(playerTwoName + " " + BLOCK_TURN);
            playerTwoBlock = scanner.nextInt();


            System.out.println(playerOneName + " kick: " + playerOneKick + " block " + playerOneBlock);
            System.out.println(playerTwoName + " kick: " + playerTwoKick + " block " + playerTwoBlock);


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
            if (playerTwoHealth<=0 & playerOneHealth<=0) {
                System.out.println("TIE");
                playerTwoHealth = 0;
                playerOneHealth = 0;
                System.out.println(playerOneName + " has " + playerOneHealth + " health");
                System.out.println(playerTwoName + " has " + playerTwoHealth + " health");
            
            }else if (playerTwoHealth<=0) {
                System.out.println(playerTwoName + " ПОБЕДИЛ(A)!!!");
                playerTwoHealth = 0;
                System.out.println(playerOneName + " has " + playerOneHealth + " health");
                System.out.println(playerTwoName + " has " + playerTwoHealth + " health");
            }else if (playerOneHealth<=0){
                System.out.println(playerTwoName + " WINNER!!!");
                playerOneHealth = 0;
                System.out.println(playerOneName + " has " + playerOneHealth + " health");
                System.out.println(playerTwoName + " has " + playerTwoHealth + " health");
            }
            else {
                System.out.println(playerOneName + " has " + playerOneHealth + " health");
                System.out.println(playerTwoName + " has " + playerTwoHealth + " health");
            }
        }
    }
}

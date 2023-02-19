import java.util.*;

public class tictac {
    public static void main(String[] args) {

        char[][] board = { { ' ', ' ', ' ' },
                { ' ', ' ', ' ' },
                { ' ', ' ', ' ' } };

        printBoard(board);

        Scanner scn = new Scanner(System.in);

        playerturn(board, scn);

        Random rand = new Random();

        while (true) {
            int computerPlay = rand.nextInt(9) + 1;
            if (isValidMove(board, computerPlay)) {
                break;
            }
        }

        printBoard(board);

    }

    // main func end...

    private static boolean isValidMove(char[][] board, int position) {
        switch (position) {
            case 1:
                return (board[0][0] == ' ');

            case 2:
                return (board[0][1] == ' ');

            case 3:
                return (board[0][2] == ' ');
            case 4:
                return (board[1][0] == ' ');
            case 5:
                return (board[1][1] == ' ');
            case 6:
                return (board[1][2] == ' ');
            case 7:
                return (board[2][0] == ' ');
            case 8:
                return (board[2][1] == ' ');
            case 9:
                return (board[2][2] == ' ');

            default:
                return false;

        }

    }

    public static void playerturn(char[][] board, Scanner scn) {
        System.out.println("Where Would You Like to Play ? (1-9)");
        String userInput = scn.nextLine();

        // System.out.println(userInput);

        switch (userInput) {
            case "1":
                board[0][0] = 'X';
                break;
            case "2":
                board[0][1] = 'X';
                break;
            case "3":
                board[0][2] = 'X';
                break;
            case "4":
                board[1][0] = 'X';
                break;
            case "5":
                board[1][1] = 'X';
                break;
            case "6":
                board[1][2] = 'X';
                break;
            case "7":
                board[2][0] = 'X';
                break;
            case "8":
                board[2][1] = 'X';
                break;
            case "9":
                board[2][2] = 'X';
                break;

            default:
                System.out.println(":(");

        }
    }

    public static void printBoard(char[][] board) {
        System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("-+-+-");
        System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("-+-+-");
        System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);

    }

}

import java.util.*;

public class tictac {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        char[][] board = { { ' ', ' ', ' ' },
                { ' ', ' ', ' ' },
                { ' ', ' ', ' ' } };

        printBoard(board);

        while (true) {
            playerTurn(board, scn);
            if (isGameFinish(board)) {
                break;
            }
            printBoard(board);
            computerTurn(board);
            printBoard(board);
        }

        scn.close();

    }

    // main func end...

    public static boolean isGameFinish(char[][] board) {
        if (hasContestantsWon(board, 'X')) {
            printBoard(board);
            System.out.println("Player Win! :");
            return true;
        }
        if (hasContestantsWon(board, 'O')) {
            printBoard(board);
            System.out.println("Computer is Win! :");
            return true;
        }

        for (int idx = 0; idx < board.length; idx++) {
            for (int jdx = 0; jdx < board[idx].length; jdx++) {
                if (board[idx][jdx] == ' ') {
                    return false;
                }

            }
        }
        printBoard(board);
        System.out.println(" The Game ended in a tie! :");
        return true;
    }

    public static boolean hasContestantsWon(char[][] board, char symbol) {
        if ((board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol) ||
                (board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol) ||
                (board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol) ||

                (board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol) ||
                (board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol) ||
                (board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol) ||

                (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
                (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)) {

            return true;
        }
        return false;
    }

    public static void computerTurn(char[][] board) {
        Random rand = new Random();
        int computerMove;
        while (true) {
            computerMove = rand.nextInt(9) + 1;
            if (isValidMove(board, Integer.toString(computerMove))) {
                break;
            }
        }
        System.out.println("Computer Chose : " + computerMove);
        placeMove(board, Integer.toString(computerMove), 'O');
    }

    private static boolean isValidMove(char[][] board, String position) {
        switch (position) {
            case "1":
                return (board[0][0] == ' ');

            case "2":
                return (board[0][1] == ' ');

            case "3":
                return (board[0][2] == ' ');
            case "4":
                return (board[1][0] == ' ');
            case "5":
                return (board[1][1] == ' ');
            case "6":
                return (board[1][2] == ' ');
            case "7":
                return (board[2][0] == ' ');
            case "8":
                return (board[2][1] == ' ');
            case "9":
                return (board[2][2] == ' ');

            default:
                return false;

        }

    }

    public static void playerTurn(char[][] board, Scanner scn) {
        String userInput;
        while (true) {
            System.out.println("Where Would You Like to Play ? (1-9)");
            userInput = scn.nextLine();
            if (isValidMove(board, userInput)) {
                break;
            } else {
                System.out.println(userInput + " is invalid Move");
            }
        }

        // System.out.println(userInput);

        placeMove(board, userInput, 'X');

    }

    public static void placeMove(char[][] board, String position, char symbol) {

        switch (position) {
            case "1":
                board[0][0] = symbol;
                break;
            case "2":
                board[0][1] = symbol;
                break;
            case "3":
                board[0][2] = symbol;
                break;
            case "4":
                board[1][0] = symbol;
                break;
            case "5":
                board[1][1] = symbol;
                break;
            case "6":
                board[1][2] = symbol;
                break;
            case "7":
                board[2][0] = symbol;
                break;
            case "8":
                board[2][1] = symbol;
                break;
            case "9":
                board[2][2] = symbol;
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

import java.util.Scanner;

public class TicTacToeGame {
    static char[][] board = new char[3][3];
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String option;

        System.out.println("\n---- Welcome to the Tic-Tac-Toe Game! ----");

        do {
            initializeBoard();
            playGame();
            System.out.print("\nDo you want to play another round? (Y/N): ");
            option = sc.nextLine().trim().toLowerCase();
        } while (option.equals("y"));

        exitApp();
    }

    static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    static void playGame() {
        char currentPlayer = 'X';
        boolean gameEnded = false;
        int moves = 0;

        while (!gameEnded) {
            displayBoard();
            System.out.println("\nPlayer " + currentPlayer + ", it's your turn.");
            int row = getValidInput("Enter row (1-3): ") - 1;
            int col = getValidInput("Enter column (1-3): ") - 1;

            if (board[row][col] != ' ') {
                System.out.println("That spot is already taken! Try again.");
                continue;
            }

            board[row][col] = currentPlayer;
            moves++;

            if (checkWinner(currentPlayer)) {
                displayBoard();
                System.out.println("\nCongratulations! Player " + currentPlayer + " wins!");
                gameEnded = true;
            } else if (moves == 9) {
                displayBoard();
                System.out.println("\nIt's a Draw!");
                gameEnded = true;
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X'; // switch player
            }
        }
    }

    static void displayBoard() {
        System.out.println("\n    1   2   3 ");
        System.out.println("  -------------");
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + " | ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) System.out.print(" | ");
            }
            System.out.println(" |");
            System.out.println("  -------------");
        }
    }

    static int getValidInput(String prompt) {
        int value = -1;
        while (value < 1 || value > 3) {
            System.out.print(prompt);
            try {
                value = Integer.parseInt(sc.nextLine());
                if (value < 1 || value > 3) {
                    System.out.println("Please enter a valid number between 1 and 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number between 1 and 3.");
            }
        }
        return value;
    }

    static boolean checkWinner(char symbol) {
        // Rows, Columns, Diagonals
        return (board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol) || 
               (board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol) ||
               (board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol) ||
               (board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol) ||
               (board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol) ||
               (board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol) ||
               (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
               (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol);
    }

    static void exitApp() {
        System.out.println("\nThank you for playing Tic-Tac-Toe!\nPlease visit again.\nExiting the application...");
        sc.close();
    }
}

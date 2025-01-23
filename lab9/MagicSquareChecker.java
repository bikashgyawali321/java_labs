
import java.io.*;

public class MagicSquareChecker {

    public static void main(String[] args) {
        String filename = "magic.txt";

        try {
            int[][] matrix = new int[3][3];
            readMatrixFromFile(filename, matrix);

            // Check if the matrix is a magic square
            if (isMagicSquare(matrix)) {
                System.out.println("The matrix is a magic square.");
            } else {
                System.out.println("The matrix is NOT a magic square.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public static void readMatrixFromFile(String filename, int[][] matrix) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        int row = 0;

        while ((line = reader.readLine()) != null && row < 3) {
            String[] tokens = line.split("\\s+");
            for (int col = 0; col < 3; col++) {
                matrix[row][col] = Integer.parseInt(tokens[col]);
            }
            row++;
        }
        reader.close();
    }

    public static boolean isMagicSquare(int[][] matrix) {
        int sum = getRowSum(matrix, 0); // Get the sum of the first row

        for (int i = 1; i < 3; i++) {
            if (getRowSum(matrix, i) != sum) {
                return false;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (getColumnSum(matrix, i) != sum) {
                return false;
            }
        }

        if (getDiagonalSum(matrix, true) != sum) {
            return false;
        }

        if (getDiagonalSum(matrix, false) != sum) {
            return false;
        }

        return true;
    }

    public static int getRowSum(int[][] matrix, int row) {
        int sum = 0;
        for (int col = 0; col < 3; col++) {
            sum += matrix[row][col];
        }
        return sum;
    }

    public static int getColumnSum(int[][] matrix, int col) {
        int sum = 0;
        for (int row = 0; row < 3; row++) {
            sum += matrix[row][col];
        }
        return sum;
    }

    public static int getDiagonalSum(int[][] matrix, boolean isMain) {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            if (isMain) {
                sum += matrix[i][i];  
            } else {
                sum += matrix[i][2 - i];  
            }
        }
        return sum;
    }
}

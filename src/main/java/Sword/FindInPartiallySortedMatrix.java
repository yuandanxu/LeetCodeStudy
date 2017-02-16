package Sword;

/**
 * Created by yuand on 2/14/2017.
 *
 * Find whether there's a match in a two dimension array
 *
 */
public class FindInPartiallySortedMatrix {

    public static void main(String[] args) {
        Integer[][] matrix = {{1,2,5,8,11}, {2,3,6,9,12}, {3,4,7,10,13}};
        FindInPartiallySortedMatrix findInPartiallySortedMatrix = new FindInPartiallySortedMatrix();
        boolean found = findInPartiallySortedMatrix.findInPartiallySortedMatrix(matrix, 4);
    }

    public boolean findInPartiallySortedMatrix(Integer[][] matrix, Integer number) {
        if (matrix.length == 0) return false;
        boolean found = false;
        int i = 0;
        int j = matrix[0].length - 1;
        while (found==false && i<matrix.length && j>=0) {
            Integer currentNumber = matrix[i][j];
            if (currentNumber == number) {
                found = true;
            } else if (currentNumber < number) {
                i = i + 1;
            } else {
                j = j - 1;
            }
        }

        return found;
    }
}

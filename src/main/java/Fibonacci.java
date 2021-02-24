import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

import java.io.IOException;

import java.math.BigInteger;

import java.util.List;


public class Fibonacci {

    public static int[] getIntArrayFromFile(Path path) {

        List<String> allLinesFromFile = null;
        int[] dataArray = null;
        try {
            allLinesFromFile = Files.readAllLines(path);
            int size = allLinesFromFile.size();
            dataArray = new int[size];
            for (int i = 0; i < size; i++) {
                dataArray[i] = Integer.parseInt(allLinesFromFile.get(i));
            }

        } catch (NoSuchFileException e) {
            System.out.println("You attempt to access a file that does not exist!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataArray;
    }

    public static BigInteger calculateFibonacci(int n) {

        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;

        for (int i = 2; i <= n; ++i) {
            BigInteger next = a.add(b);
            a = b;
            b = next;
        }

        return b;
    }

    public static void main(String[] args) {

        Path path = Path.of("input.txt");

        int[] intArrayFromFile = getIntArrayFromFile(path);

        if (intArrayFromFile != null) {
            if (intArrayFromFile.length != 0) {
                for (int i = 0; i < intArrayFromFile.length; i++) {
                    int currentDigit = intArrayFromFile[i];
                    System.out.println("Die Fibonacci Zahl für " + currentDigit +
                            " ist: " + calculateFibonacci(currentDigit));
                }
            } else {
                System.out.println("The file is empty.");
            }
        }
    }
}

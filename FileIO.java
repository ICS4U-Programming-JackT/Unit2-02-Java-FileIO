import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Program that reads integers from a file, calculates their sum line by line,
 * and writes the sum or an error message to an output file.
 *
 * @author Jack Turcotte
 * @version 1.0
 * @since 2025-10-02
 */
public final class FileIO {

    /**
     * Constant for the input file name.
     */
    final static String INPUT_FILE = "./input.txt";

    /**
     * Constant for the output file name.
     */
    final static String OUTPUT_FILE = "./output.txt";

    /**
     * Private constructor to satisfy style checker for utility class.
     *
     * @exception IllegalStateException Utility Class
     */
    private FileIO() {
        throw new IllegalStateException("Utility Class");
    }

    /**
     * Reads the input file line by line, processes the integers,
     * and writes the results to the output file.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(final String[] args) {
        //Try to open file
        try {
            File file = new File("./input.txt");
            Scanner scanner = new Scanner(file);

            FileWriter myWriter = new FileWriter(OUTPUT_FILE);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] splitData = line.split(" ");
                int lineSum = 0;
                boolean valid = true;
                for (String character : splitData) {
                    try {
                        int number = Integer.parseInt(character);
                        lineSum += number;
                    } catch (NumberFormatException error) {
                        valid = false;
                        break;
                    }
                }
                if (valid) {
                    myWriter.write(Integer.toString(lineSum));
                } else {
                    myWriter.write("Error: line contains string");
                }
                myWriter.write("\n");
            }
            myWriter.close();
            scanner.close();
        } catch (FileNotFoundException error) {
            System.out.println(error);
        } catch (NumberFormatException error) {
            System.out.println(error);
        } catch (IOException error) {
            System.out.println(error);
        }
    }
}

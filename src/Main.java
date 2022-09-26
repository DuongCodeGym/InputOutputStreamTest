import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    final static String FILE_NAME = "test.txt";

    public static void main(String[] args) {

        //ReadFromFile();
        WriteToFile();
       // CheckFile();
    }

    private static void CheckFile() {
        File file = new File(FILE_NAME);
        System.out.println("Path: "+file.getAbsolutePath());
        System.out.println("Length : "+file.length());
        System.out.println("Can read: " + file.canRead());
        System.out.println("Can write: " + file.canRead());
    }


    private static void WriteToFile() {
        try {
            FileWriter fileWriter = new FileWriter(FILE_NAME);
            PrintWriter printer = new PrintWriter(fileWriter);
            printer.println("Hello");
            printer.println("My name is Duong");
            printer.println("Welcome to the world");

            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        System.out.println("File write successfully");

    }

}
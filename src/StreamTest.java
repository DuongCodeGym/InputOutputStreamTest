import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class StreamTest {
    public static  void main(String args[]){
        try {
            inputStreamReaderTest();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void dictionaryTest() throws IOException {
        Scanner scanner = new Scanner(System.in);
        String word = "@";
        while(!word.equals("")){
            System.out.println("Xin nhap vao 1 tu: ");
            word = scanner.nextLine();
            if (!word.equals(""))
                findWord("@"+word+" ");
        }
    }

    public static void findWord(String word)throws IOException {
        FileInputStream inputStream = null;
        String path="anhviet109K.txt";
        Scanner sc = null;
        //String l;
        String meaning;
        try {
            inputStream = new FileInputStream(path);
            sc = new Scanner(inputStream, "UTF-8");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if(line.contains(word)){
                    System.out.println(line);
                    while(!(meaning=sc.nextLine()).equals("")){
                        System.out.println(meaning);
                    }

                    return;
                }
            }
            System.err.println("Word not found");
            // note that Scanner suppresses exceptions
            if (sc.ioException() != null) {
                throw sc.ioException();
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (sc != null) {
                sc.close();
            }
        }

    }
    public static void inputStreamReaderTest() throws IOException{

            URL url = new URL("https://vnexpress.net");
            URLConnection conn = url.openConnection();

            InputStream stream = conn.getInputStream();
            InputStreamReader ir = new InputStreamReader(stream);
            BufferedReader reader = new BufferedReader(ir);

            String line;
            while((line=reader.readLine()) != null){
                System.out.println(line);
            }
            reader.close();


    }
}

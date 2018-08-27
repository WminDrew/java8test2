package lambdaFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class testLambdaFile {

    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new FileReader("E:\\code\\java8\\src\\lambdaFile\\data.txt"));
        ) {
            return p.process(br);
        }
    }

    public static void main(String[] args) {
        try {
            String result = processFile((BufferedReader b) -> b.readLine()+b.readLine()+b.readLine());
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        try {
//            Stream<String> lines = Files.lines(Paths.get("E:\\code\\java8\\src\\lambdaFile\\data.txt"), Charset.defaultCharset());
//            long uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" "))).distinct().count();
//            System.out.println(uniqueWords);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}

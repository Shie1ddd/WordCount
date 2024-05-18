import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class WordCount {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java WordCount [parameter] [input_file_name]");
            System.out.println("Parameters: -c (character count) or -w (word count)");
            return;
        }

        String parameter = args[0];
        String fileName = args[1];

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            int charCount = 0;
            int wordCount = 0;

            while ((line = reader.readLine()) != null) {
                charCount += line.length();
                String[] words = line.split("[,\\s]+");
                wordCount += words.length;
            }

            reader.close();

            if ("-c".equals(parameter)) {
                System.out.println("字符数：" + charCount);
            } else if ("-w".equals(parameter)) {
                System.out.println("单词数：" + wordCount);
            } else {
                System.out.println("Invalid parameter. Use -c (character count) or -w (word count).");
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}

// import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;


public class Main {



    public static void main(String[] args) {

        // Scanner scanner = new Scanner(System.in);
        // String message1 = scanner.nextLine();
        // String message = scanner.nextLine();
        // int key = scanner.nextInt();
        // if (message1.startsWith("enc")){
        //     System.out.println(caesarEncrypt(message, key));
        // }else if(message1.startsWith("dec")){
        //     System.out.println(caesarDecrypt(message, key));
        //


        // String algorithm = "shift";
        String mode = "enc";
        String data = "";
        String source = null;
        String output = null;
        int key = 0;

    for (int i = 0; i < args.length - 1; i++) {
        switch(args[i]) {
            case "-mode":
                if (args[i+1].toLowerCase().equals("dec")) {
                    mode = "dec";
                }
                break;
                // case "-alg":
                //     if (args[i+1].toLowerCase().equals("unicode")) {
                //         algorithm = "unicode";
                //
                //     break;
            case "-key":
                try {
                    key = Integer.parseInt(args[i+1]);
                } catch (NumberFormatException e) {
                    key = 0;
                }
                break;
            case "-data":
                data = args[i+1];
                break;
            case "-in":
                source = args[i+1];
                break;
            case "-out":
                output = args[i+1];
                break;
        }
         if (source != null) {
                        data = inputFromFile(source);

    }}
        String message1 = mode;
        String message = data;
        String message2 = output;
        if (message1.startsWith("enc")){
            System.out.println(displayResult(caesarEncrypt(message, key),output));
        }
        else if(message1.startsWith("dec")){
            System.out.println(displayResult(caesarDecrypt(message, key),output));
        }


    }

    public static String caesarEncrypt(String str, int key) {
        StringBuilder encoded = new StringBuilder();

        for (char c : str.toCharArray()) {

                char newChar = (char) (c + key );
                encoded.append(newChar);

        }
        encoded.append("\n");
        return encoded.toString();
    }
    public static String caesarDecrypt(String str, int key) {
        StringBuilder decoded = new StringBuilder();

        for (char c : str.toCharArray()) {

            char newChar = (char) (c - key );
            decoded.append(newChar);

        }
        decoded.append("\n");
        return decoded.toString();

    }

        public static String inputFromFile(String url) {
            File file = new File(url);
            try (Scanner scanner = new Scanner(file)) {
                    return scanner.nextLine();
            } catch (FileNotFoundException e) {
                return "Error! File not found!";
            }
        }


        public static String outputToFile(String data, String url) {
            File file = new File(url);
            try (PrintWriter writer = new PrintWriter(file)) {
                writer.print(data);
                return file.getAbsolutePath();
            } catch (FileNotFoundException e) {
                return "Error! Cannot write to file! " + e.getMessage();
            }
        }
         public static String displayResult(String data, String output) {
                if (output == null) {
                    return data;
                } else {
                    return outputToFile(data, output);
                }
            }



}

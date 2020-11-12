/**
 * @version 1.0
 * @author github.com/Attupatil
 * @since 2020-10-19T07:09:54Z
 "created_at": "2020-10-19T07:09:54Z",
  "updated_at": "2020-11-12T13:19:28Z",
  "pushed_at": "2020-11-12T13:19:26Z",
  "git_url": "git://github.com/Attupatil/DataSecurityEncryptDecrypt.git",
  "ssh_url": "git@github.com:Attupatil/DataSecurityEncryptDecrypt.git",
  "clone_url": "https://github.com/Attupatil/DataSecurityEncryptDecrypt.git",
  "svn_url": "https://github.com/Attupatil/DataSecurityEncryptDecrypt",
 */
// import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;


public class Og {



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


        String algorithm = "unicode";
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
            case "-alg":
                if (args[i+1].toLowerCase().equals("shift")){
                    algorithm = "shift";
                    }
                break;
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

            }
        }

        String message1 = mode;
        String message = data;
        String message2 = output;
        if (message1.startsWith("enc") && algorithm.startsWith("unicode")){
            System.out.println(displayResult(caesarEncrypt(message, key),output));
        }
        else if(message1.startsWith("dec") && algorithm.startsWith("unicode")){
            System.out.println(displayResult(caesarDecrypt(message, key),output));
        }
        else if(message1.startsWith("dec") && algorithm.startsWith("shift")){
                    System.out.println(displayResult(Shiftenc(message, key),output));
        }
        else if(message1.startsWith("enc") && algorithm.startsWith("shift")){
                    System.out.println(displayResult(Shiftdec(message, key),output));
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
                return "Error! Try again, Reason :- File not found!";
            }
        }


        public static String outputToFile(String data, String url) {
            File file = new File(url);
            try (PrintWriter writer = new PrintWriter(file)) {
                writer.print(data);
                return file.getAbsolutePath();
            } catch (FileNotFoundException e) {
                return "Error! Try again, Reason:- Cannot write to file!" + e.getMessage();
            }
        }
         public static String displayResult(String data, String output) {
                if (output == null) {
                    return data;
                } else {
                    return outputToFile(data, output);
                }
            }





         public static String Shiftenc(String data, int key){

             String result = "";
                 for (int character : data.toCharArray()) {
                      if (character >= 65 && character <= 90) {
                          if (character + key > 90) {
                              result += (char) (Math.abs(character + key - 90) + 64);
                          } else {
                              result += (char) (character + key);
                          }
                      } else if (character >= 97 && character <= 122) {
                          if (character + key >= 122) {
                              result += (char) (Math.abs(character + key - 122) + 96);
                          } else {
                              result += (char) (character + key);
                          }
                      } else {
                          result += (char) character;
                      }
                 }
                 return result;
             }

             public static String Shiftdec(String data, int key){

                 String result = "";
                 for (int character : data.toCharArray()) {
                     if (character >= 65 && character <= 90) {
                         if (character - key < 65) {
                             result += (char) (90 + (character - 64 - key));
                         } else {
                             result += (char) (character - key);
                         }
                     } else if (character >= 97 && character <= 122) {
                         if (character - key < 97) {
                             result += (char) (122 + (character - 96 - key));
                         } else {
                             result += (char) (character - key);
                         }
                     } else {
                         result += (char) character;
                     }
                 }
                 return result;
             } 

             // public static String Shiftenc(String message, int key) {
             //         int shiftRange = 'z' - 'a' + 1;
             //         char[] msgCharArray = message.toCharArray();
             //         int msgLength = msgCharArray.length;
             //         char[] encryptedMessage = new char[msgLength];
             //         for (int i = 0; i < msgLength; i++) {
             //             char c = msgCharArray[i];
             //             if (Character.isLetter(c)) {
             //                 char e = (char) (c + key);
             //                 if ((Character.isLowerCase(c) && e > 'z') || (Character.isUpperCase(c) && e > 'Z')) {
             //                     e -= shiftRange;
             //                 }
             //                 if ((Character.isLowerCase(c) && e < 'a') || (Character.isUpperCase(c) && e < 'A')) {
             //                     e += shiftRange;
             //                 }
             //                 encryptedMessage[i] = e;
             //             } else {
             //                 encryptedMessage[i] = c;
             //             }
             //         }
             //         return new String(encryptedMessage);
             //     }


             //     public static String Shiftdec(String message, int key) {
             //         return Shiftenc(message, -key);
             //     }
    //     public static void Shiftenc(String text, int key, FileWriter writer) throws IOException {
    //     String referenceForSymbols = " !\"#$%&'()*+,-./0123456789:;<=>?[\\]^_`{|}~";
    //     String referenceForCharactersLower = "abcdefghijklmnopqrstuvwxyz";
    //     String referenceForCharactersUpper = "ABCDEFGHIJKLMNOQPRSTUVWXYZ";
    //     String encryptedReferenceForCharsLower = referenceForCharactersLower.substring(key) + referenceForCharactersLower.substring(0, key);
    //     String encryptedReferenceForCharsUpper = referenceForCharactersUpper.substring(key) + referenceForCharactersUpper.substring(0, key);
    //     String character;
    //     StringBuilder newText = new StringBuilder();
    //     for (int i = 0; i < text.length(); i++) {
    //         for (int k = 0; k < referenceForSymbols.length(); k++) {
    //             if (text.charAt(i) == referenceForSymbols.charAt(k)) {
    //                 newText.append(referenceForSymbols.charAt(k));
    //                 break;
    //             }
    //         }
    //         for (int j = 0; j < encryptedReferenceForCharsLower.length(); j++) {
    //             if (text.charAt(i) == referenceForCharactersLower.charAt(j)) {
    //                 character = (text.replace(text.charAt(i), encryptedReferenceForCharsLower.charAt(j)));
    //                 newText.append(character.charAt(i));
    //                 break;
    //             }
    //         }
    //         for (int j = 0; j < encryptedReferenceForCharsUpper.length(); j++) {
    //             if (text.charAt(i) == referenceForCharactersUpper.charAt(j)) {
    //                 character = (text.replace(text.charAt(i), encryptedReferenceForCharsUpper.charAt(j)));
    //                 newText.append(character.charAt(i));
    //                 break;
    //             }
    //         }
    //     }
    //     //String newerText= newText.toString().u
    //     try (writer) {
    //         if (writer != null) {
    //             writer.write(String.valueOf(newText));
    //         } else {
    //             System.out.println(newText);
    //         }
    //     }
    // }
    //     public static void Shiftdec(String text, int key, FileWriter writer) throws IOException {
    //     String referenceForSymbols = " !\"#$%&'()*+,-./0123456789:;<=>?[\\]^_`{|}~";
    //     StringBuilder referenceForCharactersLower =new StringBuilder( "abcdefghijklmnopqrstuvwxyz")  ;
    //     StringBuilder referenceForCharactersUpper =new StringBuilder("ABCDEFGHIJKLMNOQPRSTUVWXYZ")    ;
    //     String encryptedReferenceForCharsLower = referenceForCharactersLower.substring(key) + referenceForCharactersLower.substring(0, key);
    //     String encryptedReferenceForCharsUpper = referenceForCharactersUpper.substring(key) + referenceForCharactersUpper.substring(0, key);
    //     String character;
    //     StringBuilder newText = new StringBuilder();
    //     if (key == 0) {
    //         newText.append(text);
    //     } else {
    //         for (int i = 0; i < text.length(); i++) {
    //             for (int k = 0; k < referenceForSymbols.length(); k++) {
    //                 if (text.charAt(i) == referenceForSymbols.charAt(k)) {
    //                     newText.append(referenceForSymbols.charAt(k));
    //                     break;
    //                 }
    //             }
    //             int temp=0;
    //             int tempj=0;
    //             for (int j = 0; j < referenceForCharactersLower.length(); j++) {
    //                 tempj = j;
    //                 if (referenceForCharactersLower.charAt(0)=='z'){
    //                     referenceForCharactersLower.reverse();
    //                 }
    //                 if (text.charAt(i) == referenceForCharactersLower.charAt(j)) {
    //                     if (j<key){ //3-10
    //                         temp =key - j-1;
    //                         // referenceForCharactersLower.reverse();
    //                         // temp = j;
    //                         //  j= referenceForCharactersLower.length()-2; // 25-2
    //                         //   j-=2;
    //                         character = (text.replace(text.charAt(i), referenceForCharactersLower.reverse().charAt(temp)));
    //                     }else {
    //                         // j=temp;
    //                         character = (text.replace(text.charAt(i), referenceForCharactersLower.charAt(j-key)));
    //                     }
    //                     newText.append(character.charAt(i));
    //                     break;
    //                 }
    //             }
    //             for (int j = 0; j < referenceForCharactersUpper.length(); j++) {
    //                 if (text.charAt(i) == referenceForCharactersUpper.charAt(j)) {
    //                     if (j-key<0){
    //                         j= referenceForCharactersUpper.length()-2;
    //                         j-=2;
    //                         character = (text.replace(text.charAt(i), referenceForCharactersUpper.charAt(j)));
    //                     }else {
    //                         character = (text.replace(text.charAt(i), referenceForCharactersUpper.charAt(j-key)));
    //                     }
    //                     newText.append(character.charAt(i));
    //                     break;
    //                 }
    //             }
    //         }
    //     }
    //     try (writer) {
    //         if (writer != null) {
    //             writer.write(String.valueOf(newText));
    //         } else {
    //             System.out.println(newText);
    //         }
    //     }
    // }





}

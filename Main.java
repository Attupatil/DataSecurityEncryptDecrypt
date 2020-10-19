package encryptdecrypt;

import java.util.Scanner;

public class Main {

    

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String message1 = scanner.nextLine();
        String message = scanner.nextLine();
        int key = scanner.nextInt();
        if (message1.startsWith("enc")){
            System.out.println(caesarEncrypt(message, key));
        }else if(message1.startsWith("dec")){
            System.out.println(caesarDecrypt(message, key));
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
}

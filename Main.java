// package encryptdecrypt;

// import java.util.Scanner;

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
        // }
        
        
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
                //     }
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
                // case "-in":
                //     source = args[i+1];
                //     break;
                // case "-out":
                //     output = args[i+1];
                //     break;
        }

    }
        String message1 = mode;
        String message = data;
        if (message1.startsWith("enc")){
            System.out.println(caesarEncrypt(message, key));
        }
        else if(message1.startsWith("dec")){
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

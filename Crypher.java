
/**
 * @version 2.0
 * @author github.com/Attupatil
 * @since 2020-10-19T07:09:54Z
 * @updated_at: "2020-11-12T13:19:28Z",
 * @pushed_at: "2020-11-12T13:19:26Z",
 * @git_url: "git://github.com/Attupatil/DataSecurityEncryptDecrypt.git",
 * @ssh_url: "git@github.com:Attupatil/DataSecurityEncryptDecrypt.git",
 * @clone_url: "https://github.com/Attupatil/DataSecurityEncryptDecrypt.git",
 * @svn_url: "https://github.com/Attupatil/DataSecurityEncryptDecrypt",
 */
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Crypher {

    interface Algoritm {

        char decrypt(char ch, int key);

        char encrypt(char ch, int key);

    }

    static class Unicode implements Algoritm {

        @Override
        public char decrypt(char ch, int key) {
            int dec = ch - key;
            return (char) (dec < 0 ? (128 - dec) : dec);
        }

        @Override
        public char encrypt(char ch, int key) {
            return (char) ((ch + key) % 128);
        }
    }

    static class Shift implements Algoritm {

        @Override
        public char decrypt(char ch, int key) {
            if (ch >= 'a' && ch <= 'z') {
                int dec = ch - 'a' - key % 26;
                return (char) (dec < 0 ? ('z' + dec + 1) : 'a' + dec);
            }
            if (ch >= 'A' && ch <= 'Z') {
                int dec = ch - 'A' - key % 26;
                return (char) (dec < 0 ? ('Z' + dec + 1) : 'A' + dec);
            }
            return ch;
        }

        @Override
        public char encrypt(char ch, int key) {
            if (ch >= 'a' && ch <= 'z') {
                return (char) (((ch - 'a' + key) % 26) + 'a');
            }
            if (ch >= 'A' && ch <= 'Z') {
                return (char) (((ch - 'A' + key) % 26) + 'A');
            }
            return ch;
        }
    }

    public static void main(String[] args) {
        int key = 0;
        String text = "";
        String mode = "enc";
        String alg = "shift";
        String out = null;
        for (int i = 0; i < args.length; i += 2) {
            switch (args[i]) {
                case "-mode": {
                    mode = args[i + 1];
                    break;
                }
                case "-key": {
                    key = Integer.parseInt(args[i + 1]);
                    break;
                }
                case "-data": {
                    text = args[i + 1];
                    break;
                }
                case "-in": {
                    if (text.isEmpty()) {
                        try {
                            text = new String(Files.readAllBytes(Paths.get(args[i + 1])));
                        } catch (IOException e) {
                            System.out.println("Error while looking for file.. " + e.getMessage());
                        }
                    }
                    break;
                }
                case "-out": {
                    out = args[i + 1];
                    break;
                }
                case "-alg": {
                    alg = args[i + 1];
                    break;
                }
                default: {
                    System.out.println("Unknown parameter type");
                    return;
                }
            }
        }
        Algoritm algoritm = null;
        switch (alg) {
            case "shift":
                algoritm = new Shift();
                break;
            case "unicode":
                algoritm = new Unicode();
                break;
        }
        StringBuilder data = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (mode.equals("enc")) {
                data.append(algoritm.encrypt(ch, key));
            } else if (mode.equals("dec")) {
                data.append(algoritm.decrypt(ch, key));
            } else {
                data.append(ch);
            }
        }
        if (out == null) {
            System.out.println(data);
        } else {
            try (FileWriter writer = new FileWriter(out)) {
                writer.write(data.toString());
            } catch (IOException e) {
                System.out.print("An exception occurs " + e.getMessage());
            }
        }
    }
}

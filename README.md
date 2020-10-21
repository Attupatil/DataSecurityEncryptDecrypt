# DataSecurityEncryptDecrypt
Today, encryption and decryption algorithms are used everywhere on the Internet to protect our data. This is especially important for sites that handle sensitive data, such as e-commerce sites that accept online card payments and login areas that require users to enter their credentials. To ensure data security, there are complex encryption algorithms behind the scenes.

In this project includes how to encrypt and decrypt messages and texts using simple algorithms. We should note that such algorithms are not suitable for industrial use because they can easily be cracked, but these algorithms demonstrate some general ideas about encryption.

## key
The key is assumed to mean that if a person knows the value of the key, he or she will be able to decrypt the text, and if he or she does not know, he or she will not be able to decrypt the text. It's like a real key that can open up access to the message text.


## General
A Java application can accept data from the external world using the command-line arguments. JVM wraps the argument in the array of strings and passes the array to the main method.

## Speciality
The program must parse three arguments: -mode, -key and -data. The first argument should determine the program’s mode (enc for encryption, dec for decryption). The second argument is an integer key to modify the message, and the third argument is a text or ciphertext to encrypt or decrypt.

All the arguments are guaranteed to be passed to the program. If for some reason it turns out to be wrong:

    If there is no -mode, the program should work in enc mode.
    If there is no -key, the program should consider that key = 0.
    If there is no -data, the program should assume that the data is an empty string.
Keep in mind that the order of the arguments might be different. For example, -mode enc may be at the end, at the beginning or in the middle of arguments array.

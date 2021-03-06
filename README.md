# DataSecurityEncryptDecrypt
Today, encryption and decryption algorithms are used everywhere on the Internet to protect our data. This is especially important for sites that handle sensitive data, such as e-commerce sites that accept online card payments and login areas that require users to enter their credentials. To ensure data security, there are complex encryption algorithms behind the scenes.

Privacy is an important matter is the realm of the Internet. When sending a message, you want to be sure that no-one but the addressee with the key can read it. The entirety of the modern Web is encrypted - take https for example!

This project includes how to encrypt and decrypt messages and texts using simple algorithms.It must be noted that such algorithms are not suitable for industrial use because they can easily be cracked, but these algorithms demonstrate some general ideas about encryption.

## Normal Usage Run

Input 

``` bash
java Main -mode enc -key 5 -data "This is Secret message from Atharva" 
```

Output  
``` bash  
Ymnx%nx%Xjhwjy%rjxxflj%kwtr%Fymfw{f
```
Input
``` bash    
java Main -key 5 -data "Ymnx%nx%Xjhwjy%rjxxflj%kwtr%Fymfw{f" -mode dec
```
Output
``` bash    
This is Secret message from Atharva
```
## key
The key is assumed to mean that if a person knows the value of the key, he or she will be able to decrypt the text, and if he or she does not know, he or she will not be able to decrypt the text. It's like a real key that can open up access to the message text.


## General
A Java application can accept data from the external world using the command-line arguments. JVM wraps the argument in the array of strings and passes the array to the main method.

## Speciality
The program must parse three arguments: -mode, -key and -data. The first argument should determine the program’s mode (enc for encryption, dec for decryption). The second argument is an integer key to modify the message, and the third argument is a text or ciphertext to encrypt or decrypt.

All the arguments are guaranteed to be passed to the program. If for some reason it turns out to be wrong:

    If there is no -mode, the program works in enc mode.
    If there is no -key, the program considers that key = 0.
    If there is no -data, the program assumes that the data is an empty string.
Speciality of this program is that the order of the arguments might be different. For example, `-mode enc` may be at the end, at the beginning or in the middle of arguments array.
#
# Advance Usage

It is often the case that  SysAdmins needs to process and store data located outside: configuration settings, some dataset for processing, logs of execution and so on. The simplest way to store data is to use files that are supported by all modern operating systems. You can consider a file as a collection of data that is stored on a disk or another device, and that can be manipulated as a single unit when addressed by its name.Therefore The program gets update about storing enc dec in files for longer and sustainable use.
Added the ability to read and write original and cipher data to files. The program parses two additional arguments `-in` and `-out` to specify the full name of a file to read data and to write the result.
The program reads data from `-data` or from a file written in the `-in` argument. That's why you can't have both `-data` and `-in` arguments simultaneously, only one of them.

    If there is no -data, and there is no -in the program assumes that the data is an empty string.
    If there is no -out argument, the program prints data to the standard output.
    If there are both -data and -in arguments, The program prefer -data over -in.
  
## Run
Input:
``` bash
java Main -mode enc -in NuclearCode.txt -out WhatIsNuclear.txt -key 5 -alg unicode
```
Output:
This command must get data from the file `NuclearCode.txt`, encrypt the data with the key 5, create a file called `WhatIsNuclear.txt` and write `ciphertext Algorithm unicode` to it.

Input:
```bash
java Main -key 5 -alg shift -data "Ymnx nx Xjhwjy rjxxflj kwtr Fymfwaf" -mode dec
```
Output:
```bash
This is Secret message from Atharva
```

## Error Handling
If there is a non-standard situation (an input file does not exist or an argument doesn’t have a value), the program does not fail. Instead, it displays a clear message about the problem and stop successfully. The message contains the word ```"Error! Try again, Reason:- XYZ!"``` in any case {where Reason gives exact error which occured}.
   

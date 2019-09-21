#!/bin/bash

cd /Users/amsavchenko/Documents/Java/lab1

javac -sourcepath src -d bin -classpath /Users/amsavchenko/Documents/Java/lab1/commons-codec-1.8.jar src/com/amsavchenko/hash/Main.java src/com/amsavchenko/hash/CountHash.java src/com/amsavchenko/hash/InteractiveMode.java src/com/amsavchenko/hash/SimpleMode.java

mkdir lib
cd lib
jar -xvf /Users/amsavchenko/Documents/Java/lab1/commons-codec-1.8.jar org/
cd ..
cp -r bin/* lib/
jar -cef com.amsavchenko.hash/Main main.jar -C lib .
rm -r lib
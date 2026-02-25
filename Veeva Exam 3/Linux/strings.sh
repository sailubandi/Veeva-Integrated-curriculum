#!/bin/bash

echo "Enter file name:"
read filename

echo "Enter string to search:"
read searchword

if [ -f "$filename" ]; then
    echo "Matching lines:"
    grep "$searchword" "$filename"
else
    echo "File does not exist."
fi

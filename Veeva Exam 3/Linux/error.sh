#!/bin/bash

echo "Enter file name to check:"
read filename

if [ -f "$filename" ]; then
    echo "$(date) : File exists - $filename" >> log.txt
    echo "File exists."
else
    echo "$(date) : ERROR - File not found - $filename" >> error.txt
    echo "Error logged in error.txt"
fi

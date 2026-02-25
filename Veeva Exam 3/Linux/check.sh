#!/bin/bash

echo "Enter file name:"
read fn

if [ -f "$fn" ]; then
    echo "File exists in current directory."
else
    echo "File does not exist in current directory."
fi

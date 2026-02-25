#!/bin/bash

echo "Enter message to log:"
read message

echo "$(date) : $message" >> log.txt

echo "Message logged successfully."

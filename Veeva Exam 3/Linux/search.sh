
echo "----- Searching entire system -----"
# Search file entire system
location=$(find / -name "$filename" 2>/dev/null)

if [ -n "$location" ]; then
    echo "File found at:"
    echo "$location"
else
    echo "File NOT found anywhere in system."
fi

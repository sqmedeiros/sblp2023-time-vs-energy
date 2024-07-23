import os
import sys

path = sys.argv[1]
text = "entry_"

files = os.listdir(path)

for file in files:
  s = path + "/" + file
  entry_pos = s.find(text)
  
  if not entry_pos == -1:
    print(f"Renaming file: {s}")
    os.rename(s, s[:entry_pos] + s[entry_pos + len(text):])
  else:
    print(f"Not renaming file: {s}")
  

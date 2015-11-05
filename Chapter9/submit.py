import os
import shutil

for file in os.listdir('.'):
	if '.java' in file:
		shutil.copy(file, file.replace('.java', '.txt'))
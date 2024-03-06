import os
import json

# Define a function to remove specified elements from a JSON file
def remove_elements(file_path):
    with open(file_path, 'r') as f:
        data = json.load(f)
    
    # Remove specified elements
    if 'i18n' in data:
        # for audit_key in ['fullPageScreenshot', 'final-screenshot']:
        #     if audit_key in data['audits']:
                # del data['audits'][audit_key]
                del data['i18n']
    
    # Save modified JSON back to the file
    with open(file_path, 'w') as f:
        json.dump(data, f, indent=4)

# Iterate over the folders and files
folders = ['bigsize', 'courier', 'ecommerce', 'education', 'entertainment', 'gov', 'healthcare', 'news', 'nonprofit', 'mediumsize', 'smallsize', 'socialmedia']
for folder in folders:
    if os.path.isdir(folder):
        for root, _, files in os.walk(folder):
            for file in files:
                if file.endswith('.json'):
                    print(f"\n{file}")
                    file_path = os.path.join(root, file)
                    remove_elements(file_path)

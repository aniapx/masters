import os
import json

# IDs of issues to exclude
exclude_ids = {'layout-shift-elements', 'server-response-time', 'bootup-time', 'third-party-summary', 'largest-contentful-paint-element', 'mainthread-work-breakdown', 'bf-cache', 'offscreen-images', 'unused-css-rules', 'viewport', 'first-contentful-paint', 'largest-contentful-paint', 'first-meaningful-paint', 'speed-index', 'total-blocking-time', 'max-potential-fid', 'cumulative-layout-shift', 'interactive', 'redirects', 'uses-rel-preconnect', 'font-display', 'unsized-images', 'lcp-lazy-loaded', 'prioritize-lcp-image', 'uses-long-cache-ttl', 'render-blocking-resources', 'unminified-css', 'unused-javascript', 'modern-image-formats', 'uses-text-compression', 'uses-optimized-images', 'uses-responsive-images', 'efficient-animated-content', 'uses-text-compression', 'legacy-javascript', 'no-document-write', 'uses-http2', 'uses-passive-event-listeners', 'unminified-javascript', 'total-byte-weight', 'duplicated-javascript', 'meta-viewport'}

# Function to process a single file and write results to a file
def process_file(file_path, output_file):
    with open(file_path, 'r') as f, open(output_file, 'a') as output:
        data = json.load(f)
        
        output.write(f"\nData in file: {file_path}\n")
        
        # Iterate over the audits section
        for audit_id, audit_data in data['audits'].items():
            if audit_id not in exclude_ids:
                score = audit_data['score']
                if score is not None and score == 0:  # Exclude issues with score 0
                    output.write(f"ID: {audit_id}\n")
                    output.write(f"Title: {audit_data['title']}\n")
                    output.write(f"Description: {audit_data['description']}\n")
                    output.write(f"Score: {score}\n")
                    output.write('\n')  # Add a new line between issues

# Iterate over the folders and files
folders = ['bigsize', 'courier', 'ecommerce', 'education', 'entertainment', 'gov', 'healthcare', 'news', 'nonprofit', 'mediumsize', 'smallsize', 'socialmedia']
for folder in folders:
    if os.path.isdir(folder):
        output_file = folder + '.txt'  # Define the output file name
    
        for root, _, files in os.walk(folder):
            for file in files:
                if file.endswith('.json'):
                    file_path = os.path.join(root, file)
                    process_file(file_path, output_file)

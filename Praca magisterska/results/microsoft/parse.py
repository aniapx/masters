import os
import glob
import re
from bs4 import BeautifulSoup

def parse_html(html_file):
    with open(html_file, 'r', encoding='utf-8') as file:
        soup = BeautifulSoup(file, 'html.parser')

        failed_instances = soup.find_all(lambda tag: tag.name == 'div' and tag.get('class') and (tag['class'][0].startswith('failed-instances-container')))

        results = []
        for instance in failed_instances:
            tables = instance.find_all(lambda tag: tag.get('class') and (tag['class'][0].startswith('collapsible-container')))

            for table in tables:
                instance_data = {}
                
                # Extracting failed instances count
                h3_element = instance.find('h3')
                failed_count = h3_element.find('span', class_='count').text.strip() if h3_element else "Failed instances count not found"
                instance_data['failed_count'] = failed_count

                # Extracting failure title
                failure_title_span = table.find('span', class_='rule-details-description')
                failure_title = failure_title_span.text.strip().replace('\n', ' ') if failure_title_span else None
                failure_title = re.sub(r'\s+', ' ', failure_title) if failure_title else None
                instance_data['failure_title'] = failure_title
                
                # Extracting failure count
                failure_count_span = table.find('span', class_='count')
                failure_count = failure_count_span.text.strip() if failure_count_span else None
                instance_data['failure_count'] = failure_count

                # Extracting how to fix information
                how_to_fix_div = table.find('div', class_=re.compile(r'how-to-fix-content'))
                if how_to_fix_div:
                    how_to_fix = how_to_fix_div.text.strip().replace('\n', ' ')
                    how_to_fix = re.sub(r'\s+', ' ', how_to_fix) if how_to_fix else None
                    instance_data['how_to_fix'] = how_to_fix
                else:
                    instance_data['how_to_fix'] = "How to fix: information not found"

                results.append(instance_data)

        return results
    
def print_to_file(file, data):
        for instance in data:
            file.write("Failed instances count: {}\n".format(instance['failed_count']))
            file.write("Failure Title: {}\n".format(instance['failure_title']))
            file.write("Failure Count: {}\n".format(instance['failure_count']))
            file.write("How to fix: {}\n".format(instance['how_to_fix']))
            file.write("\n")

# folders = ['courier']
folders = ['bigsize', 'courier', 'ecommerce', 'education', 'entertainment', 'gov', 'healthcare', 'news', 'nonprofit', 'mediumsize', 'smallsize', 'socialmedia']

for folder in folders:
    folder_path = os.path.join('.', folder)
    html_files = glob.glob(os.path.join(folder_path, '*.html'))  # Adjust pattern to match all HTML files

    # Create a file with the folder name
    output_file_name = f"{folder}.txt"
    with open(output_file_name, 'w', encoding='utf-8') as output_file:
        output_file.write(f"Folder: {folder}\n")

    for html_file in html_files:
        print("Parsing file:", html_file)
        parsed_data = parse_html(html_file)

        # Append the parsed data to the output file
        with open(output_file_name, 'a', encoding='utf-8') as output_file:
            output_file.write(f"\n\n---------- File: {html_file} ----------\n\n")
            print_to_file(output_file, parsed_data)

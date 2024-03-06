import os
import glob
from bs4 import BeautifulSoup

def parse_html(html_file):
    with open(html_file, 'r', encoding='utf-8') as file:
        soup = BeautifulSoup(file, 'html.parser')

        failed_instances = soup.find_all(lambda tag: tag.name == 'div' and tag.get('class') and (tag['class'][0].startswith('failed-instances-container')))

        results = []
        for instance in failed_instances:
            snippet_element = instance.find(lambda tag: tag.name == 'td' and tag.get('class') and tag['class'][0].startswith('snippet'))
            snippet = snippet_element.text.strip() if snippet_element else ''

            how_to_fix = instance.find('li').text.strip()

            results.append({'snippet': snippet, 'how_to_fix': how_to_fix})

        return results

folders = ['courier']
# folders = ['bigsize', 'courier', 'ecommerce', 'education', 'entertainment', 'gov', 'healthcare', 'news', 'nonprofit', 'mediumsize', 'smallsize', 'socialmedia']

for folder in folders:
    folder_path = os.path.join('.', folder)
    html_files = glob.glob(os.path.join(folder_path, 'dhl_ship.html'))

    for html_file in html_files:
        print("Parsing file:", html_file)
        parsed_data = parse_html(html_file)

        for data in parsed_data:
            print("Snippet:", data['snippet'])
            print("How to fix:", data['how_to_fix'])
            print()

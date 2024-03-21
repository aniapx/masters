import os
import re
import matplotlib.pyplot as plt
import math

# Define the list of file names
# file_names = ['bigsize', 'courier', 'ecommerce', 'education', 'entertainment', 'gov', 'healthcare', 'news', 'nonprofit', 'mediumsize', 'smallsize', 'socialmedia']
file_names = ['socialmedia']


# Iterate over each file
for file_name in file_names:
    # Create the directory for the current file if it doesn't exist
    folder_name = f"{file_name}_graphs"
    if not os.path.exists(folder_name):
        os.makedirs(folder_name)

    # Initialize dictionaries to store data for this file
    all_issues = set()
    file_issues = {}

    # Read data from the file
    with open(f"{file_name}.txt", "r") as file:
        data = file.read()

    # Split the data into sections
    sections = re.split(r"[\w]+\\", data)[1:]

    # Parse each section
    for section in sections:
        lines = section.split("\n")

        # Extract the JSON file name
        json_file_name = lines[0].split("_")[0]

        # Find and parse Critical Issues
        critical_index = lines.index("Critical Issues:") + 1 if "Critical Issues:" in lines else len(lines)
        end_critical_index = lines.index("Serious Issues:") if "Serious Issues:" in lines else len(lines)
        critical_issues_data = lines[critical_index:end_critical_index]

        for issue_data in critical_issues_data:
            if ";" in issue_data:
                issue, count, description = issue_data.strip().split(":")
                count = int(count.strip())
                all_issues.add(issue.strip())
                file_issues.setdefault(json_file_name, {}).setdefault(issue.strip(), {"count": 0, "severity": ""})
                file_issues[json_file_name][issue.strip()]["count"] += count
                file_issues[json_file_name][issue.strip()]["severity"] = "Critical Issues"
 

        # Find and parse Serious Issues
        serious_index = lines.index("Serious Issues:") + 1 if "Serious Issues:" in lines else len(lines)
        serious_issues_data = lines[serious_index:]

        for issue_data in serious_issues_data:
            if ";" in issue_data:
                issue, count, description = issue_data.strip().split(":")
                count = int(count.strip())
                all_issues.add(issue.strip())
                file_issues.setdefault(json_file_name, {}).setdefault(issue.strip(), {"count": 0, "severity": ""})
                file_issues[json_file_name][issue.strip()]["count"] += count
                file_issues[json_file_name][issue.strip()]["severity"] = "Serious Issues"

    # Convert the set of all issues to a sorted list
    all_issues = sorted(list(all_issues))

    # Calculate the maximum total count among all issues for setting the y-axis size
    max_total_count = max([sum(file_issues.get(json_file, {}).get(issue, {"count": 0})["count"] for json_file in file_issues.keys()) for issue in all_issues], default=0)

    # Round up the maximum total count to the nearest full number
    max_total_count = math.ceil(max_total_count)

    # Add a little space between the topmost number and the top border
    max_total_count += 5

    # Plotting Total Issues
    plt.figure(figsize=(12, 6))
    total_issue_counts = [sum(file_issues.get(json_file, {}).get(issue, {"count": 0})["count"] for json_file in file_issues.keys()) for issue in all_issues]
    plt.bar(all_issues, total_issue_counts)
    plt.title(f'Total Issues for {file_name}')
    plt.xlabel('Issue Type')
    plt.ylabel('Count')
    plt.xticks(rotation=90)
    plt.ylim(0, max_total_count)  # Set the y-axis limits using the maximum total count
    plt.tight_layout()
    for i, count in enumerate(total_issue_counts):
        plt.text(i, count + 0.1, str(count), ha='center', va='bottom')
    plt.savefig(os.path.join(folder_name, 'total_issues.png'))  # Save total issues plot to a file in the current folder
    plt.close()

    # Plotting Issues for each JSON file
    for json_file_name in file_issues.keys():
        plt.figure(figsize=(12, 6))
        x = file_issues.keys();
        print(f"{x}")

        c = "orange"
        # if x["severity"] == "Critical Issues": 
        #     c = "red"

        individual_issue_counts = [sum(file_issues.get(json_file, {}).get(issue, {"count": 0})["count"] for json_file in file_issues.keys()) for issue in all_issues]
        plt.bar(all_issues, individual_issue_counts, color=c)
        for i, count in enumerate(individual_issue_counts):
            plt.text(i, count + 0.1, str(count), ha='center', va='bottom', color=c)
        
        plt.title(f"Issues for {json_file_name}")
        plt.xlabel('Issue Type')
        plt.ylabel('Count')
        plt.xticks(rotation=90)
        plt.ylim(0, max_total_count)  # Set the y-axis limits using the maximum total count
        plt.tight_layout()
        plt.savefig(os.path.join(folder_name, f'{json_file_name}_issues.png'))  # Save individual file issues plot to a file in the current folder
        plt.close()

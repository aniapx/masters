import os
import re
import matplotlib.pyplot as plt
import math
import numpy as np  

file_names = ['bigsize', 'courier', 'ecommerce', 'education', 'entertainment', 'gov', 'healthcare', 'news', 'nonprofit', 'mediumsize', 'smallsize', 'socialmedia']
file_names = ['education']

for file_name in file_names:
    folder_name = f"{file_name}_graphs"
    if not os.path.exists(folder_name):
        os.makedirs(folder_name)

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
                file_issues.setdefault(json_file_name, {}).setdefault(issue.strip(), {}).setdefault('count', 0)
                file_issues.setdefault(json_file_name, {}).setdefault(issue.strip(), {}).setdefault('color', 'red')
                x = file_issues[json_file_name][issue.strip()]
                file_issues[json_file_name][issue.strip()]["count"] += count

        # Find and parse Serious Issues
        serious_index = lines.index("Serious Issues:") + 1 if "Serious Issues:" in lines else len(lines)
        serious_issues_data = lines[serious_index:]

        for issue_data in serious_issues_data:
            if ";" in issue_data:
                issue, count, description = issue_data.strip().split(":")
                count = int(count.strip())
                all_issues.add(issue.strip())
                file_issues.setdefault(json_file_name, {}).setdefault(issue.strip(), {}).setdefault('count', 0)
                file_issues.setdefault(json_file_name, {}).setdefault(issue.strip(), {}).setdefault('color', 'orange')
                file_issues[json_file_name][issue.strip()]["count"] += count

    # Convert the set of all issues to a sorted list
    all_issues = sorted(list(all_issues))
    max_total_count = max([sum(file_issues.get(json_file, {}).get(issue, {}).get("count", 0) for json_file in file_issues.keys()) for issue in all_issues], default=0)
    max_total_count = math.ceil(max_total_count) + 5

    # Plotting Total Issues
    plt.figure(figsize=(10, 7))
    total_issue_counts = [sum(file_issues.get(json_file, {}).get(issue, {}).get("count", 0) for json_file in file_issues.keys()) for issue in all_issues]    
    colors_arrays = [[file_issues.get(json_file, {}).get(issue, {}).get("color", "") for json_file in file_issues.keys()] for issue in all_issues]

    colors = [];
    for subarr in colors_arrays:
        if any(item == 'red' for item in subarr):
            colors.append('red');
        else:
            colors.append('orange');
        
    plt.bar(all_issues, total_issue_counts, edgecolor='black', color=colors)
    
    for ticklabel, tickcolor in zip(plt.gca().get_xticklabels(), colors):
        ticklabel.set_color(tickcolor)

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
    idx = -0.4
    plt.figure(figsize=(10, 7))
    X_axis = np.arange(len(all_issues))
    max_count = 0

    for json_file_name in file_issues.keys():
        individual_issue_counts = [file_issues[json_file_name].get(issue, {}).get("count", 0) for issue in all_issues]

        maxtemp = max(individual_issue_counts)
        if maxtemp > max_count:
            max_count = maxtemp

        plt.bar(X_axis + idx, individual_issue_counts, 0.2, edgecolor='black', color=colors)
        for i, count in enumerate(individual_issue_counts):
            plt.text(i + idx, count + 0.1, str(count), ha='center', va='bottom')
        idx += 0.2

    
    plt.title(f"Issues for {file_name}")
    plt.ylabel('Count')
    plt.xlabel('Issue Type')
    plt.xticks(X_axis-idx, all_issues) 
    plt.xticks(rotation=60)

    for ticklabel, tickcolor in zip(plt.gca().get_xticklabels(), colors):
        ticklabel.set_color(tickcolor)

    plt.ylim(0, max_count + 5)  # Set the y-axis limits using the maximum total count
    plt.tight_layout()
    plt.savefig(os.path.join(folder_name, f'{folder_name}_issues.png'))  # Save individual file issues plot to a file in the current folder
    plt.close()

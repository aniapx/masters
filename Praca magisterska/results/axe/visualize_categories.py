import re
import matplotlib.pyplot as plt
import math
import numpy as np  

categories = ['bigsize', 'courier', 'ecommerce', 'education', 'entertainment', 'gov', 'healthcare', 'news', 'nonprofit', 'mediumsize', 'smallsize', 'socialmedia']
# categories = ['courier']

for category in categories:
    json_file_names = set()
    all_issues = set()
    file_issues = {}

    with open(f"{category}.txt", "r") as file:
        data = file.read()

    sections = re.split(r"[\w]+\\", data)[1:]

    for section in sections:
        lines = section.split("\n")

        json_file_name = lines[0].split("_")[0]
        json_file_names.add(json_file_name);

        if "Critical Issues:" in lines:
            critical_index = lines.index("Critical Issues:") + 1
            end_critical_index = lines.index("Serious Issues:") if "Serious Issues:" in lines else len(lines)
            critical_issues_data = lines[critical_index:end_critical_index]

            if all(data == '' for data in critical_issues_data): 
                file_issues.setdefault(json_file_name, {})

            for issue_data in critical_issues_data:
                if ";" in issue_data:
                    issue, count, description = issue_data.strip().split(":")
                    count = int(count.strip())
                    all_issues.add(issue.strip())
                    file_issues.setdefault(json_file_name, {}).setdefault(issue.strip(), {}).setdefault('count', 0)
                    file_issues.setdefault(json_file_name, {}).setdefault(issue.strip(), {}).setdefault('color', 'red')
                    file_issues.setdefault(json_file_name, {}).setdefault(issue.strip(), {}).setdefault('hatch', 'X')
                    file_issues[json_file_name][issue.strip()]["count"] += count

        if "Serious Issues:" in lines:
            serious_index = lines.index("Serious Issues:") + 1
            serious_issues_data = lines[serious_index:]

            for issue_data in serious_issues_data:
                if ";" in issue_data:
                    issue, count, description = issue_data.strip().split(":")
                    count = int(count.strip())
                    all_issues.add(issue.strip())
                    file_issues.setdefault(json_file_name, {}).setdefault(issue.strip(), {}).setdefault('count', 0)
                    file_issues.setdefault(json_file_name, {}).setdefault(issue.strip(), {}).setdefault('color', 'orange')
                    file_issues.setdefault(json_file_name, {}).setdefault(issue.strip(), {}).setdefault('hatch', '/')
                    file_issues[json_file_name][issue.strip()]["count"] += count

    all_issues = sorted(list(all_issues))
    max_total_count = max([sum(file_issues.get(json_file, {}).get(issue, {}).get("count", 0) for json_file in file_issues.keys()) for issue in all_issues], default=0)
    max_total_count = math.ceil(max_total_count) + 5

    plt.figure(figsize=(10, 7))
    total_issue_counts = [sum(file_issues.get(json_file, {}).get(issue, {}).get("count", 0) for json_file in file_issues.keys()) for issue in all_issues]

    colors_arrays = [[file_issues.get(json_file, {}).get(issue, {}).get("color", "") for json_file in file_issues.keys()] for issue in all_issues]
    colors = [];
    for subarr in colors_arrays:
        if any(item == 'red' for item in subarr):
            colors.append('red');
        else:
            colors.append('orange');
    
    hatches_arrays = [[file_issues.get(json_file, {}).get(issue, {}).get("hatch", "") for json_file in file_issues.keys()] for issue in all_issues]
    hatches = [];
    for subarr in hatches_arrays:
        if any(item == 'X' for item in subarr):
            hatches.append('X');
        else:
            hatches.append('/');

    if not all_issues:
        total_issue_counts = [0] * len(total_issue_counts)

    plt.bar(all_issues, total_issue_counts, edgecolor='black', color=colors, hatch=hatches)
    
    for ticklabel, tickcolor in zip(plt.gca().get_xticklabels(), colors):
        ticklabel.set_color(tickcolor)

    plt.title(f'Total Issues for {category}')
    plt.xlabel('Issue Type')
    plt.ylabel('Count')
    plt.xticks(rotation=90)
    plt.ylim(0, max_total_count)  # Set the y-axis limits using the maximum total count
    plt.tight_layout()
    for i, count in enumerate(total_issue_counts):
        plt.text(i, count + 0.1, str(count), ha='center', va='bottom')
    plt.savefig(f'{category}_total_issues.png')  # Save total issues plot to a file in the current folder
    plt.close()

    idx = -0.4
    plt.figure(figsize=(10, 7))
    X_axis = np.arange(len(all_issues))
    max_count = 0

    for json_file_name in json_file_names:
        individual_issue_counts = [file_issues[json_file_name].get(issue, {}).get("count", 0) for issue in all_issues]

        maxtemp = max(individual_issue_counts)
        if maxtemp > max_count:
            max_count = maxtemp

        plt.bar(X_axis + idx, individual_issue_counts, 0.2, edgecolor='black', color=colors, hatch=hatches)
        for i, count in enumerate(individual_issue_counts):
            plt.text(i + idx, count + 0.1, str(count), ha='center', va='bottom')
        idx += 0.2
    
    plt.title(f"Issues for {category}")
    plt.ylabel('Count')
    plt.xlabel('Issue Type')
    plt.xticks(X_axis-idx, all_issues) 
    plt.xticks(rotation=60)

    for ticklabel, tickcolor in zip(plt.gca().get_xticklabels(), colors):
        ticklabel.set_color(tickcolor)

    plt.ylim(0, max_count + 5)  # Set the y-axis limits using the maximum total count
    plt.tight_layout()
    plt.savefig(f'{category}_issues.png')  # Save individual file issues plot to a file in the current folder
    plt.close()

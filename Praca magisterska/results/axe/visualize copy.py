import os
import re
import matplotlib.pyplot as plt
import math

# Define the list of file names
file_names = ['bigsize', 'courier', 'ecommerce', 'education', 'entertainment', 'gov', 'healthcare', 'news', 'nonprofit', 'mediumsize', 'smallsize', 'socialmedia']

# Create the directory if it doesn't exist
if not os.path.exists('couriers_graphs'):
    os.makedirs('couriers_graphs')

# Initialize dictionaries to store data
all_issues = set()
courier_issues = {}

# Iterate over each file
for file_name in file_names:
    # Read data from the file
    with open(f"{file_name}.txt", "r") as file:
        data = file.read()

    # Split the data into sections for each courier
    sections = re.split(r"courier\\", data)[1:]

    # Parse each section
    for section in sections:
        lines = section.split("\n")
        courier_name = lines[0].split("_")[0]

        # Find and parse Critical Issues
        critical_index = lines.index("Critical Issues:") + 1
        end_critical_index = lines.index("Serious Issues:")
        critical_issues_data = lines[critical_index:end_critical_index]

        for issue_data in critical_issues_data:
            if ";" in issue_data:
                issue, count, description = issue_data.strip().split(":")
                count = int(count.strip())
                all_issues.add(issue.strip())
                courier_issues.setdefault(courier_name, {}).setdefault(issue.strip(), 0)
                courier_issues[courier_name][issue.strip()] += count

        # Find and parse Serious Issues
        serious_index = lines.index("Serious Issues:") + 1
        serious_issues_data = lines[serious_index:]

        for issue_data in serious_issues_data:
            if ";" in issue_data:
                issue, count, description = issue_data.strip().split(":")
                count = int(count.strip())
                all_issues.add(issue.strip())
                courier_issues.setdefault(courier_name, {}).setdefault(issue.strip(), 0)
                courier_issues[courier_name][issue.strip()] += count

# Convert the set of all issues to a sorted list
all_issues = sorted(list(all_issues))

# Calculate the maximum count among all issues for setting the same y-axis size
max_count = max([count for issues in courier_issues.values() for count in issues.values()])

# Round up the maximum count to the nearest full number
max_count = math.ceil(max_count)

# Add a little space between the topmost number and the top border
max_count += 2

# Plotting Total Issues
plt.figure(figsize=(12, 6))
total_issue_bars = plt.bar(all_issues, [sum(courier_issues[courier_name].get(issue, 0) for courier_name in courier_issues.keys()) for issue in all_issues])
plt.title('Total Issues')
plt.xlabel('Issue Type')
plt.ylabel('Count')
plt.xticks(rotation=90)
plt.ylim(0, max_count)
plt.yticks(range(0, max_count + 1, max_count // 5))  # Set y-axis ticks with equal intervals
plt.tight_layout()
plt.savefig(os.path.join('couriers_graphs', 'total_issues.png'))  # Save total issues plot to a file in couriers_graphs folder
plt.close()

# Plotting Issues by Courier
for courier_name, issues in courier_issues.items():
    plt.figure(figsize=(12, 6))
    plt.bar(all_issues, [issues.get(issue, 0) for issue in all_issues])
    plt.title(f"Issues for {courier_name}")
    plt.xlabel('Issue Type')
    plt.ylabel('Count')
    plt.xticks(rotation=90)
    plt.ylim(0, max_count)  # Set the same y-axis limits as the total issues plot
    plt.yticks(range(0, max_count + 1, max_count // 5))  # Set y-axis ticks with equal intervals
    plt.tight_layout()
    plt.savefig(os.path.join('couriers_graphs', f'{courier_name}_issues.png'))  # Save individual company issues plot to a file in couriers_graphs folder
    plt.close()

import re
import matplotlib.pyplot as plt
import math
import numpy as np  

countries = ['usa', 'eu', 'pl'];
# countries = ['usa', 'pl'];

country_issues = {};
country_issues2 = {};

for country in countries: 
    file_names = set()
    all_issues = set()
    file_issues = {}

    c1 = 0;

    c2 = 0;

    with open(f"{country}.txt", "r") as file:
        data = file.read()

    sections = re.split(r"[\w]+\\", data)[1:]

    for section in sections:
        lines = section.split("\n")

        file_name = lines.pop(0).split("_")[0]
        file_names.add(file_name);

        country_issues.setdefault(country, {})
        country_issues2.setdefault(country, 0)
        
        if all(data == '' for data in lines):
            file_issues.setdefault(file_name, {})

        for issue_data in lines:
            if ";" in issue_data:
                issue, count, description = issue_data.strip().split(":")
                count = int(count.strip())
                all_issues.add(issue.strip())
                file_issues.setdefault(file_name, {}).setdefault(issue.strip(), {}).setdefault('count', 0)
                file_issues[file_name][issue.strip()]["count"] += count

                country_issues.setdefault(country, {}).setdefault(issue.strip(), {}).setdefault('count', c1)
                country_issues[country][issue.strip()]["count"] += count

                country_issues2[country] += count

                c1 += count;
                c2 += count;

        
    ### total issues plot
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
    plt.title(f'Total Issues for {country}')
    plt.xlabel('Issue Type')
    plt.ylabel('Count')
    plt.xticks(rotation=90)
    plt.ylim(0, max_total_count)  # Set the y-axis limits using the maximum total count
    plt.tight_layout()
    for i, count in enumerate(total_issue_counts):
        plt.text(i, count + 0.1, str(count), ha='center', va='bottom')
    plt.savefig(f'{country}_total_issues.png')  # Save total issues plot to a file in the current folder
    plt.close()




### countries plot
idx = -0.4
plt.figure(figsize=(20, 7))
X_axis = np.arange(len(all_issues))
max_count = 0


for country in countries: 
    individual_issue_counts = [country_issues.get(country, {}).get(issue, {}).get("count", 0) for issue in all_issues]

    if country == 'usa':
        xcolors = ["white" for _ in range(len(all_issues))]
        xhatches = ["*" for _ in range(len(all_issues))]
    elif country == 'eu':
        xcolors = ["blue" for _ in range(len(all_issues))]    
        xhatches = ["" for _ in range(len(all_issues))]
    else:
        xcolors = ["red" for _ in range(len(all_issues))]
        xhatches = ["" for _ in range(len(all_issues))]

    maxtemp = max(individual_issue_counts)
    if maxtemp > max_count:
        max_count = maxtemp

    plt.bar(X_axis + idx, individual_issue_counts, 0.2, edgecolor='black', color=xcolors, hatch=xhatches)
    for i, count in enumerate(individual_issue_counts):
        plt.text(i + idx, count + 0.1, str(count), ha='center', va='bottom')
    idx += 0.2

plt.title(f"Issues for countries")
plt.ylabel('Count')
plt.xlabel('Issue Type')
plt.xticks(X_axis-idx, all_issues) 
plt.xticks(rotation=60)
plt.ylim(0, max_count + 5)  # Set the y-axis limits using the maximum total count
plt.tight_layout()
plt.savefig(f'countries_issues.png')  # Save individual file issues plot to a file in the current folder
plt.close()



### countries2 plot
plt.figure(figsize=(10, 7))
max_count = 0

for i, country in enumerate(countries): 
    count = country_issues2.get(country, 0)

    if country == 'usa':
        color = "white"
        hatch = "*"
    elif country == 'eu':
        color = "blue" 
        hatch = ""
    else:
        color = "red"
        hatch = ""

    if count > max_count:
        max_count = count

    plt.bar(i, count,edgecolor='black', color=color, hatch=hatch)
    plt.text(i, count + 0.1, str(count), ha='center', va='bottom')

plt.title(f"Issues for countries")
plt.ylabel('Count')
plt.xticks(range(3), labels=['USA', 'Unia Europejska', 'Polska'], rotation=60)
plt.ylim(0, max_count + 15)  # Set the y-axis limits using the maximum total count
plt.tight_layout()
plt.savefig(f'countries2_issues.png')  # Save individual file issues plot to a file in the current folder
plt.close()
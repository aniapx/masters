import re
import matplotlib.pyplot as plt
import math
import numpy as np  

def Average(lst): 
    return sum(lst) / len(lst) 

categories = ['bigsize', 'courier', 'ecommerce', 'education', 'entertainment', 'gov', 'healthcare', 'news', 'nonprofit', 'mediumsize', 'smallsize', 'socialmedia']
# categories = ['courier', 'bigsize', 'ecommerce', 'education']

all_issues = set()
all_issues_counts = {}
all_issues_average = {}
all_issues_detail_counts = {}
critical_counts = {}
serious_counts = {}


for category in categories:
    json_file_names = set()
    all_issues = set()
    file_issues = {}
    
    all_issues_counts.setdefault(category, {'critical': 0, 'serious': 0})
    all_issues_average.setdefault(category, {'critical': 0, 'serious': 0})

    with open(f"{category}.txt", "r") as file:
        data = file.read()

    sections = re.split(r"[\w]+\\", data)[1:]

    c = []
    s = []
    cc = 0;
    ss = 0;
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
                    all_issues.add(issue.strip())
                    all_issues_detail_counts.setdefault(issue, 0)
                    count = int(count.strip())
                    all_issues.add(issue.strip())
                    file_issues.setdefault(json_file_name, {}).setdefault(issue.strip(), {}).setdefault('count', 0)
                    file_issues.setdefault(json_file_name, {}).setdefault(issue.strip(), {}).setdefault('color', 'red')
                    file_issues.setdefault(json_file_name, {}).setdefault(issue.strip(), {}).setdefault('hatch', 'X')
                    file_issues[json_file_name][issue.strip()]["count"] += count
                    all_issues_detail_counts[issue] += count
                    all_issues_counts[category]['critical'] += count
                    cc += count
                    critical_counts.setdefault(issue, 0)
                    critical_counts[issue] += count

        if "Serious Issues:" in lines:
            serious_index = lines.index("Serious Issues:") + 1
            serious_issues_data = lines[serious_index:]

            for issue_data in serious_issues_data:
                if ";" in issue_data:
                    issue, count, description = issue_data.strip().split(":")
                    all_issues.add(issue.strip())
                    all_issues_detail_counts.setdefault(issue, 0)
                    count = int(count.strip())
                    all_issues.add(issue.strip())
                    file_issues.setdefault(json_file_name, {}).setdefault(issue.strip(), {}).setdefault('count', 0)
                    file_issues.setdefault(json_file_name, {}).setdefault(issue.strip(), {}).setdefault('color', 'orange')
                    file_issues.setdefault(json_file_name, {}).setdefault(issue.strip(), {}).setdefault('hatch', '/')
                    file_issues[json_file_name][issue.strip()]["count"] += count
                    all_issues_detail_counts[issue] += count
                    all_issues_counts[category]['serious'] += count
                    ss += count
                    serious_counts.setdefault(issue, 0)
                    serious_counts[issue] += count
    
        c.append(cc)
        s.append(ss)
    
    all_issues_average[category]["critical"] = math.ceil(Average(c))
    all_issues_average[category]["serious"] = math.ceil(Average(s))

    all_issues = sorted(list(all_issues))
    max_total_count = max([sum(file_issues.get(json_file, {}).get(issue, {}).get("count", 0) for json_file in file_issues.keys()) for issue in all_issues], default=0)
    max_total_count = math.ceil(max_total_count) + 5

    plt.figure(figsize=(10, 7))
    total_issue_counts = [sum(file_issues.get(json_file, {}).get(issue, {}).get("count", 0) for json_file in file_issues.keys()) for issue in all_issues]

    colors_arrays = [[file_issues.get(json_file, {}).get(issue, {}).get("color", "") for json_file in file_issues.keys()] for issue in all_issues]
    colors = ['red' if 'red' in subarr else 'orange' for subarr in colors_arrays]
    
    hatches_arrays = [[file_issues.get(json_file, {}).get(issue, {}).get("hatch", "") for json_file in file_issues.keys()] for issue in all_issues]
    hatches = ['X' if 'X' in subarr else '/' for subarr in hatches_arrays]

    if not all_issues:
        total_issue_counts = [0] * len(total_issue_counts)

    plt.bar(all_issues, total_issue_counts, edgecolor='black', color=colors, hatch=hatches, alpha=0.7)
    
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


# # Plot individual issues for each file
#     plt.figure(figsize=(10, 7))
#     X_axis = np.arange(len(all_issues))
#     max_count = 0
#     bar_width = 0.2
#     idx = np.arange(len(json_file_names)) * bar_width

#     for idx_offset, json_file_name in zip(idx, json_file_names):
#         individual_issue_counts = [file_issues[json_file_name].get(issue, {}).get("count", 0) for issue in all_issues]
#         max_count = max(max(individual_issue_counts), max_count)

#         plt.bar(X_axis + idx_offset, individual_issue_counts, bar_width, edgecolor='black', alpha=0.7, color=colors, hatch=hatches)
        
#         for i, count in enumerate(individual_issue_counts):
#             plt.text(i + idx_offset, count + 0.1, str(count), ha='center', va='bottom')

#     plt.title(f"Issues count for {category}")
#     plt.ylabel('Count')
#     plt.xlabel('Issue Type')
#     plt.xticks(X_axis + bar_width * (len(json_file_names) - 1) / 2, all_issues, rotation=90)
#     plt.legend()

#     for ticklabel, tickcolor in zip(plt.gca().get_xticklabels(), colors):
#         ticklabel.set_color(tickcolor)

#     plt.ylim(0, max_count + 5)  # Set the y-axis limits using the maximum total count
#     plt.tight_layout()
#     plt.savefig(f'{category}_issues.png')  # Save individual file issues plot to a file in the current folder
#     plt.close()


# Plot detailed issues count
# severities = ['critical', 'serious']
# colors = ['red', 'orange'] 
hatches = ['x', '/']
plt.figure(figsize=(15, 9))
bar_width = 0.35  # Width of each bar
idx = np.arange(len(all_issues_detail_counts))  # Array to hold the indices for each category
max_count = max(max(critical_counts.values()), max(serious_counts.values()))  # Find maximum count for setting y-axis limit

# Plotting critical issues
critical_bars = plt.bar(idx, [critical_counts.get(label, 0) for label in all_issues_detail_counts.keys()], color='red', hatch=hatches[0], label='Critical')

# Plotting serious issues
serious_bars = plt.bar(idx, [serious_counts.get(label, 0) for label in all_issues_detail_counts.keys()], bottom=[critical_counts.get(label, 0) for label in all_issues_detail_counts.keys()], color='orange', hatch=hatches[1], label='Serious')

plt.title("Issue type counts")
plt.ylabel('Count')
plt.xlabel('Issue')
plt.xticks(idx, all_issues_detail_counts.keys(), rotation=90)
plt.legend()  # Adding legend for severities
plt.tight_layout()
plt.ylim(0, max_count + 5)  # Set the y-axis limits using the maximum total count
plt.tight_layout()
plt.savefig(f'all_categories_detailed_issues.png')  # Save individual file issues plot to a file in the current folder
plt.close()


# # # Plot aggregated issues for all categories
# severities = ['critical', 'serious']
# colors = ['red', 'orange'] 
# hatches = ['x', '/'] 
# plt.figure(figsize=(10, 7))
# bar_width = 0.35  # Width of each bar
# idx = np.arange(len(categories))  # Array to hold the indices for each category
# max_count = 0

# for j, severity in enumerate(severities):
#     individual_issue_counts = [all_issues_counts[category].get(severity, 0) for category in categories]
#     max_count = max(max(individual_issue_counts), max_count)

#     plt.bar(idx + j * bar_width, individual_issue_counts, bar_width, edgecolor='black', alpha=0.7, label=severity, color=colors[j], hatch=hatches[j])
    
#     for i, count in enumerate(individual_issue_counts):
#         plt.text(idx[i] + j * bar_width, count + 0.1, str(count), ha='center', va='bottom')

# plt.title("Sum of issue count for all categories")
# plt.ylabel('Count')
# plt.xlabel('Category')
# plt.xticks(idx + bar_width / 2, categories)  # Adjusting xticks position
# plt.xticks(rotation=60)
# plt.legend()  # Adding legend for severities
# plt.tight_layout()
# plt.ylim(0, max_count + 5)  # Set the y-axis limits using the maximum total count
# plt.tight_layout()
# plt.savefig(f'all_categories_issues.png')  # Save individual file issues plot to a file in the current folder
# plt.close()


# # Plot average issues (critical and serious) per file
# severities = ['critical', 'serious']
# colors = ['red', 'orange'] 
# hatches = ['x', '/'] 
# plt.figure(figsize=(10, 7))
# bar_width = 0.35  # Width of each bar
# idx = np.arange(len(categories))  # Array to hold the indices for each category
# max_count = 0

# for j, severity in enumerate(severities):
#     individual_issue_counts = [all_issues_average[category].get(severity, 0) for category in categories]
#     max_count = max(max(individual_issue_counts), max_count)

#     plt.bar(idx + j * bar_width, individual_issue_counts, bar_width, edgecolor='black', alpha=0.7, label=severity, color=colors[j], hatch=hatches[j])
    
#     for i, count in enumerate(individual_issue_counts):
#         plt.text(idx[i] + j * bar_width, count + 0.1, str(count), ha='center', va='bottom')

# plt.title("Average issue count for all categories")
# plt.ylabel('Count')
# plt.xlabel('Category')
# plt.xticks(idx + bar_width / 2, categories)  # Adjusting xticks position
# plt.xticks(rotation=60)
# plt.legend()  # Adding legend for severities
# plt.tight_layout()
# plt.ylim(0, max_count + 15)  # Set the y-axis limits using the maximum total count
# plt.tight_layout()
# plt.savefig(f'all_categories_issues_avg.png')  # Save individual file issues plot to a file in the current folder
# plt.close()

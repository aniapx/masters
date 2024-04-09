import re
import matplotlib.pyplot as plt
import matplotlib.patches as mpatches
import math
import numpy as np  

def Average(lst): 
    return sum(lst) / len(lst) 

categories = ['bigsize', 'courier', 'ecommerce', 'education', 'entertainment', 'gov', 'healthcare', 'news', 'nonprofit', 'mediumsize', 'smallsize', 'socialmedia']
categories_pl = ['duże przedsiębiorstwa', 'firmy kurieskie', 'firmy e-commerce', 'instytucje edukacyjne', 'rozrywka', 'strony rządowe', 'instytucje zdrowia', 'wiadomości', 'non-profit', 'średnie przedsiębiorstwa', 'małe przedziębiorstwa', 'media społecznościowe']
categories = ['gov']
categories_pl = ['strony rządowe']

all_issues = set()
all_issues_counts = {}
all_issues_average = {}
all_issues_detail_counts = {}


for index, category in enumerate(categories):
    json_file_names = set()
    all_issues = set()
    file_issues = {}
    
    all_issues_counts.setdefault(category, 0)
    all_issues_average.setdefault(category, 0)

    with open(f"{category}.txt", "r") as file:
        data = file.read()

    sections = re.split(r"[\w]+\\", data)[1:]

    c = []
    for section in sections:
        cc = 0;
        lines = section.split("\n")

        json_file_name = lines.pop(0).split("_")[1]
        json_file_names.add(json_file_name);

        file_issues.setdefault(json_file_name, {})

        for issue_data in lines:
            if ";" in issue_data:
                issue, count, description = issue_data.strip().split(":")
                all_issues.add(issue.strip())
                all_issues_detail_counts.setdefault(issue, 0)
                count = int(count.strip())
                all_issues.add(issue.strip())
                file_issues.setdefault(json_file_name, {}).setdefault(issue.strip(), 0)
                file_issues[json_file_name][issue.strip()] += count
                all_issues_detail_counts[issue] += count
                all_issues_counts[category] += count
                cc += count
    
        c.append(cc)
    
    all_issues_average[category] = math.ceil(Average(c))

    all_issues = sorted(list(all_issues))
    max_count = max([sum(file_issues.get(json_file, {}).get(issue, 0) for json_file in file_issues.keys()) for issue in all_issues], default=0)
    max_count = math.ceil(max_count)

    plt.figure(figsize=(12, 8))
    total_issue_counts = [sum(file_issues.get(json_file, {}).get(issue, 0) for json_file in file_issues.keys()) for issue in all_issues]

    if not all_issues:
        total_issue_counts = [0] * len(total_issue_counts)

    plt.bar(all_issues, total_issue_counts, edgecolor='black', alpha=0.7)
    
    plt.title(f'Suma błędów w kategorii {categories_pl[index]}')
    plt.xlabel('Rodzaj błędu')
    plt.ylabel('Count')
    plt.xticks(rotation=90)
    plt.ylim(0, max_count + (max_count/10))  # Set the y-axis limits using the maximum total count
    plt.tight_layout()
    for i, count in enumerate(total_issue_counts):
        plt.text(i, count + 0.1, str(count), ha='center', va='bottom', fontsize=9)
    plt.savefig(f'{category}_total_issues.png')  # Save total issues plot to a file in the current folder
    plt.close()


# Plot individual issues for each file
    plt.figure(figsize=(13, 8))
    X_axis = np.arange(len(all_issues))
    max_count = 0
    bar_width = 0.17
    idx = np.arange(len(json_file_names)) * bar_width
    
    # cols = ['#fd581b', '#fdbc6e', '#0507a2']; # ecommerce
    # cols = ['#a31a32', '#064a6b', '#cccccc', '#218d51']; # education
    # cols = ['blue', '#2bd764', 'red']; # entertainment
    # cols = ['#cccccc', '#005eb8', '#1bc3a5']; # healthcare
    cols = ['blue', 'red', 'white']; # gov
    json_file_names = sorted(json_file_names)
    legend_handles = []

    j = 0
    for idx_offset, json_file_name in zip(idx, json_file_names):
        individual_issue_counts = [file_issues[json_file_name].get(issue, 0) for issue in all_issues]
        max_count = max(max(individual_issue_counts), max_count)

        # plt.bar(X_axis + idx_offset, individual_issue_counts, bar_width, edgecolor='black', alpha=0.7)
        plt.bar(X_axis + idx_offset, individual_issue_counts, bar_width, edgecolor='black', alpha=0.7, color=cols[j])
        legend_handles.append(mpatches.Patch(facecolor=cols[j], edgecolor='black', alpha=0.7))
        
        j = (j + 1) % len(cols)
        for i, count in enumerate(individual_issue_counts):
            plt.text(i + idx_offset, count + 0.1, f"{str(count)}", ha='center', va='bottom', fontsize=9)

    plt.title(f"Suma błędów w kategorii {categories_pl[index]}")
    plt.ylabel('Ilość błędów')
    plt.xlabel('Rodzaj błędu')
    plt.xticks(X_axis + bar_width * (len(json_file_names) - 1) / 2, all_issues, rotation=90)

    xx = [s.capitalize() for s in json_file_names]
    # xx = ['Harvard', 'Politechnika Warszawska', 'Universiteit van Amsterdam', 'Zachodniopomorski Uniwersytet Technologiczny w Szczecinie']
    # xx = ['Mayo Clinic', 'NHS', 'Znany Lekarz']
    xx = ['Francja', 'Polska','USA']
    plt.legend(legend_handles, xx, loc='upper left')
    plt.ylim(0, max_count + (max_count/10))

    plt.tight_layout()
    plt.savefig(f'{category}_issues.png')  # Save individual file issues plot to a file in the current folder
    plt.close()


# Plot aggregated issues for all categories
plt.figure(figsize=(12, 8))
bar_width = 0.35  # Width of each bar
idx = np.arange(len(categories))  # Array to hold the indices for each category
max_count = 0

individual_issue_counts = [all_issues_counts.get(category, 0) for category in categories]
max_count = max(max(individual_issue_counts), max_count)

plt.bar(idx + bar_width, individual_issue_counts, bar_width, edgecolor='black', alpha=0.7)

for i, count in enumerate(individual_issue_counts):
    plt.text(idx[i] + bar_width, count + 0.1, str(count), ha='center', va='bottom', fontsize=9)

plt.title("Suma błędów dla wszystkich kategorii")
plt.ylabel('Ilość błędów')
plt.xlabel('Kategoria')
plt.xticks(idx + bar_width, categories, rotation=60)
plt.legend()  # Adding legend for severities
plt.tight_layout()
plt.ylim(0, max_count + (max_count/10))  # Set the y-axis limits using the maximum total count
plt.tight_layout()
plt.savefig(f'all_categories_issues.png')  # Save individual file issues plot to a file in the current folder
plt.close()


# Plot average issues (critical and serious) per file
plt.figure(figsize=(12, 8))
bar_width = 0.35  # Width of each bar
idx = np.arange(len(categories))  # Array to hold the indices for each category
max_count = 0

print(f"LABELS: {categories}")
individual_issue_counts = [all_issues_average[category] for category in categories]
max_count = max(max(individual_issue_counts), max_count)

plt.bar(idx +  bar_width, individual_issue_counts, bar_width, edgecolor='black', alpha=0.7)

for i, count in enumerate(individual_issue_counts):
    plt.text(idx[i] +  bar_width, count + 0.1, str(count), ha='center', va='bottom', fontsize=9)

plt.title("Średnia ilość błędów dla pojedynczych stron we wszystich kategoriach")
plt.ylabel('Ilość błędów')
plt.xlabel('Kategoria')
plt.xticks(idx + bar_width, categories, rotation=60)
plt.legend()  # Adding legend for severities
plt.tight_layout()
plt.ylim(0, max_count + (max_count/10))  # Set the y-axis limits using the maximum total count
plt.tight_layout()
plt.savefig(f'all_categories_issues_avg.png')  # Save individual file issues plot to a file in the current folder
plt.close()

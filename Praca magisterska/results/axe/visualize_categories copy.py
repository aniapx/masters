import re
import matplotlib.pyplot as plt
import math
import numpy as np

def read_file(filename):
    with open(filename, "r") as file:
        return file.read()

def extract_issue_data(lines, issue_type):
    issue_data = {}
    for line in lines:
        if ";" in line:
            issue, count, description = line.strip().split(":")
            count = int(count.strip())
            issue_data[issue.strip()] = {'count': count, 'color': 'red' if issue_type == 'critical' else 'orange', 'hatch': 'xx' if issue_type == 'critical' else '/'}
    return issue_data

def process_category(category):
    data = read_file(f"{category}.txt")
    sections = re.split(r"[\w]+\\", data)[1:]
    file_issues = {}
    critical_counts = {}
    serious_counts = {}

    for section in sections:
        lines = section.split("\n")
        json_file_name = lines[0].split("_")[0]

        if "Critical Issues:" in lines:
            critical_issues_data = lines[lines.index("Critical Issues:") + 1:lines.index("Serious Issues:") if "Serious Issues:" in lines else None]
            if critical_issues_data:
                file_issues.setdefault(json_file_name, {}).update(extract_issue_data(critical_issues_data, 'critical'))
                for issue, data in file_issues[json_file_name].items():
                    critical_counts.setdefault(issue, 0)
                    critical_counts[issue] += data['count']

        if "Serious Issues:" in lines:
            serious_issues_data = lines[lines.index("Serious Issues:") + 1:]
            if serious_issues_data:
                file_issues.setdefault(json_file_name, {}).update(extract_issue_data(serious_issues_data, 'serious'))
                for issue, data in file_issues[json_file_name].items():
                    serious_counts.setdefault(issue, 0)
                    serious_counts[issue] += data['count']

    return file_issues, critical_counts, serious_counts

def plot_total_issues(category, all_issues):
    plt.figure(figsize=(12, 8))
    total_issue_counts = [sum(all_issues.get(category, {}).get(issue, {}).get("count", 0)) for issue in all_issues]
    colors = ['red' if 'red' in [all_issues.get(category, {}).get(issue, {}).get("color", "")] else 'orange' for issue in all_issues]
    hatches = ['xx' if 'xx' in [all_issues.get(category, {}).get(issue, {}).get("hatch", "")] else '/' for issue in all_issues]

    plt.bar(all_issues, total_issue_counts, edgecolor='black', color=colors, hatch=hatches, alpha=0.7)
    plt.title(f'Total Issues for {category}')
    plt.xlabel('Issue Type')
    plt.ylabel('Count')
    plt.xticks(rotation=90)
    plt.ylim(0, math.ceil(max(total_issue_counts)) + 5)
    plt.tight_layout()
    for i, count in enumerate(total_issue_counts):
        plt.text(i, count + 0.1, str(count), ha='center', va='bottom')
    plt.savefig(f'{category}_total_issues.png')
    plt.close()

def plot_individual_issues(category, category_issues):
    print(f"{category_issues}\n\n")
    plt.figure(figsize=(12, 8))
    X_axis = np.arange(len(category_issues))
    max_count = 0
    bar_width = 0.2

    individual_issue_counts = [category_issues.get(issue, {}).get("count", 0) for issue in category_issues]
    colors = [category_issues.get(issue, {}).get("color", 0) for issue in category_issues]
    hatches = [category_issues.get(issue, {}).get("hatch", 0) for issue in category_issues]
    max_count = max(max(individual_issue_counts), max_count)

    plt.bar(X_axis, individual_issue_counts, bar_width, edgecolor='black', alpha=0.7, color=colors, hatch=hatches)

    for i, count in enumerate(individual_issue_counts):
        plt.text(i, count + 0.1, str(count), ha='center', va='bottom')

    plt.title(f"Issues count for {category}")
    plt.ylabel('Count')
    plt.xlabel('Issue Type')
    plt.xticks(X_axis, category_issues, rotation=90)  # Use filtered list of issues specific to the category
    plt.legend()
    plt.ylim(0, max_count + 5)
    plt.tight_layout()
    plt.savefig(f'{category}_issues.png')
    plt.close()

def plot_detailed_issues(all_issues_detail_counts):
    plt.figure(figsize=(12, 8))
    bar_width = 0.35
    idx = np.arange(len(all_issues_detail_counts))
    max_count = max(issue_attrs['count'] for issue_attrs in all_issues_detail_counts.values())

    # critical_bars = plt.bar(idx, [critical_counts.get(label, 0) for label in all_issues_detail_counts.keys()], bar_width, alpha=0.7, color='red', hatch='xx', label='Critical', edgecolor='black')
    # serious_bars = plt.bar(idx, [serious_counts.get(label, 0) for label in all_issues_detail_counts.keys()], bar_width, alpha=0.7, edgecolor='black', bottom=[critical_counts.get(label, 0) for label in all_issues_detail_counts.keys()], color='orange', hatch='/')

    for i, issue in enumerate(all_issues_detail_counts.values()):
        print(f"{idx[i] + 1 * bar_width}: {issue}")
        plt.bar(idx[i] + 1 * bar_width, issue.get('count'), bar_width, edgecolor='black', alpha=0.7, color=issue.get('color'), hatch=issue.get('hatch'))
        plt.text(idx[i] + 1 * bar_width, issue.get('count') + 0.1, str(issue.get('count')), ha='center', va='bottom')

    plt.title("Issue type counts")
    plt.ylabel('Count')
    plt.xlabel('Issue')
    plt.xticks(idx + bar_width, all_issues_detail_counts.keys(), rotation=90)
    plt.legend()
    plt.tight_layout()
    plt.ylim(0, max_count + 15)
    plt.tight_layout()
    plt.savefig(f'all_categories_detailed_issues.png')
    plt.close()

def plot_aggregated_issues(categories, all_issues_counts):
    plt.figure(figsize=(12, 8))
    bar_width = 0.35
    idx = np.arange(len(categories))
    max_count = 0

    for j, severity in enumerate(['critical', 'serious']):
        individual_issue_counts = [all_issues_counts[category].get(severity, 0) for category in categories]
        max_count = max(max(individual_issue_counts), max_count)

        plt.bar(idx + j * bar_width, individual_issue_counts, bar_width, edgecolor='black', alpha=0.7, label=severity, color='red' if severity == 'critical' else 'orange', hatch='xx' if severity == 'critical' else '/')
        
    for i, count in enumerate(individual_issue_counts):
        plt.text(idx[i] + j * bar_width, count + 0.1, str(count), ha='center', va='bottom')

    plt.title("Sum of issue count for all categories")
    plt.ylabel('Count')
    plt.xlabel('Category')
    plt.xticks(idx + bar_width / 2, categories, rotation=60)
    plt.legend()
    plt.tight_layout()
    plt.ylim(0, max_count + 15)
    plt.tight_layout()
    plt.savefig(f'all_categories_issues.png')
    plt.close()

def plot_average_issues(categories, all_issues_average):
    plt.figure(figsize=(12, 8))
    bar_width = 0.35
    idx = np.arange(len(categories))
    max_count = 0

    for j, severity in enumerate(['critical', 'serious']):
        individual_issue_counts = [all_issues_average[category].get(severity, 0) for category in categories]
        max_count = max(max(individual_issue_counts), max_count)

        plt.bar(idx + j * bar_width, individual_issue_counts, bar_width, edgecolor='black', alpha=0.7, label=severity, color='red' if severity == 'critical' else 'orange', hatch='xx' if severity == 'critical' else '/')
        
        for i, count in enumerate(individual_issue_counts):
            plt.text(idx[i] + j * bar_width, count + 0.1, str(count), ha='center', va='bottom')

    plt.title("Average issue count for all categories")
    plt.ylabel('Count')
    plt.xlabel('Category')
    plt.xticks(idx + bar_width / 2, categories, rotation=60)
    plt.legend()
    plt.tight_layout()
    plt.ylim(0, max_count + 15)
    plt.tight_layout()
    plt.savefig(f'all_categories_issues_avg.png')
    plt.close()

categories = ['bigsize', 'courier', 'ecommerce', 'education', 'entertainment', 'gov', 'healthcare', 'news', 'nonprofit', 'mediumsize', 'smallsize', 'socialmedia']
# categories = ['bigsize', 'courier', 'ecommerce']

all_issues = {}
all_issues_counts = {}
all_issues_average = {}
all_issues_detail_counts = {}
critical_counts = {}
serious_counts = {}

for category in categories:
    file_issues, category_critical_counts, category_serious_counts = process_category(category)

    all_issues.setdefault(category, {})
    for company, issues_data in file_issues.items():
        for issue, details in issues_data.items():
            all_issues.get(category).setdefault(issue, {}).update(details)

    # all_issues.update(file_issues.keys())
    all_issues_counts[category] = {'critical': sum(category_critical_counts.values()), 'serious': sum(category_serious_counts.values())}

    for issue, count in all_issues.get(category, {}).items():
        all_issues_detail_counts.setdefault(issue, {'count': 0, 'color': 'red', 'hatch': 'xx'})
        sum_count = all_issues_detail_counts.get(issue, 0).get('count', 0) + count.get('count', 0)
        all_issues_detail_counts[issue]['count'] = sum_count
        all_issues_detail_counts[issue]['color'] = count.get('color', 'red')
        all_issues_detail_counts[issue]['hatch'] = count.get('hatch', 'xx')

    sorted_all_issues_detail_counts = {k: v for k, v in sorted(all_issues_detail_counts.items())}

    # Calculate average issues per category
    # total_json_files = len(file_issues)
    # if total_json_files > 0:
    #     total_critical_issues = sum(issue_counts.get("count", 0) for file_issues_data in file_issues.values() for issue_counts in file_issues_data.values() if issue_counts.get("color") == "red")
    #     total_serious_issues = sum(issue_counts.get("count", 0) for file_issues_data in file_issues.values() for issue_counts in file_issues_data.values() if issue_counts.get("color") == "orange")
    #     all_issues_average[category] = {'critical': math.ceil(total_critical_issues / total_json_files),
    #                                     'serious': math.ceil(total_serious_issues / total_json_files)}
    # else:
    #     all_issues_average[category] = {'critical': 0, 'serious': 0}
    

# Ensure all_issues remains sorted
# all_issues = sorted(list(all_issues))

# for category in categories:
    # plot_total_issues(category, all_issues)
    # plot_individual_issues(category, all_issues[category])

sum = 0
for category in categories:
    sum += all_issues.get(category, {}).get('color-contrast', {}).get('count', 0)

print("Sum of color-contrast elements:", sum)


plot_detailed_issues(sorted_all_issues_detail_counts)
# plot_aggregated_issues(categories, all_issues_counts)

# plot_average_issues(categories, all_issues_average)

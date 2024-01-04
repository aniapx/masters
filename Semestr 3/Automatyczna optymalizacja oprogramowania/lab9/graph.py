import matplotlib.pyplot as plt

tile_sizes = []
execution_times = []

# Read data from the file
with open('values.txt', 'r') as f:
    lines = f.readlines()
    for line in lines:
        values = line.strip().split()
        if len(values) == 4:
            tile_sizes.append(int(values[0]) * int(values[1]) * int(values[2]))
            execution_times.append(float(values[3]))

plt.scatter(tile_sizes, execution_times, label='Execution Time', s=5)  # Adjust the size (s) as needed

plt.xlabel('Tile Sizes Multiplied')
plt.ylabel('Execution Time (seconds)')
plt.title('Execution Time vs. Tile Size Multiplication')

plt.legend()

plt.gca().get_xaxis().get_major_formatter().set_useOffset(False)

# Set the tick locations and labels for the x-axis
tick_locations = [2e6, 4e6, 6e6, 8e6, 1e7]  # Adjust as needed
tick_labels = ['2M', '4M', '6M', '8M', '10M']  # Corresponding labels
plt.xticks(tick_locations, tick_labels)

plt.savefig('execution_time_vs_tile_size.png')
plt.show()

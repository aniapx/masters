import matplotlib 
import matplotlib.pyplot as plt
from mpl_toolkits.mplot3d import Axes3D
import numpy as np

matplotlib.rcParams.update({'font.size': 6})

tile_sizes_x = []
tile_sizes_y = []
tile_sizes_z = []
execution_times = []

with open('values.txt', 'r') as f:
    lines = f.readlines()
    for line in lines:
        values = line.strip().split()
        if len(values) == 4:
            tile_sizes_x.append(int(values[0]))
            tile_sizes_y.append(int(values[1]))
            tile_sizes_z.append(int(values[2]))
            execution_times.append(float(values[3]))

fig = plt.figure()
grid = plt.GridSpec(2, 2, wspace=0.25, hspace=0.1)

# Define viewing angles for each subplot
angles = [(30, 30), (90, -90), (0, 0), (0, -90)]  # Elevation and Azimuthal angles

for i, (elevation, azimuth) in enumerate(angles, 0):
    ax = fig.add_subplot(grid[i], projection='3d')
    
    # Create a colormap for opacity
    cmap = plt.get_cmap('viridis')
    scatter = ax.scatter(tile_sizes_x, tile_sizes_y, tile_sizes_z, c=execution_times, cmap=cmap, alpha=0.5, s=5)

    ax.set_xlabel('X')
    ax.set_ylabel('Y')
    ax.set_zlabel('Z')

    ax.view_init(elev=elevation, azim=azimuth)

# Create a common colorbar for all subplots
cax = fig.add_axes([0.15, 0.05, 0.7, 0.02])  # [left, bottom, width, height]
cbar = plt.colorbar(scatter, cax=cax, orientation='horizontal')
cbar.ax.tick_params(labelsize=8)
cbar.set_label('Execution Time (seconds)', fontsize=8)

# Adjust the margins to make them smaller
plt.subplots_adjust(left=0.1, right=0.9, top=0.99, bottom=0.05)

plt.savefig('3d_scatter_plot_2x2_grid.png', dpi=500)
plt.show()

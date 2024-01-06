import matplotlib.pyplot as plt
from matplotlib.patches import FancyArrowPatch
import random

# Assuming loop is with equation in the form of a[i][j]=a[i][j+k]+a[i+l][j-m]. Provide variables for your loop:
k=3
l=3
m=2

# Loops start with i=ilowerbound and j=jlowerbound. Provide:
ilowerbound=1
jlowerbound=2

# Set the size of the 2D plane, x is also the 'n' in his loop. 
lowerboundx=-1
lowerboundy=-1
x = jlowerbound+6

# Create the figure and axes objects
fig, ax = plt.subplots()

# Draw the 2D plane, you can adjust the x and y lims to suit your needs
ax.set_xlim(lowerboundx, x)
ax.set_ylim(lowerboundy, x)
ax.set_xticks(range(lowerboundx, x+1))
ax.set_yticks(range(lowerboundy, x+1))

# Add grid and display it below everything
ax.set_axisbelow(True)
ax.grid(axis='both', linestyle=':', color='black', linewidth=0.5)

# Add dots at integer points to the plot
for i in range(ilowerbound, x):
    for j in range(jlowerbound, x):
        ax.scatter(i, j, color='black', s=10)

# If we have a[x][y]=a[i][j]+a[k][l], then iters[n] is a list of how it looks at iteration number n: iters[n]=[[x,y],[i,j],[k,l]]
iters=[]
# Points is a list containing two related iterations like this: points[n]=[[x1,y1],[x2,y2]]
points=[]
for i in range(1,x):
    for j in range(jlowerbound, x):
        iters.append([[i, j],[i, j+k],[i+l, j-m]])
        
# Now the iterations are related if one of the following occurs. CMIIW
for i in range(1, len(iters)):
    for j in range(i):
        # Just to tidy it up lol
        half1 = (iters[i][0]==iters[j][1]) or (iters[i][0]==iters[j][2]) or (iters[i][1]==iters[j][0]) or (iters[i][1]==iters[j][1])
        half2 = (iters[i][1]==iters[j][2]) or (iters[i][2]==iters[j][0]) or (iters[i][2]==iters[j][1]) or (iters[i][2]==iters[j][2])
        if half1 or half2:
            if not ([iters[j][0], iters[i][0]]) in points:
                points.append([iters[j][0], iters[i][0]])
                
# Number of colors and list for used colors
noColors = len(points)
colors = []

# For all the connections in points list
for connection in points:
    # Randomize colors
    while True:
        color=(1/noColors*random.randint(0,noColors), 1/noColors*random.randint(0,noColors), 1/noColors*random.randint(0,noColors))
        if color not in colors:
            colors.append(color)
            break
    # Create a FancyArrowPatch object with a curved path, mutation_scale is size of the arrow head, connectionstyle is the arc with given radius
    arrow = FancyArrowPatch((connection[0][0], connection[0][1]), (connection[1][0], connection[1][1]), arrowstyle='->', mutation_scale=25,
                            connectionstyle='arc3,rad=-.4', linestyle='-', color=color)
    # Add the arrow to the axis
    ax.add_patch(arrow)


# show the plot
plt.show()
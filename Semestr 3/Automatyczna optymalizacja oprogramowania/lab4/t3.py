from islpy import *
from islplot.plotter import *
import matplotlib as mpl
import matplotlib.pyplot as plt

fig = plt.figure()
# plot_set_points(Set("{S[x,y]: 0 < x <= 6}"),
#                 marker=".", color="gray", size=3)

plot_set_points(Set("{S[x,y]: 0 < x <= 6 and 0 <= y <= 6 }"),
                marker="o")

plot_set_points(Set("{S[x,y]: 0 < x <= 6 and 0 <= y <= 6}"),
                marker="s", color="red")

# plot_set_points(Set("{S[x,y]: 0 < x <= 6}"),
#                 marker="D", color="blue")
fig.savefig("file.pdf", dpi=300)

fig_relation = plt.figure()
plot_set_points(Set("{S[8,2]}"))
plot_set_points(Set("{S[2,8]}"))
plot_set_points(Set("{S[x,y]: 0 < x = y <= 9}"))
plot_map(Map("{S[2,8] -> [x,y]: 1 <= x = y < 9}"))
plot_map(Map("{S[8,2] -> [x,y]: 1 <= x = y < 9}"), edge_style="-", edge_width=3, color="orange")
fig_relation.savefig("filerel.pdf", dpi=300)

fig_poly = plt.figure()
domain = Set("{[i,j]: 0 <= i < 6 and 0 <= j < 6}")
dependences = Map("{[i,j]-> [i+1,j+1]; [i,j]-> [i+1,j]}")
tiling = Map("{[i,j] -> [floor(i/2), floor(j/2)]}")
space = Map("{[i,j] -> [i,i+j]}")
plot_domain(domain, dependences, tiling, space)
fig_poly.savefig("filepoly.pdf", dpi=300)

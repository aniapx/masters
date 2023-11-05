from islpy import *
from islplot.plotter import *
import matplotlib as mpl
import matplotlib.pyplot as plt

fig_poly = plt.figure()# MINE
domain = Set("{[i, j] : 1 <= i <= 6 and 2 <= j <= 6 }")
dependencies = Map("{[i,j]-> [i,j-2];}")

tiling = Map("{[i, j] -> [floor(i/7), floor(j/2) ]}")
# space = Map("{[j,i] -> [i+j,i]}")
# plot_domain(domain)
plot_domain(domain, dependencies, tiling)
# plot_domain(domain, dependencies, tiling, space)
#fig_poly.savefig("mcc.pdf", dpi=300)
fig_poly.savefig("rel.png", dpi=300)
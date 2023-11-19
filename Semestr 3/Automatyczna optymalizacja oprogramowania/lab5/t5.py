from islpy import *
from islplot.plotter import *
import matplotlib as mpl
import matplotlib.pyplot as plt

fig_poly = plt.figure()# MINE
domain = Set("{[i, j] : 0 < i <= 6 and 1 < j <= 6 }")
dependencies = Map("{[i, j] -> [i' = i, j' = 2 + j] : 0 < i <= 6 and 1 < j <= -2 + 6}")

# tiling = Map("{ [i, j] -> [it, jt] : -2 + i <= 2*it < i and -2 + j <= 2*jt < j }")
tiling = Map("{ [i, j] -> [it, jt] : 0 < i <= 6 and 2 <= j <= 6 and -2 + i <= 2it < i and -2 + j <= 2jt < j }")
plot_domain(domain, dependencies, tiling)
fig_poly.savefig("filepoly.png", dpi=300)
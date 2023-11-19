from islpy import *
from islplot.plotter import *
import matplotlib as mpl
import matplotlib.pyplot as plt

fig_poly = plt.figure()# MINE
domain = Set("{[i, j] : 2 <= i <= 6 and 0 < j <= 6 }")
dependencies = Map("{[i, j] -> [i' = i - 2, j' = j - 1] : 2 <= i <= -2 + 9 and 0 < j < 9}")

# tiling = Map("{ [i, j] -> [it, jt] : -2 + i <= 2*it < i and -2 + j <= 2*jt < j }")
# tiling = Map("{ [i, j] -> [it, jt] : 0 < i <= 6 and 2 <= j <= 6 and -2 + i <= 2it < i and -2 + j <= 2jt < j }")
plot_domain(domain, dependencies)
fig_poly.savefig("filepoly.png", dpi=300)
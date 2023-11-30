from islpy import *
from islplot.plotter import *
import matplotlib as mpl
import matplotlib.pyplot as plt

fig_poly = plt.figure()# MINE
domain = Set("{[i, j] : 1 <= i <= 6 and 2 <= j <= 6 }")
dependencies = Map("{[i, j] -> [i' = i, j' = 2 + j] : 0 < i < 6 and 2 <= j <= -2 + 6}")

plot_domain(domain, dependencies)
fig_poly.savefig("filepoly.png", dpi=300)
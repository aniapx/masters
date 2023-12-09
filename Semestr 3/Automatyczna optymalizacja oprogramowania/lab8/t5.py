from islpy import *
from islplot.plotter import *
import matplotlib as mpl
import matplotlib.pyplot as plt

fig_poly = plt.figure()# MINE
domain = Set("{[i, j] : 0 < i <= 9 and 3 <= j <= 9 }")
dependencies = Map("{[i, j] -> [i' = i, j' =  j - 3] : 0 < i <= 9 and 3 <= j <= 9}")

plot_domain(domain, dependencies)
fig_poly.savefig("filepoly.png", dpi=300)
from islpy import *
from islplot.plotter import *
import matplotlib as mpl
import matplotlib.pyplot as plt

fig_poly = plt.figure()
domain = Set("{[j,i]: 0 <= i < 12 and 0 <= j < 12 }")
dependences = Map("{[j,i]-> [j-2,i+1];}")
tiling = Map("{[j,i] -> [floor(j/2), floor(i/2)]}")
space = Map("{[j,i] -> [i+j,i]}")
#plot_domain(domain)
#plot_domain(domain, dependences, tiling)
plot_domain(domain, dependences, tiling, space)
#fig_poly.savefig("mcc.pdf", dpi=300)
fig_poly.savefig("rel.png", dpi=300)
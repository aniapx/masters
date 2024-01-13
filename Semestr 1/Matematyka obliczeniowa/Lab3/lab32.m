clc; clear; close all;

x = 1:10:2000;
y = size(x, 1);
index = 1;
for i=x
    r = rand(i, i);
    tic();
    det(r);
    y(1, index) = toc();
    index = index + 1;
end

for i=1:9
    figure
    hold on;
    scatter(x, y, 'Marker', '.', 'Color','green');
    coef1 = polyfit(x,y,i);
    y1 = polyval(coef1,x);
    plot(x, y1, 'Color', 'red');
end
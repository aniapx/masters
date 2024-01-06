clc; clear; close all
format long e

m5 = load('A_0005.mat').A_5;
m10 = load("A_0010.mat").A_10;
m50 = load('A_0050.mat').A_50;
m100 = load('A_0100.mat').A_100;
m200 = load('A_0200.mat').A_200;
m300 = load('A_0300.mat').A_300;
m500 = load('A_0500.mat').A_500;
m1000 = load('A_1000.mat').A_1000;
m2000 = load('A_2000.mat').A_2000;
m5000 = load('A_5000.mat').A_5000;

matrixes = {m5, m10, m50, m100, m200, m300, m500, m1000, m2000, m5000};

for i=1:size(matrixes, 2)
    disp("--------");
    i
    tic();
    detValue = det(matrixes{i})
    detTime = toc()
    tic();
    myDetValue = calcDet(matrixes{i})
    myDetTime = toc()
end

function myDet = calcDet(m) 
    n = size(m, 1);
    result = 1;
    
    for i=1:n-1
        a = m(i, i);
        m(i, :) = m(i, :) / a;
        m(i+1, :) = m(i+1, :) - m(i, :);
        result = result * a;
    end
    for i=1:n
        result = result * m(i, i);
    end
    myDet = result;
end
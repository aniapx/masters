format long e

clc
clear
close all

f0 = (sqrt(2) - 1);
f1 = (sqrt(2) - 1)^6;
f2 = 1/((sqrt(2) + 1)^6);
f3 = (3 - 2*sqrt(2))^3;
f4 = 1/((3 + 2*sqrt(2))^3);
f5 = 99 - 70*sqrt(2);
f6 = 1/(99 + 70*sqrt(2));

Y = zeros(1, 5);
Y(1) = abs(f1-f2);
Y(2) = abs(f1-f3);
Y(3) = abs(f1-f4);
Y(4) = abs(f1-f5);
Y(5) = abs(f1-f6);

X = categorical({'f2'; 'f3'; 'f4'; 'f5'; 'f6'});

hold on
bar(X, Y)
title('Błąd pomiędzy wynikiem f1 a fn');

clc
clear
close all

f = @(x, y) 9*x^4 - y^4 + 2*y^2;
f1 = @(x, y) (3*x^2 - y^2 + 1) * (3*x^2 +y^2 - 1) + 1;

x = 40545;
y = 70226;
fxy = f(x, y);
f1xy = f1(x, y);

x2 = single(40545);
y2 = single(70226);
fx2y2 = f(x2, y2);
f1x2y2 = f1(x2, y2);

x3 = int64(40545);
y3 = int64(70226);
fx3y3 = f(x3, y3);
f1x3y3 = f1(x3, y3);

x4 = int32(40545);
y4 = int32(70226);
fx4y4 = f(x4, y4);
f1x4y4 = f1(x4, y4);


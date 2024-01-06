clc
clear
format long e

K = 4:10;

i = 0;
for k=K
    i = i + 1;
    xs = single(10^k);
    as = single(xs+sqrt(1+xs*xs));
    w1s(i) = single(xs-as);
    w2s(i) = single(-(1/(xs+as)));
end

i = 0;
for k=K
    i = i + 1;
    xd = double(10^k);
    ad = double(xd+sqrt(1+xd*xd));
    w1d(i) = double(xd-ad);
    w2d(i) = double(-(1/(xd+ad)));
end

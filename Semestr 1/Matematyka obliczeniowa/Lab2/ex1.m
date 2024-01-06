clc
close all
clear
format long e

%% single
range = single(1:10^6);

% A1
tic
sum_result1S = single(0);
for i=range
    sum_result1S = sum_result1S + i;
end
toc
sum_result1S

% A2
tic
sum_result2S = sum(range);
toc
sum_result2S

% A3
tic
x=range;
n=length(x);
S=single(x(1));
C=0;
for i=2:n
    Y=x(i)-C;
    T=S+Y;
    C=(T-S)-Y;
    S=T;
end
toc
sum_result3S = S

% A4
tic
x = range;
n = length(x);
S = single(0);
U = 0;
P = 0;
for i=1:n
    S = U+x(i);
    P = U - S + x(i) + P;
    U = S;
end
S = S + P;
toc
sum_result4S = S

%% double
range = double(1:10^6);

% A1
sum_result1D = double(0);
tic
for i=range
    sum_result1D = sum_result1D + i;
end
toc
sum_result1D

% A2
tic
sum_result2D = sum(range);
toc
sum_result2D

% A3
tic
x=range;
n=length(x);
S=double(x(1));
C=0;
for i=2:n
    Y=x(i)-C;
    T=S+Y;
    C=(T-S)-Y;
    S=T;
end
toc
sum_result3D = S

% A4
tic
x = range;
n = length(x);
S = double(0);
U = 0;
P = 0;
for i=1:n
    S = U+x(i);
    P = U - S + x(i) + P;
    U = S;
end
S = S + P;
toc
sum_result4D = S

%% suma elementów ciągu
a1 = range(1);
an = range(end);
S = ((a1 + an) * n) / 2;
sum_result_ciag = S

%% blad
errors = [
    abs(sum_result1S - sum_result_ciag),
    abs(sum_result2S - sum_result_ciag),
    abs(sum_result3S - sum_result_ciag),
    abs(sum_result4S - sum_result_ciag),
];
bar(errors);
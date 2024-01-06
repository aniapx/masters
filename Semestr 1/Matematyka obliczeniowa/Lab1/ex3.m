clc
clear
close all

format long e

d = 10^(-3);
X = linspace(2-d, 2+d, 1000);

f1 = (X -2).^4;
f2 = X.*X.*X.*X - 4*X.*X.*X*2 + 6*X.*X.*4 - 4*X.*8 + 16;


errors = zeros(1, size(X, 1));
i = 0;
for x = X 
    i = i + 1;
    errors(i) = abs(f1(i) - f2(i));
end
errors = abs(f1-f2);
max_error = max(errors);

hold on;
plot(X, f1);
plot(X, f2);
title('Błąd:', max_error);
legend('f1(x)', 'f2(x)');

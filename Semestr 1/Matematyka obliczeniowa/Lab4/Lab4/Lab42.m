format long e

clc
clear
close all
N = [10, 100, 200, 500, 1000, 2000, 3000, 5000];

times_gs = [];
times_t = [];

for n = N
    A = tridiag(n);
    d = A*ones(n,1);
    tic
    solveGauss(A, d);
    times_gs = [times_gs toc];
    tic
    solveThomas(A, d);
    times_t = [times_t toc];
end

figure;
plot(N, times_t);
title("Metoda Thomasa");
figure;
plot(N, times_gs);
title("Metoda eleminiacji Gaussa");

function x = solveGauss(A,B)
    W = 1;
    
    [w, k] = size(A);
    
    for i = 1 : w
        B(i) = B(i) ./ A(i, i);
        A(i, :) = A(i, :) ./ A(i, i);
        for j = i + 1:w
             B(j) = B(j) - B(i) * A(j, i);
             A(j, :) = A(j, :) - A(i, :) * A(j, i);
        end
    end
    
    W(w) = B(w);
    
    for i = w-1 : -1 : 1
        W(i) = B(i);
        for j = w : -1 : i+1
            W(i) = B(i) - A(i, j) * W(j);
        end
    end
    x = W';
end 

function x = solveThomas(A, d)
    n = size(d, 1);
    a = [0; diag(A, -1)];
    b = diag(A);
    c = [diag(A, 1); 0];

    beta = zeros(n, 1);
    gamma = zeros(n, 1);
    x = zeros(n, 1);

    beta(1) = -(c(1) / b(1));
    gamma(1) = d(1)/b(1);

     for i = 2:n
        beta(i) = -(c(i) / (a(i) * beta(i-1) + b(i)));
     end
     for i = 2:n
        gamma(i) = (d(i) - a(i)*gamma(i-1)) / (a(i)*beta(i-1) + b(i));
     end
     x(n) = gamma(n);
     for i = n-1:-1:1
        x(i) = beta(i)*x(i+1) + gamma(i);
     end
end
 
function T = tridiag(size)
    T = randn(size);
    T = diag(diag(T),0) + diag(diag(T,-1),-1) + diag(diag(T,1),1);
end

 
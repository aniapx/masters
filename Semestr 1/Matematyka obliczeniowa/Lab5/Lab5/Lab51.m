clc
clear
close all

matrix_sizes = [10,100,200,500,1000,2000, 3000, 5000];
times_b = [];
times_s = [];
times_gs = [];
iterations_s = [];
iterations_gs = [];
e = 0.001;

for N = matrix_sizes
    A=rand(N, N);
    A=A+N*eye(N); 
    X=ones(N,1);
    b=A*X;

    tic
    x = built_in(A, b);
    times_b = [times_b toc];
    W=A;
    Z=b;
    WZ=[A,Z];
    n=max(size(A));
    for i=1:n
       for j=1:n
          if i==j
             WZ(i,:)= WZ(i,:)./W(i,i);
             WZ(i,1:n)=WZ(i,1:n)*(-1);
             WZ(i,i) = 0;
          end
       end
    end
    W=WZ(:,1:n);
    Z=WZ(:,end);
    Wu=triu(WZ(:,1:n));
    Wl=tril(WZ(:,1:n));

    tic
    [iterations, x] = simple(W, Z, e);
    times_s = [times_s toc];
    iterations_s = [iterations_s iterations];
    tic
    [iterations, x] = gauss_siedel(Wu, Wl, Z, e);
    times_gs = [times_gs toc];
    iterations_gs = [iterations_gs iterations];
end

figure;
hold on;
plot(matrix_sizes, times_b);
plot(matrix_sizes, times_s);
plot(matrix_sizes, times_gs);
legend('Metoda wbudowana', 'Iteracja prosta', 'Iteracja Gaussa-Seidla')
title('e = 0.001')

function x = built_in(A, b) 
    x = A\b;
end

function [iterations, x] = simple(W, Z, e)
    iterations = [];
    n=max(size(W));
    x=zeros(n,1);
    i = 0;
    while (true)
        i = i+1;
        
        x_new = W * x(:, i) + Z;
        x = [x x_new];        
    
        d=max(abs(x(:,i+1)-x(:,i)));
        if (d < e)
            break;
        end
    end
    iterations = [iterations i];
    x = [x(:, end-1) x(:, end)];
end

function [iterations, x] = gauss_siedel(Wu, Wl, Z, e)
    iterations = [];
    n=max(size(Wu));
    x=zeros(n,1);
    i = 0;
    while (true)
        i = i+1;
        
        x_new = zeros(n, 1);
        x_new = Wu * x(:,i) + Wl * x_new + Z;
        x = [x x_new];
        
        d=max(abs(x(:,i+1)-x(:,i)));
        if (d < e)
            break;
        end
    end
    iterations = [iterations i];
    x = [x(:, end-1) x(:, end)];
end
format long e

clc
clear
close all

% matrix_sizes = [10,100,200,500,1000,2000,3000,5000];
matrix_sizes = [10];
times = zeros(1, size(matrix_sizes, 2));
times = [];
iterations = zeros(1, size(matrix_sizes, 2));
iterations = [];
e = 0.1;

for N = matrix_sizes
    A=rand(N, N);
    A=A+N*eye(N); 
    X=ones(N,1);
    b=A*X;
    A = [0 -0.25; -0.5 0];
    b = [2;9/2];
    
    tic
% metoda wbudowana
%     x = A\b;

% Wyznaczenie przekształconych macierzy W i Z
    W=A;
    Z=b;
    WZ=[A,Z]; % macierz A i dołączona macierz Z
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
    
% macierze trójkątne
    Wu=triu(WZ(:,1:n));
    Wl=tril(WZ(:,1:n));

    Wu = [0 -0.25; 0 0];
    Wl = [0 0; -0.5 0];
    Z = [2;2/9];

    x=zeros(n,1);

    tic
    i = 0;
    while (true)
        i = i+1;
        
        x_new = x(:, 1);
        for k=2:n
            x_new(k) = Wu(k, :) * x(:, k-1) + Wl(k, :) * x_new(:, k-1) + Z(k-1);
        end
        
        x = [x x_new];
        
        d=max(abs(x(:,i+1)-x(:,i)));
        if (d < e)
            break;
        end
    end
    iterations = [iterations i];
    times = [times toc];
end

iterations
times
clc;
close all;
clear;

format long e;

eps = 0.01;

A = [
    [1 2]
    [1 2+eps]
];

b = [
    4
    4+eps
];

an = [2;1];

cond(A)

% analityczna

% metoda cramera
% W = det(A);
% for i = 1:max(size(A))
%     A1 = A;
%     A1(:, i) = b;
%     W1 = det(A1);
%     x(i, 1) = W1/W;
% end
% x

% odwracanie macierzy
% x = linsolve(A,b)

% Gauss
% x = solveGauss(A, b)

% LU 1
% [L, U] = lu(A);
% x = U^(-1) * L^(-1) * b

% LU 2
% [L, U] = lu(A);
% y = L \ b;
% x = U \ y

% QR 1
% [Q, R] = qr(A);
% x = R^(-1) * Q^(-1) * b

% QR 2
% [Q, R] = qr(A);
% y = Q \ b;
% x = R \ y

% SVD
% [U, S, V] = svd(A, 0);
% x = V*((U'*b)./diag(S))

% err(x, an)

function x = err(a, b)
    x = abs(a - b);
end

function x = solveGauss(A,b)
    s = length(A);
    for j = 1:(s-1)
        for i = s:-1:j+1
            m = A(i,j)/A(j,j);
            A(i,:) = A(i,:) - m*A(j,:);
            b(i) = b(i) - m*b(j);
        end
    end 
    x = zeros(s,1);
    x(s) = b(s)/A(s,s);               
    for i = s-1:-1:1                    
        sum = 0;
        for j = s:-1:i+1                
            sum = sum + A(i,j)*x(j);    
        end 
        x(i) = (b(i)- sum)/A(i,i);
    end 
end

clear all
e = 0.001;
czasy = []
iteracje = []
for n=[10 100 200 500 1000]
    A=rand(n,n);
    A=A+n*eye(n);
    X=ones(n,1);
    b=A*X;
   
    % Wyznaczenie przekszta³conych macierzy W i Z
    W=A;
    Z=b;
    WZ=[A,Z]; % macierz A i do³¹czona macierz Z
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
    
    % macierze trójk¹tne
    Wu=triu(WZ(:,1:n));
    Wl=tril(WZ(:,1:n));

%     Wu = [0 -0.25; 0 0];
%     Wl = [0 0; -0.5 0];
%     Z = [2;9/2];
    
    % startowe
    x=zeros(n,1);
    
    tic
    kontynuuj = true;
    i = 0;
    while (kontynuuj)
        i = i+1;
        
        x_new = x(:, 1);
        for j=1:n
            x_new = Wu(n, :) * x(:,i) + Wl(n, :) * x_new + Z;
        end
        
        x = [x x_new];
        
        d=max(abs(x(:,i+1)-x(:,i)));
        if (d < e)
            kontynuuj = false;
        end
    end
    x
    iteracje = [iteracje i]
    czasy = [czasy toc]
end

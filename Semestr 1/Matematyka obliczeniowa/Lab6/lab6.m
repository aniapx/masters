clc
clear 
close all

h=0.0001;

% f1 = @(X) X(1) ^ 2 - X(2) ^2 - 1;
% f2 = @(X) X(1) ^ 3 * X(2) ^2 - 1;
% [x, y] = meshgrid(1:0.1:3, -3:0.1:3);
% z_1 = x .^ 2 - y .^ 2 - 1;
% z_2 = x .^ 3 .* y .^ 2 - 1;

f1 = @(X) 90 * X(1) ^ 2 + 25 * X(2) ^2 - 225;
f2 = @(X) 9 * X(1) ^ 4 + 25 * X(2) ^3 - 50;
[x, y] = meshgrid(-6:0.1:6, -6:0.1:6);
z_1 = 90 .* x .^ 2 + 25 * y .^2 - 225;
z_2 = 9 .* x .^ 4 + 25 * y .^3 - 50;

% figure(1)
% mesh(x, y, z_1);
% hold on 
% mesh(x, y, z_2);

% figure(2)
% [c H] = contour(x, y, z_1);
% clabel(c, H);
% hold on
% contour(x, y, z_1, [0 0], 'color', 'r', 'LineWidth', 2);
% 
% [c H] = contour(x, y, z_2);
% clabel(c, H);
% contour(x, y, z_2, [0 0], 'color', 'r', 'LineWidth', 2);

% Newton
diff_x1 = @(f, X) (f([X(1) + h, X(2)]) - f([X(1) - h, X(2)])) / (2 * h);
diff_x2 = @(f, X) (f([X(1), X(2) + h]) - f([X(1), X(2) - h])) / (2 * h);

xk = [-2;0.5];
 
black = [[];[]];
green = [[];[]];
yellow = [[];[]];

for x1 = -5:0.025:5
    for x2 = -5:0.025:5
        xk = [x1; x2];

        J = [diff_x1(f1, xk) diff_x2(f1, xk); diff_x1(f2, xk) diff_x2(f2, xk)];
        dk = J \ [f1(xk); f2(xk)];
        
        while norm(dk) > h
            xk = xk - dk;
            J = [diff_x1(f1, xk) diff_x2(f1, xk); diff_x1(f2, xk) diff_x2(f2, xk)];
            dk = J \ [f1(xk); f2(xk)];
            if all(isnan(dk))
%                 fprintf(1, 'Macierz osobliwa\n');
                break
            end
        end

        xk = xk - dk;
        
        if any(isnan(xk))
            black = [black [x1; x2]];
        elseif xk(1) >= 0
            green = [green [x1; x2]];
        else
            yellow = [yellow [x1; x2]];
        end
    end
end

figure 
hold on
if size(black) ~= [0 0]
    plot(black(1, :), black(2, :), 'k.')
end
if size(green) ~= [0 0]
    plot(green(1, :), green(2, :), 'g.')
end
if size(yellow) ~= [0 0]
    plot(yellow(1, :), yellow(2, :), 'y.')
end

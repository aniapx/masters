clc; clear all; close all;
format long e;

m5 = load('A_0005.mat').A_5;
m10 = load("A_0010.mat").A_10;
m50 = load('A_0050.mat').A_50;
m100 = load('A_0100.mat').A_100;
m200 = load('A_0200.mat').A_200;
m300 = load('A_0300.mat').A_300;
m500 = load('A_0500.mat').A_500;
m1000 = load('A_1000.mat').A_1000;
m2000 = load('A_2000.mat').A_2000;
m5000 = load('A_5000.mat').A_5000;

matrixes = {m5, m10, m50, m100, m200, m300, m500, m1000, m2000, m5000};
% matrixes = {m300};

for i=1:size(matrixes, 2)
    disp("--------");
    i
    tic();
    det(matrixes{i})
    detTime = toc()
    tic();
    calcDet(matrixes{i})
    myDetTime = toc()
end

t = [5,2,1; 2,4,6; 1,7,8];
t2 = [0,2,1; 5,5,6; 1,7,8];
t2 = [5,2,1; 5,5,6; 1,7,8];
expectedT = det(t2);
myDet = calcDet(t2);

format short;

assert(abs(myDet - expectedT) <= 0.01)

% y = zeros(1, 200);
% index = 1;
% x = 1:10:2000;
% for i=1:10:2000
%     r = rand(i, i);
%     tic();
%     det(r);
%     y(1, index) = toc();
%     index = index + 1;
% end
% 
% % figure
% % hold on
% % plot(x,y);
% 
% for i=1:2
%     figure
%     hold on;
%     scatter(x, y, 'Marker', '.', 'Color','green');
%     coef1 = polyfit(x,y,i);
%     y1 = polyval(coef1,x);
%     plot(x, y1, 'Color', 'red');
% end
% 
% 
function myDet = calcDet(t) 
    myDet = 1;
    for rowIndex=1:size(t, 1)
        wRow = t(rowIndex, :);
        if wRow(rowIndex) == 0
            for innerRowIndex=rowIndex+1:size(t, 1)
                if t(innerRowIndex, rowIndex) ~= 0
                    wRow = t(rowIndex+innerRowIndex, :);
                    t(rowIndex+innerRowIndex, :) = t(rowIndex, :);
                    t(rowIndex, :) = wRow;
                end
            end
        end
        restRows = t(rowIndex+1:end, :);
        divisor = wRow(rowIndex);
        myDet = myDet * divisor;
        wRow = wRow ./ divisor;
        t(rowIndex, :) = wRow; 
        for innerRowIndex=1:size(restRows, 1)
            innerWorkingRow = restRows(innerRowIndex, :);
            multiplier = innerWorkingRow(rowIndex);
            diffTmpRow = (multiplier .* wRow);
            t(rowIndex+innerRowIndex, :) = innerWorkingRow - diffTmpRow;
        end
    end
end




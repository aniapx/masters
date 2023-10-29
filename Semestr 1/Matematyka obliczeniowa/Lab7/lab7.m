clc
clear
close all

x = 0:10:150;
y = 0:10:90;
z = [
    0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0;
    0	0	50	90	80	60	10	0	0	0	0	0	0	0	0	0;
    0	20	150	220	220	150	80	30	0	0	0	0	0	0	0	0;
    0	120	350	700	700	500	280	100	50	0	0	0	0	0	0	0;
    0	180	500	1000	700	400	300	200	140	70	30	10	10	80	100	0;
    0	170	250	650	495	205	150	250	220	200	100	90	170	230	140	0;
    0	100	160	190	150	90	30	0	50	150	230	250	250	210	120	0;
    0	20	70	80	60	0	0	0	0	20	100	150	150	120	70	0;
    0	0	0	0	0	0	0	0	0	0	20	60	70	50	5	0;
    0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0;
];

figure
subplot(1, 2, 1)
[X, Y] = meshgrid(x, y);
contour3(X, Y, z);

subplot(1, 2, 2)
plot3(X, Y, z, '.r')

% subplot(2, 2, 3)
% surf(X,Y,z)

xx = 0:1:150;
yy = 0:1:90;
[X,Y]=meshgrid(x,y);
[XX,YY]=meshgrid(xx,yy);
% [X, Y] = meshgrid(0:5:150, 0:5:90);

I1=interp2(X,Y,z,XX,YY,'nearest');
I2=interp2(X,Y,z,XX,YY,'linear');
I3=interp2(X,Y,z,XX,YY,'spline');
I4=interp2(X,Y,z,XX,YY,'makima');
I5=interp2(X,Y,z,XX,YY,'cubic');

figure
subplot(3,2,1)
plot3(X,Y,z,'.r')
hold on
mesh(XX,YY,I1)
title('nearest')

subplot(3,2,2)
plot3(X,Y,z,'.r')
hold on
mesh(XX,YY,I2)
title('linear')

subplot(3,2,3)
plot3(X,Y,z,'.r')
hold on
mesh(XX,YY,I3)
title('spline')

subplot(3,2,4)
plot3(X,Y,z,'.r')
hold on
mesh(XX,YY,I4)
title('makima')

subplot(3,2,5)
plot3(X,Y,z,'.r')
hold on
mesh(XX,YY,I5)
title('cubic')
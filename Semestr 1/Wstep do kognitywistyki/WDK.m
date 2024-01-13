close all
clc
clear

answers_table = readmatrix("WDK.csv");
lillietest(answers_table(:, 4))
[p,tbl,stats] = kruskalwallis(answers_table(:, 4), answers_table(:, 2))
multcompare(stats)

% temat, kategorie, osoby badane ilosć, co trzeba było zrobić, rozkłąd
% normalny i jaki wynik, ze względu na to wybrano metodę kruskal wallice, brak istotniści statystycznej, wyniki się
% zazębiają i nie ma jedengo wyboru


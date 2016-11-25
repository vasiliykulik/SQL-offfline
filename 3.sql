/*Создать внешние ключи для зависимостей N-N.*/
ALTER TABLE Component ADD COLUMN component_amount real;
UPDATE Component SET component_amount  = 0.3 where id = 1;
UPDATE Component SET component_amount  = 0.12 where id = 2;
UPDATE Component SET component_amount  = 0.17 where id = 3;
UPDATE Component SET component_amount  = 0.3 where id = 4;
UPDATE Component SET component_amount  = 0.05 where id = 5;
UPDATE Component SET component_amount  = 0.01 where id = 6;

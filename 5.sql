/*Вывести самый дорогой и дешевый ингредиент.*/

Select * from Component where PRICE = (Select MAX(PRICE) FROM COMPONENT);
union
Select * from Component where PRICE = (Select min(PRICE) FROM COMPONENT);
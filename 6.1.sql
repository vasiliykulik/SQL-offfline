select sum( component.price * component_amount )
from component;

select component.name, component.price * component_amount as component_cost
from component;

select * from component
  join pizza_component
    on component.id = pizza_component.componentid;

/*В результате у нас получится строка со всех колонок*/
select * from component
join pizza_component
  on component.id = pizza_component.componentid
join pizza
  ON pizza.id = pizza_component.pizzaid


select component.name, sum(component.price * component_amount)
from component
  join pizza_component
    on component.id = pizza_component.componentid
  join pizza
    ON pizza.id = pizza_component.pizzaid
/*GROUP BY выберет с одинаковым name b посчитает для одинаковых подмножеств*/
GROUP BY component.name;

select component.name, sum(component.price * pizza.)
from component
  join pizza_component
    on component.id = pizza_component.componentid
  join pizza
    ON pizza.id = pizza_component.pizzaid
/*GROUP BY выберет с одинаковым name b посчитает для одинаковых подмножеств*/
GROUP BY component.name
/*К запросу выше добавить суммарную цену за пиццу исходя из цены на ингредиенты.
*/

select component.name, component.price * component_amount as component_cost
from component
union
  select 'Итого', sum( component.price * component_amount )
  from component;
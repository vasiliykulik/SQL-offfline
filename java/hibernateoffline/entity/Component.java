package hibernateoffline.entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by Стрела on 02.12.2016.
 */
@Entity
@Table(name = "component",schema = "public")
public class Component {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;
    private String name;
    private double price;
    private double component_amount;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Component{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", price=").append(price);
        sb.append(", component_amount=").append(component_amount);
        sb.append('}');
        return sb.toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getComponent_amount() {
        return component_amount;
    }

    public void setComponent_amount(double component_amount) {
        this.component_amount = component_amount;
    }
}

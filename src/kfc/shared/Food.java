package kfc.shared;

import java.util.Objects;

/**
 *
 * @author hien
 */
public class Food {
    private String name;
    private String description;
    private int price;
    
    public Food(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
    
    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }

        if (!Food.class.isAssignableFrom(object.getClass())) {
            return false;
        }
        
        final Food food = (Food)object;
        return food.hashCode() == this.hashCode();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.name);
        hash = 71 * hash + Objects.hashCode(this.description);
        hash = 71 * hash + this.price;
        return hash;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

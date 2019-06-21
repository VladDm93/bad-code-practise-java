package model;

import java.util.Objects;

/**
 * Класс-модель, описывающая ингридиент
 */
public class Ingredient {

    private String name;

    public Ingredient(String name) {
        this.name = name.toLowerCase();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Ingredient that = (Ingredient) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

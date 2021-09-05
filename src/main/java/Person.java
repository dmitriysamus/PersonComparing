import java.util.Objects;

/**
 * Реализует интерфейс Comparable<Person>.
 * Определяет следующий порядок по возрастанию:
 * - сначала по полю city,
 * - затем по полю name.
 * Поля name, city отличны от null.
 */
public class Person implements Comparable<Person> {

    private String name;
    private String city;
    private int age;

    /**
     * Конструктор объекта типа Person.
     */
    public Person(String name, String city, int age) {
        this.name = name;
        this.city = city;
        this.age = age;
    }

    /**
     * Производит сравнение текущего объекта с переданным.
     * возвращает положительное при this > o,
     * отрицательное при this < o,
     * или ноль при this == o.
     */
    public int compareTo(Person o) {
        int result;
        result = this.city.compareToIgnoreCase(o.city);
        if (result == 0) {
            result = this.name.compareToIgnoreCase(o.name);
        }

        return result;
    }

    /**
     * Производит расчет hashCode объекта по полям name, city и age.
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.city, this.name, this.age);
    }

    /**
     * Проверяет идентичность объектов по полям name, city и age.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!obj.getClass().equals(this.getClass())) {
            return false;
        }
        Person other = (Person) obj;

        return this.city.equals(other.city) &&
                this.name.equals(other.name) &&
                this.age == other.age;
    }

    /**
     * Возвращает строковое отображение объекта.
     */
    @Override
    public String toString() {
        return "Person{" +
                "city = " + this.city +
                ", name = " + this.name +
                ", age = " + this.age +
                "}";
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public int getAge() {
        return age;
    }
}

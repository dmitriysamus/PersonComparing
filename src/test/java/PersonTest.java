import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PersonTest {
    List<Person> arrayList;

    /**
     * Подготовка данных для тестов.
     */
    @BeforeEach
    void Init() {
        arrayList = new ArrayList<>();
        arrayList.add(new Person("Andrey", "Yalta", 29));
        arrayList.add(new Person("dasha", "novosibirsk", 26));
        arrayList.add(new Person("Oleg", "Novosibirsk", 20));
    }

    /**
     * Очистка объектов после тестов.
     */
    @AfterEach
    void clean() {
        arrayList = null;
    }

    /**
     * Проверяется работа метода compareTo().
     * Сортировка сначала по полю city, а затем по полю name
     */
    @Test
    void compareTo() {
        arrayList.sort(Person::compareTo);
        Assert.assertEquals(new Person("dasha", "novosibirsk", 26), arrayList.get(0));
        Assert.assertEquals(new Person("Oleg", "Novosibirsk", 23), arrayList.get(1));
        Assert.assertEquals(new Person("Andrey", "Yalta", 29), arrayList.get(2));
    }

    /**
     * Проверяется работа метода toString() на соответствие вывода.
     */
    @Test
    void testToString() {
        Assert.assertEquals("Person{city = novosibirsk, name = dasha, age = 26}",
               arrayList.get(1).toString());
    }

}

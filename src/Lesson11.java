import box.Box;
import fruits.Apple;
import fruits.Orange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lesson11 {
    public static void main(String[] args) throws CloneNotSupportedException {
        // Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа)
        // метод replaceElementsOfArray
        String[] strArray = new String[]{"1", "3", "5", "7", "9", "10"};
        System.out.println("Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа)");
        System.out.println("Исходный массив: " + Arrays.toString(strArray));
        replaceElementsOfArray(strArray, 0, 1);
        System.out.println("Измененный массив: " + Arrays.toString(strArray));

        // Написать метод, который преобразует массив в ArrayList;
        // convertArrayToArrayList
        System.out.println("\nПреобразование массива в ArrayList;");
        ArrayList<?> listArray = convertArrayToArrayList(strArray);
        System.out.println("Исходный класс: " + strArray.getClass().getName());
        System.out.println("Результатирующий класс: " + listArray.getClass().getName());

        // Задача:
        //а) Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
        //б) Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта, поэтому в одну
        // коробку нельзя сложить и яблоки, и апельсины;
        //в) Для хранения фруктов внутри коробки можно использовать ArrayList;
        //г) Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество:
        // вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
        //д) Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той, которую подадут
        // в compare() в качестве параметра. true – если их массы равны, false в противоположном случае. Можно
        // сравнивать коробки с яблоками и апельсинами;
        //е) Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую. Помним про сортировку
        // фруктов: нельзя яблоки высыпать в коробку с апельсинами. Соответственно, в текущей коробке фруктов не
        // остается, а в другую перекидываются объекты, которые были в первой;
        //ж) Не забываем про метод добавления фрукта в коробку.
        System.out.println("\nЗадача. Этапы выполения:");
        Apple apple1 = new Apple("Яблоко 1");
        Apple apple2 = new Apple("Яблоко 2");
        Apple apple3 = new Apple("Яблоко 3");
        Orange orange1 = new Orange("Апельсин 1");
        Orange orange2 = new Orange("Апельсин 2");
        Orange orange3 = new Orange("Апельсин 3");
        // складываем фрукты по типу в каждую коробку: яблоки
        Box<Apple> boxOfApple = new Box<>(
                new ArrayList<>(List.of(apple1, apple2, apple3)), "Корзина с яблоками №1"
        );
        // складываем фрукты по типу в каждую коробку: апельсины
        Box<Orange> boxOfOrange = new Box<>(
                new ArrayList<>(List.of(orange1, orange2)), "Корзина с апельсинами №1"
        );
        System.out.println("Вес коробок яблок и апельсинов равен? = " + boxOfApple.compare(boxOfOrange));
        boxOfOrange.addFruit(orange3);
        System.out.println("Вес коробок яблок и апельсинов после добавления апельсина? = " + boxOfApple.compare(boxOfOrange));

        // пункт задания №3Е
        System.out.println("\nОперации с фруктами (№3Е)");
        boxOfApple.show();
        boxOfOrange.show();
        // создадим корзину и добавуим яблок
        Apple apple4 = new Apple("Яблоко 4");
        Apple apple5 = new Apple("Яблоко 5");
        Apple apple6 = new Apple("Яблоко 6");
        Box<Apple> boxOfApple2 = new Box<>(
                new ArrayList<>(List.of(apple4, apple5, apple6)), "Корзина с яблоками №2"
        );
        boxOfApple2.show();

        System.out.println("\nменяем количество яблок в корзинах:");
        boxOfApple.addFruitsFromBox(boxOfApple2, 1);
        boxOfApple.show();
        boxOfApple2.show();
    }

    // Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа)
    public static <T> void replaceElementsOfArray(T[] array, int index1, int index2) {
        if (index1 != index2) {
            T element = array[index1];
            array[index1] = array[index2];
            array[index2] = element;
        }
    }

    // Написать метод, который преобразует массив в ArrayList;
    public static <T> ArrayList<T> convertArrayToArrayList(T[] array) {
        return new ArrayList<>(List.of(array));
    }
}
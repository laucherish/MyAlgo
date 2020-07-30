package mj;

public class Person implements Comparable<Person> {
    public int age;

    public Person(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        return age - o.age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                '}';
    }
}

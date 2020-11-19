package pt.uma.tpsi;

import java.util.Comparator;
import java.util.Objects;

public class Student implements Comparator<Student> {
    private int number;
    private String name;

    public Student (int number, String name){
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compare(Student std1, Student std2) {
        return std1.getName().compareTo(std2.getName());
    }

    @Override
    public boolean equals(final Object o) {
        //comparacao de referencia/identidade
        if (this == o) return true;
        //verificar se a classe é igual / == null
        if (o == null || getClass() != o.getClass()) return false;
        //conversao de Object para Student
        final Student student = (Student) o;
        return number == student.number &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }
}

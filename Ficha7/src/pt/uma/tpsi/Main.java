package pt.uma.tpsi;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        /*
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduza uma opção: ");
        String line = scanner.nextLine();
        Option option = Option.valueOf(line);

        for (Option opt : Option.values()) {
            System.out.println(opt);
        }

        switch
        (option) {
            case START:
                System.out.println("Game Started");
                break;
            case SAVEGAME:
                System.out.println("Game Saved");
                break;
            case LOADGAME:
                System.out.println("Game Loaded");
                break;
            case HIGHSCORES:
                System.out.println("Highscores: ");
                break;
            case QUIT:
                System.out.println("Quitting...");
                break;
        }

        /*
        String s1 = Option.START.name();
        System.out.println(s1);

        String s2 = Option.START.prettyName();
        System.out.println(s2);
        */

        Rational r1 = new Rational(3 ,4);
        Rational r2 = new Rational(1 ,33);
        Rational r3 = new Rational(34 ,54);
        Rational r4 = new Rational(43 ,4);

        List<Rational> rationals = new ArrayList<Rational>();

        rationals.add(r1);
        rationals.add(r2);
        rationals.add(r3);
        rationals.add(r4);

        Collections.sort(rationals);

        /*
        for (Rational r : rationals
        ) {
            System.out.println(r.toString());
        }
        */

        Student s3 = new Student(1, "Pedro");
        Student s2 = new Student(2 ,"Neves");
        Student s1 = new Student(3 ,"Carlao");
        Student s4 = new Student(4 ,"David");

        List<Student> students = new ArrayList<Student>();

        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);

        for (Student s : students
        ) {
            System.out.println(s.toString());
        }

        //Collections.sort();

    }


    public enum Option {
        START, SAVEGAME, LOADGAME, HIGHSCORES, QUIT;

        public String prettyName() {
            return name().charAt(0) +
                    name().substring(1).toLowerCase();
        }
    }
}

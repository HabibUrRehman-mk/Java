abstract class Person {
    protected String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract boolean isOutstanding();
}

class Student extends Person {
    private double CGPA;

    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }

    public double getCGPA() {
        return CGPA;
    }

    @Override
    public boolean isOutstanding() {
        return CGPA > 3.5;
    }
}

class Professor extends Person {
    private int numberOfPublications;

    public void setNumberOfPublications(int numberOfPublications) {
        this.numberOfPublications = numberOfPublications;
    }

    public int getNumberOfPublications() {
        return numberOfPublications;
    }

    @Override
    public boolean isOutstanding() {
        return numberOfPublications > 50;
    }
}

public class Main {
    public static void main(String[] args) {
        Person[] people = new Person[2];

        Student student = new Student();
        student.setName("HABIB UR REHMAN");
        student.setCGPA(3.96);

        Professor professor = new Professor();
        professor.setName("Dr. Shahid Qaiser");
        professor.setNumberOfPublications(100);

        people[0] = student;
        people[1] = professor;

        for (Person person : people) {
            System.out.println(person.getName() + " is outstanding: " + person.isOutstanding());
        }
    }
}

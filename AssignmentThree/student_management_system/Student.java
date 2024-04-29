package AssignmentThree.student_management_system;

public class Student {

    private Integer id;
    private String name;
    private Integer age;
    private Double grade;

    public Student(Integer id, String name, Integer age, Double grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Double getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

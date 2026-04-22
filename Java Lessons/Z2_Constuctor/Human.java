package Z2_Constuctor;

public class Human {

    String name ;
    int age;
    double weight;

    Human(String name ,int age , double weight){
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    void work(){
        System.out.println(this.name + " is going to Work");
    }

    // Override toString() to print meaningful info
    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Weight: " + weight;
    }
}

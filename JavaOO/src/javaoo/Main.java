package javaoo;

/**
 *
 * @author willian
 * 
 * Object > Class > Inheritance > Polymorphism > Abstraction > Encapsulation
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Person person1 = new Person();
        person1.name = "Josh";
        person1.cpf = "1234578910";
        person1.age = 40;
        
        System.out.println(person1);
        person1.say();
        Person.say("hi people!!!");
        person1.say("hi");
    }
    
}

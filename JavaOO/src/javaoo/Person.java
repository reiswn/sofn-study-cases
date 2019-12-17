package javaoo;

public class Person {

    String name;
    String cpf;
    Integer age;
    
    public Person(){

    }
    
    public void say(){
        System.out.println(this.name + " say something!!!");
    }
    
    /*
        static - In Java, static is a keyword used to describe how objects 
    are managed in memory. It means that the static object belongs specifically
    to the class, instead of instances of that class. Variables, methods, and 
    nested classes can be static.
    */
    public static void say(String something) {
        //System.out.println(this.name + " say something!!!");
        System.out.println(something);
    }
}

package javaoo;
/*
To encapsulate a class/ object completely you need to:

> Declare all the variables of a the as private.
> Provide public setter and getter methods to modify and view their values.

*/
public class EncapsuledPerson {
    
    private String name;
    private String cpf;
    private Integer age;
    
    public EncapsuledPerson(String name, String cpf, Integer age){
        this.setName(name);
        this.setCpf(cpf);
        this.setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    
}

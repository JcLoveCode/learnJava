package fanshe;


public class Person {
   public Integer age;
   public String name;

    public Person( int age,String name) {
        this.name = name;
        this.age = age;
    }

    public Person(Integer age) {
        this.age=age;
    }

    public Integer getAge() {
      return age;
   }

   public void setAge(Integer age) {
      this.age = age;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }


}

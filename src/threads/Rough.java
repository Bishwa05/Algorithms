package threads;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Person {
    int age;
    String name;

    Person(int age, String name){
        this.age = age;
        this.name = name;
    }

    @Override public boolean equals (Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Person person = (Person)o;
        return age == person.age;
    }

//    @Override public int hashCode ()
//    {
//        return Objects.hash(age, name);
//    }
}

public class Rough
{

    public static void main(String arg[]){
//        Person p1 = new Person(21, "John");
//        Person p2 = new Person(21, "Alex");
//        //p1 = p2;
//        Set<Person> set = new HashSet<>();
//        set.add(p1);
//        set.add(p2);
//
//        System.out.println(set);

        Rough r = new Rough();

        System.out.println(r.minSideJumps(new int[]{0,2,1,0,3,0}));
    }


    public int minSideJumps(int[] obstacles) {
        int min = Integer.MAX_VALUE;

        for(int i=0; i< obstacles.length-1; i++){
            if(obstacles[i]==2){
                min = Math.min(Math.min(min, jump(obstacles[i+1])),
                    jump(obstacles[i-1]));
            }

        }
        if(min == Integer.MAX_VALUE) return 0;
        return min;
    }

    public int jump(int i){
            return  1;
    }

}

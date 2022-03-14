package FIDemo4;

@FunctionalInterface
public interface MyFirstFunctionalInterface
{
    public void firstWork();
    //------------ default method One------------
    public default void doSomeMoreWork1(){
        //Method body
        System.out.println("default method one executed");
    }
    //------------ default method two------------
    public  default void doSomeMoreWork2(){
        //Method body
        System.out.println("default method two executed");
    }
}


package GenericsDemo;

public class Runnable {
    public static void main(String[] args) {
        G_DataTypesClass obj1 = new G_DataTypesClass();

        // we can pass any data type to setVarName or the constructor
        obj1.setVarName("TEKsystems");
        System.out.println(obj1.getVarName());
        obj1.setVarName(12);
        System.out.println(obj1.getVarName());
        obj1.setVarName(true);
        System.out.println(obj1.getVarName());
        obj1.setVarName(3.14);
        System.out.println(obj1.getVarName());

        // bound type or type safety
        // constructor based or class level
        G_DataTypesClass<String> obj2 = new G_DataTypesClass<>();
        obj2.setVarName("Sujata");

        // now, below statement wont work
        // compiler error: java: incompatible types: double cannot be converted to java.lang.String
        //obj2.setVarName(12.5);

        G_DataTypesClass<Integer> obj3 = new G_DataTypesClass<>();
        obj3.setVarName(34);
        System.out.println(obj3.getVarName());

        // only works with wrapper or reference classes
        // compiler error:
        // java: unexpected type
        // required: reference
        // found:    int
        //G_DataTypesClass<int> obj4 = new G_DataTypesClass<int>();
        //obj4.setVarName(3);

        StudentService s1 = new StudentService();
        s1.setsName("Sujata");
        s1.setsRNum(7);
        G_DataTypesClass<StudentService> obj5 = new G_DataTypesClass<>();
        obj5.setVarName(s1);
        System.out.println(obj5.getVarName());

        // using MultipleGeneric
        MultipleGeneric myObj1 = new MultipleGeneric(111, "TEKsystems");
        MultipleGeneric myObj2 = new MultipleGeneric(20.3, 2563);
        MultipleGeneric myObj3 = new MultipleGeneric("College Name", "TEKsystems");
        MultipleGeneric myObj4 = new MultipleGeneric();
        myObj4.setV2("Sujata");
        myObj4.setV1(25);

        // the above objects were not type safe. we can make them type safe.
        MultipleGeneric<Integer, String> myObj5 = new MultipleGeneric<>();
        myObj5.setV1(25);
        myObj5.setV2("Sujata");
        myObj5.printBoth();

        MultipleGeneric<String, String> myObj6 = new MultipleGeneric<>();
        myObj6.setV1("TEKsystems");
        myObj6.setV2("Sujata");
        myObj6.printBoth();
    }
}

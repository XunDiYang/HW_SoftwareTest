import java.lang.reflect.Method;
public class GetDeclaredMethods  {
    interface Base {
        BaseFoo foo();
        interface BaseFoo {           
        }
    }

    interface Derived extends Base {
        DerivedFoo foo();
        interface DerivedFoo extends BaseFoo {

        }
    }

    public static void main(String[] args) {       
        dumpDeclaredMethods(Derived.class);
    }

    private static void dumpDeclaredMethods(Class<?> class1) {
        System.out.println("---" + class1.getSimpleName() + "---");
        Method[] methods = class1.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("----------");
    }
}
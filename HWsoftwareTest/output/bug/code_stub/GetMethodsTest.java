package tem1;
	
import java.lang.reflect.Method;	
import java.math.BigDecimal;	
public class GetMethodsTest {	
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
         Method[] methods = class1.getMethods();	
         System.out.println("");
 		System.out.print("The line : ");
 		System.out.print("Lines " + 25);
 		System.out.println("-" + 25);
 		System.out.println("@@Class: ");
 		System.out.println("Class");
 		System.out.println("The object: ");
 		System.out.println(class1);
 		System.out.println("Call method: ");
 		System.out.println("getMethods");
 		System.out.println("Input parameters: ");
 		System.out.println("Return Value: ");
         for (Method method : methods) {	
             System.out.println(method);	
         }	
	
        System.out.println("----------");	
    }	
}	

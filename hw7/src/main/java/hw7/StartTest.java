package hw7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class StartTest {
    public static void start(Class c){
        List<Method> methods = new ArrayList<>();
        Method[] classMethod = c.getDeclaredMethods();

        for(Method m: classMethod){
            if(m.isAnnotationPresent(Test.class)){
                methods.add(m);
            }
        }
        methods.sort(Comparator.comparing(new Function<Method, Integer>() {
            @Override
            public Integer apply(Method m) {
                return m.getAnnotation(Test.class).priority();
            }
        }));

        for(Method m: classMethod){
            if(m.isAnnotationPresent(BeforeSuite.class)){
                if(methods.size()>0 && methods.get(0).isAnnotationPresent(BeforeSuite.class)){
                    throw new RuntimeException("BeforeSuite");
                     }
                methods.add(0, m);
            }
        }
        for(Method m: classMethod){
            if(m.isAnnotationPresent(AfterSuite.class)){
                if(methods.size()>0 && methods.get(methods.size()-1).isAnnotationPresent(AfterSuite.class)){
                    throw new RuntimeException("AfterSuite");
                }
                methods.add(m);
            }
        }
        for(Method m: methods){
            try {
                m.invoke(null);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

    }
}

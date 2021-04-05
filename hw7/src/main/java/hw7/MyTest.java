package hw7;

public class MyTest {

    @BeforeSuite
    public static void testBegin() {
        System.out.println("BeforeSuite");
    }

    @AfterSuite
    public static void testEnd() {
        System.out.println("AfterSuite");
    }

  /*  @AfterSuite
    public static void testEnd2() {
        System.out.println("AfterSuite");
    }*/

    @Test(priority = 7)
    public static void test7(){
        System.out.println("test7 priority - 7");
    }

    @Test(priority = 1)
    public static void test1(){
        System.out.println("test1 priority - 1");
    }

    @Test
    public static void test2(){
        System.out.println("test7 default");
    }

    @Test
    public static void test3(){
        System.out.println("test3 default");
    }

    @Test(priority = 4)
    public static void test4(){
        System.out.println("test4 priority - 4");
    }




}

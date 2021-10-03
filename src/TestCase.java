import java.lang.reflect.Field;

public class TestCase {
    Class object;

//    public TestCase(Class object) {
//        this.object = object;
//    }

    @BeforeSuite
    public  void before_test(){
        object = TestObject.class;
        System.out.println("Start testing: " + object.getName());
    }
//    @BeforeSuite
//    public  void before_test2(){
//        object = TestObject.class;
//        System.out.println("Start testing2: " + object.getName());
//    }

    @Test(priority = 2)
    public boolean testing_name(){
        if (object.getName() != null){
            System.out.println("Testing name: " + object.getName());
            return true;
        }
        return false;
    }
    @Test(priority = 1)
    public boolean testing_field(){
        Field privateField = null;
        try {
            privateField = TestObject.class.getDeclaredField("field");
            privateField.setAccessible(true);
            System.out.println("get: " + privateField.get(object));
            return true;
        } catch (NoSuchFieldException e) {
            System.out.println("Неверное имя поля.");
//            e.printStackTrace();
        }finally {

            return false;
        }
    }

    @AfterSuite
    public void after_Test(){
        System.out.println("Result testing: Type object is " + object.getTypeName());

    }

    public  void start (Object obj){
        object = obj.getClass();
        before_test();
        testing_name();
        testing_field();
        after_Test();

    }

}

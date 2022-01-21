package jav.demo;

public class DemoException {
    public static int testException() {
        try{
            throw new Exception("test");
        } catch (Exception e) {
//            e.printStackTrace();
            return 1;
        } finally {
        }
    }

    public static void main(String[] args) {
        System.out.println(testException());
    }


}

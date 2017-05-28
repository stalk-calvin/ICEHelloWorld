package HelloWorld;

import Ice.Current;
import myHelloWorld._HelloWorldDisp;

public class HelloWorldI extends _HelloWorldDisp {

    private static final long serialVersionUID = 1L;

    public void greeting(String value, Current __current) {
        System.out.println("Greeting: "+value);

    }

    public void testAnotherOperation(String value, Current __current) {
        System.out.println("Value was passed: "+value);

    }


}
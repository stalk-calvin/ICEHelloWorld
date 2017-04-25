package HelloWorld;

import Ice.Current;
import firstHelloWorld._HelloWorldDisp;

public class HelloWorldI extends _HelloWorldDisp {

    private static final long serialVersionUID = 1L;

    public void greeting(String value, Current __current) {
        System.out.println("Java Honk first ICE application: "+value);

    }

    public void testAnotherOperation(String value, Current __current) {
        System.out.println("Value was passed: "+value);

    }


}
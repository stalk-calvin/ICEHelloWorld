package HelloWorld;

import firstHelloWorld.HelloWorldPrx;
import firstHelloWorld.HelloWorldPrxHelper;

public class Client {

    public static void main(String[] args) {

        Ice.Communicator ic = null;
        try {
            // Initialize Ice run time
            ic = Ice.Util.initialize(args);

            // Access to remote adapter JavaHonk agent
            Ice.ObjectPrx base = ic.stringToProxy("JavaHonk:default -p 10000");

            // Convert proxy
            HelloWorldPrx helloWorld = HelloWorldPrxHelper.checkedCast(base);

            // Check if conversion proxy is valid
            if (helloWorld == null) {
                throw new Error("Proxy is invalid");
            }

            // Call the method and pass the value
            helloWorld.greeting("Hello World");
            helloWorld.testAnotherOperation("Java Honk Hello World!");
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        } finally {
            if (ic != null) {
                ic.destroy();
            }
        }
        System.exit(1);
    }

}
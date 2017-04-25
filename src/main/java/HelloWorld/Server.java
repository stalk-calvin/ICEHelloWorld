package HelloWorld;

public class Server {

    public static void main(String[] args) {

        Ice.Communicator ic = null;

        try {

            System.out.println("Initialize ice run time...");
            ic = Ice.Util.initialize(args);

            // Creates object adapter and its mandatory to trail it with name Adapter. Port number 10000 to receive the request
            System.out.println("Create object adapter, listening on port 10000...");
            Ice.ObjectAdapter adapter = ic.createObjectAdapterWithEndpoints("JavaHonkAdapter", "default -p 10000");

            System.out.println("Create object out from servant interface...");
            Ice.Object object = new HelloWorldI();

            System.out.println("It's required to add adapter into servent...");
            adapter.add(object, Ice.Util.stringToIdentity("JavaHonk"));

            System.out.println("Activating adapter, waiting to process request...");
            adapter.activate();

            ic.waitForShutdown();

        } catch (Exception exception) {
            exception.printStackTrace();
            System.exit(1);
        } finally {
            if (ic != null) {
                ic.destroy();
            }
        }

    }

}
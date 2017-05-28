package HelloWorld;

public class Server {

    public static void main(String[] args)
    {
        int status = 0;
        // Communicator example, ice run time clause handles
        Ice.Communicator ic = null;
        try {
            ic = Ice.Util.initialize(args);
            Ice.ObjectAdapter adapter =
                ic.createObjectAdapterWithEndpoints("SimplePrinterAdapter", "default -p 10000");
            Ice.Object object = new HelloWorldI();
            adapter.add(object, ic.stringToIdentity("SimplePrinter"));
            adapter.activate();
            ic.waitForShutdown();
        } catch (Ice.LocalException e)
        {
            e.printStackTrace();
            status = 1;
        } catch (Exception e)
        {
            e.printStackTrace();
            status = 1;
        } finally
        {
            if (ic != null)
            {
                ic.destroy();
            }
        }
        System.exit(status);
    }
}
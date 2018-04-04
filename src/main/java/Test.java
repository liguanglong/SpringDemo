import org.apache.log4j.Logger;

public class Test {


    private static Logger LOG = Logger.getLogger(Test.class);

    public static void main(String[] args) {
        LOG.debug("debug");
        LOG.info("info");
        LOG.error("error");
    }
}
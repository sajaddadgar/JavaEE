package logging;


import org.apache.log4j.Logger;

public class Sajad {

    static Logger logger = Logger.getLogger(Sajad.class);


    public static void main(String[] args) {


        logger.info("salam info");
        logger.debug("salam debug");
        logger.fatal("salam fatal");
        logger.error("salam error");
        logger.warn("salam warning");


    }

}

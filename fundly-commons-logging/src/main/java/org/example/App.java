package org.example;

import org.fundly.commons.logging.DefaultMessageLogger;
import org.fundly.commons.logging.MessageLogger;
import org.fundly.commons.logging.writer.LogWriter;
import org.fundly.commons.logging.writer.LogWriterFactory;
import org.fundly.commons.logging.writer.LogWriterImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    private static LogWriter logWriter = new LogWriterFactory().getLogWriter(App.class);
    public static void main( String[] args )
    {
        logWriter.info().logMessage("Hello World logging wrapper");


    }
}

package org.example.sboot;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChangeLogAppender extends AppenderBase<ILoggingEvent> {

    private final Logger logger = LoggerFactory.getLogger(ChangeLogAppender.class);

    public ChangeLogAppender() {
        super();
    }

    @Override
    protected void append(ILoggingEvent iLoggingEvent) {
        logger.info("Hey, ChangeLogAppender is running. {}", iLoggingEvent.toString());
    }


}

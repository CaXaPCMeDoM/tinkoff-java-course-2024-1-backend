package edu.java.bot.services.url.strategy.command;

import edu.java.bot.services.url.strategy.IDomainExecute;
import edu.java.bot.services.url.strategy.IDomainSetCommand;

public class StopTracking implements IDomainExecute {
    private IDomainSetCommand domainSetCommand;
    private String userId;
    private String url;

    public StopTracking(IDomainSetCommand domainSetCommand, String userId, String url) {
        this.domainSetCommand = domainSetCommand;
        this.userId = userId;
        this.url = url;
    }

    @Override
    public void execute() {
        domainSetCommand.stopTracking(userId, url);
    }
}

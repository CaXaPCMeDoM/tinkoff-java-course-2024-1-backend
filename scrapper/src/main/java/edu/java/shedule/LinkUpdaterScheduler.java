package edu.java.shedule;

import edu.java.dto.jdbc.JdbcLinkDto;
import edu.java.service.LinkService;
import edu.java.shedule.process.LinkProcessService;
import java.time.Duration;
import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
@ConditionalOnProperty(value = "app.scheduler.enable", havingValue = "true", matchIfMissing = true)
public class LinkUpdaterScheduler {
    private final LinkService linkService;
    private final Duration schedulerInterval;
    private final LinkProcessService linkProcessService;

    public LinkUpdaterScheduler(
        LinkService linkService,
        @Qualifier("schedulerInterval") Duration schedulerInterval,
        LinkProcessService linkProcessService
    ) {
        this.linkService = linkService;
        this.schedulerInterval = schedulerInterval;
        this.linkProcessService = linkProcessService;
    }

    @Scheduled(fixedDelayString = "#{@schedulerInterval.toMillis()}")
    public void update() {
        List<JdbcLinkDto> linksDtos = linkService.listAll();
        for (JdbcLinkDto jdbcLinkDto : linksDtos) {
            linkProcessService.processLink(jdbcLinkDto);
        }
    }
}

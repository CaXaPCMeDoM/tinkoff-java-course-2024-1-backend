package edu.java.scrapper.db.jdbc;

import edu.java.dao.jdbc.JdbcChatDao;
import edu.java.dao.jdbc.JdbcChatLinkDao;
import edu.java.dao.jdbc.JdbcLinkDao;
import edu.java.dto.ChatDto;
import edu.java.dto.LinkDto;
import edu.java.dto.jdbc.JdbcChatLinkDto;
import edu.java.scrapper.db.IntegrationEnvironment;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class JdbcChatLinkTest extends IntegrationEnvironment {
    @Autowired
    private JdbcChatLinkDao jdbcChatLinkDao;
    @Autowired
    private JdbcLinkDao jdbcLinkDao;
    @Autowired
    private JdbcChatDao jdbcChatDao;

    private static final Long CHAT_ID = -1L;

    @Test
    @Transactional
    @Rollback
    void addTest() {
        int sizeAfterAdd = jdbcChatLinkDao.findAll().size();

        LinkDto
            linkDto = new LinkDto("https://edu.tinkoff.ru",
            Timestamp.valueOf(LocalDateTime.now()),
            Timestamp.valueOf(LocalDateTime.now()),
            "testUser"
        );
        jdbcLinkDao.add(linkDto);
        Long linkId = jdbcLinkDao.getIdByUrl(linkDto.getUrl());

        ChatDto chatDto = new ChatDto(CHAT_ID);
        jdbcChatDao.add(chatDto);

        JdbcChatLinkDto jdbcChatLinkDto = new JdbcChatLinkDto(CHAT_ID, linkId);

        jdbcChatLinkDao.add(jdbcChatLinkDto);

        int sizeBeforeAdd = sizeAfterAdd + 1;

        assertThat(jdbcChatLinkDao.findAll().size()).isEqualTo(sizeBeforeAdd);
    }

    @Test
    @Transactional
    @Rollback
    void removeTest() {
        // Сначала добавим

        int sizeAfterAdd = jdbcChatLinkDao.findAll().size();

        LinkDto
            linkDto = new LinkDto("https://edu.tinkoff.ru", Timestamp.valueOf(LocalDateTime.now()), Timestamp.valueOf(LocalDateTime.now()), "testUser");
        jdbcLinkDao.add(linkDto);
        Long linkId = jdbcLinkDao.getIdByUrl(linkDto.getUrl());

        ChatDto chatDto = new ChatDto(CHAT_ID);
        jdbcChatDao.add(chatDto);

        JdbcChatLinkDto jdbcChatLinkDto = new JdbcChatLinkDto(CHAT_ID, linkId);
        jdbcChatLinkDao.add(jdbcChatLinkDto);

        int sizeBeforeAdd = sizeAfterAdd + 1;

        assertThat(jdbcChatLinkDao.findAll().size()).isEqualTo(sizeBeforeAdd);

        // Переходим к удалению

        int sizeAfterRemove = jdbcChatLinkDao.findAll().size();

        jdbcChatLinkDao.remove(CHAT_ID, linkId);

        int sizeBeforeRemove = sizeAfterRemove - 1;

        assertThat(jdbcChatLinkDao.findAll().size()).isEqualTo(sizeBeforeRemove);
    }
}

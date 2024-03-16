/*
 * This file is generated by jOOQ.
 */
package edu.java.scrapper.domain.jooq.tables.pojos;


import java.beans.ConstructorProperties;
import java.io.Serializable;

import javax.annotation.processing.Generated;

import org.jetbrains.annotations.NotNull;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.18.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class ChatLink implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long chatId;
    private Long urlId;

    public ChatLink() {}

    public ChatLink(ChatLink value) {
        this.chatId = value.chatId;
        this.urlId = value.urlId;
    }

    @ConstructorProperties({ "chatId", "urlId" })
    public ChatLink(
        @NotNull Long chatId,
        @NotNull Long urlId
    ) {
        this.chatId = chatId;
        this.urlId = urlId;
    }

    /**
     * Getter for <code>CHAT_LINK.CHAT_ID</code>.
     */
    @jakarta.validation.constraints.NotNull
    @NotNull
    public Long getChatId() {
        return this.chatId;
    }

    /**
     * Setter for <code>CHAT_LINK.CHAT_ID</code>.
     */
    public void setChatId(@NotNull Long chatId) {
        this.chatId = chatId;
    }

    /**
     * Getter for <code>CHAT_LINK.URL_ID</code>.
     */
    @jakarta.validation.constraints.NotNull
    @NotNull
    public Long getUrlId() {
        return this.urlId;
    }

    /**
     * Setter for <code>CHAT_LINK.URL_ID</code>.
     */
    public void setUrlId(@NotNull Long urlId) {
        this.urlId = urlId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final ChatLink other = (ChatLink) obj;
        if (this.chatId == null) {
            if (other.chatId != null)
                return false;
        }
        else if (!this.chatId.equals(other.chatId))
            return false;
        if (this.urlId == null) {
            if (other.urlId != null)
                return false;
        }
        else if (!this.urlId.equals(other.urlId))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.chatId == null) ? 0 : this.chatId.hashCode());
        result = prime * result + ((this.urlId == null) ? 0 : this.urlId.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ChatLink (");

        sb.append(chatId);
        sb.append(", ").append(urlId);

        sb.append(")");
        return sb.toString();
    }
}

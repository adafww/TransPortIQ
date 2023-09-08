package org.transportiq.repository;

import org.transportiq.models.BaseModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;


@Repository
public class BaseRepository {
    private final JdbcTemplate jdbc;

    public BaseRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public BaseModel getById(String model, Integer id) {
        String sql = "SELECT * FROM " + model + " WHERE id = ?";
        Map<String, Object> result = jdbc.queryForMap(sql, id);

        BaseModel baseModel = new BaseModel();
        baseModel.setFields(result);

        return baseModel;
    }

    public void updateReadStatus (Integer id) {
        String sql = "UPDATE message SET read_status = 'READ' WHERE dialog_id = ? AND read_status = 'SENT'";
        jdbc.update(sql, id);
    }
    public Integer sendMessage (Long time, Integer authorId,
                                Integer recipientId, String messageText, Integer dialogId) {
        String sql = "INSERT INTO message (time, author_id, recipient_id, message_text, read_status, dialog_id) " +
                "VALUES (?, ?, ?, ?, 'SENT', ?) RETURNING id ";
        return jdbc.queryForObject(sql, Integer.class, time, authorId, recipientId, messageText, dialogId);
    }

//    public PersonForDialogsDto getPersonForDialog (Integer id) {
//        String sql = "SELECT id, photo, first_name, last_name, e_mail, last_online_time FROM person WHERE id = ?";
//
//        return jdbc.queryForObject(sql, new PersonForDialogsMapper(), id);
//    }
//
//    public List<MessageDto> getMessageList(Integer id) {
//        String sql = "select id, time, author_id, recipient_id, message_text, read_status FROM message WHERE dialog_id = ?";
//        return jdbc.query(sql, new MessageMapper(), id);
//    }
//    public DialogsDto getUnreadCount(Integer id) {
//        String sql = "SELECT COUNT(*) AS unread_count FROM message WHERE read_status = 'SENT' AND recipient_id = ?";
//
//        return jdbc.queryForObject(sql, new CountMapper(), id);
//    }

    public void deleteAllPersonMessages(Integer personId){
        String sql = "delete from message where author_id = ? or recipient_id = ?";
        jdbc.update(sql, personId, personId);
    }
}

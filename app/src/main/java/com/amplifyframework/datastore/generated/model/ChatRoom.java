package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.annotations.BelongsTo;
import com.amplifyframework.core.model.annotations.HasMany;
import com.amplifyframework.core.model.temporal.Temporal;

import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.AuthStrategy;
import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.ModelOperation;
import com.amplifyframework.core.model.annotations.AuthRule;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the ChatRoom type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "ChatRooms", authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
public final class ChatRoom implements Model {
  public static final QueryField ID = field("ChatRoom", "id");
  public static final QueryField NEW_MSGS = field("ChatRoom", "newMsgs");
  public static final QueryField LAST_MESSAGE = field("ChatRoom", "chatRoomLastMessageId");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="Int") Integer newMsgs;
  private final @ModelField(targetType="Message") @BelongsTo(targetName = "chatRoomLastMessageId", type = Message.class) Message LastMessage;
  private final @ModelField(targetType="Message") @HasMany(associatedWith = "chatroomID", type = Message.class) List<Message> Messages = null;
  private final @ModelField(targetType="ChatRoomUser") @HasMany(associatedWith = "chatroom", type = ChatRoomUser.class) List<ChatRoomUser> ChatRoomUsers = null;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String getId() {
      return id;
  }
  
  public Integer getNewMsgs() {
      return newMsgs;
  }
  
  public Message getLastMessage() {
      return LastMessage;
  }
  
  public List<Message> getMessages() {
      return Messages;
  }
  
  public List<ChatRoomUser> getChatRoomUsers() {
      return ChatRoomUsers;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private ChatRoom(String id, Integer newMsgs, Message LastMessage) {
    this.id = id;
    this.newMsgs = newMsgs;
    this.LastMessage = LastMessage;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      ChatRoom chatRoom = (ChatRoom) obj;
      return ObjectsCompat.equals(getId(), chatRoom.getId()) &&
              ObjectsCompat.equals(getNewMsgs(), chatRoom.getNewMsgs()) &&
              ObjectsCompat.equals(getLastMessage(), chatRoom.getLastMessage()) &&
              ObjectsCompat.equals(getCreatedAt(), chatRoom.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), chatRoom.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getNewMsgs())
      .append(getLastMessage())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("ChatRoom {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("newMsgs=" + String.valueOf(getNewMsgs()) + ", ")
      .append("LastMessage=" + String.valueOf(getLastMessage()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static BuildStep builder() {
      return new Builder();
  }
  
  /** 
   * WARNING: This method should not be used to build an instance of this object for a CREATE mutation.
   * This is a convenience method to return an instance of the object with only its ID populated
   * to be used in the context of a parameter in a delete mutation or referencing a foreign key
   * in a relationship.
   * @param id the id of the existing item this instance will represent
   * @return an instance of this model with only ID populated
   * @throws IllegalArgumentException Checks that ID is in the proper format
   */
  public static ChatRoom justId(String id) {
    try {
      UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
    } catch (Exception exception) {
      throw new IllegalArgumentException(
              "Model IDs must be unique in the format of UUID. This method is for creating instances " +
              "of an existing object with only its ID field for sending as a mutation parameter. When " +
              "creating a new object, use the standard builder method and leave the ID field blank."
      );
    }
    return new ChatRoom(
      id,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      newMsgs,
      LastMessage);
  }
  public interface BuildStep {
    ChatRoom build();
    BuildStep id(String id) throws IllegalArgumentException;
    BuildStep newMsgs(Integer newMsgs);
    BuildStep lastMessage(Message lastMessage);
  }
  

  public static class Builder implements BuildStep {
    private String id;
    private Integer newMsgs;
    private Message LastMessage;
    @Override
     public ChatRoom build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new ChatRoom(
          id,
          newMsgs,
          LastMessage);
    }
    
    @Override
     public BuildStep newMsgs(Integer newMsgs) {
        this.newMsgs = newMsgs;
        return this;
    }
    
    @Override
     public BuildStep lastMessage(Message lastMessage) {
        this.LastMessage = lastMessage;
        return this;
    }
    
    /** 
     * @param id id
     * @return Current Builder instance, for fluent method chaining
     */
    public BuildStep id(String id) {
        this.id = id;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String id, Integer newMsgs, Message lastMessage) {
      super.id(id);
      super.newMsgs(newMsgs)
        .lastMessage(lastMessage);
    }
    
    @Override
     public CopyOfBuilder newMsgs(Integer newMsgs) {
      return (CopyOfBuilder) super.newMsgs(newMsgs);
    }
    
    @Override
     public CopyOfBuilder lastMessage(Message lastMessage) {
      return (CopyOfBuilder) super.lastMessage(lastMessage);
    }
  }
  
}

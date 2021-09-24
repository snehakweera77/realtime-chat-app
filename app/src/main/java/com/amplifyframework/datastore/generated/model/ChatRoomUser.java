package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.annotations.BelongsTo;
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

/** This is an auto generated class representing the ChatRoomUser type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "ChatRoomUsers", authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ }),
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
@Index(name = "byChatRoom", fields = {"chatroomID","userID"})
@Index(name = "byUser", fields = {"userID","chatroomID"})
public final class ChatRoomUser implements Model {
  public static final QueryField ID = field("ChatRoomUser", "id");
  public static final QueryField CHATROOM = field("ChatRoomUser", "chatroomID");
  public static final QueryField USER = field("ChatRoomUser", "userID");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="ChatRoom", isRequired = true) @BelongsTo(targetName = "chatroomID", type = ChatRoom.class) ChatRoom chatroom;
  private final @ModelField(targetType="User", isRequired = true) @BelongsTo(targetName = "userID", type = User.class) User user;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String getId() {
      return id;
  }
  
  public ChatRoom getChatroom() {
      return chatroom;
  }
  
  public User getUser() {
      return user;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private ChatRoomUser(String id, ChatRoom chatroom, User user) {
    this.id = id;
    this.chatroom = chatroom;
    this.user = user;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      ChatRoomUser chatRoomUser = (ChatRoomUser) obj;
      return ObjectsCompat.equals(getId(), chatRoomUser.getId()) &&
              ObjectsCompat.equals(getChatroom(), chatRoomUser.getChatroom()) &&
              ObjectsCompat.equals(getUser(), chatRoomUser.getUser()) &&
              ObjectsCompat.equals(getCreatedAt(), chatRoomUser.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), chatRoomUser.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getChatroom())
      .append(getUser())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("ChatRoomUser {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("chatroom=" + String.valueOf(getChatroom()) + ", ")
      .append("user=" + String.valueOf(getUser()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static ChatroomStep builder() {
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
  public static ChatRoomUser justId(String id) {
    try {
      UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
    } catch (Exception exception) {
      throw new IllegalArgumentException(
              "Model IDs must be unique in the format of UUID. This method is for creating instances " +
              "of an existing object with only its ID field for sending as a mutation parameter. When " +
              "creating a new object, use the standard builder method and leave the ID field blank."
      );
    }
    return new ChatRoomUser(
      id,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      chatroom,
      user);
  }
  public interface ChatroomStep {
    UserStep chatroom(ChatRoom chatroom);
  }
  

  public interface UserStep {
    BuildStep user(User user);
  }
  

  public interface BuildStep {
    ChatRoomUser build();
    BuildStep id(String id) throws IllegalArgumentException;
  }
  

  public static class Builder implements ChatroomStep, UserStep, BuildStep {
    private String id;
    private ChatRoom chatroom;
    private User user;
    @Override
     public ChatRoomUser build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new ChatRoomUser(
          id,
          chatroom,
          user);
    }
    
    @Override
     public UserStep chatroom(ChatRoom chatroom) {
        Objects.requireNonNull(chatroom);
        this.chatroom = chatroom;
        return this;
    }
    
    @Override
     public BuildStep user(User user) {
        Objects.requireNonNull(user);
        this.user = user;
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
    private CopyOfBuilder(String id, ChatRoom chatroom, User user) {
      super.id(id);
      super.chatroom(chatroom)
        .user(user);
    }
    
    @Override
     public CopyOfBuilder chatroom(ChatRoom chatroom) {
      return (CopyOfBuilder) super.chatroom(chatroom);
    }
    
    @Override
     public CopyOfBuilder user(User user) {
      return (CopyOfBuilder) super.user(user);
    }
  }
  
}

package ch.admin.seco.chatserver.dto.users;

public class UserDto {

    /*
    Create the user. Modifiers are private, due to access of getter and setters.
     */

    private final int id;
    private String nickname;
    private Status status;
    private int avatar;

    public UserDto(final int id, String nickname, Status status, int avatar){
        this.id = id;
        this.nickname = nickname;
        this.status = status;
        this.avatar = avatar;
    }

    public int getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public Status getStatus() {
        return status;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

}

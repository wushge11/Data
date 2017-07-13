package cn.datamining.dat.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by wushange on 2017/7/12.
 */

@Entity
public class User {

    @Id(autoincrement = true)
    private long id;
    private String testUpdate;
    private String userId;
    private String userName;
    private String nickName;
    private String aliasName;
    private String userHead;
    private String userPhone;
    private String userEmail;
    private String birthday;
    private String userCompany;
    private String userPosition;
    private String version;
    @Transient
    private AuthContext authContext;

    @Generated(hash = 64484547)
    public User(long id, String testUpdate, String userId, String userName, String nickName, String aliasName, String userHead, String userPhone, String userEmail, String birthday,
            String userCompany, String userPosition, String version) {
        this.id = id;
        this.testUpdate = testUpdate;
        this.userId = userId;
        this.userName = userName;
        this.nickName = nickName;
        this.aliasName = aliasName;
        this.userHead = userHead;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
        this.birthday = birthday;
        this.userCompany = userCompany;
        this.userPosition = userPosition;
        this.version = version;
    }

    @Generated(hash = 586692638)
    public User() {
    }

    public String getTestUpdate() {
        return testUpdate;
    }

    public void setTestUpdate(String testUpdate) {
        this.testUpdate = testUpdate;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public String getUserHead() {
        return userHead;
    }

    public void setUserHead(String userHead) {
        this.userHead = userHead;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getUserCompany() {
        return userCompany;
    }

    public void setUserCompany(String userCompany) {
        this.userCompany = userCompany;
    }

    public String getUserPosition() {
        return userPosition;
    }

    public void setUserPosition(String userPosition) {
        this.userPosition = userPosition;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public AuthContext getAuthContext() {
        return authContext;
    }

    public void setAuthContext(AuthContext authContext) {
        this.authContext = authContext;
    }

    @Entity
    class AuthContext {

        /**
         * username : 18519232094
         * userId : 57fc9ed7bef1da489a45b4aa
         * token : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE0NzY1ODExODgsInN1YiI6IjEiLCJpc3MiOiI1N2ZjOWVkN2JlZjFkYTQ4OWE0NWI0YWEifQ.2qzSNrTvzQKX7kD6Pb9_OxpObuNq9QKv0swUyh0r51Q
         * channel : 1
         */

        private String username;
        private String userId;
        private String token;
        private String channel;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getChannel() {
            return channel;
        }

        public void setChannel(String channel) {
            this.channel = channel;
        }

        @Override
        public String toString() {
            return "AuthContext{" +
                    "username='" + username + '\'' +
                    ", userId='" + userId + '\'' +
                    ", token='" + token + '\'' +
                    ", channel='" + channel + '\'' +
                    '}';
        }

    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", aliasName='" + aliasName + '\'' +
                ", userHead='" + userHead + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", birthday='" + birthday + '\'' +
                ", userCompany='" + userCompany + '\'' +
                ", userPosition='" + userPosition + '\'' +
                ", version='" + version + '\'' +
                ", authContext=" + authContext +
                '}';
    }
}
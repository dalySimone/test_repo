package com.zx.entity;


public class User {

    private String uid;
    private String username;
    private String password;
    private String telephone;
    private String birthday;
    private String sex;

     public String getUid() {
         return uid;
     }

     public void setUid(String uid) {
         this.uid = uid;
     }

     public String getUsername() {
         return username;
     }

     public void setUsername(String username) {
         this.username = username;
     }

     public String getPassword() {
         return password;
     }

     public void setPassword(String password) {
         this.password = password;
     }

     public String getTelephone() {
         return telephone;
     }

     public void setTelephone(String telephone) {
         this.telephone = telephone;
     }

     public String getBirthday() {
         return birthday;
     }

     public void setBirthday(String birthday) {
         this.birthday = birthday;
     }

     public String getSex() {
         return sex;
     }

     public void setSex(String sex) {
         this.sex = sex;
     }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", telephone='" + telephone + '\'' +
                ", birthday='" + birthday + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}

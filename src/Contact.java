public class Contact {
    private String name;
    private String date;
    private String phone;
    private String sex;

    protected Contact(String name,String date,String phone,String sex){
        this.name = name;
        this.date = date;
        this.phone = phone;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }
    public String getDate(){
        return date;
    }

    public String getPhone() {
        return phone;
    }

    public String getSex() {
        return sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return name + " " + date + " " + phone + " " + sex;
    }
}

package Entity;

public class Admin {
    private int adminID;
    private String adminName;
    private String adminpw;

    public Admin(int adminID, String adminName, String adminpw) {
        this.adminID = adminID;
        this.adminName = adminName;
        this.adminpw = adminpw;
    }

    public int getAdminID() {
        return adminID;
    }

    public String getAdminName() {
        return adminName;
    }

    public String getAdminpw() {
        return adminpw;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public void setAdminpw(String adminpw) {
        this.adminpw = adminpw;
    }
}

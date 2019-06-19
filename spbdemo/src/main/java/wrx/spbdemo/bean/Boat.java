package wrx.spbdemo.bean;

/**
 * | Field  | Type         | Null | Key | Default | Extra          |
 * +--------+--------------+------+-----+---------+----------------+
 * | bid    | int(11)      | NO   | PRI | NULL    | auto_increment |
 * | uid    | int(11)      | NO   | MUL | NULL    |                |
 * | name   | varchar(255) | NO   |     | NULL    |                |
 * | method | varchar(255) | NO   |     | NULL    |                |
 * | head   | text         | YES  |     | NULL    |                |
 * | body   | longtext     | YES  |     | NULL    |                |
 */
public class Boat {

    private Integer bid;

    private Integer uid;

    private String name;

    private String method;

    private String head;

    private String body;

    public Boat() {
    }

    public Boat(Integer uid, String name, String method, String head, String body) {
        this.uid = uid;
        this.name = name;
        this.method = method;
        this.head = head;
        this.body = body;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}

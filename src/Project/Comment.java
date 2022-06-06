package Project;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Comment{

    private String comment;
    private String author;
    private String date;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();

    public Comment(String comment, String author) {
        this.comment = comment;
        this.author = author;
        this.date = dtf.format(now);


    }

    @Override
    public String toString() {
        return date+" Author:"+author+" Comment:"+comment;
    }
}

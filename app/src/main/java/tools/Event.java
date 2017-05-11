package tools;

/**
 * Created by Javad Ansari on 3/12/2017.
 */

public class Event {
    int id;
    String title;
    String comment;
    int alarm;
    String calorie;
    String image;

    public Event(int id, String title, String comment, int alarm, String calorie, String image) {

        this.id = id;
        this.title = title;
        this.comment = comment;
        this.alarm = alarm;
        this.calorie = calorie;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getAlarm() {
        return alarm;
    }

    public void setAlarm(int alarm) {
        this.alarm = alarm;
    }

    public String getCalorie() {
        return calorie;
    }

    public void setCalorie(String calorie) {
        this.calorie = calorie;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

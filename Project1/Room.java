public class Room {
    Object content;
    Room next;
    Room prev;

    public Room(Object content) {
        this.content = content;
    }

    public Object getContent() {
        return content;
    }
}

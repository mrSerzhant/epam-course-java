package by.serzhant.array_app.entity;

import java.util.Objects;

public class Message {
    private String stringMessage;
    private Array<?> arrayMessage;

    public Message(String stringMessage) {
        this.stringMessage = stringMessage;
    }

    public Message(Array<?> arrayMessage) {
        this.arrayMessage = arrayMessage;
    }

    public String getStringMessage() {
        return stringMessage;
    }

    public Array<?> getArrayMessage() {
        return arrayMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(stringMessage, message.stringMessage) &&
                Objects.equals(arrayMessage, message.arrayMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stringMessage, arrayMessage);
    }

    @Override
    public String toString() {
        return "Message{" +
                "stringMessage='" + stringMessage + '\'' +
                ", arrayMessage=" + arrayMessage +
                '}';
    }
}

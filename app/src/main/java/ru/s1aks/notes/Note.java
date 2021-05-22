package ru.s1aks.notes;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Note {
    private int id;
    private String title;
    private String content;
    private GregorianCalendar createTime;
    private int importance;

    private static int freeId;

    public Note(String title, String content, GregorianCalendar createTime, int importance) {
        this.id = freeId++;
        this.title = title;
        this.content = content;
        this.createTime = createTime;
        this.importance = importance;
    }

    public int getId() {
        return id;
    }

    public Note setId(int id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Note setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Note setContent(String content) {
        this.content = content;
        return this;
    }

    public GregorianCalendar getCreateTime() {
        return createTime;
    }

    public String getStringCreateTime() {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat fmt = new SimpleDateFormat("hh:mm  dd.MMMM.yyyy");
        fmt.setCalendar(createTime);
        return fmt.format(createTime.getTime());
    }

    public Note setCreateTime(GregorianCalendar createTime) {
        this.createTime = createTime;
        return this;
    }

    public int getImportance() {
        return importance;
    }

    public Note setImportance(int importance) {
        this.importance = importance;
        return this;
    }

    public static int getFreeId() {
        return freeId;
    }

    public static void setFreeId(int freeId) {
        Note.freeId = freeId;
    }
}

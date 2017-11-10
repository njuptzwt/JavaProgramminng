package com.sort;

/**
 * Created by 18362 on 2017/11/10.
 */
public class Student implements Comparable<Student> {
    private String name;
    private Integer score;

    public Student(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    //java中的自定义排序算法的实现
    @Override
    public int compareTo(Student o) {
        if (this.score == o.score)
            return this.name.compareTo(o.name);
        else if (this.score > o.score)
            return 1;
        else if (this.score < o.score)
            return -1;
        else
            return 0;
    }
}

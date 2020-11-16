package com.guan.domain;

public class StudentBean {
    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder{
        private String name;

        private int age;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public StudentBean build() {
            StudentBean studentBean = new StudentBean();
            studentBean.setName(name);
            studentBean.setAge(age);
            return studentBean;
        }
    }

    public static void main(String[] args) {
        System.out.println("start");
        assert true;
        System.out.println("go on");
        assert false:"stop";
        System.out.println("end");
    }
}
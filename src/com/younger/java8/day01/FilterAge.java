package com.younger.java8.day01;

public class FilterAge implements MyFilter<Employpee> {
    @Override
    public boolean test(Employpee employpee) {
        return employpee.getAge()>=30;
    }
}

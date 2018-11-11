package com.younger.java8.day01;

public class FilterSalar implements  MyFilter<Employpee> {
    @Override
    public boolean test(Employpee o) {

        return o.getSalary()<=5000;
    }
}

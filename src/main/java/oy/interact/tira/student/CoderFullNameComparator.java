package oy.interact.tira.student;

import oy.interact.tira.model.Coder;

import java.util.Comparator;


public class CoderFullNameComparator implements Comparator<Coder> {
    @Override
    public int compare(Coder o1, Coder o2) {
        if (o1 != null && o2 != null) {
            return o1.getFullName().compareTo(o2.getFullName());
        }
        return 0;
    }
}


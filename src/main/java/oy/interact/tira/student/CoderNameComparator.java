package oy.interact.tira.student;

import oy.interact.tira.model.Coder;

import java.util.Comparator;

public class CoderNameComparator implements Comparator<Coder> {
    @Override
    public int compare(Coder o1, Coder o2) {
        if (o1 != null && o2 != null) {
            return o1.getCoderName().compareTo(o2.getCoderName());
        }
        return 0;
    }
}

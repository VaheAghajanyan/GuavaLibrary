package ObjectMethods;

import com.google.common.collect.ComparisonChain;

class Human implements Comparable<Human> {
    private String lastName;
    private String firstName;
    private int zipCode;

    @Override
    public int compareTo(Human other) {
        int cmp = lastName.compareTo(other.lastName);
        if (cmp != 0) {
            return cmp;
        }
        cmp = firstName.compareTo(other.firstName);
        if (cmp != 0) {
            return cmp;
        }
        return Integer.compare(zipCode, other.zipCode);
    }

  /*  public int compareTo(Human that) {
        return ComparisonChain.start()
                .compare(this.aString, that.aString)
                .compare(this.anInt, that.anInt)
                .compare(this.anEnum, that.anEnum, Ordering.natural().nullsLast())
                .result();
    }*/
}



package Throwables;

import com.google.common.base.Throwables;

public class Main {
    public static void main(String[] args) throws Exception {
        try {
            methodThatMightThrowThrowable();
        } catch (Throwable t) {
            Throwables.propagateIfPossible(t, Exception.class);
            throw new RuntimeException(t);
        }

        /*try {
            return something(...);
        } catch (IOException e) {
            throw Throwables.propagate(e);
        }

        try {
            return something(...);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/


    }

    private static void methodThatMightThrowThrowable() throws Exception {
        throw new Exception();
    }
}

package Preconditions;

import com.google.common.base.Preconditions;

public class Main {
    public static void main(String[] args) {
        checkState();
        checkNotNull(2022);
        checkArgument(5);
    }

    private static void checkNotNull(int year){
        String month = null;
        Preconditions.checkNotNull(month, "Month cant be null");
        System.out.println(year + month);
    }

    private static void checkState(){
        boolean isTurned = true;
        Preconditions.checkState(!isTurned, "Is already turned on.");
        System.out.println(isTurned);
    }

    private static void checkArgument(int x){
        Preconditions.checkArgument(x > 10, "Number must be greater 10");
    }
}

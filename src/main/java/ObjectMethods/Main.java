package ObjectMethods;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public class Main {
    public static void main(String[] args) {
        Objects.equal("a", "a"); // returns true
        Objects.equal(null, "a"); // returns false
        Objects.equal("a", null); // returns false
        Objects.equal(null, null); // returns true

        var Vahe = new Person("Vahe", "Aghajanyan");
        System.out.println(Objects.hashCode(Vahe.getName(), Vahe.getSurname()));

        MoreObjects.toStringHelper(Vahe)
                .add("x", 1)
                .toString();

        // Returns "MyObject{x=1}"
        MoreObjects.toStringHelper("MyObject")
                .add("x", 1)
                .toString();
    }
}

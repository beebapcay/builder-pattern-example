import builder.BlackCatBuilder;
import builder.Builder;
import builder.CalicoCatBuilder;
import data.Cat;
import director.Director;

public class BuilderExample {
    public static void main(String[] args) {
        System.out.println("Demo");

        Director director = new Director();
        Builder builder = new BlackCatBuilder();

        Cat cat = director.createCat(builder);
        System.out.println("Cat object produced from Producer: \n" + cat + "\n----");

        // Create cat object directly from builder
        CalicoCatBuilder calicoBuilder = new CalicoCatBuilder();
        calicoBuilder.addName("Andy");
        calicoBuilder.addOwner("Cynthia");
        System.out.print("Cat object produced from Builder: \n");
        System.out.println(calicoBuilder.build());
    }
}

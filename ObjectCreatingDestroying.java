/**
 * Consider static factory methods instead of constructors
 */
class StaticFactoryMethod {
}


/**
 * Builder pattern
 */
class NutritionFacts {

  private final int servingSize;
  private final int servings;
  private final int colories;
  private final int fat;
  private final int carbohydrate;

  private NutritionFacts(Builder builder) {
    this.servingSize = builder.servingSize;
    this.servings = builder.servings;

    this.colories = builder.colories;
    this.fat = builder.fat;
    this.carbohydrate = builder.carbohydrate;
  }

  @Override
  public String toString() {
    return getClass().getName() + " - servingSize: " + servingSize + ", servings: " + servings
        + ", colories: " + colories + ", fat: " + fat + ", carbohydrate: " + carbohydrate;
  }

  public static void main(String[] args) {
    System.out.println("Hello World!");
    NutritionFacts cocaCola =
        new NutritionFacts.Builder(240, 8).calories(100).carbohydrate(27).build();
    System.out.println(cocaCola);
  }

  static class Builder {
    // Required parameters
    private final int servingSize;
    private final int servings;

    // Optional parameters
    private int colories = 0;
    private int fat = 0;
    private int carbohydrate = 0;

    public Builder(int servingSize, int servings) {
      this.servingSize = servingSize;
      this.servings = servings;
    }

    public Builder calories(int val) {
      colories = val;
      return this;
    }

    public Builder fat(int val) {
      fat = val;
      return this;
    }

    public Builder carbohydrate(int val) {
      carbohydrate = val;
      return this;
    }

    public NutritionFacts build() {
      return new NutritionFacts(this);
    }
  }
}


/**
 * Enforce the singleton property with a private method or an enum type. Enum is the best choice for
 * singleton if there is no inheritant or implementation, Enum is guarantee singleton even with
 * deserialization.
 */
/**
 * Singleton with public final field. Have to consider thread safe under multi threading
 * environment.
 */
class Elvis {
  public static final Elvis INSTANCE = new Elvis();

  private Elvis() {
  }

  public void leaveTheBuilding() {
    System.out.println(getClass().getName() + " leaves the building.");
  }
}

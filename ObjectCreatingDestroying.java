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

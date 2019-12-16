package cookbook.domain.models.binding;

public class PostCreateBindingModel {

    private String recipeName;
    private byte[] recipeImage;
    private String recipeProduct;
    private String recipeDescription;

    public PostCreateBindingModel() {
    }

    public String getRecipeName() {
        return this.recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public byte[] getRecipeImage() {
        return this.recipeImage;
    }

    public void setRecipeImage(byte[] recipeImage) {
        this.recipeImage = recipeImage;
    }

    public String getRecipeProduct() {
        return this.recipeProduct;
    }

    public void setRecipeProduct(String recipeProduct) {
        this.recipeProduct = recipeProduct;
    }

    public String getRecipeDescription() {
        return this.recipeDescription;
    }

    public void setRecipeDescription(String recipeDescription) {
        this.recipeDescription = recipeDescription;
    }
}

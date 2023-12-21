package viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.repository.RecipeRepository
import com.example.myapplication.repository.RecipeModel

class RecipeDetailViewModel : ViewModel() {
    private val repository = RecipeRepository

    var recipe: MutableLiveData<RecipeModel> = MutableLiveData()

    fun fetchRecipeDetail(recipeId: Int) {
        val recipe = repository.getRecipe(recipeId)
        this.recipe.value = recipe
    }
}
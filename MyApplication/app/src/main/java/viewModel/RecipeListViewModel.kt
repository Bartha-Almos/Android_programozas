package viewModel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.repository.RecipeRepository
import com.example.myapplication.repository.RecipeModel


internal class RecipeListViewModel : ViewModel() {

    val repository = RecipeRepository

    val recipeList: MutableLiveData<List<RecipeModel>> =
        MutableLiveData()

    fun fetchRecipeData(context: Context) {
        recipeList.value = repository.getRecipes(context)
    }
}
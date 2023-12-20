package viewModel

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentRecipeDetailBinding
import com.example.myapplication.databinding.FragmentRecipesBinding
import com.example.myapplication.repository.RecipeModel
import viewModel.RecipeDetailViewModel


class RecipeDetailFragment : Fragment() {

    private lateinit var binding: FragmentRecipeDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecipeDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recipeId = arguments?.getInt(RecipesFragment.BUNDLE_EXTRA_SELECTED_RECIPE_ID)
        Log.d(TAG, "Show details for recipe with ID = $recipeId")

        val viewModel =
            ViewModelProvider(this)[RecipeDetailViewModel::class.java]

        recipeId?.let {viewModel.fetchRecipeDetail(it) }

        viewModel.recipe.observe(viewLifecycleOwner) {
            Log.d(TAG, "Selected recipe's details: $it")
            updateView(it)
        }
    }

    private fun updateView(recipeModel: RecipeModel){
        binding.recipeItemTitleView.text = recipeModel.name
        binding.recipeItemDescriptionView.text = recipeModel.description
        Glide.with(requireActivity())
            .load(recipeModel.thumbnailUrl)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .fallback(R.drawable.ic_launcher_background)
            .into(binding.recipeImageView)

        val ratingsLabel = requireActivity().getString(R.string.user_ratings_label)
        binding.recipeRatingsView.text = ratingsLabel
            .plus(" ")
            .plus(recipeModel.userRatings.score)

        binding.totalTimeView.text = recipeModel.total_time_tier.display_tier

        val instructionsString = recipeModel.instructions.joinToString("\n") {
            it.position.toString().plus(". ").plus(it.display_text)
        }
        binding.instructionsView.text = instructionsString
    }


}
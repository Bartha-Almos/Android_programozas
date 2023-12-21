package viewModel

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.databinding.RecipeListItemBinding
import com.example.myapplication.repository.RecipeModel

class RecipesListAdapter (
    private var recipesList: List<RecipeModel>,
    private val context: Context,
    private val onItemClickListener: (RecipeModel) -> Unit
) : RecyclerView.Adapter<RecipesListAdapter.RecipeItemViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeItemViewHolder {
            val binding = RecipeListItemBinding
                .inflate(LayoutInflater.from(context), parent, false)
            return RecipeItemViewHolder(binding)
        }

        override fun getItemCount(): Int = recipesList.size

        override fun onBindViewHolder(holder: RecipeItemViewHolder, position: Int) {
            val currentRecipe = recipesList[position]

            holder.recipeTitleView.text = currentRecipe.name
            holder.recipeDescriptionView.text = currentRecipe.description

            Log.d(TAG, "Recipe's thumbnail URL: ${currentRecipe.thumbnailUrl}")
            //Download image from url
            Glide.with(context)
                .load(currentRecipe.thumbnailUrl)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .fallback(R.drawable.ic_launcher_background)
                .into(holder.recipeImageView)

            val ratingsLabel = context.getString(R.string.user_ratings_label)
            holder.recipeRatingsView.text = ratingsLabel
                .plus(" ")
                .plus(currentRecipe.userRatings.score)
        }

    /**
     * Update the list.
     */
    fun setData(newList: List<RecipeModel>) {
        recipesList = newList;
    }

    inner class RecipeItemViewHolder(binding: RecipeListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val recipeTitleView: TextView = binding.recipeItemTitleView
        val recipeDescriptionView: TextView = binding.recipeItemDescriptionView
        val recipeImageView : ImageView = binding.recipeImageView
        val recipeRatingsView: TextView = binding.recipeRatingsView

        init {
            binding.root.setOnClickListener {
                val currentPosition = this.adapterPosition
                val currentRecipe = recipesList[currentPosition]

                onItemClickListener(currentRecipe)
            }
        }
    }
}



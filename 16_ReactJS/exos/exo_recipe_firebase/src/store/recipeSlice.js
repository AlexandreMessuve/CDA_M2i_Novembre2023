import { createSlice } from "@reduxjs/toolkit";
const recipeSlice = createSlice({
    name: "recipe",
    initialState: {
        formMode: "Ajouter une recette",
        recipes: [],
        selectedRecipe: null,
        ingredients: [],
        isLoading: false,
        error: null
    },
    reducers: {
        fetchRecipes: (state, action) => {
           state.recipes = action.payload;
        },
        addRecipe:(state, action) => {
            state.recipes.push(action.payload);
        },
        updateRecipe: (state, action) => {
          state.recipes = state.recipes.map((recipe) => {
              if(recipe.id === action.payload.id){
                  return action.payload;
              }
              return recipe;
          })
        },
        delRecipe:(state, action) => {
            state.recipes = state.recipes.filter((recipe) => recipe.index !== action.payload);
        },
        fetchIngredients: (state, action) => {
           state.ingredients = action.payload;
        },
        setLoading: (state, action) => {
            state.isLoading = action.payload;
        },
        setFormMode: (state, action) => {
            state.formMode = action.payload;
        },
        setSelectedRecipe: (state, action) => {
            state.selectedRecipe = action.payload;
        }
    },
});

export const { addRecipe,updateRecipe, delRecipe, fetchRecipes, fetchIngredients, setLoading, setFormMode, setSelectedRecipe } = recipeSlice.actions;
export default recipeSlice.reducer;

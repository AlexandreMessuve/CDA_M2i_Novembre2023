import {setFormMode, setSelectedRecipe} from "../store/recipeSlice.js";
import {Link} from "react-router-dom";
import {useDispatch} from "react-redux";
import {LuChefHat} from "react-icons/lu";
import {GiCampCookingPot} from "react-icons/gi";

export const RecipeItem = (props) => {
    const recipe = props.recipe;
    const deleteRecipe = props.deleteRecipe;
    const dispatch = useDispatch();
    return (
        <div className={'card w-50 m-auto'}>
            <div className={'d-flex justify-content-between'}>
                <h3 className={'m-3'}>{recipe.name}</h3>
                <div className={'d-flex justify-content-center'}>
                    <div className={'d-flex align-items-center border border-3 m-3'}>
                        <LuChefHat size={15}/><span>{recipe.preparationTime} minutes</span>
                    </div>

                    <div className={'d-flex align-items-center border border-3 m-3'}>
                        <GiCampCookingPot size={15}/><span>{recipe.cookingTime} minutes</span>
                    </div>
                </div>

            </div>
            <hr/>
            <div className={'d-flex'}>
                <div className={'w-25 mx-3'}>
                    <h4>Ingredients</h4>
                    <hr/>
                    <ul>
                        {
                            recipe.ingredients.map((ingredient) => (
                                <li key={ingredient.id}>{ingredient.name}</li>
                            ))
                        }
                    </ul>
                </div>
                <div className={'w-75 mx-3'}>
                    <h4>Instructions</h4>
                    <hr/>
                    <p>{recipe.instruction}</p>
                </div>
            </div>
            <hr/>
            <div className={'d-flex justify-content-end w-100'}>
                <Link onClick={() => {
                    dispatch(setFormMode('Modifier une recette'));
                    dispatch(setSelectedRecipe(recipe));
                }} to={'/recipe-form'} className={'btn btn-outline-info m-3'}>Modifier</Link>
                <button onClick={() => deleteRecipe(recipe.index)} className={'btn btn-outline-danger m-3'}>Supprimer
                </button>
            </div>
        </div>
    )
}
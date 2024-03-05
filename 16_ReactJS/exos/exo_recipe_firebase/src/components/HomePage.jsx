import {useDispatch, useSelector} from "react-redux";
import {RecipeItem} from "./RecipeItem.jsx";
import {useEffect} from "react";
import {setLoading, fetchRecipes, fetchIngredients, delRecipe} from "../store/recipeSlice.js";
import axios from "axios";
import {DB_URL} from "../firebaseConfig.js";

export const HomePage = () => {
    const recipes = useSelector(state => state.recipe.recipes);
    const isLoading = useSelector(state => state.recipe.isLoading);
    const dispatch = useDispatch();
    const user = useSelector(state => state.auth.user);
    const deleteRecipe = (idRecipe) => {
        (async() => {
            try {
                const resp = await axios.delete(`${DB_URL}recipesList/${idRecipe}.json/?auth=${user.idToken}`);
                console.log(resp.status);
                dispatch(delRecipe(idRecipe));
            }catch (e) {
                console.log(e);
            }
        })()
    }
    useEffect(() => {
        (async() =>{
             try {
                 const resp = await axios.get(`${DB_URL}recipesList.json`);
                 const data = []
                 if(resp.data){
                     for (const recipe in resp.data){
                         resp.data[recipe].index = recipe;
                         data.push(resp.data[recipe]);
                     };
                     dispatch(fetchRecipes(data));
                 }
                 dispatch(setLoading(true));
             }catch (e) {
                 console.log(e)
             }
             try {
                 const resp = await axios.get(`${DB_URL}ingredientsList.json`);
                 if(resp.data){
                     dispatch(fetchIngredients(resp.data))
                 }
             }catch (e) {
                 console.log(e)
             }
        })()
    }, []);
    return (
        <>
            {
                isLoading ? (
                    <>
                        <h1 className={'m-5'}>Recipe List :</h1>
                        {
                            recipes.length <=0 && (
                                <h3 className={'m-3'}>Aucune recette</h3>
                            )
                         }
                        <div className={'m-auto text-start'}>

                        {
                            recipes.map((recipe, index) => (
                                <RecipeItem  deleteRecipe={deleteRecipe} recipe={recipe} key={index} />
                            ))
                        }

                        </div>
                    </>
                ) : (
                    <div className={'position-absolute top-50 start-50 translate-middle'}>
                        <div className="spinner-border" role="status">
                            <span className="visually-hidden">Loading...</span>
                        </div>
                    </div>
                )
            }
        </>

    )
}
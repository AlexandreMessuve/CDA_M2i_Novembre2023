import { useRef } from "react";
import { useDispatch, useSelector } from "react-redux";
import axios from 'axios'
import { DB_URL } from "../../firebaseConfig.js";
import {addRecipe, updateRecipe} from "../../store/recipeSlice.js";
import {useNavigate} from "react-router-dom";

const RecipeForm = () => {
    const ingredients = useSelector(state => state.recipe.ingredients);
    const formMode = useSelector(state => state.recipe.formMode);
    const recipe = useSelector(state => state.recipe.selectedRecipe);
    const nameRef = useRef()
    const instructionRef = useRef()
    const ingredientsRef = useRef()
    const preparationTimeRef = useRef()
    const cookingTimeRef = useRef()
    const user = useSelector(state => state.auth.user);
    const dispatch = useDispatch()
    const navigate = useNavigate();
    const handleSubmit = async (e) => {
        e.preventDefault()
        const selectedOptions = Array.from(ingredientsRef.current.selectedOptions).map(option => ingredients.find((ingredient) => ingredient.id == option.value))
        console.log(selectedOptions);

        const newRecipe = {
            id: formMode === 'Ajouter une recette' ? Date.now() : recipe?.id,
            name: nameRef.current.value,
            instruction: instructionRef.current.value,
            ingredients: selectedOptions,
            preparationTime: preparationTimeRef.current.value,
            cookingTime: cookingTimeRef.current.value
        }

        if(user.idToken){
            if(formMode === 'Ajouter une recette'){
                try {
                    const response = await axios.post(`${DB_URL}recipesList.json?auth=${user.idToken}`, newRecipe);
                    console.log(response.data);
                    dispatch(addRecipe(newRecipe));
                    e.target.reset();
                    navigate('/');
                }catch (e) {
                    console.log(e)
                }
            }else{
                try {
                    const response = await axios.put(`${DB_URL}recipesList/${recipe?.index}.json?auth=${user.idToken}`, newRecipe);
                    console.log(response.data);
                    dispatch(updateRecipe(newRecipe));
                    e.target.reset();
                    navigate('/');
                }catch (e) {
                    console.log(e)
                }
            }
        }
    }

    return (
        <>
            <h1>{formMode}</h1>
            <form className={'w-50 m-auto'} onSubmit={handleSubmit}>
                <div>
                    <input className={'form-control'} type={'text'} defaultValue={recipe?.name} placeholder={'nom de la recette'} ref={nameRef} required={true}/>
                </div>
                <div>
                    <textarea className={'form-control'} rows={10} defaultValue={recipe?.instruction} placeholder={'instruction'} ref={instructionRef} required={true}>

                    </textarea>
                </div>
                <div>
                    <select className={'form-select'} multiple={true}  ref={ingredientsRef} required={true}>
                        {
                            ingredients.map((ingredient) => (
                                <option selected={recipe?.ingredients.find((ing) => ingredient.id == ing.id)} value={ingredient.id} key={ingredient.id}>{ingredient.name}</option>
                            ))
                        }
                    </select>
                </div>
                <div>
                    <input className={'form-control'} type={'number'} defaultValue={recipe?.preparationTime} placeholder={'Temps de preparation en minute'} ref={preparationTimeRef} required={true}/>
                </div>
                <div>
                    <input className={'form-control'} type={'number'} defaultValue={recipe?.cookingTime} placeholder={'Temps de cuisson en minute'} ref={cookingTimeRef} required={true}/>
                </div>
                <div>
                    <button className={'btn btn-outline-primary'}>{formMode === 'Ajouter une recette' ?'Ajouter' : 'Modifier'}</button>
                </div>
            </form>
        </>
    );
}

export default RecipeForm;
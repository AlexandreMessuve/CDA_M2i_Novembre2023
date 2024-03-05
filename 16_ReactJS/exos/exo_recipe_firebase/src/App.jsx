import {Link, Navigate, Outlet, useNavigate} from "react-router-dom";
import {useDispatch, useSelector} from "react-redux";
import {removeUser} from "./store/authSlice.js";
import {setFormMode} from "./store/recipeSlice.js";

function App() {
    const navigate = useNavigate();
    const dispatch = useDispatch();
    const user = useSelector(state => state.auth.user);
    const logout = () => {
        dispatch(removeUser);
        navigate('/sign');
    }
  return (
    <>
      <header>
          <nav className={'navbar d-flex justify-content-between'}>
              <h3>eRecipe</h3>
              <ul className={'nav'}>
                  <li className={'nav-item'}><Link className={'nav-link'} to={'/'}>Home</Link></li>
                  <li className={'nav-item'}><Link onClick={() => dispatch(setFormMode('Ajouter une recette'))} className={'nav-link'} to={'/recipe-form'}>AddRecipe</Link></li>
              </ul>
              <button className={'btn btn-outline-danger'} onClick={() => logout()}>Logout</button>
          </nav>
      </header>
        <main className={'text-center container'}>
            {
                user ? (
                  <Outlet />
              ):(
                  <Navigate to={'/sign'} />
              )
          }

      </main>
    </>
  )
}

export default App

import {createBrowserRouter} from "react-router-dom";
import App from "../App.jsx";
import {ErrorPage} from "../components/ErrorPage.jsx";
import {HomePage} from "../components/HomePage.jsx";
import SignForm from "../components/form/SignForm.jsx";
import RecipeForm from "../components/form/RecipeForm.jsx";

const router = createBrowserRouter([
    {
        path: '/',
        element: <App />,
        errorElement: <ErrorPage />,
        children:  [
            {
                path: '/',
                element: <HomePage />
            },
            {
                path: '/recipe-form',
                element: <RecipeForm />
            }
        ],
    },
    {
        path: '/sign',
        element: <SignForm />
    }
])

export default router;
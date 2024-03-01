import {createBrowserRouter} from "react-router-dom";
import App from "../App.jsx";
import {ErrorPage} from "../components/ErrorPage.jsx";
import {DisplayMovies} from "../components/DisplayMovies.jsx";
import {FormMovies} from "../components/FormMovies.jsx";


const router = createBrowserRouter([
    {
        path: '/',
        element: <App />,
        errorElement: <ErrorPage />,
        children:  [
            {
                path: '/',
                element: <DisplayMovies />
            },
            {
                path: '/add',
                element: <FormMovies />
            },
            {
                path: '/edit/:movieId',
                element: <FormMovies />
            }
        ],
    }
])

export default router;
import {createBrowserRouter} from "react-router-dom";
import App from "../App.jsx";
import {ErrorPage} from "../components/pages/ErrorPage.jsx";
import {HomePage} from "../components/pages/HomePage.jsx";
import SignForm from "../components/form/SignForm.jsx";
import AlbumForm from "../components/form/AlbumForm.jsx";

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
                path: '/album-form',
                element: <AlbumForm />
            }
        ],
    },
    {
        path: '/sign',
        element: <SignForm />
    }
])

export default router;
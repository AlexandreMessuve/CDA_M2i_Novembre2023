import {createBrowserRouter} from "react-router-dom";
import App from "../App.jsx";
import {ErrorPage} from "../components/ErrorPage.jsx";
import {HomePage} from "../components/HomePage.jsx";
import {FormComponent} from "../components/FormComponent.jsx";

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
                path: '/contacts/add',
                element: <FormComponent />
            },
            {
                path: '/contacts/:contactId',
                element: <FormComponent />
            }
        ],
    }
])

export default router;
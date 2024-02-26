import {createBrowserRouter} from "react-router-dom";
import App from '../App.jsx';
import {ErrorPage} from "../components/ErrorPage.jsx";
import {HomePage} from "../components/HomePage.jsx";
import {LoginPage} from "../components/LoginPage.jsx";
import {ProductsPage} from "../components/ProductsPage.jsx";

const router = createBrowserRouter([
    {
        path: '/',
        element: <App />,
        errorElement: <ErrorPage />,
        children: [
            {
                path: '/',
                element: <HomePage/>
            },
            {
                path: '/login',
                element: <LoginPage/>
            },
            {
                path: '/products',
                element: <ProductsPage/>
            }
        ]
    }
]);

export default router;
import {createBrowserRouter} from "react-router-dom";
import App from "../App.jsx";
import {ErrorPage} from "../components/ErrorPage.jsx";
import {HomePage} from "../components/HomePage.jsx";
import {FormTodoComponent} from "../components/todo/FormTodoComponent.jsx";

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
                path: '/todos/add',
                element: <FormTodoComponent />
            },
            {
                path: '/todos/:todoId',
                element: <FormTodoComponent />
            }
        ],
    }
])

export default router;
import {createBrowserRouter} from "react-router-dom";
import App from "../App.jsx";
import {BookPage} from "../components/BookPage.jsx";

const router = createBrowserRouter([
    {
        path: '/',
        element: <App />,
    },
    {
        path: '/:bookId',
        element: <BookPage />
    }
])

export default router;
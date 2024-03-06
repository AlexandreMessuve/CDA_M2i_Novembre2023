import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.jsx'
import 'bootstrap/dist/css/bootstrap.min.css'
import {RouterProvider} from "react-router-dom";
import router from "./routes/Routes.jsx";
import {Provider} from "react-redux";
import store from "./store/store.js";

ReactDOM.createRoot(document.getElementById('root')).render(
    <React.StrictMode>
        <Provider store={store} >
            <RouterProvider router={router}>
                <App />
            </RouterProvider>
        </Provider>
    </React.StrictMode>,
)

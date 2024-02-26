import React from 'react';
import ReactDOM from 'react-dom/client';
import 'bootstrap/dist/css/bootstrap.min.css';
import router from "./routes/Routes.jsx";
import {RouterProvider} from "react-router-dom";
import {ContactProvider} from "./context/ContactContext.jsx";

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
      <ContactProvider>
          <RouterProvider router={router} />
      </ContactProvider>
  </React.StrictMode>,
)

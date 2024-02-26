import {NavBar} from "./components/NavBar.jsx";
import {Outlet} from "react-router-dom";

function App() {

  return (
      <>
          <NavBar/>
          <main className={'container my-4'}>
              <Outlet/>
          </main>
          <footer>
              <h6 className={'text-center'}>Mon footer</h6>
          </footer>
      </>
  )
}

export default App

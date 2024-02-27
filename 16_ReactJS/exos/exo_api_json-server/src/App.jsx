import {Link, Outlet} from "react-router-dom";
import {TodoProvider} from "./context/TodoContext.jsx";

function App() {
  return (
        <TodoProvider>
            <header>
                <nav className={'text-center'}>
                    <Link className={'mx-2'} to={'/'}>Todo List</Link>
                    <Link className={'mx-2'} to={'/todos/add'}>Ajouter un Todo</Link>
                </nav>
            </header>
            <main>
                <Outlet/>
            </main>
        </TodoProvider>
  )
}

export default App

import './App.css'
import {NumbersInput} from "./components/NumbersInput.jsx";

function App() {
  const numberCible = 50;

  return (
    <>
        <NumbersInput numberCible={numberCible} />
    </>
  )
}

export default App

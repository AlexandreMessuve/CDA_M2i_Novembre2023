import './App.css'
import {Form} from "./components/Form.jsx";

function App() {
  const sendForm = (data) => {
    console.log(data);
  }
  return (
    <>
      <Form sendForm={sendForm} />
    </>
  )
}

export default App

import {useState} from 'react'
import {TodoForm} from "./components/TodoForm.jsx";
import {TodoComponent} from "./components/TodoComponent.jsx";

function App() {
  const [todoList, setTodoList] = useState([]);
  const addTodo = (newTodo) => {
      setTodoList(prevTodoList => [...prevTodoList, newTodo]);
  }

  const deleteTodo = (indexDel) => {
      const updatedTodoList = todoList.filter((todo, index) => index !== indexDel);
      setTodoList(updatedTodoList);
  }

  const switchDone = (indexTodo) => {
      const updatedTodoList = todoList.map((todo, index) => {
          if(index === indexTodo){
              return {...todo, done: !todo.done}
          }
          return todo
      })
      setTodoList(updatedTodoList);
  }
  return (
    <>
        <div className={'container my-3'}>
            <div className={'d-flex justify-content-center'}>
                <TodoForm addTodo={addTodo} />
                <TodoComponent todoList={todoList}  deleteTodo={deleteTodo} switchDone={switchDone} />
            </div>
        </div>
    </>
  )
}

export default App

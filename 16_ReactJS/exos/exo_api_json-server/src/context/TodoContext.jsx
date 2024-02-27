import {createContext, useState} from "react";
import axios from "axios";
export const TodoContext = createContext('todo');

export const TodoProvider = (props) => {
    const [todos, setTodos] = useState([]);
    const URLBack = 'http://localhost:3000/todos';

    const fetchTodos = async () => {
        try{
            const resp = await axios.get(URLBack);
            setTodos(resp.data);
            return true;
        }catch (e){
            console.log(e);
            return false;
        }
    }
    const addTodo = async(todo) => {
        try {
            await axios.post(URLBack, todo);
            setTodos([...todos, todo]);
            return true;
        } catch (e) {
            console.log(e);
            return false;
        }
    }

    const updateTodo = async(todoId, updatedTodo) => {

        try {
            await axios.put(URLBack+`/${todoId}`, updatedTodo)
            const updatedTodos = todos.map((todo) => {
                if(todo.id === todoId){
                    return updatedTodo;
                }
                return todo;
            });
            setTodos(updatedTodos);
            return true;
        }catch (e){
            console.log(e);
            return false;
        }
    }

    const deleteTodo = async(todoId) => {
        try {
            await axios.delete(URLBack+`/${todoId}`)
            const updatedTodos = todos.filter((todo) => todo.id !== todoId);
            setTodos(updatedTodos);
            return true;
        } catch (e) {
            console.log(e);
            return false
        }
    }
    return(
        <TodoContext.Provider value={
            {
                todos: todos,
                fetchTodos: fetchTodos,
                addTodo: addTodo,
                updateTodo: updateTodo,
                deleteTodo: deleteTodo
            }
        }>
            {props.children}
        </TodoContext.Provider>
    );
}
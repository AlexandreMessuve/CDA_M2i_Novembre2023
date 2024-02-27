import {useContext, useEffect, useState} from "react";
import {TodoContext} from "../context/TodoContext.jsx";
import {TodoCard} from "./todo/TodoCard.jsx";

export const HomePage = () => {
    const {todos, fetchTodos} = useContext(TodoContext);
    const [isLoad, setIsLoad] = useState(false);
    const [isLoadFailed, setIsLoadFailed] = useState(false);


    useEffect(() => {
        (async () => {
            try {
                setIsLoad(await  fetchTodos);
            }catch (e){
                setIsLoadFailed(true);
            }
        })()
    }, []);
    return (
        <>
            <h1 className={'text-center my-5'}>Todo List</h1>
            {
                !isLoad && !isLoadFailed ?
                    <div className={'d-flex justify-content-center'}>
                        <div className="spinner-border" role="status">
                            <span className="visually-hidden">Loading...</span>
                        </div>
                    </div>

                    :
                    <>
                        {
                            todos.length > 0 ?
                                <div className={'d-flex justify-content-center'}>
                                    {
                                        todos.map((todo) => (
                                            <TodoCard key={todo.id} todo={todo}/>
                                        ))
                                    }
                                </div>
                                :
                                <h2 className={'text-center'}>Aucun todo</h2>
                        }
                    </>
            }
            {
                isLoadFailed && !isLoad &&
                <>
                    <div className="alert alert-danger" role="alert">
                        Error loading todos list
                    </div>
                </>
            }
        </>
    )
}
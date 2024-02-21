export const TodoComponent = (props) => {
    const todoList = props.todoList;
    const deleteTodo = props.deleteTodo;
    const switchDone = props.switchDone;
    return (
        <>
            <div className={'bg-dark text-white container h-100 mx-3 rounded-2'}>
                <h1 className={'text-center'}>Todos</h1>
                <hr />
                    {
                        todoList.length > 0 ? todoList.map((todo, index) => (
                                <div key={index} className={'bg-dark text-white border border-3  border-white rounded-2 h-auto my-2'}>
                                    <div className={'d-flex justify-content-between mx-3 my-2'}>
                                        <h3>{todo.title}</h3>
                                        <h3>{new Date(todo.dueDate).toLocaleDateString()}</h3>
                                    </div>
                                    <div className={'m-auto text-center'}>
                                        <p>{todo.description}</p>
                                    </div>
                                    <div className={'d-flex justify-content-between mx-3 my-2'}>
                                        <button onClick={() => switchDone(index)} className={todo.done ? 'btn btn-success': 'btn btn-warning'}>{todo.done ? 'Done' : 'To do'}</button>
                                        <button onClick={() => deleteTodo(index)} className={'btn btn-danger'}>Delete</button>
                                    </div>
                                </div>
                            ))
                            : <h2 className={'text-center'}>Aucun To do</h2>
                    }

            </div>
        </>
    )
}
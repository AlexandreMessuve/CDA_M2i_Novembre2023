import {Link} from "react-router-dom";

export const TodoCard = (props) => {
    const todo = props.todo;
    return (
        <div className={"card mx-5"}>
            <h5 className={"card-header"}>{todo.id}</h5>
            <div className={"card-body"}>
                <h5 className={"card-title"}>{todo.title}</h5>
                <p className={"card-text"}>{todo.description}</p>
                <p className={'card-text'}>{todo.checked ? 'Fait' : 'A faire'}</p>
                <Link to={`/todos/${todo.id}?mode=edit`} className="btn btn-primary">Modifier</Link>
                <Link to={`/todos/${todo.id}?mode=del`} className="btn btn-danger">Supprimer</Link>
            </div>
        </div>
    )
}
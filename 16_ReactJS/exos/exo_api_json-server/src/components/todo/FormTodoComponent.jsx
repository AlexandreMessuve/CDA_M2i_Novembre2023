import {Link, useNavigate, useParams, useSearchParams} from "react-router-dom";
import {useContext, useRef, useState} from "react";
import {v4 as uuidv4} from 'uuid';
import {TodoContext} from "../../context/TodoContext.jsx";
export function FormTodoComponent() {
    const {todos, addTodo, updateTodo, deleteTodo} = useContext(TodoContext);
    const [isErr, setIsErr] = useState(false);
    const [msgErr, setMsgErr] = useState('');
    const navigate = useNavigate();
    const {todoId} = useParams();
    const [searchParams] = useSearchParams();
    const mode = searchParams.get('mode') ?? "default";
    const todo = todos.find((todo) => todo.id === todoId);
    const title = useRef(mode !== 'default' ? todo.title : '');
    const description = useRef(mode !== 'default' ? todo.description : '');
    const checked = useRef(mode !== 'default' ? todo.checked : false);

    const formHandler = async(e) => {
        e.preventDefault();
        const newTodo = {
            id: mode === 'default' ? uuidv4() : todoId,
            title: title.current.value,
            description: description.current.value,
            checked: mode === 'edit' ? checked.current.value : false,
        }
        if (mode === 'default') {
            if(await addTodo(newTodo)){
                navigate('/');
            }else {
                setIsErr(true);
                setMsgErr('created Todo');
            }

        } else {
            if(await updateTodo(todoId, newTodo)){
                navigate('/');
            }else {
                setIsErr(true);
                setMsgErr('updated Todo');
            }

        }
    }

    const deleteHandler = async() => {
        if(await deleteTodo(todoId)){
            navigate('/');
        }else{
            setIsErr(true);
            setMsgErr('deleted Todo');
        }
    }
    return (
        <>
            {
                isErr &&
                <>
                    <div className="alert alert-danger alert-dismissible fade show" role="alert">
                        <strong>Error</strong> {msgErr}
                        <button type="button" className="btn-close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                </>
            }
            {
                mode !== 'del' ?
                    <>
                        <h1 className={'text-center my-5'}>{mode === 'default' ? 'Formulaire Todo' : `Formulaire d'edition du todo: ${todo.title}`}</h1>
                        <div className={'container'}>
                            <form className={'w-50 m-auto'} onSubmit={formHandler}>
                                <div className={'my-5'}>
                                    <label className={'form-label'}>Titre</label>
                                    <input className={'form-control'} ref={title} defaultValue={mode === 'edit' ? todo.title : ''}
                                           id={'title'} name={'title'} type={'text'} placeholder={'Titre du todo'}
                                           required={true}/>
                                </div>
                                <div className={'my-5'}>
                                    <label className={'form-label'}>Description</label>
                                    <textarea className={'form-control'} ref={description} defaultValue={mode === 'default' ? '' : todo.description} rows={10} required={true}>
                                    </textarea>
                                </div>
                                {
                                    mode === 'edit' &&
                                        <div className={'my-5'}>
                                            <label className={'form-check-label'}>Fait ?</label>
                                            <input className={'form-check-input'} ref={checked} id={'checked'}
                                                   defaultValue={mode === 'edit' ? todo.checked : false}
                                                   name={'checked'} type={'checkbox'}/>
                                        </div>
                                }
                                <div className={'my-5 d-flex justify-content-center'}>
                                    <button className={'btn btn-primary'}>{
                                        mode === 'default' ? 'Ajouter' : 'Modifier'
                                    }</button>
                                </div>
                            </form>
                        </div>
                    </> :
                    <>
                        <h3 className={'text-center my-5'}>Voulez vous vraiment
                            supprimer {todo.title} ?</h3>
                        <div className={'d-flex justify-content-center'}>
                            <button className={'btn btn-danger'} onClick={deleteHandler}>Oui</button>
                            <Link className={'btn btn-outline-primary'} to={'/'}>Non</Link>
                        </div>
                    </>
            }

        </>
    )
}
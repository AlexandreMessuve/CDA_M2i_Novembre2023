import {useRef} from "react";
export const TodoForm = (props) => {
    const title = useRef();
    const description = useRef();
    const dueDate = useRef();
    const addTodo = props.addTodo;
    const submitHandler = (e) => {
        e.preventDefault();
        const newTodo =
            {
                "title" : title.current.value,
                'description' : description.current.value,
                'dueDate' : dueDate.current.value,
                'done' : false
            };
        addTodo(newTodo);
        e.target.reset();
    }
    return (
        <>
            <div className={'w-50 h-75 bg-dark text-white rounded-2'}>
                <h1 className={'text-center'}>Todo Form</h1>
                <hr />
                <form onSubmit={submitHandler}>
                    <div className={'m-3'}>
                        <label className={'text-center form-label'}>Title</label>
                        <input className={'form-control'} ref={title} name={'title'} type={'text'} required={true}/>
                    </div>
                    <div className={'m-3'}>
                        <label className={'text-center form-label'}>Descritpion</label>
                        <textarea className={'form-control'} rows={'7'} ref={description} required={true}>

                    </textarea>
                    </div>
                    <div className={'m-3'}>
                        <label className={'text-center form-label'}>DueDate</label>
                        <input className={'form-control'} ref={dueDate} name={'dueDate'} type={'date'} required={true}/>
                    </div>
                    <div className={'m-3 d-flex justify-content-end'}>
                        <button type={'submit'} className={'btn btn-outline-light'}>Add To Do</button>
                    </div>
                </form>
            </div>

        </>
    )
}
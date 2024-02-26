import {Link, useRouteError} from "react-router-dom";

export const ErrorPage = () => {
    const error = useRouteError();
    return (
        <>
            <div className={'d-flex flex-column my-5 '}>
                <h1 className={'text-center'}>{error.status}</h1>
                <p className={'text-center my-4'}>{error.data}</p>
                <Link className={'my-4 text-center'} to={'/'}>Home</Link>
            </div>
        </>
    )
}
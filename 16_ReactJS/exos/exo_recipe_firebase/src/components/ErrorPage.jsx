import {Link, useRouteError} from "react-router-dom";

export const ErrorPage = () => {
    const error = useRouteError()
    return (
        <div className={'container text-center'}>
            <h1>Error {error.status}</h1>
            <p>{error.data}</p>
            <Link className={'link link-primary'} to={'/'}>Home Page</Link>
        </div>
    )
}
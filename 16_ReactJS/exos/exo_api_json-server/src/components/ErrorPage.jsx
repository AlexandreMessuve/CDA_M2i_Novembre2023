import {Link, useRouteError} from "react-router-dom";

export const ErrorPage = () => {
    const error = useRouteError()
    return (
        <>
            <h1>Error {error.status}</h1>
            <p>{error.data}</p>
            <Link to={'/'}>Home Page</Link>
        </>
    )
}
export const LoginPage = () => {
    return (
        <>
            <div className={'d-flex flex-column justify-content-center align-items-center'}>
                <h1 className={'text-center'}>Log in : </h1>
                <form className={'w-50 text-center'}>
                    <div className={'my-4'}>
                        <label className={'form-label'} htmlFor={'username'}>Username :</label>
                        <input placeholder={'username'} className={'form-control'} type={'text'} name={'username'} id={'username'} />
                    </div>
                    <div className={'my-4'}>
                        <label className={'form-label'} htmlFor={'password'}>Password :</label>
                        <input placeholder={'password'} className={'form-control'} type={'password'} name={'password'} id={'password'}/>
                    </div>
                    <div className={'my-4'}>
                        <button className={'btn btn-outline-primary'} type={'submit'}>Log in</button>
                    </div>
                </form>
            </div>
        </>
    )
}
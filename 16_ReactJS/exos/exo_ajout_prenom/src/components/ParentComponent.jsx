export const ParentComponent = () => {
    const tablePrenom = [];
    const addPrenom = (e) => {
        e.preventDefault();
        const prenom = document.getElementById('prenom');
        tablePrenom.push(prenom.value);
        console.table(tablePrenom);
        prenom.value = '';
    }
    return (
        <>
                <input type={"text"} name={"prenom"} id={'prenom'}/>
                <button onClick={addPrenom}>Ajouter un prenom</button>
                <h3>Regarder le tableau dans la console ! </h3>
        </>
    )
}
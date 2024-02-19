export const RowComponent = () => {
    const data = [
        {
            "nom": "M",
            "prenom": "Alex",
            "age": 26
        },
        {
            "nom": "P",
            "prenom": "Alex",
            "age": 21
        },
        {
            "nom": "B",
            "prenom": "Mohamed",
            "age": 26
        },
        {
            "nom": "D",
            "prenom": "Florian",
            "age": 30
        },
        {
            "nom": "D",
            "prenom": "François",
            "age": 28
        },
        {
            "nom": "N",
            "prenom": "Jeremy",
            "age": 90
        },
    ]
    return (
        <>
            {
                data.map((person, index) =>
                <tr key={index}>
                    <td>{person.nom}</td>
                    <td>{person.prenom}</td>
                    <td>{person.age}</td>
                </tr>
                )
            }
        </>
    )
}
export const TableComponent = (props) => {
    const contacts = props.contacts;
    return (
        <>
            <table>
                <thead>
                    <tr>
                        <th>Nom</th>
                        <th>Prénom</th>
                        <th>Email</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        contacts.map((contact, index) =>
                            <tr key={index}>
                                <td>{contact.lastname}</td>
                                <td>{contact.firstname}</td>
                                <td>{contact.email}</td>
                            </tr>
                        )
                    }
                </tbody>
            </table>
        </>
    )
}
import {RowComponent} from "./RowComponent";

export const TableComponent = () => {
    return (
        <>
            <table>
                <thead>
                    <tr>
                        <th>Nom</th>
                        <th>Prénom</th>
                        <th>Age</th>
                    </tr>
                </thead>
                <tbody>
                    <RowComponent />
                </tbody>
            </table>
        </>
    )
}
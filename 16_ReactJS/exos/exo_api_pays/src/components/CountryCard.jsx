import classes from '../assets/card.module.css';
export const CountryCard = (props) => {
    const country = props.country;
    return (
        <div className={"card my-3 mx-3 "+ classes.card} >
            <img src={country.flag} height={'200'}  className={"card-img-top"} alt={`flag ${country.name}`}/>
            <div className={"card-body"}>
                <h3 className={"card-title"}>{country.name}</h3>
                <h4 className={"card-text"}>Region: {country.region}</h4>
                <h4 className={"card-text"}>Capital:
                    {country.capital !== undefined ? country.capital.map((cap) => cap + ' '): 'Non défini'}
                </h4>
                <h4 className={"card-text"}>Population: {country.population}</h4>
            </div>
        </div>
    )
}
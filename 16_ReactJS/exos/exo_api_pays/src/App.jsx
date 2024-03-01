import {useEffect, useState} from 'react'
import axios from "axios";
import {CountryCard} from "./components/CountryCard.jsx";

function App() {
  const [countryList, setCountryList] = useState([]);
  const [load, setLoad] = useState(false);
  const [failLoad, setFailLoad] = useState(false);
  const [search, setSearch] = useState('');

    useEffect(() => {
        (async() =>{
            try {
                const resp = await axios.get('https://restcountries.com/v3.1/all');
                let countrys = await resp.data;
                countrys = countrys.map((country) => {
                   const newCountry = {
                       'name' : country.translations.fra.common,
                       'capital' : country.capital,
                       'region' : country.region,
                       'population' : country.population,
                       'flag' : country.flags.png
                   }
                   return newCountry;
                });
                setCountryList(countrys);
                setLoad(true);
            }catch (e) {
                setLoad(true)
                setFailLoad(true)
            }
        })()
    });

    const onChangeInput = (e) => {
        setSearch(e.target.value);
    }
  return (
    <>
        <h1 className={'text-center my-4'}>Liste des pays :</h1>
        {
            load && !failLoad ?
                <div className={'container my-4'}>
                    <input onChange={onChangeInput} className={'form-control my-3'} type={'search'} placeholder={'rechercher un pays'}/>
                    <div className={'d-flex justify-content-center flex-wrap'}>
                        {
                            countryList.length > 0 ?
                            countryList.filter((country) => {return new RegExp('^'+search, 'i').test(country.name);}).map(
                                (country, index) => (
                                    <CountryCard  key={index} country={country} />
                                )
                            )
                                :
                                <h3 className={'text-center'}>Aucun pays</h3>
                        }
                    </div>
                </div>
                : !load && !failLoad &&
                    <div className={'d-flex justify-content-center'}>
                            <div className="spinner-border" role="status">
                                <span className="visually-hidden">Loading...</span>
                            </div>
                    </div>

        }
        {
            load && failLoad &&
                <div className="alert alert-danger" role="alert">
                    Erreur lors du chargement des pays
                </div>
        }
    </>
  )
}

export default App

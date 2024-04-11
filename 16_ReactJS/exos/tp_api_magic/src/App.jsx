import {Button, Container, Nav, Navbar} from "react-bootstrap";
import {useEffect, useState} from "react";
import {useDispatch, useSelector} from "react-redux";
import {fetchCards} from "./store/magicSlice.js";
import {MagicItem} from "./components/MagicItem.jsx";
import logo from './assets/magicLogo.png';
import {FaRegArrowAltCircleLeft, FaRegArrowAltCircleRight} from "react-icons/fa";
function App() {
    const [page, setPage] = useState(1);
    const cards = useSelector(state => state.magic.cards);
    const deckCardsCount = useSelector(state => state.magic.deckCardsCount);
    const loading = useSelector(state => state.magic.isLoading);
    const dispatch = useDispatch();
    useEffect(() => {
        dispatch(fetchCards(page));
    }, []);
    useEffect(() => {
        console.log(cards)
    }, [cards]);
    const  previousPage=() => {
        setPage(page - 1);
        dispatch(fetchCards(page));
    }
    const nextPage = () => {
        setPage(page + 1);
        dispatch(fetchCards(page))
    }
  return (
    <>
          <header>
              <Navbar bg="light" data-bs-theme="light">
                  <Container>
                      <Navbar.Brand target={'_blank'} href="https://magic.wizards.com/fr/intro"><img height={100} src={logo}/></Navbar.Brand>
                      <Nav className="me-auto">
                          <Nav.Link href="/">Accueil</Nav.Link>
                          <div className={'d-flex'}>
                              <Nav.Link href="#features">Mon deck </Nav.Link>
                              <span style={{fontSize: "0.8rem"}}>{deckCardsCount}</span>
                          </div>
                          <Nav.Link href="#pricing">Pricing</Nav.Link>
                      </Nav>
                  </Container>
              </Navbar>
          </header>
        <main>
            {
                loading ? (
                    <>
                        <div className={'position-absolute top-50 start-50 translate-middle'}>
                            <div className="spinner-border" role="status">
                                <span className="visually-hidden">Loading...</span>
                            </div>
                        </div>
                    </>
                ) : (
                    <>
                        <h1 className={'text-center'}>Liste des cartes</h1>
                        <h5 className={'text-center'}>Page {page}</h5>
                        <div className={'d-flex align-items-center m-3 text-center'}>
                            <Button disabled={page === 1} onClick={() => previousPage()}><FaRegArrowAltCircleLeft size={50}  /></Button>
                            <div className={'d-flex flex-wrap container'}>
                                {
                                    cards?.map((card) => (
                                        <MagicItem key={card.id} card={card}/>
                                    ))
                                }
                            </div>
                            <Button onClick={() => nextPage()}><FaRegArrowAltCircleRight size={50} /></Button>
                        </div>
                    </>
                )
            }

        </main>
    </>
  )
}

export default App

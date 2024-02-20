import {useEffect, useState} from "react";

export const NumbersInput = (props) => {
    const [firstNumber, setFirstNumber] = useState(0);
    const [secondNumber, setSecondNumber] = useState(0);
    const [showResult, setShowResult] = useState(false);
    const numberCible = props.numberCible;

    const firstNumberHandler = (e) => {
        setFirstNumber(Number(e.target.value))
    }
    const secondNumberHandler = (e) => {
        setSecondNumber(Number(e.target.value))
    }

    useEffect(() => {
        const result = firstNumber * secondNumber;
        if(result === numberCible){
            setShowResult(true);
        }
        else{
            setShowResult(false);
        }
    }, [firstNumber, secondNumber]);
    return (
        <>
            <div>
                <label>Premier nombre :</label>
                <input type={"number"} value={firstNumber}  onChange={firstNumberHandler}/>
            </div>
            <div>
                <label>Second nombre :</label>
                <input type={"number"} value={secondNumber} onChange={secondNumberHandler} />
            </div>
            <p>
                {
                    showResult ? `La multiplication des deux nombres fait bien : ${numberCible}` : `Les deux nombres multipliés ne font pas : ${numberCible}`
                }
            </p>
        </>
    )
}
import {useState} from 'react'
import './App.css'

function App() {
    const [count, setCount] = useState(1);
    const maxCount = 100;
    const incrementCount = () => {
        setCount(count + 1);
    }
    const decrementCount = () => {
        setCount(count - 1);
    }

    return (
        <>
            <p>{count % 3 === 0 && count % 5 === 0 ? 'FizzBuzz' : (count % 3 === 0 ? 'Fizz' : count % 5 === 0 ? 'Buzz' : count)}</p>
            <button onClick={decrementCount} disabled={count <= 1}>-1</button>
            <button onClick={incrementCount} disabled={count >= maxCount}>+1</button>
        </>
    )
}

export default App

import { StyleSheet, Text, View } from 'react-native'
import React, { useEffect, useState } from 'react'
import Calculator from './components/Calculator'

const App = () => {
  const [result, setResult] = useState('0');
  const [expression, setExpression] = useState('');
  
  const addToExpression = (value) => {
    setExpression(prevExpression => prevExpression + value);
  }

  const delExpression = () => {
    setExpression('');
    setResult('0');

  }
  const calculate = () => {
    try{
      const res = eval(expression)?.toString();
      setResult(res);
      setExpression(res);

    }catch{
        console.log('error');
    }
  }
  useEffect(() => {
    if(expression.length > 0){
      setResult(expression);
    }
  },[expression])
  return (
    <View style={styles.view}>
      <View style={styles.viewTitle}>
        <Text style={styles.title}>Calculator</Text>
      </View>
      <View>
        <Text style={styles.number}>{result}</Text>
      </View>
      <Calculator addToExpression={addToExpression} calculate={calculate} delExpression={delExpression}/>
    </View>
  )
}

export default App

const styles = StyleSheet.create({
  view: {
    flex: 1,
    backgroundColor: '#2F4F4F',
    justifyContent: 'space-between',
  },
  title: {
    marginTop: 100,
    color: 'white',
    fontSize: 50,
    textAlign: 'center'
  },
  number:{
    marginHorizontal: 20,
    marginVertical: 50,
    fontSize: 70,
    color: 'white',
    textAlign: 'right'
  }
})
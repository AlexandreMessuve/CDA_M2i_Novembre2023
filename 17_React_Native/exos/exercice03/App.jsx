import { StyleSheet, Text, View } from 'react-native'
import React, { useEffect, useState } from 'react'
import Calculator from './components/Calculator'
import * as math from 'mathjs'

const App = () => {
  const [result, setResult] = useState('0');
  const [expression, setExpression] = useState('');
  
  const addToExpression = (value) => {
    setExpression(prevExpression => prevExpression + value);
  }

  const delExpression = () => {
    const maxLength = expression.length;
    if(maxLength === 1){
      resetExpression();
      return;
    }
    const newExpression = expression.substring(0,maxLength-1);
    setExpression(newExpression);
  }

  const resetExpression = () => {
    setExpression('');
    setResult('0');
  }
  const calculate = () => {
    try{
      const res = math.evaluate(expression).toString();
      setResult(res);
      setExpression(res);

    }catch (e){
        console.log(e);
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
      <Calculator resetExpression={resetExpression} addToExpression={addToExpression} calculate={calculate} delExpression={delExpression}/>
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
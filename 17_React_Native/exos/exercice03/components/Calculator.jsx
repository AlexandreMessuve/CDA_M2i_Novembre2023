import { StyleSheet, Text, View } from 'react-native'
import React from 'react'
import ButtonComponent from './ButtonComponent'

const Calculator = (props) => {
  return (
    <View style={styles.view}>

      <View style={styles.calculatorView}>

        <ButtonComponent resetExpression={props.resetExpression} delExpression={props.delExpression} addToExpression={props.addToExpression} calculate={props.calculate} styleButton={styles.buttonOperator} stylePressed={styles.buttonOperatorPressed} styleText={styles.operatorText}>AC</ButtonComponent>

        <ButtonComponent resetExpression={props.resetExpression} delExpression={props.delExpression} addToExpression={props.addToExpression} calculate={props.calculate} styleButton={styles.buttonOperator} stylePressed={styles.buttonOperatorPressed} styleText={styles.operatorText}>^</ButtonComponent>

        <ButtonComponent resetExpression={props.resetExpression} delExpression={props.delExpression} addToExpression={props.addToExpression} calculate={props.calculate} styleButton={styles.buttonOperator} stylePressed={styles.buttonOperatorPressed} styleText={styles.operatorText}>%</ButtonComponent>

        <ButtonComponent resetExpression={props.resetExpression} delExpression={props.delExpression} addToExpression={props.addToExpression} calculate={props.calculate} styleButton={styles.buttonOperator} stylePressed={styles.buttonOperatorPressed} styleText={styles.operatorText}>/</ButtonComponent>

      </View>

      <View style={styles.calculatorView}>

        <ButtonComponent resetExpression={props.resetExpression} delExpression={props.delExpression} addToExpression={props.addToExpression} calculate={props.calculate} styleButton={styles.buttonNumber} stylePressed={styles.buttonNumberPressed} styleText={styles.numberText}>7</ButtonComponent>

        <ButtonComponent resetExpression={props.resetExpression} delExpression={props.delExpression} addToExpression={props.addToExpression} calculate={props.calculate} styleButton={styles.buttonNumber} stylePressed={styles.buttonNumberPressed} styleText={styles.numberText}>8</ButtonComponent>

        <ButtonComponent resetExpression={props.resetExpression} delExpression={props.delExpression} addToExpression={props.addToExpression} calculate={props.calculate} styleButton={styles.buttonNumber} stylePressed={styles.buttonNumberPressed} styleText={styles.numberText}>9</ButtonComponent>

        <ButtonComponent resetExpression={props.resetExpression} delExpression={props.delExpression} addToExpression={props.addToExpression} calculate={props.calculate} styleButton={styles.buttonOperator} stylePressed={styles.buttonOperatorPressed} styleText={styles.operatorText}>*</ButtonComponent>

      </View>

      <View style={styles.calculatorView}>

        <ButtonComponent resetExpression={props.resetExpression} delExpression={props.delExpression} addToExpression={props.addToExpression} calculate={props.calculate} styleButton={styles.buttonNumber} stylePressed={styles.buttonNumberPressed} styleText={styles.numberText}>4</ButtonComponent>

        <ButtonComponent resetExpression={props.resetExpression} delExpression={props.delExpression} addToExpression={props.addToExpression} calculate={props.calculate} styleButton={styles.buttonNumber} stylePressed={styles.buttonNumberPressed} styleText={styles.numberText}>5</ButtonComponent>

        <ButtonComponent resetExpression={props.resetExpression} delExpression={props.delExpression} addToExpression={props.addToExpression} calculate={props.calculate} styleButton={styles.buttonNumber} stylePressed={styles.buttonNumberPressed} styleText={styles.numberText}>6</ButtonComponent>

        <ButtonComponent resetExpression={props.resetExpression} delExpression={props.delExpression} addToExpression={props.addToExpression} calculate={props.calculate} styleButton={styles.buttonOperator} stylePressed={styles.buttonOperatorPressed} styleText={styles.operatorText}>+</ButtonComponent>

      </View>

      <View style={styles.calculatorView}>

        <ButtonComponent resetExpression={props.resetExpression} delExpression={props.delExpression} addToExpression={props.addToExpression} calculate={props.calculate} styleButton={styles.buttonNumber} stylePressed={styles.buttonNumberPressed} styleText={styles.numberText}>1</ButtonComponent>

        <ButtonComponent resetExpression={props.resetExpression} delExpression={props.delExpression} addToExpression={props.addToExpression} calculate={props.calculate} styleButton={styles.buttonNumber} stylePressed={styles.buttonNumberPressed} styleText={styles.numberText}>2</ButtonComponent>

        <ButtonComponent resetExpression={props.resetExpression} delExpression={props.delExpression} addToExpression={props.addToExpression} calculate={props.calculate} styleButton={styles.buttonNumber} stylePressed={styles.buttonNumberPressed} styleText={styles.numberText}>3</ButtonComponent>

        <ButtonComponent resetExpression={props.resetExpression} delExpression={props.delExpression} addToExpression={props.addToExpression} calculate={props.calculate} styleButton={styles.buttonOperator} stylePressed={styles.buttonOperatorPressed} styleText={styles.operatorText}>-</ButtonComponent>

      </View>

      <View style={styles.calculatorView}>

        <ButtonComponent resetExpression={props.resetExpression}delExpression={props.delExpression} addToExpression={props.addToExpression} calculate={props.calculate} styleButton={styles.buttonNumber} stylePressed={styles.buttonNumberPressed} styleText={styles.numberText}>.</ButtonComponent>

        <ButtonComponent resetExpression={props.resetExpression}delExpression={props.delExpression} addToExpression={props.addToExpression} calculate={props.calculate} styleButton={styles.buttonNumber} stylePressed={styles.buttonNumberPressed} styleText={styles.numberText}>0</ButtonComponent>

        <ButtonComponent resetExpression={props.resetExpression}delExpression={props.delExpression} addToExpression={props.addToExpression} calculate={props.calculate} styleButton={styles.buttonNumber} stylePressed={styles.buttonNumberPressed} styleText={styles.numberText}>Del</ButtonComponent>

        <ButtonComponent resetExpression={props.resetExpression}delExpression={props.delExpression} addToExpression={props.addToExpression} calculate={props.calculate} styleButton={styles.buttonOperator} stylePressed={styles.buttonOperatorPressed} styleText={styles.operatorText}>=</ButtonComponent>
        
      </View>

    </View>
  )
}

export default Calculator

const styles = StyleSheet.create({
  view: {
    height: '100%',
    width: '100%'
  },
  calculatorView: {
    flexDirection: 'row',
  },
  buttonNumber: {
    backgroundColor: '#F5F5F5',
    borderRadius: 50
  },
  buttonNumberPressed: {
    backgroundColor: '#F5F5DC',
    borderRadius: 50
  },
  buttonOperator: {
    backgroundColor: 'grey',
    borderRadius: 20
  },
  buttonOperatorPressed: {
    backgroundColor: '#C0C0C0',
    borderRadius: 20
  },
  numberText: {
    fontSize: 30,
    color: 'black',
    fontWeight: 'bold'
  },
  operatorText: {
    fontSize: 30,
    color: 'white',
  }
})
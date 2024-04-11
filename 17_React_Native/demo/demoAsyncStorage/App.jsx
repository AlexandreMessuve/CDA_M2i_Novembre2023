import { Button, StyleSheet, Text, View } from 'react-native'
import React, { useState } from 'react'
import AsyncStorage from '@react-native-async-storage/async-storage'

export default function App() {

  const [value,setValue] = useState({})

  const addData = async () => {
    try{
      const person = {
        firstname: 'Alexandre',
        lastname: 'Messuve'
      }
      await AsyncStorage.setItem('key',JSON.stringify(person))
    }catch(error){
      console.log(error)
    }
  }

  const recupData = async () => {
    try{
      const value =  await AsyncStorage.getItem('key')
      if(value !== null){
        setValue(JSON.parse(value))
      }
    }catch(error){
      console.log(error)
    }
  }

  const deleteData = async () => {
    try{
      await AsyncStorage.removeItem('key')
      setValue({})
    }catch(error){
      console.log(error)
    }
  }


  return (
    <View>
      <Text>Nom : {value?.lastname}</Text>
      <Text>Prénom : {value?.firstname}</Text>
      <Button title='Ajout' onPress={addData}/>
      <Button title='Recup' onPress={recupData}/>
      <Button title='Delete' onPress={deleteData}/>
    </View>
  )
}

const styles = StyleSheet.create({})
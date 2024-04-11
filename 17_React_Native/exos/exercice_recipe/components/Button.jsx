import {  Text, Pressable } from 'react-native'
import React from 'react'

const Button = ({title, styles, onPress}) => {
  return (
    <Pressable style={styles?.container} onPress={onPress}>
      <Text style={styles?.text}>{title}</Text>
    </Pressable>
  )
}

export default Button
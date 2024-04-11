import { StyleSheet, Text } from 'react-native'
import React from 'react'
export default UserInfo = (props) => {
  const { children, title } = props;
  return (
    <Text style={styles.text}>{title} <Text style={styles.info}>{children}</Text></Text>
  )
}

const styles = StyleSheet.create({

  text: {
    color: 'black',
    fontSize: 25
  },
  info: {
    fontWeight: 'bold',
    fontSize: 20
  }

})
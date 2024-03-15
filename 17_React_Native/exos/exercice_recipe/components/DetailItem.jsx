import { StyleSheet, Text, View } from 'react-native'
import React from 'react'

const DetailItem = ({item}) => {
  return (
    <View style={styles.container}>
      <Text style={styles.text}>{item}</Text>
    </View>
  )
}

export default DetailItem

const styles = StyleSheet.create({
    container: {
        justifyContent: 'center',
        alignItems: 'center',
        width: 300,
        backgroundColor: 'orange',
        marginVertical: 5,
        borderRadius: 5
    },
    text: {
        textAlign: 'center',
        fontWeight: '600',
        fontSize: 17
    }
})
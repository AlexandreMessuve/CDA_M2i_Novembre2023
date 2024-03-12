import { View, Text, Button, StyleSheet } from 'react-native'
import React from 'react'

const ArticleItem = (props) => {
  return (
    <View style={styles.listView}>
    <View style={styles.viewItem}>
        <Text style={styles.listText}>{(props.index + 1).toString()}-{props.article.name}</Text>
    </View>
    <View style={styles.viewItem}>
        <Button color={'red'} title='x' onPress={() => deleteItem(props.article.id)} />
    </View>

</View>
  )
}

const styles = StyleSheet.create({
    listText: {
        color: 'white',
        fontSize: 15
    },
    listView: {
        flexDirection: 'row',
        backgroundColor: 'purple',
        margin: 3,
        borderRadius: 35,
        width: 400,
        height: 50,
        alignItems: 'center',
        justifyContent: 'space-between'
    },
    viewItem: {
        marginLeft: 30,
        marginRight: 30
    }
})
export default ArticleItem
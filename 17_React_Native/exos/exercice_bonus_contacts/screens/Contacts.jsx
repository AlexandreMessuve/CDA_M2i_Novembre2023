import { View, Text, StyleSheet, Button, FlatList } from 'react-native'
import React, { useContext, useEffect, useState } from 'react'
import ContactList from '../components/ContactList';
import contactContext from '../context/contactContext';
const Contacts = ({navigation}) => {
    const {contacts} = useContext(contactContext)
  return (
    <View style={styles.container}>
        <View style={styles.header}>
            <Text style={styles.title}>Contacts : </Text>
        </View>
      <FlatList data={contacts} renderItem={({item}) => {
        console.log(item);
        return (
            <ContactList id={item.id} username={item.username} navigation={navigation} />
        )
      }} keyExtractor={(item) => item.id} ListEmptyComponent={() => {
        return(
            <Text style={styles.listText}>Aucun contact</Text>
        )
      }} style={styles.list}/>
    </View>
  )
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        alignItems: 'center',
        backgroundColor: '#663180',
    },
    title:{
        fontSize: 40,
        fontWeight: '700',
        color: 'white'
    },
    header: {
        backgroundColor: '#48245A',
        width: '100%',
        justifyContent: 'center',
        alignItems: 'center'
    },
    list:{
        width: '100%'
    },
    listText: {
        marginTop: 20,
        fontSize: 28,
        fontWeight: '500',
        color: 'white',
        textAlign: 'center'
    }
})
export default Contacts
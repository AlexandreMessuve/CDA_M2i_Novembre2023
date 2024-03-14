import { View, Text, StyleSheet, Button, FlatList } from 'react-native'
import React, { useEffect, useState } from 'react'
import ContactList from '../components/ContactList';

const Contacts = ({navigation}) => {
    const [contacts, setContacts] = useState([]);
    const addContact = (newContact) => {
        setContacts([...contacts, newContact]);
    }
    const delContact = (idContact) => {
        const newContacts = contacts.filter((contact) => contact.id !== idContact);
        setContacts(newContacts);
    }
    useEffect(() => {
        console.log(contacts);
    }, [contacts])
  return (
    <View style={styles.container}>
        <View style={styles.header}>
            <Text style={styles.title}>Contacts : </Text>
        </View>
      <FlatList data={contacts} renderItem={({item}) => {
        console.log(item);
        return (
            <ContactList contact={item} delContact={delContact} navigation={navigation} />
        )
      }} keyExtractor={(item) => item.id} ListEmptyComponent={() => {
        return(
            <Text style={styles.listText}>Aucun contact</Text>
        )
      }} style={styles.list}/>
      <View style={styles.button}>
        <Button title={'Ajouter un contact'} onPress={() => navigation.navigate('FormContact', {addContact: addContact})}/>
      </View>
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
    },
    button: {
        margin: 40
    }
})
export default Contacts
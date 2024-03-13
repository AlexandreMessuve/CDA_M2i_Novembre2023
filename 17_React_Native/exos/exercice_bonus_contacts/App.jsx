import { View, Text, StyleSheet, Button, FlatList } from 'react-native'
import React, { useEffect, useState } from 'react'
import FormContact from './components/FormContact';
import ContactList from './components/ContactList';

const App = () => {
    const [contacts, setContacts] = useState([]);
    const [showModal, setShowModal] = useState(false);
    const addContact = (newContact) => {
        setContacts([...contacts, newContact]);
        setShowModal(false);
    }
    const delContact = (idContact) => {
        const newContacts = contacts.filter((contact) => contact.id !== idContact);
        setContacts(newContacts);
    }
    useEffect(() => {
        console.log(contacts);
    }, [contacts])
  return (
    <View style={styles.view}>
      <Text style={styles.title}>Contacts : </Text>
      <FormContact visible={showModal} addContact={addContact} closeModal={() => setShowModal(false)}/>
      <FlatList data={contacts} renderItem={({item}) => {
        console.log(item);
        return (
            <ContactList contact={item} delContact={delContact} />
        )
      }} keyExtractor={(item) => item.id} ListEmptyComponent={() => {
        return(
            <Text style={styles.listText}>Aucun contact</Text>
        )
      }}/>
      <Button title={'Ajouter un contact'} onPress={() => setShowModal(true)}/>
    </View>
  )
}

const styles = StyleSheet.create({
    view: {
        flex: 1,
        alignItems: 'center'
    },
    title:{
        fontSize: 40,
        marginTop: 20,
        fontWeight: '700'
    },
    listText: {
        marginTop: 20,
        fontSize: 28,
        fontWeight: '500'
    }
})
export default App
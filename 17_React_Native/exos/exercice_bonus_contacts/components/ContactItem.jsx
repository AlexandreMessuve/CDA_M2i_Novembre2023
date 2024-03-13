import { Modal, Pressable, StyleSheet, Text, View } from 'react-native'
import React from 'react'

const ContactItem = (props) => {
    const {contact, closeModal, visible} = props
  return (
    <Modal visible={visible}>
        <View style={styles.container}>
            <View style={styles.containerContact}>
                <Text style={styles.textItem}>Nom: </Text>
                <Text style={styles.textContact}>{contact.lastname}</Text>
            </View>
            <View style={styles.containerContact}>
                <Text style={styles.textItem}>Prenom:</Text>
                <Text style={styles.textContact}>{contact.firstname}</Text>
            </View>
            <View style={styles.containerContact}>
                <Text style={styles.textItem}>Telephone: </Text>
                <Text style={styles.textContact}>{contact.phone}</Text>
            </View>
            <View style={styles.containerContact}>
                <Text style={styles.textItem}>Adresse: </Text>
                <Text style={styles.textContact}>{contact.address}</Text>
            </View>
            <Pressable style={({pressed}) => [styles.return, (pressed) && styles.returnPressed]} onPress={closeModal}>
                <Text style={styles.buttonText}>Retour</Text>
            </Pressable>
        </View>
    </Modal>
  )
}

export default ContactItem

const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: 'center',
        marginHorizontal: 10
    },
    return: {
        backgroundColor: '#0884AC',
        height: 30,
        width: 60,
        borderRadius: 10,
        alignItems: 'center',
        justifyContent: 'center',
        alignContent: 'center'
    },
    returnPressed: {
        backgroundColor: '#03B5EF'
    },
    containerContact:{
        marginVertical: 20,
        flexDirection: 'row',
        justifyContent: 'space-between',
        alignItems: 'center'
    },
    textContact: {
        fontSize: 20,
        fontWeight: 'bold'
    },
    textItem: {
        fontSize: 25,
    },
    buttonText: {
        color: 'white',
        fontSize: 20
    }
})
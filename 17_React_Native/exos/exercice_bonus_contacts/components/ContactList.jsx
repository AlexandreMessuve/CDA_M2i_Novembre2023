import { Image, Pressable, StyleSheet, Text, View } from 'react-native'
import React, { useState } from 'react'
import iconRemove from '../assets/icones/iconRemove.png';
import ContactItem from './ContactItem';
const ContactList = (props) => {
    const [modal, setModal] = useState(false);
    const { contact, delContact } = props
    return (
        <View>
            <Pressable style={({pressed}) => [styles.item, (pressed) && styles.itemPressed]} onPress={() => setModal(true)}>
                <Text style={styles.itemText}>{contact.lastname} {contact.firstname}</Text>
                <Pressable style={({ pressed }) => [(pressed) && styles.pressed]} onPressOut={() => delContact(contact.id)}>
                    <Image style={styles.iconRemove} source={iconRemove} />
                </Pressable>
            </Pressable>
            <ContactItem visible={modal} closeModal={() => setModal(false)} contact={contact} />
        </View>
    )
}

export default ContactList

const styles = StyleSheet.create({
    
    item: {
        backgroundColor: '#B233FF',
        width: 400,
        height: 50,
        marginHorizontal: 30,
        borderRadius: 30,
        flexDirection: 'row',
        justifyContent: 'space-around',
        alignItems: 'center',
        marginTop: 20
    },
    itemText:{
        fontSize: 20,
        fontWeight: 'bold',
        color: 'white'
    },
    itemPressed: {
        backgroundColor: '#8626C1'
    },
    pressed: {
        backgroundColor: '#FF6E33',
        borderRadius: 10
    },
    iconRemove: {
        height: 20,
        width: 20
    }
})